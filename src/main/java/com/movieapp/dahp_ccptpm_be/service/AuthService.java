package com.movieapp.dahp_ccptpm_be.service;

import com.movieapp.dahp_ccptpm_be.dto.AccountDTO;
import com.movieapp.dahp_ccptpm_be.dto.CreateSuccessDTO;
import com.movieapp.dahp_ccptpm_be.dto.LoginSuccessDTO;
import com.movieapp.dahp_ccptpm_be.mapper.AccountMapper;
import com.movieapp.dahp_ccptpm_be.model.entity.Account;
import com.movieapp.dahp_ccptpm_be.repository.AccountRepository;
import com.movieapp.dahp_ccptpm_be.security.JWTutils;
import jakarta.validation.Valid;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.net.URI;
import java.util.HashMap;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Service
public class AuthService {
     @Autowired
     AccountMapper accountMapper;

     @Autowired
     AccountRepository accountRepository;

     @Autowired
     PasswordEncoder passwordEncoder;

     @Autowired
     private JWTutils jwtUtils;

     @Autowired
     private AuthenticationManager authenticationManager;

     public ResponseEntity<CreateSuccessDTO> register(AccountDTO accountDTO) {
          Account account = accountMapper.toAccount(accountDTO);
          account.setPassword(passwordEncoder.encode(account.getPassword()));
          URI location = URI.create("/auth/register/");

          try {
               accountRepository.save(account);
          } catch (DataAccessException e) {
               throw new RuntimeException("Không thể thêm vào cơ sở dữ liệu");
          }

          CreateSuccessDTO createSuccessDTO = new CreateSuccessDTO();
          createSuccessDTO.setMessage("Tạo tài khoản thành công");
          return ResponseEntity.created(location).body(createSuccessDTO);
     }

     public ResponseEntity<LoginSuccessDTO> login(AccountDTO accountDTO) {
          Account account = accountMapper.toAccount(accountDTO);

          try {
               authenticationManager.authenticate(
                         new UsernamePasswordAuthenticationToken(account.getUsername(), account.getPassword()));
          } catch (AuthenticationException e) {
               throw new BadCredentialsException("Sai tên đăng nhập hoặc mật khẩu");
          }

          Account account1 = accountRepository.findByUsername(account.getUsername()).orElseThrow(() -> {
               throw new UsernameNotFoundException("Không tìm thấy tài khoản");
          });
          String token = jwtUtils.generateToken(account1);
          String refreshToken = jwtUtils.generateRefreshToken(new HashMap<>(), account1);

          LoginSuccessDTO loginSuccessDTO = new LoginSuccessDTO();
          loginSuccessDTO.setToken(token);
          loginSuccessDTO.setRefreshToken(refreshToken);

          return ResponseEntity.ok(loginSuccessDTO);
     }
}
