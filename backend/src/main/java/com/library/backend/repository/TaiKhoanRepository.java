package com.library.backend.repository;

import com.library.backend.entity.TaiKhoan;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TaiKhoanRepository extends JpaRepository<TaiKhoan, String> {

    boolean existsByTenDangNhap(String tenDangNhap);

    boolean existsByEmailDangNhap(String emailDangNhap);

    Optional<TaiKhoan> findByTenDangNhap(String tenDangNhap);

    Optional<TaiKhoan> findByEmailDangNhap(String emailDangNhap);
}