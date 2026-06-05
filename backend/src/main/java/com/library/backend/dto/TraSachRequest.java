package com.library.backend.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

import java.math.BigDecimal;
import java.util.List;

public class TraSachRequest {

    @NotBlank(message = "Mã phiếu trả không được để trống")
    @Size(max = 20, message = "Mã phiếu trả tối đa 20 ký tự")
    private String maPhieuTra;

    @NotBlank(message = "Mã độc giả không được để trống")
    private String maDocGia;

    @NotBlank(message = "Mã nhân viên nhận không được để trống")
    private String maNhanVienNhan;

    @NotBlank(message = "Mã chi nhánh không được để trống")
    private String maChiNhanh;

    @NotEmpty(message = "Phải có ít nhất một cuốn sách được trả")
    @Valid
    private List<ChiTietTraRequest> chiTiet;

    private String ghiChu;

    public String getMaPhieuTra() { return maPhieuTra; }
    public void setMaPhieuTra(String maPhieuTra) { this.maPhieuTra = maPhieuTra; }

    public String getMaDocGia() { return maDocGia; }
    public void setMaDocGia(String maDocGia) { this.maDocGia = maDocGia; }

    public String getMaNhanVienNhan() { return maNhanVienNhan; }
    public void setMaNhanVienNhan(String maNhanVienNhan) { this.maNhanVienNhan = maNhanVienNhan; }

    public String getMaChiNhanh() { return maChiNhanh; }
    public void setMaChiNhanh(String maChiNhanh) { this.maChiNhanh = maChiNhanh; }

    public List<ChiTietTraRequest> getChiTiet() { return chiTiet; }
    public void setChiTiet(List<ChiTietTraRequest> chiTiet) { this.chiTiet = chiTiet; }

    public String getGhiChu() { return ghiChu; }
    public void setGhiChu(String ghiChu) { this.ghiChu = ghiChu; }

    public static class ChiTietTraRequest {

        @NotBlank(message = "Mã chi tiết mượn không được để trống")
        private String maChiTietMuon;

        @NotBlank(message = "Tình trạng khi trả không được để trống")
        private String tinhTrangKhiTra;

        @DecimalMin(value = "0.0", message = "Tiền phạt hỏng/mất không được âm")
        private BigDecimal tienPhatHongMat;

        private String ghiChu;

        public String getMaChiTietMuon() { return maChiTietMuon; }
        public void setMaChiTietMuon(String maChiTietMuon) { this.maChiTietMuon = maChiTietMuon; }

        public String getTinhTrangKhiTra() { return tinhTrangKhiTra; }
        public void setTinhTrangKhiTra(String tinhTrangKhiTra) { this.tinhTrangKhiTra = tinhTrangKhiTra; }

        public BigDecimal getTienPhatHongMat() { return tienPhatHongMat; }
        public void setTienPhatHongMat(BigDecimal tienPhatHongMat) { this.tienPhatHongMat = tienPhatHongMat; }

        public String getGhiChu() { return ghiChu; }
        public void setGhiChu(String ghiChu) { this.ghiChu = ghiChu; }
    }
}