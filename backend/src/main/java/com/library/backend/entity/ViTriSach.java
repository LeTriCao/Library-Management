package com.library.backend.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "VITRISACH")
public class ViTriSach {

    @Id
    @Column(name = "MaViTri", length = 30)
    private String maViTri;

    @Column(name = "MaKeSach", nullable = false, length = 30)
    private String maKeSach;

    @Column(name = "MaViTriHienThi", nullable = false, length = 100)
    private String maViTriHienThi;

    @Column(name = "MoTa", length = 255)
    private String moTa;

    public String getMaViTri() {
        return maViTri;
    }

    public void setMaViTri(String maViTri) {
        this.maViTri = maViTri;
    }

    public String getMaKeSach() {
        return maKeSach;
    }

    public void setMaKeSach(String maKeSach) {
        this.maKeSach = maKeSach;
    }

    public String getMaViTriHienThi() {
        return maViTriHienThi;
    }

    public void setMaViTriHienThi(String maViTriHienThi) {
        this.maViTriHienThi = maViTriHienThi;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }
}