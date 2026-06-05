package com.library.backend.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "GOITHANHVIEN")
public class GoiThanhVien {

    @Id
    @Column(name = "MaGoiThanhVien", length = 30)
    private String maGoiThanhVien;

    @Column(name = "TenGoi", nullable = false, length = 100)
    private String tenGoi;

    @Column(name = "MoTa", length = 255)
    private String moTa;

    @Column(name = "TrangThai", nullable = false, length = 30)
    private String trangThai;

    public String getMaGoiThanhVien() { return maGoiThanhVien; }
    public void setMaGoiThanhVien(String maGoiThanhVien) { this.maGoiThanhVien = maGoiThanhVien; }

    public String getTenGoi() { return tenGoi; }
    public void setTenGoi(String tenGoi) { this.tenGoi = tenGoi; }

    public String getMoTa() { return moTa; }
    public void setMoTa(String moTa) { this.moTa = moTa; }

    public String getTrangThai() { return trangThai; }
    public void setTrangThai(String trangThai) { this.trangThai = trangThai; }
}