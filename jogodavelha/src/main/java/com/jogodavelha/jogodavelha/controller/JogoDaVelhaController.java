package com.jogodavelha.jogodavelha.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.jogodavelha.jogodavelha.model.JogoDaVelha;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping("/") //rota padrão
@CrossOrigin(origins = "*") //para permitir o acesso de qualquer origem
@SuppressWarnings("unused") //para não dar warning de variaveis não utilizadas
public class JogoDaVelhaController {
    private JogoDaVelha jogoDaVelha = new JogoDaVelha(); //instancia do jogo da velha

    @GetMapping("/start")
    public JogoDaVelha start() {
        jogoDaVelha = new JogoDaVelha(); //inicializa o jogo
        return jogoDaVelha; //retorna o jogo
    }

    @PostMapping("/play")
    public JogoDaVelha play(@RequestParam int row, @RequestParam int col) {
        jogoDaVelha.fazerJogada(row, col); //faz a jogada
        return jogoDaVelha; //retorna o jogo
    }

    @GetMapping("/status")
    public JogoDaVelha status() {
        return jogoDaVelha; //retorna o status do jogo
    }
}
