package com.library.backend.dto;

public class NhaXuatBanResponse {

    private String maNhaXuatBan;
    private String tenNhaXuatBan;
    private String diaChi;
    private String email;
    private String soDienThoai;

    public NhaXuatBanResponse(
            String maNhaXuatBan,
            String tenNhaXuatBan,
            String diaChi,
            String email,
            String soDienThoai
    ) {
        this.maNhaXuatBan = maNhaXuatBan;
        this.tenNhaXuatBan = tenNhaXuatBan;
        this.diaChi = diaChi;
        this.email = email;
        this.soDienThoai = soDienThoai;
    }

    public String getMaNhaXuatBan() {
        return maNhaXuatBan;
    }

    public String getTenNhaXuatBan() {
        return tenNhaXuatBan;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public String getEmail() {
        return email;
    }

    public String getSoDienThoai() {
        return soDienThoai;
    }
}