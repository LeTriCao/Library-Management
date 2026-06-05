package com.library.backend.service;

import com.library.backend.dto.NhaXuatBanRequest;
import com.library.backend.dto.NhaXuatBanResponse;
import com.library.backend.entity.NhaXuatBan;
import com.library.backend.repository.NhaXuatBanRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NhaXuatBanService {

    private final NhaXuatBanRepository nhaXuatBanRepository;

    public NhaXuatBanService(NhaXuatBanRepository nhaXuatBanRepository) {
        this.nhaXuatBanRepository = nhaXuatBanRepository;
    }

    public List<NhaXuatBanResponse> getAll() {
        return nhaXuatBanRepository.findAll()
                .stream()
                .map(this::toResponse)
                .toList();
    }

    public NhaXuatBanResponse getById(String maNhaXuatBan) {
        NhaXuatBan nhaXuatBan = nhaXuatBanRepository.findById(maNhaXuatBan)
                .orElseThrow(() -> new RuntimeException("Không tìm thấy nhà xuất bản"));

        return toResponse(nhaXuatBan);
    }

    public NhaXuatBanResponse create(NhaXuatBanRequest request) {
        if (nhaXuatBanRepository.existsById(request.getMaNhaXuatBan())) {
            throw new RuntimeException("Mã nhà xuất bản đã tồn tại");
        }

        NhaXuatBan nhaXuatBan = new NhaXuatBan();
        nhaXuatBan.setMaNhaXuatBan(request.getMaNhaXuatBan());
        nhaXuatBan.setTenNhaXuatBan(request.getTenNhaXuatBan());
        nhaXuatBan.setDiaChi(request.getDiaChi());
        nhaXuatBan.setEmail(request.getEmail());
        nhaXuatBan.setSoDienThoai(request.getSoDienThoai());

        NhaXuatBan saved = nhaXuatBanRepository.save(nhaXuatBan);

        return toResponse(saved);
    }

    public NhaXuatBanResponse update(String maNhaXuatBan, NhaXuatBanRequest request) {
        NhaXuatBan nhaXuatBan = nhaXuatBanRepository.findById(maNhaXuatBan)
                .orElseThrow(() -> new RuntimeException("Không tìm thấy nhà xuất bản"));

        nhaXuatBan.setTenNhaXuatBan(request.getTenNhaXuatBan());
        nhaXuatBan.setDiaChi(request.getDiaChi());
        nhaXuatBan.setEmail(request.getEmail());
        nhaXuatBan.setSoDienThoai(request.getSoDienThoai());

        NhaXuatBan updated = nhaXuatBanRepository.save(nhaXuatBan);

        return toResponse(updated);
    }

    public void delete(String maNhaXuatBan) {
        if (!nhaXuatBanRepository.existsById(maNhaXuatBan)) {
            throw new RuntimeException("Không tìm thấy nhà xuất bản");
        }

        nhaXuatBanRepository.deleteById(maNhaXuatBan);
    }

    private NhaXuatBanResponse toResponse(NhaXuatBan nhaXuatBan) {
        return new NhaXuatBanResponse(
                nhaXuatBan.getMaNhaXuatBan(),
                nhaXuatBan.getTenNhaXuatBan(),
                nhaXuatBan.getDiaChi(),
                nhaXuatBan.getEmail(),
                nhaXuatBan.getSoDienThoai()
        );
    }
}