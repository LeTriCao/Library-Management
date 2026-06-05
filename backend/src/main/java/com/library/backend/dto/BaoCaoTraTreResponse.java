package com.library.backend.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class BaoCaoTraTreResponse {

    private Integer thang;
    private Integer nam;
    private String maCuonSach;
    private String tenDauSach;
    private String maDocGia;
    private String hoTenDocGia;
    private LocalDateTime ngayMuon;
    private LocalDateTime hanTra;
    private LocalDateTime ngayTraThucTe;
    private Integer soNgayTre;
    private BigDecimal tienPhatTre;

    public BaoCaoTraTreResponse(
            Integer thang,
            Integer nam,
            String maCuonSach,
            String tenDauSach,
            String maDocGia,
            String hoTenDocGia,
            LocalDateTime ngayMuon,
            LocalDateTime hanTra,
            LocalDateTime ngayTraThucTe,
            Integer soNgayTre,
            BigDecimal tienPhatTre
    ) {
        this.thang = thang;
        this.nam = nam;
        this.maCuonSach = maCuonSach;
        this.tenDauSach = tenDauSach;
        this.maDocGia = maDocGia;
        this.hoTenDocGia = hoTenDocGia;
        this.ngayMuon = ngayMuon;
        this.hanTra = hanTra;
        this.ngayTraThucTe = ngayTraThucTe;
        this.soNgayTre = soNgayTre;
        this.tienPhatTre = tienPhatTre;
    }

    public Integer getThang() {
        return thang;
    }

    public Integer getNam() {
        return nam;
    }

    public String getMaCuonSach() {
        return maCuonSach;
    }

    public String getTenDauSach() {
        return tenDauSach;
    }

    public String getMaDocGia() {
        return maDocGia;
    }

    public String getHoTenDocGia() {
        return hoTenDocGia;
    }

    public LocalDateTime getNgayMuon() {
        return ngayMuon;
    }

    public LocalDateTime getHanTra() {
        return hanTra;
    }

    public LocalDateTime getNgayTraThucTe() {
        return ngayTraThucTe;
    }

    public Integer getSoNgayTre() {
        return soNgayTre;
    }

    public BigDecimal getTienPhatTre() {
        return tienPhatTre;
    }
}