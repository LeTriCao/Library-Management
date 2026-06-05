package com.library.backend.dto;

import java.math.BigDecimal;

public class TongNoDocGiaReportResponse {

    private String maDocGia;
    private String hoTen;
    private BigDecimal tongNoConLai;

    public TongNoDocGiaReportResponse(String maDocGia, String hoTen, BigDecimal tongNoConLai) {
        this.maDocGia = maDocGia;
        this.hoTen = hoTen;
        this.tongNoConLai = tongNoConLai;
    }

    public String getMaDocGia() {
        return maDocGia;
    }

    public String getHoTen() {
        return hoTen;
    }

    public BigDecimal getTongNoConLai() {
        return tongNoConLai;
    }
}