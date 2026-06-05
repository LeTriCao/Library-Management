package com.library.backend.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

import java.util.List;

public class MuonSachRequest {

    @NotBlank(message = "Mã phiếu mượn không được để trống")
    @Size(max = 20, message = "Mã phiếu mượn tối đa 20 ký tự")
    private String maPhieuMuon;

    @NotBlank(message = "Mã độc giả không được để trống")
    private String maDocGia;

    @NotBlank(message = "Mã nhân viên lập không được để trống")
    private String maNhanVienLap;

    @NotBlank(message = "Mã chi nhánh không được để trống")
    private String maChiNhanh;

    @NotEmpty(message = "Phải chọn ít nhất một cuốn sách")
    private List<String> maCuonSachs;

    private String ghiChu;

    public String getMaPhieuMuon() { return maPhieuMuon; }
    public void setMaPhieuMuon(String maPhieuMuon) { this.maPhieuMuon = maPhieuMuon; }

    public String getMaDocGia() { return maDocGia; }
    public void setMaDocGia(String maDocGia) { this.maDocGia = maDocGia; }

    public String getMaNhanVienLap() { return maNhanVienLap; }
    public void setMaNhanVienLap(String maNhanVienLap) { this.maNhanVienLap = maNhanVienLap; }

    public String getMaChiNhanh() { return maChiNhanh; }
    public void setMaChiNhanh(String maChiNhanh) { this.maChiNhanh = maChiNhanh; }

    public List<String> getMaCuonSachs() { return maCuonSachs; }
    public void setMaCuonSachs(List<String> maCuonSachs) { this.maCuonSachs = maCuonSachs; }

    public String getGhiChu() { return ghiChu; }
    public void setGhiChu(String ghiChu) { this.ghiChu = ghiChu; }
}