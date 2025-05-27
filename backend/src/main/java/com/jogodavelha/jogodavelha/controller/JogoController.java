package com.jogodavelha.jogodavelha.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.jogodavelha.jogodavelha.model.JogoDaVelha;
import com.jogodavelha.jogodavelha.services.JogoService;

import org.springframework.web.bind.annotation.PostMapping;



@RestController
@RequestMapping("/") //rota padrão
// @CrossOrigin(origins = "https://champs-8.github.io") //para permitir o acesso de qualquer origem
// @CrossOrigin(origins = "http://127.0.0.1:5500/") //acesso para testes
@SuppressWarnings("unused") //para não dar warning de variaveis não utilizadas
public class JogoController {

    @Autowired
    private JogoService jogoService;

    @GetMapping("/") //mostrar a mensagem de status da API
    public Map<String, String> statusRoot() {
        Map<String, String> resposta = new HashMap<>();
        resposta.put("mensagem", "API  Jogo da Velha está ativa!");
        return resposta;
    }

    @GetMapping("/start")
    public JogoDaVelha start() {
        return jogoService.iniciarNovoJogo(); //inicia um novo jogo e retorna o objeto JogoDaVelha
    }

    @PostMapping("/play")
    public JogoDaVelha play(@RequestParam int row, @RequestParam int col) {
        System.out.println("Jogada recebida: row=" + row + ", col=" + col);
        jogoService.fazerJogada(row, col); //faz a jogada com as coordenadas passadas
        return jogoService.getJogo(); //retorna o jogo
    }

    @GetMapping("/status")
    public JogoDaVelha status() {
        return jogoService.getJogo(); //retorna o status do jogo
    }
}
