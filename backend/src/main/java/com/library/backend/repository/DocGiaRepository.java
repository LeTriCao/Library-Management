package com.library.backend.repository;

import com.library.backend.entity.DocGia;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DocGiaRepository extends JpaRepository<DocGia, String> {

    boolean existsByEmail(String email);

    boolean existsByEmailAndMaDocGiaNot(String email, String maDocGia);

    Optional<DocGia> findByMaTaiKhoan(String maTaiKhoan);
}