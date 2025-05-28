package com.jogodavelha.jogodavelha.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(JogoNaoIniciadoException.class)
    public ResponseEntity<String> handleJogoNaoIniciado(JogoNaoIniciadoException ex) {
        return ResponseEntity
            .status(HttpStatus.CONFLICT) //
            .body(ex.getMessage());
    }
    
    // Tratamento de exceção genérica para capturar outros erros
    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleGeneric(Exception ex) {
        return ResponseEntity
            .status(HttpStatus.INTERNAL_SERVER_ERROR)
            .body("Erro interno na aplicação.");
    }
}
