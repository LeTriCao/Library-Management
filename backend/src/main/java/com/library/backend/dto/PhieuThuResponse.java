package com.library.backend.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public class PhieuThuResponse {

    private String maPhieuThu;
    private String maDocGia;
    private String maNhanVienThu;
    private String maPhuongThuc;
    private String loaiThu;
    private BigDecimal soTienThu;
    private LocalDateTime ngayThu;
    private String trangThai;
    private List<ChiTietPhieuThuNoResponse> chiTietNo;

    public PhieuThuResponse(
            String maPhieuThu,
            String maDocGia,
            String maNhanVienThu,
            String maPhuongThuc,
            String loaiThu,
            BigDecimal soTienThu,
            LocalDateTime ngayThu,
            String trangThai,
            List<ChiTietPhieuThuNoResponse> chiTietNo
    ) {
        this.maPhieuThu = maPhieuThu;
        this.maDocGia = maDocGia;
        this.maNhanVienThu = maNhanVienThu;
        this.maPhuongThuc = maPhuongThuc;
        this.loaiThu = loaiThu;
        this.soTienThu = soTienThu;
        this.ngayThu = ngayThu;
        this.trangThai = trangThai;
        this.chiTietNo = chiTietNo;
    }

    public String getMaPhieuThu() { return maPhieuThu; }
    public String getMaDocGia() { return maDocGia; }
    public String getMaNhanVienThu() { return maNhanVienThu; }
    public String getMaPhuongThuc() { return maPhuongThuc; }
    public String getLoaiThu() { return loaiThu; }
    public BigDecimal getSoTienThu() { return soTienThu; }
    public LocalDateTime getNgayThu() { return ngayThu; }
    public String getTrangThai() { return trangThai; }
    public List<ChiTietPhieuThuNoResponse> getChiTietNo() { return chiTietNo; }

    public static class ChiTietPhieuThuNoResponse {
        private String maChiTietPhieuThu;
        private String maKhoanNo;
        private BigDecimal soTienApDung;

        public ChiTietPhieuThuNoResponse(
                String maChiTietPhieuThu,
                String maKhoanNo,
                BigDecimal soTienApDung
        ) {
            this.maChiTietPhieuThu = maChiTietPhieuThu;
            this.maKhoanNo = maKhoanNo;
            this.soTienApDung = soTienApDung;
        }

        public String getMaChiTietPhieuThu() { return maChiTietPhieuThu; }
        public String getMaKhoanNo() { return maKhoanNo; }
        public BigDecimal getSoTienApDung() { return soTienApDung; }
    }
}