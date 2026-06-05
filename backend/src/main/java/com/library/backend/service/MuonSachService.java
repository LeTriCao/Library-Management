package com.library.backend.service;

import com.library.backend.dto.MuonSachRequest;
import com.library.backend.dto.MuonSachResponse;
import com.library.backend.entity.ChiTietPhieuMuon;
import com.library.backend.entity.CuonSach;
import com.library.backend.entity.DocGia;
import com.library.backend.entity.PhieuMuon;
import com.library.backend.exception.BusinessException;
import com.library.backend.exception.ResourceNotFoundException;
import com.library.backend.repository.ChiTietPhieuMuonRepository;
import com.library.backend.repository.CuonSachRepository;
import com.library.backend.repository.DocGiaRepository;
import com.library.backend.repository.PhieuMuonRepository;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class MuonSachService {

    private static final String TT_SANCO = "TT_SANCO";
    private static final String TT_DANGMUON = "TT_DANGMUON";

    private final PhieuMuonRepository phieuMuonRepository;
    private final ChiTietPhieuMuonRepository chiTietPhieuMuonRepository;
    private final DocGiaRepository docGiaRepository;
    private final CuonSachRepository cuonSachRepository;
    private final JdbcTemplate jdbcTemplate;
    private final ActivityLogService activityLogService;

    public MuonSachService(
            PhieuMuonRepository phieuMuonRepository,
            ChiTietPhieuMuonRepository chiTietPhieuMuonRepository,
            DocGiaRepository docGiaRepository,
            CuonSachRepository cuonSachRepository,
            JdbcTemplate jdbcTemplate,
            ActivityLogService activityLogService
    ) {
        this.phieuMuonRepository = phieuMuonRepository;
        this.chiTietPhieuMuonRepository = chiTietPhieuMuonRepository;
        this.docGiaRepository = docGiaRepository;
        this.cuonSachRepository = cuonSachRepository;
        this.jdbcTemplate = jdbcTemplate;
        this.activityLogService = activityLogService;
    }

    @Transactional
    public MuonSachResponse create(MuonSachRequest request) {
        validateBasicRequest(request);

        if (phieuMuonRepository.existsById(request.getMaPhieuMuon())) {
            throw new BusinessException("Mã phiếu mượn đã tồn tại");
        }

        if (!existsById("NHANVIEN", "MaNhanVien", request.getMaNhanVienLap())) {
            throw new ResourceNotFoundException("Nhân viên lập phiếu không tồn tại");
        }

        if (!existsById("CHINHANH", "MaChiNhanh", request.getMaChiNhanh())) {
            throw new ResourceNotFoundException("Chi nhánh không tồn tại");
        }

        DocGia docGia = docGiaRepository.findById(request.getMaDocGia())
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Không tìm thấy độc giả với mã: " + request.getMaDocGia()
                ));

        LocalDateTime ngayMuon = LocalDateTime.now();

        validateReaderCanBorrow(docGia, ngayMuon);

        String maPhienBan = getCurrentPolicyVersion();

        String maGoiThanhVien = getCurrentMembershipPlan(
                docGia.getMaDocGia(),
                ngayMuon.toLocalDate()
        );

        int soSachDangMuon = countCurrentLoans(docGia.getMaDocGia());

        int soSachMuonToiDa = getBorrowLimit(
                maPhienBan,
                maGoiThanhVien
        );

        int soSachMuonMoi = request.getMaCuonSachs().size();

        if (soSachDangMuon + soSachMuonMoi > soSachMuonToiDa) {
            throw new BusinessException(
                    "Vượt quá số sách được mượn. Đang mượn "
                            + soSachDangMuon
                            + ", mượn thêm "
                            + soSachMuonMoi
                            + ", tối đa "
                            + soSachMuonToiDa
            );
        }

        PhieuMuon phieuMuon = new PhieuMuon();
        phieuMuon.setMaPhieuMuon(request.getMaPhieuMuon());
        phieuMuon.setMaDocGia(request.getMaDocGia());
        phieuMuon.setMaNhanVienLap(request.getMaNhanVienLap());
        phieuMuon.setMaChiNhanh(request.getMaChiNhanh());
        phieuMuon.setMaPhienBanQuyDinh(maPhienBan);
        phieuMuon.setNgayMuon(ngayMuon);
        phieuMuon.setTrangThai("Đang mượn");
        phieuMuon.setGhiChu(request.getGhiChu());

        phieuMuonRepository.save(phieuMuon);

        for (int i = 0; i < request.getMaCuonSachs().size(); i++) {
            String maCuonSach = request.getMaCuonSachs().get(i);

            CuonSach cuonSach = cuonSachRepository.findByIdForUpdate(maCuonSach)
                    .orElseThrow(() -> new ResourceNotFoundException(
                            "Không tìm thấy cuốn sách: " + maCuonSach
                    ));

            validateBookCopyCanBorrow(
                    cuonSach,
                    request.getMaChiNhanh()
            );

            BorrowRule borrowRule = getBorrowRule(
                    maPhienBan,
                    maGoiThanhVien,
                    maCuonSach
            );

            LocalDateTime hanTra = calculateDueDate(
                    ngayMuon,
                    borrowRule.soNgayMuon,
                    docGia
            );

            String maChiTietMuon = buildMaChiTietMuon(
                    request.getMaPhieuMuon(),
                    i + 1
            );

            ChiTietPhieuMuon chiTiet = new ChiTietPhieuMuon();
            chiTiet.setMaChiTietMuon(maChiTietMuon);
            chiTiet.setMaPhieuMuon(request.getMaPhieuMuon());
            chiTiet.setMaCuonSach(maCuonSach);
            chiTiet.setMaQuyDinhMuon(borrowRule.maQuyDinhMuon);
            chiTiet.setNgayMuon(ngayMuon);
            chiTiet.setHanTra(hanTra);
            chiTiet.setNgayTraThucTe(null);
            chiTiet.setTrangThai("Đang mượn");

            chiTietPhieuMuonRepository.save(chiTiet);

            cuonSach.setMaTrangThai(TT_DANGMUON);
            cuonSachRepository.save(cuonSach);
        }

        MuonSachResponse response = getById(request.getMaPhieuMuon());

        activityLogService.logSafe(
                "Tạo phiếu mượn",
                "PHIEUMUON",
                request.getMaPhieuMuon(),
                "Độc giả " + request.getMaDocGia()
                        + " mượn các cuốn: "
                        + String.join(", ", request.getMaCuonSachs())
                        + " tại chi nhánh " + request.getMaChiNhanh()
        );

        return response;
    }

    public MuonSachResponse getById(String maPhieuMuon) {
        PhieuMuon phieuMuon = phieuMuonRepository.findById(maPhieuMuon)
                .orElseThrow(() -> new ResourceNotFoundException("Không tìm thấy phiếu mượn"));

        List<MuonSachResponse.ChiTietMuonResponse> chiTiet = chiTietPhieuMuonRepository
                .findByMaPhieuMuon(maPhieuMuon)
                .stream()
                .map(ct -> new MuonSachResponse.ChiTietMuonResponse(
                        ct.getMaChiTietMuon(),
                        ct.getMaCuonSach(),
                        ct.getMaQuyDinhMuon(),
                        ct.getNgayMuon(),
                        ct.getHanTra(),
                        ct.getTrangThai()
                ))
                .toList();

        return new MuonSachResponse(
                phieuMuon.getMaPhieuMuon(),
                phieuMuon.getMaDocGia(),
                phieuMuon.getMaNhanVienLap(),
                phieuMuon.getMaChiNhanh(),
                phieuMuon.getMaPhienBanQuyDinh(),
                phieuMuon.getNgayMuon(),
                phieuMuon.getTrangThai(),
                chiTiet
        );
    }

    public List<MuonSachResponse.ChiTietMuonResponse> getCurrentLoansByReader(String maDocGia) {
        String sql = """
                SELECT
                    ctm.MaChiTietMuon,
                    ctm.MaCuonSach,
                    ctm.MaQuyDinhMuon,
                    ctm.NgayMuon,
                    ctm.HanTra,
                    ctm.TrangThai
                FROM PHIEUMUON pm
                INNER JOIN CHITIETPHIEUMUON ctm
                    ON pm.MaPhieuMuon = ctm.MaPhieuMuon
                WHERE pm.MaDocGia = ?
                  AND ctm.TrangThai = N'Đang mượn'
                ORDER BY ctm.HanTra ASC
                """;

        return jdbcTemplate.query(
                sql,
                (rs, rowNum) -> new MuonSachResponse.ChiTietMuonResponse(
                        rs.getString("MaChiTietMuon"),
                        rs.getString("MaCuonSach"),
                        rs.getString("MaQuyDinhMuon"),
                        rs.getTimestamp("NgayMuon").toLocalDateTime(),
                        rs.getTimestamp("HanTra").toLocalDateTime(),
                        rs.getString("TrangThai")
                ),
                maDocGia
        );
    }

    private void validateBasicRequest(MuonSachRequest request) {
        if (request.getMaCuonSachs() == null || request.getMaCuonSachs().isEmpty()) {
            throw new BusinessException("Phiếu mượn phải có ít nhất một cuốn sách");
        }

        if (request.getMaPhieuMuon() != null && request.getMaPhieuMuon().length() > 20) {
            throw new BusinessException("Mã phiếu mượn tối đa 20 ký tự");
        }

        Set<String> uniqueBookCopies = new HashSet<>(request.getMaCuonSachs());

        if (uniqueBookCopies.size() != request.getMaCuonSachs().size()) {
            throw new BusinessException("Danh sách cuốn sách mượn bị trùng");
        }
    }

    private void validateReaderCanBorrow(DocGia docGia, LocalDateTime ngayMuon) {
        if (!"Hoạt động".equals(docGia.getTrangThai())) {
            throw new BusinessException("Độc giả không ở trạng thái hoạt động");
        }

        if (!docGia.getNgayHetHanThe().isAfter(ngayMuon.toLocalDate())) {
            throw new BusinessException("Thẻ độc giả đã hết hạn hoặc hết hạn trong ngày hôm nay");
        }

        BigDecimal tongNo = jdbcTemplate.queryForObject(
                """
                SELECT CAST(COALESCE(SUM(SoTienConLai), 0) AS DECIMAL(18,2))
                FROM KHOANNO
                WHERE MaDocGia = ?
                  AND TrangThai <> N'Đã thanh toán'
                """,
                BigDecimal.class,
                docGia.getMaDocGia()
        );

        if (tongNo != null && tongNo.compareTo(BigDecimal.ZERO) > 0) {
            throw new BusinessException("Độc giả đang có nợ, không được mượn sách");
        }

        Integer soSachQuaHan = jdbcTemplate.queryForObject(
                """
                SELECT COUNT(*)
                FROM PHIEUMUON pm
                INNER JOIN CHITIETPHIEUMUON ctm
                    ON pm.MaPhieuMuon = ctm.MaPhieuMuon
                WHERE pm.MaDocGia = ?
                  AND ctm.TrangThai = N'Đang mượn'
                  AND ctm.HanTra < ?
                """,
                Integer.class,
                docGia.getMaDocGia(),
                ngayMuon
        );

        if (soSachQuaHan != null && soSachQuaHan > 0) {
            throw new BusinessException("Độc giả có sách quá hạn chưa trả");
        }
    }

    private void validateBookCopyCanBorrow(CuonSach cuonSach, String maChiNhanh) {
        if (!maChiNhanh.equals(cuonSach.getMaChiNhanh())) {
            throw new BusinessException(
                    "Cuốn sách "
                            + cuonSach.getMaCuonSach()
                            + " không thuộc chi nhánh đã chọn"
            );
        }

        if (!TT_SANCO.equals(cuonSach.getMaTrangThai())) {
            throw new BusinessException(
                    "Cuốn sách "
                            + cuonSach.getMaCuonSach()
                            + " không ở trạng thái sẵn có"
            );
        }
    }

    private String getCurrentPolicyVersion() {
        List<String> result = jdbcTemplate.query(
                """
                SELECT TOP 1 MaPhienBan
                FROM PHIENBANQUYDINH
                WHERE TrangThai = N'Đang áp dụng'
                ORDER BY NgayApDung DESC
                """,
                (rs, rowNum) -> rs.getString("MaPhienBan")
        );

        if (result.isEmpty()) {
            throw new BusinessException("Chưa có phiên bản quy định đang áp dụng");
        }

        return result.get(0);
    }

    private String getCurrentMembershipPlan(String maDocGia, LocalDate ngayMuon) {
        List<String> result = jdbcTemplate.query(
                """
                SELECT TOP 1 MaGoiThanhVien
                FROM LICHSUGOITHANHVIEN
                WHERE MaDocGia = ?
                  AND TrangThai = N'Đang sử dụng'
                  AND NgayBatDau <= ?
                  AND NgayKetThuc >= ?
                ORDER BY NgayBatDau DESC
                """,
                (rs, rowNum) -> rs.getString("MaGoiThanhVien"),
                maDocGia,
                ngayMuon,
                ngayMuon
        );

        if (result.isEmpty()) {
            throw new BusinessException("Độc giả chưa có gói thành viên đang sử dụng");
        }

        return result.get(0);
    }

    private int countCurrentLoans(String maDocGia) {
        Integer count = jdbcTemplate.queryForObject(
                """
                SELECT COUNT(*)
                FROM PHIEUMUON pm
                INNER JOIN CHITIETPHIEUMUON ctm
                    ON pm.MaPhieuMuon = ctm.MaPhieuMuon
                WHERE pm.MaDocGia = ?
                  AND ctm.TrangThai = N'Đang mượn'
                """,
                Integer.class,
                maDocGia
        );

        return count == null ? 0 : count;
    }

    private int getBorrowLimit(String maPhienBan, String maGoiThanhVien) {
        List<Integer> result = jdbcTemplate.query(
                """
                SELECT SoSachMuonToiDa
                FROM QUYDINHGOI
                WHERE MaPhienBan = ?
                  AND MaGoiThanhVien = ?
                """,
                (rs, rowNum) -> rs.getInt("SoSachMuonToiDa"),
                maPhienBan,
                maGoiThanhVien
        );

        if (result.isEmpty()) {
            throw new BusinessException(
                    "Chưa có quy định số sách mượn tối đa cho gói "
                            + maGoiThanhVien
            );
        }

        return result.get(0);
    }

    private BorrowRule getBorrowRule(
            String maPhienBan,
            String maGoiThanhVien,
            String maCuonSach
    ) {
        String sql = """
                SELECT TOP 1
                    qdm.MaQuyDinhMuon,
                    qdm.SoNgayMuon
                FROM CUONSACH cs
                INNER JOIN DAUSACH_THELOAI dstl
                    ON cs.MaDauSach = dstl.MaDauSach
                INNER JOIN QUYDINHMUON_THELOAI qdm
                    ON dstl.MaTheLoai = qdm.MaTheLoai
                WHERE cs.MaCuonSach = ?
                  AND qdm.MaPhienBan = ?
                  AND qdm.MaGoiThanhVien = ?
                ORDER BY qdm.SoNgayMuon ASC, qdm.MaQuyDinhMuon ASC
                """;

        List<BorrowRule> result = jdbcTemplate.query(
                sql,
                (rs, rowNum) -> new BorrowRule(
                        rs.getString("MaQuyDinhMuon"),
                        rs.getInt("SoNgayMuon")
                ),
                maCuonSach,
                maPhienBan,
                maGoiThanhVien
        );

        if (result.isEmpty()) {
            throw new BusinessException(
                    "Chưa có quy định mượn phù hợp cho cuốn sách "
                            + maCuonSach
                            + " và gói "
                            + maGoiThanhVien
            );
        }

        return result.get(0);
    }

    private LocalDateTime calculateDueDate(
            LocalDateTime ngayMuon,
            int soNgayMuon,
            DocGia docGia
    ) {
        LocalDateTime hanTraTheoQuyDinh = ngayMuon.plusDays(soNgayMuon);

        LocalDateTime hanToiDaTheoThe = docGia.getNgayHetHanThe()
                .minusDays(1)
                .atTime(23, 59, 59);

        LocalDateTime hanTraThucTe = hanTraTheoQuyDinh.isBefore(hanToiDaTheoThe)
                ? hanTraTheoQuyDinh
                : hanToiDaTheoThe;

        if (!hanTraThucTe.isAfter(ngayMuon)) {
            throw new BusinessException("Thẻ độc giả sắp hết hạn, không thể mượn sách");
        }

        return hanTraThucTe;
    }

    private String buildMaChiTietMuon(String maPhieuMuon, int index) {
        String maChiTietMuon = "CTM_" + maPhieuMuon + "_" + String.format("%02d", index);

        if (maChiTietMuon.length() > 30) {
            throw new BusinessException("Mã chi tiết mượn vượt quá 30 ký tự");
        }

        return maChiTietMuon;
    }

    private boolean existsById(String tableName, String idColumn, String value) {
        Integer count = jdbcTemplate.queryForObject(
                "SELECT COUNT(*) FROM " + tableName + " WHERE " + idColumn + " = ?",
                Integer.class,
                value
        );

        return count != null && count > 0;
    }

    private static class BorrowRule {
        private final String maQuyDinhMuon;
        private final int soNgayMuon;

        public BorrowRule(String maQuyDinhMuon, int soNgayMuon) {
            this.maQuyDinhMuon = maQuyDinhMuon;
            this.soNgayMuon = soNgayMuon;
        }
    }
}