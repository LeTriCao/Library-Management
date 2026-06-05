package com.library.backend.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class TheLoaiRequest {

    @NotBlank(message = "Mã thể loại không được để trống")
    @Size(max = 30, message = "Mã thể loại tối đa 30 ký tự")
    private String maTheLoai;

    @NotBlank(message = "Tên thể loại không được để trống")
    @Size(max = 100, message = "Tên thể loại tối đa 100 ký tự")
    private String tenTheLoai;

    @Size(max = 255, message = "Mô tả tối đa 255 ký tự")
    private String moTa;

    public String getMaTheLoai() {
        return maTheLoai;
    }

    public void setMaTheLoai(String maTheLoai) {
        this.maTheLoai = maTheLoai;
    }

    public String getTenTheLoai() {
        return tenTheLoai;
    }

    public void setTenTheLoai(String tenTheLoai) {
        this.tenTheLoai = tenTheLoai;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }
}