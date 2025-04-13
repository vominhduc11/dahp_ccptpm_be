package com.movieapp.dahp_ccptpm_be.service;

import com.movieapp.dahp_ccptpm_be.dto.AccountDTO;
import com.movieapp.dahp_ccptpm_be.mapper.AccountMapper;
import com.movieapp.dahp_ccptpm_be.model.entity.Account;
import com.movieapp.dahp_ccptpm_be.repository.AccountRepository;
import jakarta.validation.Valid;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.net.URI;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Service
public class AuthService {
     @Autowired
     AccountMapper accountMapper;

     @Autowired
     AccountRepository accountRepository;

     public ResponseEntity<Account> register(AccountDTO accountDTO) {
          Account account = accountMapper.toAccount(accountDTO);
          URI location = URI.create("/auth/register/");

          accountRepository.save(account);
          return ResponseEntity.created(location).body(account);
     }

     public ResponseEntity<Account> login(AccountDTO accountDTO) {
          Account account = accountMapper.toAccount(accountDTO);
          boolean  isExist = accountRepository.existsByUsername(account.getUsername());
          if(isExist){
               return ResponseEntity.ok(account);
          } else {
               return ResponseEntity.notFound().build();
          }
     }
}
