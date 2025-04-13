package com.movieapp.dahp_ccptpm_be.controller;

import com.movieapp.dahp_ccptpm_be.dto.AccountDTO;
import com.movieapp.dahp_ccptpm_be.dto.LoginSuccessDTO;
import com.movieapp.dahp_ccptpm_be.model.entity.Account;
import com.movieapp.dahp_ccptpm_be.service.AuthService;
import jakarta.validation.Valid;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@FieldDefaults(level = AccessLevel.PRIVATE)
@RestController
public class AuthController {
    @Autowired
    AuthService authService;

    @PostMapping(value = "/auth/register")
    public ResponseEntity<Account> register(@Valid @RequestBody AccountDTO accountDTO) {
        ResponseEntity<Account> result = authService.register(accountDTO);
        return result;
    }

    @PostMapping(value = "/auth/login")
    public ResponseEntity<LoginSuccessDTO> login(@Valid @RequestBody AccountDTO accountDTO) {
        ResponseEntity<LoginSuccessDTO> result = authService.login(accountDTO);
        return result;
    }
}
