package com.movieapp.dahp_ccptpm_be.exeption;

import com.movieapp.dahp_ccptpm_be.dto.ExeptionResDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class AuthenticationExceptionHandler {
    @ExceptionHandler(BadCredentialsException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseEntity<ExeptionResDTO> handleAuthenticationException(BadCredentialsException ex) {
        ExeptionResDTO error = new ExeptionResDTO();
        error.setError(ex.getMessage());
        return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
