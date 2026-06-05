package com.library.backend.dto;

public class TacGiaResponse {

    private String maTacGia;
    private String tenTacGia;
    private String moTa;

    public TacGiaResponse(String maTacGia, String tenTacGia, String moTa) {
        this.maTacGia = maTacGia;
        this.tenTacGia = tenTacGia;
        this.moTa = moTa;
    }

    public String getMaTacGia() {
        return maTacGia;
    }

    public String getTenTacGia() {
        return tenTacGia;
    }

    public String getMoTa() {
        return moTa;
    }
}