package com.library.backend.repository;

import com.library.backend.entity.TheLoai;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TheLoaiRepository extends JpaRepository<TheLoai, String> {

    boolean existsByTenTheLoai(String tenTheLoai);

    boolean existsByTenTheLoaiAndMaTheLoaiNot(String tenTheLoai, String maTheLoai);
}