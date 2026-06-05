package com.library.backend.dto;

public class SachDangMuonReportResponse {

    private String maDocGia;
    private String hoTen;
    private Integer soSachDangMuon;

    public SachDangMuonReportResponse(String maDocGia, String hoTen, Integer soSachDangMuon) {
        this.maDocGia = maDocGia;
        this.hoTen = hoTen;
        this.soSachDangMuon = soSachDangMuon;
    }

    public String getMaDocGia() {
        return maDocGia;
    }

    public String getHoTen() {
        return hoTen;
    }

    public Integer getSoSachDangMuon() {
        return soSachDangMuon;
    }
}