package com.library.backend.controller;

import com.library.backend.entity.GoiThanhVien;
import com.library.backend.entity.NhomDocGia;
import com.library.backend.repository.GoiThanhVienRepository;
import com.library.backend.repository.NhomDocGiaRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ReaderOptionController {

    private final NhomDocGiaRepository nhomDocGiaRepository;
    private final GoiThanhVienRepository goiThanhVienRepository;

    public ReaderOptionController(
            NhomDocGiaRepository nhomDocGiaRepository,
            GoiThanhVienRepository goiThanhVienRepository
    ) {
        this.nhomDocGiaRepository = nhomDocGiaRepository;
        this.goiThanhVienRepository = goiThanhVienRepository;
    }

    @GetMapping("/reader-groups")
    public List<NhomDocGia> getReaderGroups() {
        return nhomDocGiaRepository.findAll();
    }

    @GetMapping("/membership-plans")
    public List<GoiThanhVien> getMembershipPlans() {
        return goiThanhVienRepository.findAll();
    }
}