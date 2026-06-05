package com.library.backend.service;

import com.library.backend.dto.TraSachRequest;
import com.library.backend.dto.TraSachResponse;
import com.library.backend.entity.ChiTietPhieuMuon;
import com.library.backend.entity.ChiTietPhieuTra;
import com.library.backend.entity.CuonSach;
import com.library.backend.entity.KhoanNo;
import com.library.backend.entity.PhieuMuon;
import com.library.backend.entity.PhieuTra;
import com.library.backend.exception.BusinessException;
import com.library.backend.exception.ResourceNotFoundException;
import com.library.backend.repository.ChiTietPhieuMuonRepository;
import com.library.backend.repository.ChiTietPhieuTraRepository;
import com.library.backend.repository.CuonSachRepository;
import com.library.backend.repository.KhoanNoRepository;
import com.library.backend.repository.PhieuMuonRepository;
import com.library.backend.repository.PhieuTraRepository;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TraSachService {

    private static final String TT_SANCO = "TT_SANCO";
    private static final String TT_HONG = "TT_HONG";
    private static final String TT_MAT = "TT_MAT";

    private final PhieuTraRepository phieuTraRepository;
    private final ChiTietPhieuTraRepository chiTietPhieuTraRepository;
    private final ChiTietPhieuMuonRepository chiTietPhieuMuonRepository;
    private final PhieuMuonRepository phieuMuonRepository;
    private final CuonSachRepository cuonSachRepository;
    private final KhoanNoRepository khoanNoRepository;
    private final JdbcTemplate jdbcTemplate;
    private final ActivityLogService activityLogService;

    public TraSachService(
            PhieuTraRepository phieuTraRepository,
            ChiTietPhieuTraRepository chiTietPhieuTraRepository,
            ChiTietPhieuMuonRepository chiTietPhieuMuonRepository,
            PhieuMuonRepository phieuMuonRepository,
            CuonSachRepository cuonSachRepository,
            KhoanNoRepository khoanNoRepository,
            JdbcTemplate jdbcTemplate,
            ActivityLogService activityLogService
    ) {
        this.phieuTraRepository = phieuTraRepository;
        this.chiTietPhieuTraRepository = chiTietPhieuTraRepository;
        this.chiTietPhieuMuonRepository = chiTietPhieuMuonRepository;
        this.phieuMuonRepository = phieuMuonRepository;
        this.cuonSachRepository = cuonSachRepository;
        this.khoanNoRepository = khoanNoRepository;
        this.jdbcTemplate = jdbcTemplate;
        this.activityLogService = activityLogService;
    }

    @Transactional
    public TraSachResponse create(TraSachRequest request) {
        if (phieuTraRepository.existsById(request.getMaPhieuTra())) {
            throw new BusinessException("Mã phiếu trả đã tồn tại");
        }

        if (!existsById("DOCGIA", "MaDocGia", request.getMaDocGia())) {
            throw new ResourceNotFoundException("Độc giả không tồn tại");
        }

        if (!existsById("NHANVIEN", "MaNhanVien", request.getMaNhanVienNhan())) {
            throw new ResourceNotFoundException("Nhân viên nhận sách không tồn tại");
        }

        if (!existsById("CHINHANH", "MaChiNhanh", request.getMaChiNhanh())) {
            throw new ResourceNotFoundException("Chi nhánh không tồn tại");
        }

        LocalDateTime ngayTra = LocalDateTime.now();

        PhieuTra phieuTra = new PhieuTra();
        phieuTra.setMaPhieuTra(request.getMaPhieuTra());
        phieuTra.setMaDocGia(request.getMaDocGia());
        phieuTra.setMaNhanVienNhan(request.getMaNhanVienNhan());
        phieuTra.setMaChiNhanh(request.getMaChiNhanh());
        phieuTra.setNgayTra(ngayTra);
        phieuTra.setGhiChu(request.getGhiChu());

        phieuTraRepository.save(phieuTra);

        for (int i = 0; i < request.getChiTiet().size(); i++) {
            TraSachRequest.ChiTietTraRequest item = request.getChiTiet().get(i);

            if (chiTietPhieuTraRepository.existsByMaChiTietMuon(item.getMaChiTietMuon())) {
                throw new BusinessException("Chi tiết mượn đã được trả: " + item.getMaChiTietMuon());
            }

            ChiTietPhieuMuon chiTietMuon = chiTietPhieuMuonRepository.findById(item.getMaChiTietMuon())
                    .orElseThrow(() -> new ResourceNotFoundException(
                            "Không tìm thấy chi tiết mượn: " + item.getMaChiTietMuon()
                    ));

            if (!"Đang mượn".equals(chiTietMuon.getTrangThai())) {
                throw new BusinessException("Chi tiết mượn không ở trạng thái Đang mượn");
            }

            PhieuMuon phieuMuon = phieuMuonRepository.findById(chiTietMuon.getMaPhieuMuon())
                    .orElseThrow(() -> new ResourceNotFoundException("Không tìm thấy phiếu mượn"));

            if (!request.getMaDocGia().equals(phieuMuon.getMaDocGia())) {
                throw new BusinessException("Chi tiết mượn không thuộc độc giả này");
            }

            if (!request.getMaChiNhanh().equals(phieuMuon.getMaChiNhanh())) {
                throw new BusinessException("Không được trả sách khác chi nhánh mượn");
            }

            CuonSach cuonSach = cuonSachRepository.findById(chiTietMuon.getMaCuonSach())
                    .orElseThrow(() -> new ResourceNotFoundException("Không tìm thấy cuốn sách"));

            String tinhTrang = item.getTinhTrangKhiTra();

            if (!"Bình thường".equals(tinhTrang)
                    && !"Hỏng".equals(tinhTrang)
                    && !"Mất".equals(tinhTrang)) {
                throw new BusinessException("Tình trạng khi trả chỉ được là Bình thường, Hỏng hoặc Mất");
            }

            BigDecimal tienPhatHongMat = item.getTienPhatHongMat() == null
                    ? BigDecimal.ZERO
                    : item.getTienPhatHongMat();

            if ("Bình thường".equals(tinhTrang) && tienPhatHongMat.compareTo(BigDecimal.ZERO) > 0) {
                throw new BusinessException("Sách bình thường thì không được nhập tiền phạt hỏng/mất");
            }

            if (("Hỏng".equals(tinhTrang) || "Mất".equals(tinhTrang))
                    && tienPhatHongMat.compareTo(BigDecimal.ZERO) <= 0) {
                throw new BusinessException("Sách hỏng/mất phải nhập tiền phạt hỏng/mất lớn hơn 0");
            }

            long soNgayTreLong = ChronoUnit.DAYS.between(
                    chiTietMuon.getHanTra().toLocalDate(),
                    ngayTra.toLocalDate()
            );

            int soNgayTre = Math.max(0, (int) soNgayTreLong);

            BigDecimal mucPhatTreMoiNgay = getMucPhatTreMoiNgay(phieuMuon.getMaPhienBanQuyDinh());
            BigDecimal tienPhatTre = mucPhatTreMoiNgay.multiply(BigDecimal.valueOf(soNgayTre));

            String maChiTietTra = buildMaChiTietTra(request.getMaPhieuTra(), i + 1);

            ChiTietPhieuTra chiTietTra = new ChiTietPhieuTra();
            chiTietTra.setMaChiTietTra(maChiTietTra);
            chiTietTra.setMaPhieuTra(request.getMaPhieuTra());
            chiTietTra.setMaChiTietMuon(item.getMaChiTietMuon());
            chiTietTra.setTinhTrangKhiTra(tinhTrang);
            chiTietTra.setSoNgayTre(soNgayTre);
            chiTietTra.setTienPhatTre(tienPhatTre);
            chiTietTra.setTienPhatHongMat(tienPhatHongMat);
            chiTietTra.setGhiChu(item.getGhiChu());

            chiTietPhieuTraRepository.save(chiTietTra);

            chiTietMuon.setNgayTraThucTe(ngayTra);

            if ("Bình thường".equals(tinhTrang)) {
                chiTietMuon.setTrangThai("Đã trả");
                cuonSach.setMaTrangThai(TT_SANCO);
            } else if ("Hỏng".equals(tinhTrang)) {
                chiTietMuon.setTrangThai("Hỏng");
                cuonSach.setMaTrangThai(TT_HONG);
            } else {
                chiTietMuon.setTrangThai("Mất");
                cuonSach.setMaTrangThai(TT_MAT);
            }

            chiTietPhieuMuonRepository.save(chiTietMuon);
            cuonSachRepository.save(cuonSach);

            if (tienPhatTre.compareTo(BigDecimal.ZERO) > 0) {
                createKhoanNo(
                        "NO_" + request.getMaPhieuTra() + "_" + String.format("%02d", i + 1) + "T",
                        request.getMaDocGia(),
                        "NO_TRA_TRE",
                        maChiTietTra,
                        tienPhatTre,
                        "Trả trễ " + soNgayTre + " ngày cho cuốn " + chiTietMuon.getMaCuonSach(),
                        ngayTra
                );
            }

            if (tienPhatHongMat.compareTo(BigDecimal.ZERO) > 0) {
                String loaiNo = "Hỏng".equals(tinhTrang) ? "NO_HONG_SACH" : "NO_MAT_SACH";

                createKhoanNo(
                        "NO_" + request.getMaPhieuTra() + "_" + String.format("%02d", i + 1) + "H",
                        request.getMaDocGia(),
                        loaiNo,
                        maChiTietTra,
                        tienPhatHongMat,
                        "Phạt do sách " + tinhTrang.toLowerCase() + ": " + chiTietMuon.getMaCuonSach(),
                        ngayTra
                );
            }

            updatePhieuMuonStatusIfDone(phieuMuon);
        }

        TraSachResponse response = getById(request.getMaPhieuTra());

        String chiTietTraText = request.getChiTiet()
                .stream()
                .map(item -> item.getMaChiTietMuon() + " - " + item.getTinhTrangKhiTra())
                .collect(Collectors.joining(", "));

        activityLogService.logSafe(
                "Tạo phiếu trả",
                "PHIEUTRA",
                request.getMaPhieuTra(),
                "Độc giả " + request.getMaDocGia()
                        + " trả sách. Chi tiết: "
                        + chiTietTraText
        );

        return response;
    }

    public TraSachResponse getById(String maPhieuTra) {
        PhieuTra phieuTra = phieuTraRepository.findById(maPhieuTra)
                .orElseThrow(() -> new ResourceNotFoundException("Không tìm thấy phiếu trả"));

        List<TraSachResponse.ChiTietTraResponse> chiTiet = chiTietPhieuTraRepository
                .findByMaPhieuTra(maPhieuTra)
                .stream()
                .map(ct -> new TraSachResponse.ChiTietTraResponse(
                        ct.getMaChiTietTra(),
                        ct.getMaChiTietMuon(),
                        ct.getTinhTrangKhiTra(),
                        ct.getSoNgayTre(),
                        ct.getTienPhatTre(),
                        ct.getTienPhatHongMat()
                ))
                .toList();

        return new TraSachResponse(
                phieuTra.getMaPhieuTra(),
                phieuTra.getMaDocGia(),
                phieuTra.getMaNhanVienNhan(),
                phieuTra.getMaChiNhanh(),
                phieuTra.getNgayTra(),
                chiTiet
        );
    }

    private void createKhoanNo(
            String maKhoanNo,
            String maDocGia,
            String maLoaiKhoanNo,
            String maChiTietTra,
            BigDecimal soTien,
            String lyDo,
            LocalDateTime ngayPhatSinh
    ) {
        if (khoanNoRepository.existsById(maKhoanNo)) {
            throw new BusinessException("Mã khoản nợ đã tồn tại: " + maKhoanNo);
        }

        KhoanNo khoanNo = new KhoanNo();
        khoanNo.setMaKhoanNo(maKhoanNo);
        khoanNo.setMaDocGia(maDocGia);
        khoanNo.setMaLoaiKhoanNo(maLoaiKhoanNo);
        khoanNo.setMaChiTietTra(maChiTietTra);
        khoanNo.setSoTienPhatSinh(soTien);
        khoanNo.setSoTienDaThanhToan(BigDecimal.ZERO);
        khoanNo.setNgayPhatSinh(ngayPhatSinh);
        khoanNo.setLyDo(lyDo);
        khoanNo.setTrangThai("Chưa thanh toán");

        khoanNoRepository.save(khoanNo);
    }

    private BigDecimal getMucPhatTreMoiNgay(String maPhienBan) {
        List<BigDecimal> result = jdbcTemplate.query(
                """
                SELECT MucPhatTreMoiNgay
                FROM THAMSOQUYDINH
                WHERE MaPhienBan = ?
                """,
                (rs, rowNum) -> rs.getBigDecimal("MucPhatTreMoiNgay"),
                maPhienBan
        );

        if (result.isEmpty()) {
            throw new BusinessException("Không tìm thấy mức phạt trễ cho phiên bản quy định " + maPhienBan);
        }

        return result.get(0);
    }

    private void updatePhieuMuonStatusIfDone(PhieuMuon phieuMuon) {
        Integer soSachConDangMuon = jdbcTemplate.queryForObject(
                """
                SELECT COUNT(*)
                FROM CHITIETPHIEUMUON
                WHERE MaPhieuMuon = ?
                  AND TrangThai = N'Đang mượn'
                """,
                Integer.class,
                phieuMuon.getMaPhieuMuon()
        );

        if (soSachConDangMuon != null && soSachConDangMuon == 0) {
            phieuMuon.setTrangThai("Đã trả hết");
            phieuMuonRepository.save(phieuMuon);
        }
    }

    private String buildMaChiTietTra(String maPhieuTra, int index) {
        String maChiTietTra = "CTT_" + maPhieuTra + "_" + String.format("%02d", index);

        if (maChiTietTra.length() > 30) {
            throw new BusinessException("Mã chi tiết trả vượt quá 30 ký tự");
        }

        return maChiTietTra;
    }

    private boolean existsById(String tableName, String idColumn, String value) {
        Integer count = jdbcTemplate.queryForObject(
                "SELECT COUNT(*) FROM " + tableName + " WHERE " + idColumn + " = ?",
                Integer.class,
                value
        );

        return count != null && count > 0;
    }
}