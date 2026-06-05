package com.library.backend.controller;

import com.library.backend.dto.TheLoaiRequest;
import com.library.backend.dto.TheLoaiResponse;
import com.library.backend.service.TheLoaiService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categories")
public class TheLoaiController {

    private final TheLoaiService theLoaiService;

    public TheLoaiController(TheLoaiService theLoaiService) {
        this.theLoaiService = theLoaiService;
    }

    @GetMapping
    public List<TheLoaiResponse> getAll() {
        return theLoaiService.getAll();
    }

    @GetMapping("/{maTheLoai}")
    public TheLoaiResponse getById(@PathVariable String maTheLoai) {
        return theLoaiService.getById(maTheLoai);
    }

    @PostMapping
    public TheLoaiResponse create(@Valid @RequestBody TheLoaiRequest request) {
        return theLoaiService.create(request);
    }

    @PutMapping("/{maTheLoai}")
    public TheLoaiResponse update(
            @PathVariable String maTheLoai,
            @Valid @RequestBody TheLoaiRequest request
    ) {
        return theLoaiService.update(maTheLoai, request);
    }

    @DeleteMapping("/{maTheLoai}")
    public String disable(@PathVariable String maTheLoai) {
        theLoaiService.disable(maTheLoai);
        return "Ngừng áp dụng thể loại thành công";
    }
}