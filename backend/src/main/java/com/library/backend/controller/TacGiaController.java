package com.library.backend.controller;

import com.library.backend.dto.TacGiaRequest;
import com.library.backend.dto.TacGiaResponse;
import com.library.backend.service.TacGiaService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/authors")
public class TacGiaController {

    private final TacGiaService tacGiaService;

    public TacGiaController(TacGiaService tacGiaService) {
        this.tacGiaService = tacGiaService;
    }

    @GetMapping
    public List<TacGiaResponse> getAll() {
        return tacGiaService.getAll();
    }

    @GetMapping("/{maTacGia}")
    public TacGiaResponse getById(@PathVariable String maTacGia) {
        return tacGiaService.getById(maTacGia);
    }

    @PostMapping
    public TacGiaResponse create(@Valid @RequestBody TacGiaRequest request) {
        return tacGiaService.create(request);
    }

    @PutMapping("/{maTacGia}")
    public TacGiaResponse update(
            @PathVariable String maTacGia,
            @Valid @RequestBody TacGiaRequest request
    ) {
        return tacGiaService.update(maTacGia, request);
    }

    @DeleteMapping("/{maTacGia}")
    public String delete(@PathVariable String maTacGia) {
        tacGiaService.delete(maTacGia);
        return "Xóa tác giả thành công";
    }
}