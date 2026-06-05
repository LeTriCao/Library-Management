package com.library.backend.dto;

import java.math.BigDecimal;

public class BaoCaoMuonTheLoaiResponse {

    private Integer thang;
    private Integer nam;
    private String maTheLoai;
    private String tenTheLoai;
    private Long soLuotMuon;
    private BigDecimal tiLePhanTram;

    public BaoCaoMuonTheLoaiResponse(
            Integer thang,
            Integer nam,
            String maTheLoai,
            String tenTheLoai,
            Long soLuotMuon,
            BigDecimal tiLePhanTram
    ) {
        this.thang = thang;
        this.nam = nam;
        this.maTheLoai = maTheLoai;
        this.tenTheLoai = tenTheLoai;
        this.soLuotMuon = soLuotMuon;
        this.tiLePhanTram = tiLePhanTram;
    }

    public Integer getThang() {
        return thang;
    }

    public Integer getNam() {
        return nam;
    }

    public String getMaTheLoai() {
        return maTheLoai;
    }

    public String getTenTheLoai() {
        return tenTheLoai;
    }

    public Long getSoLuotMuon() {
        return soLuotMuon;
    }

    public BigDecimal getTiLePhanTram() {
        return tiLePhanTram;
    }
}