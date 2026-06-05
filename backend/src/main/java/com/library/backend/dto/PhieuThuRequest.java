package com.library.backend.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.math.BigDecimal;
import java.util.List;

public class PhieuThuRequest {

    @NotBlank(message = "Mã phiếu thu không được để trống")
    @Size(max = 20, message = "Mã phiếu thu tối đa 20 ký tự")
    private String maPhieuThu;

    @NotBlank(message = "Mã độc giả không được để trống")
    private String maDocGia;

    private String maNhanVienThu;

    @NotBlank(message = "Mã phương thức thanh toán không được để trống")
    private String maPhuongThuc;

    @NotNull(message = "Số tiền thu không được để trống")
    @DecimalMin(value = "0.01", message = "Số tiền thu phải lớn hơn 0")
    private BigDecimal soTienThu;

    private String maGiaoDichNgoai;

    private String ghiChu;

    @Valid
    private List<ChiTietThuNoRequest> chiTietNo;

    public String getMaPhieuThu() { return maPhieuThu; }
    public void setMaPhieuThu(String maPhieuThu) { this.maPhieuThu = maPhieuThu; }

    public String getMaDocGia() { return maDocGia; }
    public void setMaDocGia(String maDocGia) { this.maDocGia = maDocGia; }

    public String getMaNhanVienThu() { return maNhanVienThu; }
    public void setMaNhanVienThu(String maNhanVienThu) { this.maNhanVienThu = maNhanVienThu; }

    public String getMaPhuongThuc() { return maPhuongThuc; }
    public void setMaPhuongThuc(String maPhuongThuc) { this.maPhuongThuc = maPhuongThuc; }

    public BigDecimal getSoTienThu() { return soTienThu; }
    public void setSoTienThu(BigDecimal soTienThu) { this.soTienThu = soTienThu; }

    public String getMaGiaoDichNgoai() { return maGiaoDichNgoai; }
    public void setMaGiaoDichNgoai(String maGiaoDichNgoai) { this.maGiaoDichNgoai = maGiaoDichNgoai; }

    public String getGhiChu() { return ghiChu; }
    public void setGhiChu(String ghiChu) { this.ghiChu = ghiChu; }

    public List<ChiTietThuNoRequest> getChiTietNo() { return chiTietNo; }
    public void setChiTietNo(List<ChiTietThuNoRequest> chiTietNo) { this.chiTietNo = chiTietNo; }

    public static class ChiTietThuNoRequest {

        @NotBlank(message = "Mã khoản nợ không được để trống")
        private String maKhoanNo;

        @NotNull(message = "Số tiền áp dụng không được để trống")
        @DecimalMin(value = "0.01", message = "Số tiền áp dụng phải lớn hơn 0")
        private BigDecimal soTienApDung;

        public String getMaKhoanNo() { return maKhoanNo; }
        public void setMaKhoanNo(String maKhoanNo) { this.maKhoanNo = maKhoanNo; }

        public BigDecimal getSoTienApDung() { return soTienApDung; }
        public void setSoTienApDung(BigDecimal soTienApDung) { this.soTienApDung = soTienApDung; }
    }
}