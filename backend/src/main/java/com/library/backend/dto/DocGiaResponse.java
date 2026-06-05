package com.library.backend.dto;

import java.time.LocalDate;

public class DocGiaResponse {

    private String maDocGia;
    private String maTaiKhoan;
    private String tenDangNhap;
    private String maNhomDocGia;
    private String hoTen;
    private LocalDate ngaySinh;
    private String diaChi;
    private String email;
    private String soDienThoai;
    private LocalDate ngayLapThe;
    private LocalDate ngayHetHanThe;
    private String trangThai;
    private String maGoiThanhVien;
    private LocalDate ngayHetHanGoi;

    public DocGiaResponse(
            String maDocGia,
            String maTaiKhoan,
            String tenDangNhap,
            String maNhomDocGia,
            String hoTen,
            LocalDate ngaySinh,
            String diaChi,
            String email,
            String soDienThoai,
            LocalDate ngayLapThe,
            LocalDate ngayHetHanThe,
            String trangThai,
            String maGoiThanhVien,
            LocalDate ngayHetHanGoi
    ) {
        this.maDocGia = maDocGia;
        this.maTaiKhoan = maTaiKhoan;
        this.tenDangNhap = tenDangNhap;
        this.maNhomDocGia = maNhomDocGia;
        this.hoTen = hoTen;
        this.ngaySinh = ngaySinh;
        this.diaChi = diaChi;
        this.email = email;
        this.soDienThoai = soDienThoai;
        this.ngayLapThe = ngayLapThe;
        this.ngayHetHanThe = ngayHetHanThe;
        this.trangThai = trangThai;
        this.maGoiThanhVien = maGoiThanhVien;
        this.ngayHetHanGoi = ngayHetHanGoi;
    }

    public String getMaDocGia() { return maDocGia; }
    public String getMaTaiKhoan() { return maTaiKhoan; }
    public String getTenDangNhap() { return tenDangNhap; }
    public String getMaNhomDocGia() { return maNhomDocGia; }
    public String getHoTen() { return hoTen; }
    public LocalDate getNgaySinh() { return ngaySinh; }
    public String getDiaChi() { return diaChi; }
    public String getEmail() { return email; }
    public String getSoDienThoai() { return soDienThoai; }
    public LocalDate getNgayLapThe() { return ngayLapThe; }
    public LocalDate getNgayHetHanThe() { return ngayHetHanThe; }
    public String getTrangThai() { return trangThai; }
    public String getMaGoiThanhVien() { return maGoiThanhVien; }
    public LocalDate getNgayHetHanGoi() { return ngayHetHanGoi; }
}