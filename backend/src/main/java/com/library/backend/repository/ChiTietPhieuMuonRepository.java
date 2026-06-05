package com.library.backend.repository;

import com.library.backend.entity.ChiTietPhieuMuon;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ChiTietPhieuMuonRepository extends JpaRepository<ChiTietPhieuMuon, String> {

    List<ChiTietPhieuMuon> findByMaPhieuMuon(String maPhieuMuon);
}