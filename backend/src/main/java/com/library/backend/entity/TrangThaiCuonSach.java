package com.library.backend.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "TRANGTHAICUONSACH")
public class TrangThaiCuonSach {

    @Id
    @Column(name = "MaTrangThai", length = 30)
    private String maTrangThai;

    @Column(name = "TenTrangThai", nullable = false, length = 100)
    private String tenTrangThai;

    @Column(name = "MoTa", length = 255)
    private String moTa;

    public String getMaTrangThai() {
        return maTrangThai;
    }

    public void setMaTrangThai(String maTrangThai) {
        this.maTrangThai = maTrangThai;
    }

    public String getTenTrangThai() {
        return tenTrangThai;
    }

    public void setTenTrangThai(String tenTrangThai) {
        this.tenTrangThai = tenTrangThai;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }
}