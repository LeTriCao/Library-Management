package com.library.backend.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class KhoanNoResponse {

    private String maKhoanNo;
    private String maDocGia;
    private String maLoaiKhoanNo;
    private String maChiTietTra;
    private BigDecimal soTienPhatSinh;
    private BigDecimal soTienDaThanhToan;
    private BigDecimal soTienConLai;
    private LocalDateTime ngayPhatSinh;
    private String lyDo;
    private String trangThai;

    public KhoanNoResponse(
            String maKhoanNo,
            String maDocGia,
            String maLoaiKhoanNo,
            String maChiTietTra,
            BigDecimal soTienPhatSinh,
            BigDecimal soTienDaThanhToan,
            BigDecimal soTienConLai,
            LocalDateTime ngayPhatSinh,
            String lyDo,
            String trangThai
    ) {
        this.maKhoanNo = maKhoanNo;
        this.maDocGia = maDocGia;
        this.maLoaiKhoanNo = maLoaiKhoanNo;
        this.maChiTietTra = maChiTietTra;
        this.soTienPhatSinh = soTienPhatSinh;
        this.soTienDaThanhToan = soTienDaThanhToan;
        this.soTienConLai = soTienConLai;
        this.ngayPhatSinh = ngayPhatSinh;
        this.lyDo = lyDo;
        this.trangThai = trangThai;
    }

    public String getMaKhoanNo() { return maKhoanNo; }
    public String getMaDocGia() { return maDocGia; }
    public String getMaLoaiKhoanNo() { return maLoaiKhoanNo; }
    public String getMaChiTietTra() { return maChiTietTra; }
    public BigDecimal getSoTienPhatSinh() { return soTienPhatSinh; }
    public BigDecimal getSoTienDaThanhToan() { return soTienDaThanhToan; }
    public BigDecimal getSoTienConLai() { return soTienConLai; }
    public LocalDateTime getNgayPhatSinh() { return ngayPhatSinh; }
    public String getLyDo() { return lyDo; }
    public String getTrangThai() { return trangThai; }
}