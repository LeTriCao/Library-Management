package com.library.backend.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.math.BigDecimal;

@Entity
@Table(name = "DAUSACH")
public class DauSach {

    @Id
    @Column(name = "MaDauSach", length = 30)
    private String maDauSach;

    @Column(name = "MaNhaXuatBan", length = 30)
    private String maNhaXuatBan;

    @Column(name = "TenDauSach", nullable = false, length = 200)
    private String tenDauSach;

    @Column(name = "ISBN", length = 30)
    private String isbn;

    @Column(name = "NamXuatBan", nullable = false)
    private Integer namXuatBan;

    @Column(name = "NgonNgu", length = 50)
    private String ngonNgu;

    @Column(name = "SoTrang")
    private Integer soTrang;

    @Column(name = "MoTa", columnDefinition = "NVARCHAR(MAX)")
    private String moTa;

    @Column(name = "AnhBia", length = 500)
    private String anhBia;

    @Column(name = "TriGia", nullable = false, precision = 18, scale = 2)
    private BigDecimal triGia;

    @Column(name = "TrangThai", nullable = false, length = 30)
    private String trangThai;

    public String getMaDauSach() {
        return maDauSach;
    }

    public void setMaDauSach(String maDauSach) {
        this.maDauSach = maDauSach;
    }

    public String getMaNhaXuatBan() {
        return maNhaXuatBan;
    }

    public void setMaNhaXuatBan(String maNhaXuatBan) {
        this.maNhaXuatBan = maNhaXuatBan;
    }

    public String getTenDauSach() {
        return tenDauSach;
    }

    public void setTenDauSach(String tenDauSach) {
        this.tenDauSach = tenDauSach;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public Integer getNamXuatBan() {
        return namXuatBan;
    }

    public void setNamXuatBan(Integer namXuatBan) {
        this.namXuatBan = namXuatBan;
    }

    public String getNgonNgu() {
        return ngonNgu;
    }

    public void setNgonNgu(String ngonNgu) {
        this.ngonNgu = ngonNgu;
    }

    public Integer getSoTrang() {
        return soTrang;
    }

    public void setSoTrang(Integer soTrang) {
        this.soTrang = soTrang;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    public String getAnhBia() {
        return anhBia;
    }

    public void setAnhBia(String anhBia) {
        this.anhBia = anhBia;
    }

    public BigDecimal getTriGia() {
        return triGia;
    }

    public void setTriGia(BigDecimal triGia) {
        this.triGia = triGia;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }
}