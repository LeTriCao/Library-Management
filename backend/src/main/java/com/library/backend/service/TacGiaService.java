package com.library.backend.service;

import com.library.backend.dto.TacGiaRequest;
import com.library.backend.dto.TacGiaResponse;
import com.library.backend.entity.TacGia;
import com.library.backend.repository.TacGiaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TacGiaService {

    private final TacGiaRepository tacGiaRepository;

    public TacGiaService(TacGiaRepository tacGiaRepository) {
        this.tacGiaRepository = tacGiaRepository;
    }

    public List<TacGiaResponse> getAll() {
        return tacGiaRepository.findAll()
                .stream()
                .map(this::toResponse)
                .toList();
    }

    public TacGiaResponse getById(String maTacGia) {
        TacGia tacGia = tacGiaRepository.findById(maTacGia)
                .orElseThrow(() -> new RuntimeException("Không tìm thấy tác giả"));

        return toResponse(tacGia);
    }

    public TacGiaResponse create(TacGiaRequest request) {
        if (tacGiaRepository.existsById(request.getMaTacGia())) {
            throw new RuntimeException("Mã tác giả đã tồn tại");
        }

        TacGia tacGia = new TacGia();
        tacGia.setMaTacGia(request.getMaTacGia());
        tacGia.setTenTacGia(request.getTenTacGia());
        tacGia.setMoTa(request.getMoTa());

        TacGia saved = tacGiaRepository.save(tacGia);

        return toResponse(saved);
    }

    public TacGiaResponse update(String maTacGia, TacGiaRequest request) {
        TacGia tacGia = tacGiaRepository.findById(maTacGia)
                .orElseThrow(() -> new RuntimeException("Không tìm thấy tác giả"));

        tacGia.setTenTacGia(request.getTenTacGia());
        tacGia.setMoTa(request.getMoTa());

        TacGia updated = tacGiaRepository.save(tacGia);

        return toResponse(updated);
    }

    public void delete(String maTacGia) {
        if (!tacGiaRepository.existsById(maTacGia)) {
            throw new RuntimeException("Không tìm thấy tác giả");
        }

        tacGiaRepository.deleteById(maTacGia);
    }

    private TacGiaResponse toResponse(TacGia tacGia) {
        return new TacGiaResponse(
                tacGia.getMaTacGia(),
                tacGia.getTenTacGia(),
                tacGia.getMoTa()
        );
    }
}