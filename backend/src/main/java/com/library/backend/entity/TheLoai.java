package com.library.backend.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "THELOAI", schema = "dbo")
public class TheLoai {

    @Id
    @Column(name = "MaTheLoai", length = 30)
    private String maTheLoai;

    @Column(name = "TenTheLoai", nullable = false, unique = true, length = 100)
    private String tenTheLoai;

    @Column(name = "MoTa", length = 255)
    private String moTa;

    @Column(name = "TrangThai", nullable = false, length = 30)
    private String trangThai;

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

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }
}