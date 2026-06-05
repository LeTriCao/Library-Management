package com.library.backend.dto;

import java.time.LocalDate;

public class CuonSachResponse {

    private String maCuonSach;
    private String maDauSach;
    private String tenDauSach;
    private String maChiNhanh;
    private String maViTri;
    private String maTrangThai;
    private String tenTrangThai;
    private String maVach;
    private String maQrCode;
    private LocalDate ngayNhapSach;
    private String ghiChu;

    public CuonSachResponse(
            String maCuonSach,
            String maDauSach,
            String tenDauSach,
            String maChiNhanh,
            String maViTri,
            String maTrangThai,
            String tenTrangThai,
            String maVach,
            String maQrCode,
            LocalDate ngayNhapSach,
            String ghiChu
    ) {
        this.maCuonSach = maCuonSach;
        this.maDauSach = maDauSach;
        this.tenDauSach = tenDauSach;
        this.maChiNhanh = maChiNhanh;
        this.maViTri = maViTri;
        this.maTrangThai = maTrangThai;
        this.tenTrangThai = tenTrangThai;
        this.maVach = maVach;
        this.maQrCode = maQrCode;
        this.ngayNhapSach = ngayNhapSach;
        this.ghiChu = ghiChu;
    }

    public String getMaCuonSach() {
        return maCuonSach;
    }

    public String getMaDauSach() {
        return maDauSach;
    }

    public String getTenDauSach() {
        return tenDauSach;
    }

    public String getMaChiNhanh() {
        return maChiNhanh;
    }

    public String getMaViTri() {
        return maViTri;
    }

    public String getMaTrangThai() {
        return maTrangThai;
    }

    public String getTenTrangThai() {
        return tenTrangThai;
    }

    public String getMaVach() {
        return maVach;
    }

    public String getMaQrCode() {
        return maQrCode;
    }

    public LocalDate getNgayNhapSach() {
        return ngayNhapSach;
    }

    public String getGhiChu() {
        return ghiChu;
    }
}