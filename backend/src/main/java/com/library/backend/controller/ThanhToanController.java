package com.library.backend.controller;

import com.library.backend.dto.KhoanNoResponse;
import com.library.backend.dto.PhieuThuRequest;
import com.library.backend.dto.PhieuThuResponse;
import com.library.backend.entity.PhuongThucThanhToan;
import com.library.backend.repository.PhuongThucThanhToanRepository;
import com.library.backend.service.ThanhToanService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ThanhToanController {

    private final ThanhToanService thanhToanService;
    private final PhuongThucThanhToanRepository phuongThucThanhToanRepository;

    public ThanhToanController(
            ThanhToanService thanhToanService,
            PhuongThucThanhToanRepository phuongThucThanhToanRepository
    ) {
        this.thanhToanService = thanhToanService;
        this.phuongThucThanhToanRepository = phuongThucThanhToanRepository;
    }

    @GetMapping("/readers/{maDocGia}/debts")
    public List<KhoanNoResponse> getDebtsByReader(@PathVariable String maDocGia) {
        return thanhToanService.getDebtsByReader(maDocGia);
    }

    @GetMapping("/payment-methods")
    public List<PhuongThucThanhToan> getPaymentMethods() {
        return phuongThucThanhToanRepository.findAll();
    }

    @PostMapping("/payments")
    public PhieuThuResponse createPayment(@Valid @RequestBody PhieuThuRequest request) {
        return thanhToanService.createPayment(request);
    }

    @GetMapping("/payments/{maPhieuThu}")
    public PhieuThuResponse getPaymentById(@PathVariable String maPhieuThu) {
        return thanhToanService.getPaymentById(maPhieuThu);
    }

    @GetMapping("/readers/{maDocGia}/payments")
    public List<PhieuThuResponse> getPaymentsByReader(@PathVariable String maDocGia) {
        return thanhToanService.getPaymentsByReader(maDocGia);
    }
}