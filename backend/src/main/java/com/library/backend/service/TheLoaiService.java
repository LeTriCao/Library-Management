package com.library.backend.service;

import com.library.backend.dto.TheLoaiRequest;
import com.library.backend.dto.TheLoaiResponse;
import com.library.backend.entity.TheLoai;
import com.library.backend.repository.TheLoaiRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TheLoaiService {

    private final TheLoaiRepository theLoaiRepository;

    public TheLoaiService(TheLoaiRepository theLoaiRepository) {
        this.theLoaiRepository = theLoaiRepository;
    }

    public List<TheLoaiResponse> getAll() {
        return theLoaiRepository.findAll()
                .stream()
                .map(this::toResponse)
                .toList();
    }

    public TheLoaiResponse getById(String maTheLoai) {
        TheLoai theLoai = theLoaiRepository.findById(maTheLoai)
                .orElseThrow(() -> new RuntimeException("Không tìm thấy thể loại"));

        return toResponse(theLoai);
    }

    public TheLoaiResponse create(TheLoaiRequest request) {
        if (theLoaiRepository.existsById(request.getMaTheLoai())) {
            throw new RuntimeException("Mã thể loại đã tồn tại");
        }

        if (theLoaiRepository.existsByTenTheLoai(request.getTenTheLoai())) {
            throw new RuntimeException("Tên thể loại đã tồn tại");
        }

        TheLoai theLoai = new TheLoai();
        theLoai.setMaTheLoai(request.getMaTheLoai());
        theLoai.setTenTheLoai(request.getTenTheLoai());
        theLoai.setMoTa(request.getMoTa());
        theLoai.setTrangThai("Hoạt động");

        TheLoai saved = theLoaiRepository.save(theLoai);

        return toResponse(saved);
    }

    public TheLoaiResponse update(String maTheLoai, TheLoaiRequest request) {
        TheLoai theLoai = theLoaiRepository.findById(maTheLoai)
                .orElseThrow(() -> new RuntimeException("Không tìm thấy thể loại"));

        if (theLoaiRepository.existsByTenTheLoaiAndMaTheLoaiNot(request.getTenTheLoai(), maTheLoai)) {
            throw new RuntimeException("Tên thể loại đã tồn tại");
        }

        theLoai.setTenTheLoai(request.getTenTheLoai());
        theLoai.setMoTa(request.getMoTa());

        TheLoai updated = theLoaiRepository.save(theLoai);

        return toResponse(updated);
    }

    public void disable(String maTheLoai) {
        TheLoai theLoai = theLoaiRepository.findById(maTheLoai)
                .orElseThrow(() -> new RuntimeException("Không tìm thấy thể loại"));

        theLoai.setTrangThai("Ngừng áp dụng");
        theLoaiRepository.save(theLoai);
    }

    private TheLoaiResponse toResponse(TheLoai theLoai) {
        return new TheLoaiResponse(
                theLoai.getMaTheLoai(),
                theLoai.getTenTheLoai(),
                theLoai.getMoTa(),
                theLoai.getTrangThai()
        );
    }
}