package com.library.backend.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "VAITRO")
public class VaiTro {

    @Id
    @Column(name = "MaVaiTro", length = 20)
    private String maVaiTro;

    @Column(name = "TenVaiTro", nullable = false, length = 50)
    private String tenVaiTro;

    @Column(name = "MoTa", length = 255)
    private String moTa;

    public String getMaVaiTro() {
        return maVaiTro;
    }

    public void setMaVaiTro(String maVaiTro) {
        this.maVaiTro = maVaiTro;
    }

    public String getTenVaiTro() {
        return tenVaiTro;
    }

    public void setTenVaiTro(String tenVaiTro) {
        this.tenVaiTro = tenVaiTro;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }
}