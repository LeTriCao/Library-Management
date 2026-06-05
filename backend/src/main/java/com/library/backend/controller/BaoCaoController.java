package com.library.backend.controller;

import com.library.backend.dto.*;
import com.library.backend.service.BaoCaoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reports")
public class BaoCaoController {

    private final BaoCaoService baoCaoService;

    public BaoCaoController(BaoCaoService baoCaoService) {
        this.baoCaoService = baoCaoService;
    }

    @GetMapping("/debts")
    public List<TongNoDocGiaReportResponse> getTongNoDocGia() {
        return baoCaoService.getTongNoDocGia();
    }

    @GetMapping("/current-loans")
    public List<SachDangMuonReportResponse> getSoSachDangMuon() {
        return baoCaoService.getSoSachDangMuon();
    }

    @GetMapping("/borrow-by-category")
    public List<BaoCaoMuonTheLoaiResponse> getBaoCaoMuonTheoTheLoai(
            @RequestParam Integer month,
            @RequestParam Integer year
    ) {
        return baoCaoService.getBaoCaoMuonTheoTheLoai(month, year);
    }

    @GetMapping("/late-returns")
    public List<BaoCaoTraTreResponse> getBaoCaoTraTre(
            @RequestParam Integer month,
            @RequestParam Integer year
    ) {
        return baoCaoService.getBaoCaoTraTre(month, year);
    }
}