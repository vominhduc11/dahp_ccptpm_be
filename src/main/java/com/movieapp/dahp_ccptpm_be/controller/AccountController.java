package com.movieapp.dahp_ccptpm_be.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "User Management", description = "APIs for managing users")
@FieldDefaults(level = AccessLevel.PRIVATE)
@RestController
public class AccountController {
    @Operation(summary = "Say hello", description = "Api say hello")
    @GetMapping
    public ResponseEntity<String> sayHello() {
        return ResponseEntity.ok("Hello, Swagger!");
    }
}
