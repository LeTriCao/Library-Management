package com.library.backend.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "KHOANNO")
public class KhoanNo {

    @Id
    @Column(name = "MaKhoanNo", length = 30)
    private String maKhoanNo;

    @Column(name = "MaDocGia", nullable = false, length = 30)
    private String maDocGia;

    @Column(name = "MaLoaiKhoanNo", nullable = false, length = 30)
    private String maLoaiKhoanNo;

    @Column(name = "MaChiTietTra", length = 30)
    private String maChiTietTra;

    @Column(name = "SoTienPhatSinh", nullable = false, precision = 18, scale = 2)
    private BigDecimal soTienPhatSinh;

    @Column(name = "SoTienDaThanhToan", nullable = false, precision = 18, scale = 2)
    private BigDecimal soTienDaThanhToan;

    @Column(name = "SoTienConLai", insertable = false, updatable = false, precision = 18, scale = 2)
    private BigDecimal soTienConLai;

    @Column(name = "NgayPhatSinh", nullable = false)
    private LocalDateTime ngayPhatSinh;

    @Column(name = "LyDo", length = 255)
    private String lyDo;

    @Column(name = "TrangThai", nullable = false, length = 30)
    private String trangThai;

    public String getMaKhoanNo() { return maKhoanNo; }
    public void setMaKhoanNo(String maKhoanNo) { this.maKhoanNo = maKhoanNo; }

    public String getMaDocGia() { return maDocGia; }
    public void setMaDocGia(String maDocGia) { this.maDocGia = maDocGia; }

    public String getMaLoaiKhoanNo() { return maLoaiKhoanNo; }
    public void setMaLoaiKhoanNo(String maLoaiKhoanNo) { this.maLoaiKhoanNo = maLoaiKhoanNo; }

    public String getMaChiTietTra() { return maChiTietTra; }
    public void setMaChiTietTra(String maChiTietTra) { this.maChiTietTra = maChiTietTra; }

    public BigDecimal getSoTienPhatSinh() { return soTienPhatSinh; }
    public void setSoTienPhatSinh(BigDecimal soTienPhatSinh) { this.soTienPhatSinh = soTienPhatSinh; }

    public BigDecimal getSoTienDaThanhToan() { return soTienDaThanhToan; }
    public void setSoTienDaThanhToan(BigDecimal soTienDaThanhToan) { this.soTienDaThanhToan = soTienDaThanhToan; }

    public BigDecimal getSoTienConLai() { return soTienConLai; }

    public LocalDateTime getNgayPhatSinh() { return ngayPhatSinh; }
    public void setNgayPhatSinh(LocalDateTime ngayPhatSinh) { this.ngayPhatSinh = ngayPhatSinh; }

    public String getLyDo() { return lyDo; }
    public void setLyDo(String lyDo) { this.lyDo = lyDo; }

    public String getTrangThai() { return trangThai; }
    public void setTrangThai(String trangThai) { this.trangThai = trangThai; }
}