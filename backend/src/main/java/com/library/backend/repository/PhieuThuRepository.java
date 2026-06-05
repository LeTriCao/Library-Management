package com.library.backend.repository;

import com.library.backend.entity.PhieuThu;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PhieuThuRepository extends JpaRepository<PhieuThu, String> {

    List<PhieuThu> findByMaDocGiaOrderByNgayThuDesc(String maDocGia);
}