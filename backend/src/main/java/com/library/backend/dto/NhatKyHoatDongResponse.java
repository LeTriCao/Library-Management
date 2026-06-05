package com.library.backend.dto;

import com.library.backend.entity.NhatKyHoatDong;

import java.time.LocalDateTime;

public class NhatKyHoatDongResponse {

    private Long maNhatKy;
    private String maTaiKhoan;
    private String hanhDong;
    private String doiTuongTacDong;
    private String maDoiTuongTacDong;
    private LocalDateTime thoiGian;
    private String diaChiIP;
    private String moTaChiTiet;

    public NhatKyHoatDongResponse(
            Long maNhatKy,
            String maTaiKhoan,
            String hanhDong,
            String doiTuongTacDong,
            String maDoiTuongTacDong,
            LocalDateTime thoiGian,
            String diaChiIP,
            String moTaChiTiet
    ) {
        this.maNhatKy = maNhatKy;
        this.maTaiKhoan = maTaiKhoan;
        this.hanhDong = hanhDong;
        this.doiTuongTacDong = doiTuongTacDong;
        this.maDoiTuongTacDong = maDoiTuongTacDong;
        this.thoiGian = thoiGian;
        this.diaChiIP = diaChiIP;
        this.moTaChiTiet = moTaChiTiet;
    }

    public static NhatKyHoatDongResponse from(NhatKyHoatDong log) {
        return new NhatKyHoatDongResponse(
                log.getMaNhatKy(),
                log.getMaTaiKhoan(),
                log.getHanhDong(),
                log.getDoiTuongTacDong(),
                log.getMaDoiTuongTacDong(),
                log.getThoiGian(),
                log.getDiaChiIP(),
                log.getMoTaChiTiet()
        );
    }

    public Long getMaNhatKy() { return maNhatKy; }
    public String getMaTaiKhoan() { return maTaiKhoan; }
    public String getHanhDong() { return hanhDong; }
    public String getDoiTuongTacDong() { return doiTuongTacDong; }
    public String getMaDoiTuongTacDong() { return maDoiTuongTacDong; }
    public LocalDateTime getThoiGian() { return thoiGian; }
    public String getDiaChiIP() { return diaChiIP; }
    public String getMoTaChiTiet() { return moTaChiTiet; }
}