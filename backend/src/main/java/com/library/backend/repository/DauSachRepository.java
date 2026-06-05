package com.library.backend.repository;

import com.library.backend.entity.DauSach;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DauSachRepository extends JpaRepository<DauSach, String> {

    boolean existsByIsbn(String isbn);

    boolean existsByIsbnAndMaDauSachNot(String isbn, String maDauSach);
}