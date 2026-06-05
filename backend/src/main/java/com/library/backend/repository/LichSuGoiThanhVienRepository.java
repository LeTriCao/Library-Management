package com.library.backend.repository;

import com.library.backend.entity.LichSuGoiThanhVien;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface LichSuGoiThanhVienRepository extends JpaRepository<LichSuGoiThanhVien, String> {

    Optional<LichSuGoiThanhVien> findFirstByMaDocGiaAndTrangThaiOrderByNgayBatDauDesc(
            String maDocGia,
            String trangThai
    );
}