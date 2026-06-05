package com.library.backend.dto;

public class TheLoaiResponse {

    private String maTheLoai;
    private String tenTheLoai;
    private String moTa;
    private String trangThai;

    public TheLoaiResponse(String maTheLoai, String tenTheLoai, String moTa, String trangThai) {
        this.maTheLoai = maTheLoai;
        this.tenTheLoai = tenTheLoai;
        this.moTa = moTa;
        this.trangThai = trangThai;
    }

    public String getMaTheLoai() {
        return maTheLoai;
    }

    public String getTenTheLoai() {
        return tenTheLoai;
    }

    public String getMoTa() {
        return moTa;
    }

    public String getTrangThai() {
        return trangThai;
    }
}