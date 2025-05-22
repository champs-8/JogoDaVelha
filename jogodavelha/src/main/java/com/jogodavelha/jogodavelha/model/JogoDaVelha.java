package com.jogodavelha.jogodavelha.model;

import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@SuppressWarnings("unused") //para não dar warning de variaveis não utilizadas
public class JogoDaVelha { //variaveis
	private char[][] tabuleiro; //pode-se usar char, devido ser apenas 1 caractere;
	private char jogadorAtual;
	private String status; //status do jogo, se está em andamento ou não
	
	public JogoDaVelha() { //construtor da classe
		tabuleiro = new char[3][3];
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
	
	//metodo para fazer a jogada
	public boolean fazerJogada(int linha, int coluna){
		if (linha >= 0 && linha < 3 && coluna >=0  && coluna < 3 && tabuleiro[linha][coluna] == '-'){ 
			//é utilizada == inves de equals devido utilizar char e '';
			tabuleiro[linha][coluna] = jogadorAtual; //a posição que foi passada como parametro receber o valor de jogador
			return true;
		}
		System.err.println("\n ==> Posicao ja preenchida ou não existente, tente novamente <==\n");
		return false;
	}
	
	private void alternarJogador(){
		jogadorAtual = (jogadorAtual == 'X') ? 'O' : 'X';
	}

	//verificar Vitoria
	private boolean verificarVitoria(){
		for (int i = 0; i < 3; i++ ){
			//verificando vitoria na horizontal e vertical
			if (tabuleiro[i][0] != '-' && tabuleiro[i][0] == tabuleiro[i][1] && tabuleiro[i][1] == tabuleiro[i][2]) return true;
			if (tabuleiro[0][i] != '-' && tabuleiro[0][i] == tabuleiro[1][i] && tabuleiro[1][i] == tabuleiro[2][i]) return true;
		}

		//verificarndo na diagonal
		//diagonal principal
		if(tabuleiro[0][0] != '-' && tabuleiro[0][0] == tabuleiro[1][1] && tabuleiro[1][1] == tabuleiro[2][2]) return true;
		//diagonal secundaria
		if(tabuleiro[0][2] != '-' && tabuleiro[0][2] == tabuleiro[1][1] && tabuleiro[1][1] == tabuleiro[2][0]) return true;
		
		//se caso nao for não nenhuma dessas linhas
		return false; //ninguem ganhou
	}

	private boolean verificarEmpate(){
		for (int i = 0; i < 3; i++){
			for (int j = 0; j < 3; j++ ){
				if (tabuleiro[i][j] == '-') return false;
			}
		}
		return !verificarVitoria(); // se tiver dado vitoria (true) aqui será false, o contrario do true do metodo
		//se em verificarVitoria() der false, aqui será true, confirmando que deu empate
	}

	//getters
	public char[][] getTabuleiro() {
		return tabuleiro;
	}
	public char getJogadorAtual() {
		return jogadorAtual;
	}
	public String getStatus() {
		return status;
	}
}