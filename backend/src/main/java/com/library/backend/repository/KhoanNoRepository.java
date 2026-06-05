package com.library.backend.repository;

import com.library.backend.entity.KhoanNo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface KhoanNoRepository extends JpaRepository<KhoanNo, String> {

    List<KhoanNo> findByMaDocGiaAndTrangThaiNotOrderByNgayPhatSinhAsc(
            String maDocGia,
            String trangThai
    );

    List<KhoanNo> findByMaDocGiaOrderByNgayPhatSinhDesc(String maDocGia);
}