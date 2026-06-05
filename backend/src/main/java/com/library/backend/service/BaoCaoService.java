package com.library.backend.service;

import com.library.backend.dto.*;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class BaoCaoService {

    private final JdbcTemplate jdbcTemplate;

    public BaoCaoService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<TongNoDocGiaReportResponse> getTongNoDocGia() {
        String sql = """
                SELECT MaDocGia, HoTen, TongNoConLai
                FROM VW_TONGNO_DOCGIA
                ORDER BY TongNoConLai DESC, MaDocGia ASC
                """;

        return jdbcTemplate.query(
                sql,
                (rs, rowNum) -> new TongNoDocGiaReportResponse(
                        rs.getString("MaDocGia"),
                        rs.getString("HoTen"),
                        rs.getBigDecimal("TongNoConLai")
                )
        );
    }

    public List<SachDangMuonReportResponse> getSoSachDangMuon() {
        String sql = """
                SELECT MaDocGia, HoTen, SoSachDangMuon
                FROM VW_SOSACH_DANGMUON
                ORDER BY SoSachDangMuon DESC, MaDocGia ASC
                """;

        return jdbcTemplate.query(
                sql,
                (rs, rowNum) -> new SachDangMuonReportResponse(
                        rs.getString("MaDocGia"),
                        rs.getString("HoTen"),
                        rs.getInt("SoSachDangMuon")
                )
        );
    }

    public List<BaoCaoMuonTheLoaiResponse> getBaoCaoMuonTheoTheLoai(Integer month, Integer year) {
        validateMonthYear(month, year);

        String sql = """
                SELECT Thang, Nam, MaTheLoai, TenTheLoai, SoLuotMuon, TiLePhanTram
                FROM VW_BAOCAO_MUON_THELOAI
                WHERE Thang = ?
                  AND Nam = ?
                ORDER BY SoLuotMuon DESC, TenTheLoai ASC
                """;

        return jdbcTemplate.query(
                sql,
                (rs, rowNum) -> new BaoCaoMuonTheLoaiResponse(
                        rs.getInt("Thang"),
                        rs.getInt("Nam"),
                        rs.getString("MaTheLoai"),
                        rs.getString("TenTheLoai"),
                        rs.getLong("SoLuotMuon"),
                        rs.getBigDecimal("TiLePhanTram")
                ),
                month,
                year
        );
    }

    public List<BaoCaoTraTreResponse> getBaoCaoTraTre(Integer month, Integer year) {
        validateMonthYear(month, year);

        String sql = """
                SELECT 
                    Thang,
                    Nam,
                    MaCuonSach,
                    TenDauSach,
                    MaDocGia,
                    HoTenDocGia,
                    NgayMuon,
                    HanTra,
                    NgayTraThucTe,
                    SoNgayTre,
                    TienPhatTre
                FROM VW_BAOCAO_TRA_TRE
                WHERE Thang = ?
                  AND Nam = ?
                ORDER BY SoNgayTre DESC, TienPhatTre DESC
                """;

        return jdbcTemplate.query(
                sql,
                (rs, rowNum) -> new BaoCaoTraTreResponse(
                        rs.getInt("Thang"),
                        rs.getInt("Nam"),
                        rs.getString("MaCuonSach"),
                        rs.getString("TenDauSach"),
                        rs.getString("MaDocGia"),
                        rs.getString("HoTenDocGia"),
                        toLocalDateTime(rs.getTimestamp("NgayMuon")),
                        toLocalDateTime(rs.getTimestamp("HanTra")),
                        toLocalDateTime(rs.getTimestamp("NgayTraThucTe")),
                        rs.getInt("SoNgayTre"),
                        rs.getBigDecimal("TienPhatTre")
                ),
                month,
                year
        );
    }

    private void validateMonthYear(Integer month, Integer year) {
        if (month == null || month < 1 || month > 12) {
            throw new RuntimeException("Tháng phải từ 1 đến 12");
        }

        if (year == null || year < 2000 || year > 2100) {
            throw new RuntimeException("Năm không hợp lệ");
        }
    }

    private LocalDateTime toLocalDateTime(Timestamp timestamp) {
        if (timestamp == null) {
            return null;
        }

        return timestamp.toLocalDateTime();
    }
}