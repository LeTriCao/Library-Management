package com.library.backend.repository;

import com.library.backend.entity.CuonSach;
import jakarta.persistence.LockModeType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface CuonSachRepository extends JpaRepository<CuonSach, String> {

    boolean existsByMaVach(String maVach);

    boolean existsByMaQrCode(String maQrCode);

    boolean existsByMaVachAndMaCuonSachNot(String maVach, String maCuonSach);

    boolean existsByMaQrCodeAndMaCuonSachNot(String maQrCode, String maCuonSach);

    @Lock(LockModeType.PESSIMISTIC_WRITE)
    @Query("SELECT cs FROM CuonSach cs WHERE cs.maCuonSach = :maCuonSach")
    Optional<CuonSach> findByIdForUpdate(@Param("maCuonSach") String maCuonSach);
}