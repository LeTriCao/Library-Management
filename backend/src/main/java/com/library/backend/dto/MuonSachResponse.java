package com.library.backend.dto;

import java.time.LocalDateTime;
import java.util.List;

public class MuonSachResponse {

    private String maPhieuMuon;
    private String maDocGia;
    private String maNhanVienLap;
    private String maChiNhanh;
    private String maPhienBanQuyDinh;
    private LocalDateTime ngayMuon;
    private String trangThai;
    private List<ChiTietMuonResponse> chiTiet;

    public MuonSachResponse(
            String maPhieuMuon,
            String maDocGia,
            String maNhanVienLap,
            String maChiNhanh,
            String maPhienBanQuyDinh,
            LocalDateTime ngayMuon,
            String trangThai,
            List<ChiTietMuonResponse> chiTiet
    ) {
        this.maPhieuMuon = maPhieuMuon;
        this.maDocGia = maDocGia;
        this.maNhanVienLap = maNhanVienLap;
        this.maChiNhanh = maChiNhanh;
        this.maPhienBanQuyDinh = maPhienBanQuyDinh;
        this.ngayMuon = ngayMuon;
        this.trangThai = trangThai;
        this.chiTiet = chiTiet;
    }

    public String getMaPhieuMuon() { return maPhieuMuon; }
    public String getMaDocGia() { return maDocGia; }
    public String getMaNhanVienLap() { return maNhanVienLap; }
    public String getMaChiNhanh() { return maChiNhanh; }
    public String getMaPhienBanQuyDinh() { return maPhienBanQuyDinh; }
    public LocalDateTime getNgayMuon() { return ngayMuon; }
    public String getTrangThai() { return trangThai; }
    public List<ChiTietMuonResponse> getChiTiet() { return chiTiet; }

    public static class ChiTietMuonResponse {
        private String maChiTietMuon;
        private String maCuonSach;
        private String maQuyDinhMuon;
        private LocalDateTime ngayMuon;
        private LocalDateTime hanTra;
        private String trangThai;

        public ChiTietMuonResponse(
                String maChiTietMuon,
                String maCuonSach,
                String maQuyDinhMuon,
                LocalDateTime ngayMuon,
                LocalDateTime hanTra,
                String trangThai
        ) {
            this.maChiTietMuon = maChiTietMuon;
            this.maCuonSach = maCuonSach;
            this.maQuyDinhMuon = maQuyDinhMuon;
            this.ngayMuon = ngayMuon;
            this.hanTra = hanTra;
            this.trangThai = trangThai;
        }

        public String getMaChiTietMuon() { return maChiTietMuon; }
        public String getMaCuonSach() { return maCuonSach; }
        public String getMaQuyDinhMuon() { return maQuyDinhMuon; }
        public LocalDateTime getNgayMuon() { return ngayMuon; }
        public LocalDateTime getHanTra() { return hanTra; }
        public String getTrangThai() { return trangThai; }
    }
}