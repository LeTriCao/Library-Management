package com.library.backend.controller;

import com.library.backend.dto.OptionResponse;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/options")
public class OptionController {

    private final JdbcTemplate jdbcTemplate;

    public OptionController(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @GetMapping("/branches")
    public List<OptionResponse> getBranches() {
        String sql = """
                SELECT MaChiNhanh AS value, TenChiNhanh AS label
                FROM CHINHANH
                WHERE TrangThai = N'Hoạt động'
                ORDER BY TenChiNhanh
                """;

        return queryOptions(sql);
    }

    @GetMapping("/book-locations")
    public List<OptionResponse> getBookLocations() {
        String sql = """
                SELECT 
                    vt.MaViTri AS value,
                    CONCAT(k.TenKhu, N' - ', ks.TenKeSach, N' - ', vt.MaViTriHienThi) AS label
                FROM VITRISACH vt
                INNER JOIN KESACH ks ON vt.MaKeSach = ks.MaKeSach
                INNER JOIN KHU k ON ks.MaKhu = k.MaKhu
                ORDER BY k.TenKhu, ks.TenKeSach, vt.MaViTriHienThi
                """;

        return queryOptions(sql);
    }

    @GetMapping("/book-copy-statuses")
    public List<OptionResponse> getBookCopyStatuses() {
        String sql = """
                SELECT MaTrangThai AS value, TenTrangThai AS label
                FROM TRANGTHAICUONSACH
                ORDER BY TenTrangThai
                """;

        return queryOptions(sql);
    }

    @GetMapping("/reader-groups")
    public List<OptionResponse> getReaderGroups() {
        String sql = """
                SELECT MaNhomDocGia AS value, TenNhomDocGia AS label
                FROM NHOMDOCGIA
                ORDER BY TenNhomDocGia
                """;

        return queryOptions(sql);
    }

    @GetMapping("/membership-plans")
    public List<OptionResponse> getMembershipPlans() {
        String sql = """
                SELECT MaGoiThanhVien AS value, TenGoi AS label
                FROM GOITHANHVIEN
                WHERE TrangThai = N'Hoạt động'
                ORDER BY TenGoi
                """;

        return queryOptions(sql);
    }

    @GetMapping("/payment-methods")
    public List<OptionResponse> getPaymentMethods() {
        String sql = """
                SELECT MaPhuongThuc AS value, TenPhuongThuc AS label
                FROM PHUONGTHUCTHANHTOAN
                ORDER BY TenPhuongThuc
                """;

        return queryOptions(sql);
    }

    private List<OptionResponse> queryOptions(String sql) {
        return jdbcTemplate.query(
                sql,
                (rs, rowNum) -> new OptionResponse(
                        rs.getString("value"),
                        rs.getString("label")
                )
        );
    }
}