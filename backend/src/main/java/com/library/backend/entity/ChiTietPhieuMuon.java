package com.library.backend.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.time.LocalDateTime;

@Entity
@Table(name = "CHITIETPHIEUMUON")
public class ChiTietPhieuMuon {

    @Id
    @Column(name = "MaChiTietMuon", length = 30)
    private String maChiTietMuon;

    @Column(name = "MaPhieuMuon", nullable = false, length = 30)
    private String maPhieuMuon;

    @Column(name = "MaCuonSach", nullable = false, length = 40)
    private String maCuonSach;

    @Column(name = "MaQuyDinhMuon", nullable = false, length = 30)
    private String maQuyDinhMuon;

    @Column(name = "NgayMuon", nullable = false)
    private LocalDateTime ngayMuon;

    @Column(name = "HanTra", nullable = false)
    private LocalDateTime hanTra;

    @Column(name = "NgayTraThucTe")
    private LocalDateTime ngayTraThucTe;

    @Column(name = "TrangThai", nullable = false, length = 30)
    private String trangThai;

    public String getMaChiTietMuon() { return maChiTietMuon; }
    public void setMaChiTietMuon(String maChiTietMuon) { this.maChiTietMuon = maChiTietMuon; }

    public String getMaPhieuMuon() { return maPhieuMuon; }
    public void setMaPhieuMuon(String maPhieuMuon) { this.maPhieuMuon = maPhieuMuon; }

    public String getMaCuonSach() { return maCuonSach; }
    public void setMaCuonSach(String maCuonSach) { this.maCuonSach = maCuonSach; }

    public String getMaQuyDinhMuon() { return maQuyDinhMuon; }
    public void setMaQuyDinhMuon(String maQuyDinhMuon) { this.maQuyDinhMuon = maQuyDinhMuon; }

    public LocalDateTime getNgayMuon() { return ngayMuon; }
    public void setNgayMuon(LocalDateTime ngayMuon) { this.ngayMuon = ngayMuon; }

    public LocalDateTime getHanTra() { return hanTra; }
    public void setHanTra(LocalDateTime hanTra) { this.hanTra = hanTra; }

    public LocalDateTime getNgayTraThucTe() { return ngayTraThucTe; }
    public void setNgayTraThucTe(LocalDateTime ngayTraThucTe) { this.ngayTraThucTe = ngayTraThucTe; }

    public String getTrangThai() { return trangThai; }
    public void setTrangThai(String trangThai) { this.trangThai = trangThai; }
}