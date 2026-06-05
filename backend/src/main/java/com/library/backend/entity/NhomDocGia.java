package com.library.backend.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "NHOMDOCGIA")
public class NhomDocGia {

    @Id
    @Column(name = "MaNhomDocGia", length = 30)
    private String maNhomDocGia;

    @Column(name = "TenNhomDocGia", nullable = false, length = 100)
    private String tenNhomDocGia;

    @Column(name = "MoTa", length = 255)
    private String moTa;

    public String getMaNhomDocGia() { return maNhomDocGia; }
    public void setMaNhomDocGia(String maNhomDocGia) { this.maNhomDocGia = maNhomDocGia; }

    public String getTenNhomDocGia() { return tenNhomDocGia; }
    public void setTenNhomDocGia(String tenNhomDocGia) { this.tenNhomDocGia = tenNhomDocGia; }

    public String getMoTa() { return moTa; }
    public void setMoTa(String moTa) { this.moTa = moTa; }
}