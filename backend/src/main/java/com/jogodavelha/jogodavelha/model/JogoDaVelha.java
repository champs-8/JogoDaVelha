package com.jogodavelha.jogodavelha.model;

import com.fasterxml.jackson.annotation.JsonFormat;

public class JogoDaVelha { //variaveis
	@JsonFormat(shape = JsonFormat.Shape.ARRAY) //para formatar o tabuleiro como um array no JSON
	private Character[][] tabuleiro; //pode-se usar char, devido ser apenas 1 caractere;
	private char jogadorAtual;
	private String status; //status do jogo, se está em andamento ou não
	
	public JogoDaVelha() { //construtor da classe
		tabuleiro = new Character[3][3];
		jogadorAtual = 'X';
		status = "IN_PROGRESS";
		inicializarTabuleiro();
	}

	private void inicializarTabuleiro(){ //nao é estatico porque nao será chamada no main
		for (int i = 0; i < 3; i++){
				for (int j = 0; j < 3; j++){
				tabuleiro[i][j] = '-'; //identificar o espaço que foi criado, com aspas simples pois é char
			}
		}
	}

	//getters
	public Character[][] getTabuleiro() {
		return tabuleiro;
	}
	public char getJogadorAtual() {
		return jogadorAtual;
	}
	public void setJogadorAtual(char jogadorAtual) {
		this.jogadorAtual = jogadorAtual;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
}