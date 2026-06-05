package com.library.backend.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.time.LocalDate;

@Entity
@Table(name = "DOCGIA")
public class DocGia {

    @Id
    @Column(name = "MaDocGia", length = 30)
    private String maDocGia;

    @Column(name = "MaTaiKhoan", nullable = false, length = 30)
    private String maTaiKhoan;

    @Column(name = "MaNhomDocGia", nullable = false, length = 30)
    private String maNhomDocGia;

    @Column(name = "HoTen", nullable = false, length = 150)
    private String hoTen;

    @Column(name = "NgaySinh", nullable = false)
    private LocalDate ngaySinh;

    @Column(name = "DiaChi", length = 255)
    private String diaChi;

    @Column(name = "Email", nullable = false, length = 255)
    private String email;

    @Column(name = "SoDienThoai", length = 20)
    private String soDienThoai;

    @Column(name = "NgayLapThe", nullable = false)
    private LocalDate ngayLapThe;

    @Column(name = "NgayHetHanThe", nullable = false)
    private LocalDate ngayHetHanThe;

    @Column(name = "TrangThai", nullable = false, length = 30)
    private String trangThai;

    public String getMaDocGia() { return maDocGia; }
    public void setMaDocGia(String maDocGia) { this.maDocGia = maDocGia; }

    public String getMaTaiKhoan() { return maTaiKhoan; }
    public void setMaTaiKhoan(String maTaiKhoan) { this.maTaiKhoan = maTaiKhoan; }

    public String getMaNhomDocGia() { return maNhomDocGia; }
    public void setMaNhomDocGia(String maNhomDocGia) { this.maNhomDocGia = maNhomDocGia; }

    public String getHoTen() { return hoTen; }
    public void setHoTen(String hoTen) { this.hoTen = hoTen; }

    public LocalDate getNgaySinh() { return ngaySinh; }
    public void setNgaySinh(LocalDate ngaySinh) { this.ngaySinh = ngaySinh; }

    public String getDiaChi() { return diaChi; }
    public void setDiaChi(String diaChi) { this.diaChi = diaChi; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getSoDienThoai() { return soDienThoai; }
    public void setSoDienThoai(String soDienThoai) { this.soDienThoai = soDienThoai; }

    public LocalDate getNgayLapThe() { return ngayLapThe; }
    public void setNgayLapThe(LocalDate ngayLapThe) { this.ngayLapThe = ngayLapThe; }

    public LocalDate getNgayHetHanThe() { return ngayHetHanThe; }
    public void setNgayHetHanThe(LocalDate ngayHetHanThe) { this.ngayHetHanThe = ngayHetHanThe; }

    public String getTrangThai() { return trangThai; }
    public void setTrangThai(String trangThai) { this.trangThai = trangThai; }
}