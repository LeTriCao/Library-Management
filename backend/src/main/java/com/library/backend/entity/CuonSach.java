package com.library.backend.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.time.LocalDate;

@Entity
@Table(name = "CUONSACH")
public class CuonSach {

    @Id
    @Column(name = "MaCuonSach", length = 40)
    private String maCuonSach;

    @Column(name = "MaDauSach", nullable = false, length = 30)
    private String maDauSach;

    @Column(name = "MaChiNhanh", nullable = false, length = 30)
    private String maChiNhanh;

    @Column(name = "MaViTri", nullable = false, length = 30)
    private String maViTri;

    @Column(name = "MaTrangThai", nullable = false, length = 30)
    private String maTrangThai;

    @Column(name = "MaVach", length = 100)
    private String maVach;

    @Column(name = "MaQRCode", length = 100)
    private String maQrCode;

    @Column(name = "NgayNhapSach", nullable = false)
    private LocalDate ngayNhapSach;

    @Column(name = "GhiChu", length = 255)
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