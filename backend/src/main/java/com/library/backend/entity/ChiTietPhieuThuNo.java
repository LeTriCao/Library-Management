package com.library.backend.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.math.BigDecimal;

@Entity
@Table(name = "CHITIETPHIEUTHU_NO")
public class ChiTietPhieuThuNo {

    @Id
    @Column(name = "MaChiTietPhieuThu", length = 30)
    private String maChiTietPhieuThu;

    @Column(name = "MaPhieuThu", nullable = false, length = 30)
    private String maPhieuThu;

    @Column(name = "MaKhoanNo", nullable = false, length = 30)
    private String maKhoanNo;

    @Column(name = "SoTienApDung", nullable = false, precision = 18, scale = 2)
    private BigDecimal soTienApDung;

    public String getMaChiTietPhieuThu() { return maChiTietPhieuThu; }
    public void setMaChiTietPhieuThu(String maChiTietPhieuThu) { this.maChiTietPhieuThu = maChiTietPhieuThu; }

    public String getMaPhieuThu() { return maPhieuThu; }
    public void setMaPhieuThu(String maPhieuThu) { this.maPhieuThu = maPhieuThu; }

    public String getMaKhoanNo() { return maKhoanNo; }
    public void setMaKhoanNo(String maKhoanNo) { this.maKhoanNo = maKhoanNo; }

    public BigDecimal getSoTienApDung() { return soTienApDung; }
    public void setSoTienApDung(BigDecimal soTienApDung) { this.soTienApDung = soTienApDung; }
}