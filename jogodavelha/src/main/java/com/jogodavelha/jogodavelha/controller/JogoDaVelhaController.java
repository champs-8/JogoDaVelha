package com.jogodavelha.jogodavelha.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jogodavelha.jogodavelha.JogoDaVelha;

@RestController
@RequestMapping("/") //rota padrão
@CrossOrigin(origins = "*") //para permitir o acesso de qualquer origem
@SuppressWarnings("unused") //para não dar warning de variaveis não utilizadas
public class JogoDaVelhaController {
    private JogoDaVelha jogoDaVelha = new JogoDaVelha(); //instancia do jogo da velha
    
}
