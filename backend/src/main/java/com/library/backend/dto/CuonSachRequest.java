package com.library.backend.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

public class CuonSachRequest {

    @NotBlank(message = "Mã cuốn sách không được để trống")
    @Size(max = 40, message = "Mã cuốn sách tối đa 40 ký tự")
    private String maCuonSach;

    @NotBlank(message = "Mã đầu sách không được để trống")
    @Size(max = 30, message = "Mã đầu sách tối đa 30 ký tự")
    private String maDauSach;

    @NotBlank(message = "Mã chi nhánh không được để trống")
    @Size(max = 30, message = "Mã chi nhánh tối đa 30 ký tự")
    private String maChiNhanh;

    @NotBlank(message = "Mã vị trí không được để trống")
    @Size(max = 30, message = "Mã vị trí tối đa 30 ký tự")
    private String maViTri;

    @Size(max = 30, message = "Mã trạng thái tối đa 30 ký tự")
    private String maTrangThai;

    @Size(max = 100, message = "Mã vạch tối đa 100 ký tự")
    private String maVach;

    @Size(max = 100, message = "Mã QR tối đa 100 ký tự")
    private String maQrCode;

    @PastOrPresent(message = "Ngày nhập sách không được lớn hơn ngày hiện tại")
    private LocalDate ngayNhapSach;

    @Size(max = 255, message = "Ghi chú tối đa 255 ký tự")
    private String ghiChu;

    public String getMaCuonSach() {
        return maCuonSach;
    }

    public void setMaCuonSach(String maCuonSach) {
        this.maCuonSach = maCuonSach;
    }

    public String getMaDauSach() {
        return maDauSach;
    }

    public void setMaDauSach(String maDauSach) {
        this.maDauSach = maDauSach;
    }

    public String getMaChiNhanh() {
        return maChiNhanh;
    }

    public void setMaChiNhanh(String maChiNhanh) {
        this.maChiNhanh = maChiNhanh;
    }

    public String getMaViTri() {
        return maViTri;
    }

    public void setMaViTri(String maViTri) {
        this.maViTri = maViTri;
    }

    public String getMaTrangThai() {
        return maTrangThai;
    }

    public void setMaTrangThai(String maTrangThai) {
        this.maTrangThai = maTrangThai;
    }

    public String getMaVach() {
        return maVach;
    }

    public void setMaVach(String maVach) {
        this.maVach = maVach;
    }

    public String getMaQrCode() {
        return maQrCode;
    }

    public void setMaQrCode(String maQrCode) {
        this.maQrCode = maQrCode;
    }

    public LocalDate getNgayNhapSach() {
        return ngayNhapSach;
    }

    public void setNgayNhapSach(LocalDate ngayNhapSach) {
        this.ngayNhapSach = ngayNhapSach;
    }

    public String getGhiChu() {
        return ghiChu;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }
}