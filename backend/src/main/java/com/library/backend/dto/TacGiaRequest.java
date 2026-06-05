package com.library.backend.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class TacGiaRequest {

    @NotBlank(message = "Mã tác giả không được để trống")
    @Size(max = 30, message = "Mã tác giả tối đa 30 ký tự")
    private String maTacGia;

    @NotBlank(message = "Tên tác giả không được để trống")
    @Size(max = 150, message = "Tên tác giả tối đa 150 ký tự")
    private String tenTacGia;

    @Size(max = 255, message = "Mô tả tối đa 255 ký tự")
    private String moTa;

    public String getMaTacGia() {
        return maTacGia;
    }

    public void setMaTacGia(String maTacGia) {
        this.maTacGia = maTacGia;
    }

    public String getTenTacGia() {
        return tenTacGia;
    }

    public void setTenTacGia(String tenTacGia) {
        this.tenTacGia = tenTacGia;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }
}