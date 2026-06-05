package com.library.backend.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.math.BigDecimal;

@Entity
@Table(name = "CHITIETPHIEUTRA")
public class ChiTietPhieuTra {

    @Id
    @Column(name = "MaChiTietTra", length = 30)
    private String maChiTietTra;

    @Column(name = "MaPhieuTra", nullable = false, length = 30)
    private String maPhieuTra;

    @Column(name = "MaChiTietMuon", nullable = false, length = 30)
    private String maChiTietMuon;

    @Column(name = "TinhTrangKhiTra", nullable = false, length = 30)
    private String tinhTrangKhiTra;

    @Column(name = "SoNgayTre", nullable = false)
    private Integer soNgayTre;

    @Column(name = "TienPhatTre", nullable = false, precision = 18, scale = 2)
    private BigDecimal tienPhatTre;

    @Column(name = "TienPhatHongMat", nullable = false, precision = 18, scale = 2)
    private BigDecimal tienPhatHongMat;

    @Column(name = "GhiChu", length = 255)
    private String ghiChu;

    public String getMaChiTietTra() { return maChiTietTra; }
    public void setMaChiTietTra(String maChiTietTra) { this.maChiTietTra = maChiTietTra; }

    public String getMaPhieuTra() { return maPhieuTra; }
    public void setMaPhieuTra(String maPhieuTra) { this.maPhieuTra = maPhieuTra; }

    public String getMaChiTietMuon() { return maChiTietMuon; }
    public void setMaChiTietMuon(String maChiTietMuon) { this.maChiTietMuon = maChiTietMuon; }

    public String getTinhTrangKhiTra() { return tinhTrangKhiTra; }
    public void setTinhTrangKhiTra(String tinhTrangKhiTra) { this.tinhTrangKhiTra = tinhTrangKhiTra; }

    public Integer getSoNgayTre() { return soNgayTre; }
    public void setSoNgayTre(Integer soNgayTre) { this.soNgayTre = soNgayTre; }

    public BigDecimal getTienPhatTre() { return tienPhatTre; }
    public void setTienPhatTre(BigDecimal tienPhatTre) { this.tienPhatTre = tienPhatTre; }

    public BigDecimal getTienPhatHongMat() { return tienPhatHongMat; }
    public void setTienPhatHongMat(BigDecimal tienPhatHongMat) { this.tienPhatHongMat = tienPhatHongMat; }

    public String getGhiChu() { return ghiChu; }
    public void setGhiChu(String ghiChu) { this.ghiChu = ghiChu; }
}