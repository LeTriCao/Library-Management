package com.library.backend.repository;

import com.library.backend.entity.NhanVien;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface NhanVienRepository extends JpaRepository<NhanVien, String> {

    Optional<NhanVien> findByMaTaiKhoan(String maTaiKhoan);
}