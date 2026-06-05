package com.library.backend.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "NHATKYHOATDONG")
public class NhatKyHoatDong {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MaNhatKy")
    private Long maNhatKy;

    @Column(name = "MaTaiKhoan", length = 30)
    private String maTaiKhoan;

    @Column(name = "HanhDong", nullable = false, length = 100)
    private String hanhDong;

    @Column(name = "DoiTuongTacDong", length = 100)
    private String doiTuongTacDong;

    @Column(name = "MaDoiTuongTacDong", length = 50)
    private String maDoiTuongTacDong;

    @Column(name = "ThoiGian", nullable = false)
    private LocalDateTime thoiGian;

    @Column(name = "DiaChiIP", length = 45)
    private String diaChiIP;

    @Column(name = "MoTaChiTiet", columnDefinition = "NVARCHAR(MAX)")
    private String moTaChiTiet;

    public Long getMaNhatKy() { return maNhatKy; }
    public void setMaNhatKy(Long maNhatKy) { this.maNhatKy = maNhatKy; }

    public String getMaTaiKhoan() { return maTaiKhoan; }
    public void setMaTaiKhoan(String maTaiKhoan) { this.maTaiKhoan = maTaiKhoan; }

    public String getHanhDong() { return hanhDong; }
    public void setHanhDong(String hanhDong) { this.hanhDong = hanhDong; }

    public String getDoiTuongTacDong() { return doiTuongTacDong; }
    public void setDoiTuongTacDong(String doiTuongTacDong) { this.doiTuongTacDong = doiTuongTacDong; }

    public String getMaDoiTuongTacDong() { return maDoiTuongTacDong; }
    public void setMaDoiTuongTacDong(String maDoiTuongTacDong) { this.maDoiTuongTacDong = maDoiTuongTacDong; }

    public LocalDateTime getThoiGian() { return thoiGian; }
    public void setThoiGian(LocalDateTime thoiGian) { this.thoiGian = thoiGian; }

    public String getDiaChiIP() { return diaChiIP; }
    public void setDiaChiIP(String diaChiIP) { this.diaChiIP = diaChiIP; }

    public String getMoTaChiTiet() { return moTaChiTiet; }
    public void setMoTaChiTiet(String moTaChiTiet) { this.moTaChiTiet = moTaChiTiet; }
}