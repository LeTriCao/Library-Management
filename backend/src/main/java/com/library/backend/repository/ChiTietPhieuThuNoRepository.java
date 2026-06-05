package com.library.backend.repository;

import com.library.backend.entity.ChiTietPhieuThuNo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ChiTietPhieuThuNoRepository extends JpaRepository<ChiTietPhieuThuNo, String> {

    List<ChiTietPhieuThuNo> findByMaPhieuThu(String maPhieuThu);
}