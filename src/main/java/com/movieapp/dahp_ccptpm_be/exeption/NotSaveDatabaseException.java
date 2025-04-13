package com.movieapp.dahp_ccptpm_be.exeption;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.movieapp.dahp_ccptpm_be.dto.ExeptionResDTO;

@ControllerAdvice
public class NotSaveDatabaseException {
    @ExceptionHandler(RuntimeException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseEntity<ExeptionResDTO> handleAuthenticationException(RuntimeException ex) {
        ExeptionResDTO error = new ExeptionResDTO();
        error.setError(ex.getMessage());
        return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
