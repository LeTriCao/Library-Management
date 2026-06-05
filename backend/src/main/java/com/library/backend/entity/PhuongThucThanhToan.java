package com.library.backend.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "PHUONGTHUCTHANHTOAN")
public class PhuongThucThanhToan {

    @Id
    @Column(name = "MaPhuongThuc", length = 30)
    private String maPhuongThuc;

    @Column(name = "TenPhuongThuc", nullable = false, length = 100)
    private String tenPhuongThuc;

    @Column(name = "MoTa", length = 255)
    private String moTa;

    public String getMaPhuongThuc() { return maPhuongThuc; }
    public void setMaPhuongThuc(String maPhuongThuc) { this.maPhuongThuc = maPhuongThuc; }

    public String getTenPhuongThuc() { return tenPhuongThuc; }
    public void setTenPhuongThuc(String tenPhuongThuc) { this.tenPhuongThuc = tenPhuongThuc; }

    public String getMoTa() { return moTa; }
    public void setMoTa(String moTa) { this.moTa = moTa; }
}