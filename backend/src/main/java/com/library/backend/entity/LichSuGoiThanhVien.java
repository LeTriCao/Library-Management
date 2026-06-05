package com.library.backend.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.time.LocalDate;

@Entity
@Table(name = "LICHSUGOITHANHVIEN")
public class LichSuGoiThanhVien {

    @Id
    @Column(name = "MaLichSuGoi", length = 30)
    private String maLichSuGoi;

    @Column(name = "MaDocGia", nullable = false, length = 30)
    private String maDocGia;

    @Column(name = "MaGoiThanhVien", nullable = false, length = 30)
    private String maGoiThanhVien;

    @Column(name = "MaPhieuThu", length = 30)
    private String maPhieuThu;

    @Column(name = "NgayBatDau", nullable = false)
    private LocalDate ngayBatDau;

    @Column(name = "NgayKetThuc", nullable = false)
    private LocalDate ngayKetThuc;

    @Column(name = "TrangThai", nullable = false, length = 30)
    private String trangThai;

    @Column(name = "GhiChu", length = 255)
    private String ghiChu;

    public String getMaLichSuGoi() { return maLichSuGoi; }
    public void setMaLichSuGoi(String maLichSuGoi) { this.maLichSuGoi = maLichSuGoi; }

    public String getMaDocGia() { return maDocGia; }
    public void setMaDocGia(String maDocGia) { this.maDocGia = maDocGia; }

    public String getMaGoiThanhVien() { return maGoiThanhVien; }
    public void setMaGoiThanhVien(String maGoiThanhVien) { this.maGoiThanhVien = maGoiThanhVien; }

    public String getMaPhieuThu() { return maPhieuThu; }
    public void setMaPhieuThu(String maPhieuThu) { this.maPhieuThu = maPhieuThu; }

    public LocalDate getNgayBatDau() { return ngayBatDau; }
    public void setNgayBatDau(LocalDate ngayBatDau) { this.ngayBatDau = ngayBatDau; }

    public LocalDate getNgayKetThuc() { return ngayKetThuc; }
    public void setNgayKetThuc(LocalDate ngayKetThuc) { this.ngayKetThuc = ngayKetThuc; }

    public String getTrangThai() { return trangThai; }
    public void setTrangThai(String trangThai) { this.trangThai = trangThai; }

    public String getGhiChu() { return ghiChu; }
    public void setGhiChu(String ghiChu) { this.ghiChu = ghiChu; }
}