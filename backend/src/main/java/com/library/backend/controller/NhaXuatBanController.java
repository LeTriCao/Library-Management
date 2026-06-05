package com.library.backend.controller;

import com.library.backend.dto.NhaXuatBanRequest;
import com.library.backend.dto.NhaXuatBanResponse;
import com.library.backend.service.NhaXuatBanService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/publishers")
public class NhaXuatBanController {

    private final NhaXuatBanService nhaXuatBanService;

    public NhaXuatBanController(NhaXuatBanService nhaXuatBanService) {
        this.nhaXuatBanService = nhaXuatBanService;
    }

    @GetMapping
    public List<NhaXuatBanResponse> getAll() {
        return nhaXuatBanService.getAll();
    }

    @GetMapping("/{maNhaXuatBan}")
    public NhaXuatBanResponse getById(@PathVariable String maNhaXuatBan) {
        return nhaXuatBanService.getById(maNhaXuatBan);
    }

    @PostMapping
    public NhaXuatBanResponse create(@Valid @RequestBody NhaXuatBanRequest request) {
        return nhaXuatBanService.create(request);
    }

    @PutMapping("/{maNhaXuatBan}")
    public NhaXuatBanResponse update(
            @PathVariable String maNhaXuatBan,
            @Valid @RequestBody NhaXuatBanRequest request
    ) {
        return nhaXuatBanService.update(maNhaXuatBan, request);
    }

    @DeleteMapping("/{maNhaXuatBan}")
    public String delete(@PathVariable String maNhaXuatBan) {
        nhaXuatBanService.delete(maNhaXuatBan);
        return "Xóa nhà xuất bản thành công";
    }
}