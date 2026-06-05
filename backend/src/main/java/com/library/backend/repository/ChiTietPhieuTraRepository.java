package com.library.backend.repository;

import com.library.backend.entity.ChiTietPhieuTra;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ChiTietPhieuTraRepository extends JpaRepository<ChiTietPhieuTra, String> {

    boolean existsByMaChiTietMuon(String maChiTietMuon);

    List<ChiTietPhieuTra> findByMaPhieuTra(String maPhieuTra);
}