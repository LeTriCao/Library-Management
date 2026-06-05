package com.library.backend.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

public class DocGiaRequest {

    @NotBlank(message = "Mã độc giả không được để trống")
    private String maDocGia;

    @NotBlank(message = "Mã tài khoản không được để trống")
    private String maTaiKhoan;

    @NotBlank(message = "Tên đăng nhập không được để trống")
    private String tenDangNhap;

    @NotBlank(message = "Mật khẩu không được để trống")
    @Size(min = 6, message = "Mật khẩu tối thiểu 6 ký tự")
    private String matKhau;

    @NotBlank(message = "Mã nhóm độc giả không được để trống")
    private String maNhomDocGia;

    private String maGoiThanhVien;

    @NotBlank(message = "Họ tên không được để trống")
    private String hoTen;

    @NotNull(message = "Ngày sinh không được để trống")
    private LocalDate ngaySinh;

    private String diaChi;

    @NotBlank(message = "Email không được để trống")
    @Email(message = "Email không đúng định dạng")
    private String email;

    private String soDienThoai;

    private LocalDate ngayLapThe;

    public String getMaDocGia() { return maDocGia; }
    public void setMaDocGia(String maDocGia) { this.maDocGia = maDocGia; }

    public String getMaTaiKhoan() { return maTaiKhoan; }
    public void setMaTaiKhoan(String maTaiKhoan) { this.maTaiKhoan = maTaiKhoan; }

    public String getTenDangNhap() { return tenDangNhap; }
    public void setTenDangNhap(String tenDangNhap) { this.tenDangNhap = tenDangNhap; }

    public String getMatKhau() { return matKhau; }
    public void setMatKhau(String matKhau) { this.matKhau = matKhau; }

    public String getMaNhomDocGia() { return maNhomDocGia; }
    public void setMaNhomDocGia(String maNhomDocGia) { this.maNhomDocGia = maNhomDocGia; }

    public String getMaGoiThanhVien() { return maGoiThanhVien; }
    public void setMaGoiThanhVien(String maGoiThanhVien) { this.maGoiThanhVien = maGoiThanhVien; }

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
}