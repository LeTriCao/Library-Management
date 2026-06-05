package com.library.backend.service;

import com.library.backend.dto.AuthResponse;
import com.library.backend.dto.LoginRequest;
import com.library.backend.entity.DocGia;
import com.library.backend.entity.NhanVien;
import com.library.backend.entity.TaiKhoan;
import com.library.backend.entity.VaiTro;
import com.library.backend.repository.DocGiaRepository;
import com.library.backend.repository.NhanVienRepository;
import com.library.backend.repository.TaiKhoanRepository;
import com.library.backend.repository.VaiTroRepository;
import com.library.backend.security.AuthUser;
import com.library.backend.security.TokenService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class AuthService {

    private final TaiKhoanRepository taiKhoanRepository;
    private final VaiTroRepository vaiTroRepository;
    private final DocGiaRepository docGiaRepository;
    private final NhanVienRepository nhanVienRepository;
    private final PasswordEncoder passwordEncoder;
    private final TokenService tokenService;
    private final ActivityLogService activityLogService;

    public AuthService(
            TaiKhoanRepository taiKhoanRepository,
            VaiTroRepository vaiTroRepository,
            DocGiaRepository docGiaRepository,
            NhanVienRepository nhanVienRepository,
            PasswordEncoder passwordEncoder,
            TokenService tokenService,
            ActivityLogService activityLogService
    ) {
        this.taiKhoanRepository = taiKhoanRepository;
        this.vaiTroRepository = vaiTroRepository;
        this.docGiaRepository = docGiaRepository;
        this.nhanVienRepository = nhanVienRepository;
        this.passwordEncoder = passwordEncoder;
        this.tokenService = tokenService;
        this.activityLogService = activityLogService;
    }

    public AuthResponse login(LoginRequest request) {
        TaiKhoan taiKhoan = taiKhoanRepository.findByTenDangNhap(request.getUsernameOrEmail())
                .or(() -> taiKhoanRepository.findByEmailDangNhap(request.getUsernameOrEmail()))
                .orElseThrow(() -> new RuntimeException("Tên đăng nhập/email hoặc mật khẩu không đúng"));

        if (!"Hoạt động".equals(taiKhoan.getTrangThai())) {
            throw new RuntimeException("Tài khoản không ở trạng thái hoạt động");
        }

        if (!passwordEncoder.matches(request.getPassword(), taiKhoan.getMatKhauHash())) {
            throw new RuntimeException("Tên đăng nhập/email hoặc mật khẩu không đúng");
        }

        VaiTro vaiTro = vaiTroRepository.findById(taiKhoan.getMaVaiTro())
                .orElseThrow(() -> new RuntimeException("Vai trò tài khoản không tồn tại"));

        AuthUser user = buildAuthUser(taiKhoan, vaiTro);
        String token = tokenService.generateToken(user);

        taiKhoan.setLanDangNhapCuoi(LocalDateTime.now());
        taiKhoanRepository.save(taiKhoan);

        activityLogService.logAsAccountSafe(
                taiKhoan.getMaTaiKhoan(),
                "Đăng nhập",
                "TAIKHOAN",
                taiKhoan.getMaTaiKhoan(),
                "Tài khoản " + taiKhoan.getTenDangNhap() + " đăng nhập thành công"
        );

        return toResponse(token, user);
    }

    public AuthResponse me(AuthUser user) {
        return toResponse(null, user);
    }

    private AuthUser buildAuthUser(TaiKhoan taiKhoan, VaiTro vaiTro) {
        String maDocGia = docGiaRepository.findByMaTaiKhoan(taiKhoan.getMaTaiKhoan())
                .map(DocGia::getMaDocGia)
                .orElse(null);

        String maNhanVien = nhanVienRepository.findByMaTaiKhoan(taiKhoan.getMaTaiKhoan())
                .map(NhanVien::getMaNhanVien)
                .orElse(null);

        return new AuthUser(
                taiKhoan.getMaTaiKhoan(),
                taiKhoan.getTenDangNhap(),
                taiKhoan.getMaVaiTro(),
                vaiTro.getTenVaiTro(),
                maDocGia,
                maNhanVien
        );
    }

    private AuthResponse toResponse(String token, AuthUser user) {
        return new AuthResponse(
                token,
                "Bearer",
                user.getMaTaiKhoan(),
                user.getTenDangNhap(),
                user.getMaVaiTro(),
                user.getTenVaiTro(),
                user.getMaDocGia(),
                user.getMaNhanVien()
        );
    }
}