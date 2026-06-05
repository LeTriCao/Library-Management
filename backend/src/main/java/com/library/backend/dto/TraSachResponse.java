package com.library.backend.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public class TraSachResponse {

    private String maPhieuTra;
    private String maDocGia;
    private String maNhanVienNhan;
    private String maChiNhanh;
    private LocalDateTime ngayTra;
    private List<ChiTietTraResponse> chiTiet;

    public TraSachResponse(
            String maPhieuTra,
            String maDocGia,
            String maNhanVienNhan,
            String maChiNhanh,
            LocalDateTime ngayTra,
            List<ChiTietTraResponse> chiTiet
    ) {
        this.maPhieuTra = maPhieuTra;
        this.maDocGia = maDocGia;
        this.maNhanVienNhan = maNhanVienNhan;
        this.maChiNhanh = maChiNhanh;
        this.ngayTra = ngayTra;
        this.chiTiet = chiTiet;
    }

    public String getMaPhieuTra() { return maPhieuTra; }
    public String getMaDocGia() { return maDocGia; }
    public String getMaNhanVienNhan() { return maNhanVienNhan; }
    public String getMaChiNhanh() { return maChiNhanh; }
    public LocalDateTime getNgayTra() { return ngayTra; }
    public List<ChiTietTraResponse> getChiTiet() { return chiTiet; }

    public static class ChiTietTraResponse {
        private String maChiTietTra;
        private String maChiTietMuon;
        private String tinhTrangKhiTra;
        private Integer soNgayTre;
        private BigDecimal tienPhatTre;
        private BigDecimal tienPhatHongMat;

        public ChiTietTraResponse(
                String maChiTietTra,
                String maChiTietMuon,
                String tinhTrangKhiTra,
                Integer soNgayTre,
                BigDecimal tienPhatTre,
                BigDecimal tienPhatHongMat
        ) {
            this.maChiTietTra = maChiTietTra;
            this.maChiTietMuon = maChiTietMuon;
            this.tinhTrangKhiTra = tinhTrangKhiTra;
            this.soNgayTre = soNgayTre;
            this.tienPhatTre = tienPhatTre;
            this.tienPhatHongMat = tienPhatHongMat;
        }

        public String getMaChiTietTra() { return maChiTietTra; }
        public String getMaChiTietMuon() { return maChiTietMuon; }
        public String getTinhTrangKhiTra() { return tinhTrangKhiTra; }
        public Integer getSoNgayTre() { return soNgayTre; }
        public BigDecimal getTienPhatTre() { return tienPhatTre; }
        public BigDecimal getTienPhatHongMat() { return tienPhatHongMat; }
    }
}