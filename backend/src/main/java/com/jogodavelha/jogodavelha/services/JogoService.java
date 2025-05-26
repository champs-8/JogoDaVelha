package com.jogodavelha.jogodavelha.services;

import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.jogodavelha.jogodavelha.model.JogoDaVelha;

@Service // Anotação para indicar que esta classe é um serviço
public class JogoService {

	private static final Logger logger = LoggerFactory
	.getLogger(JogoService.class); // Logger para registrar informações de depuração e erros
    private JogoDaVelha jogo; // Instância do jogo da velha

	public JogoDaVelha iniciarNovoJogo() {
		jogo = new JogoDaVelha(); // Cria uma nova instância do jogo da velha
		return jogo; // Retorna o objeto JogoDaVelha
	}


	//metodo para fazer a jogada
	public void fazerJogada(int linha, int coluna){
		if(jogo.getStatus().equals("FINALIZADO") ||
			jogo.getStatus().startsWith("VENCEDOR") ||
			jogo.getStatus().equals("EMPATE")) {
			return;
		}
		
		char[][] tabuleiro =jogo.getTabuleiro(); //obtendo o tabuleiro atual
		char jogadorAtual = jogo.getJogadorAtual(); //obtendo o jogador atual


		if (linha >= 0 && linha < 3 && coluna >=0  && coluna < 3 && tabuleiro[linha][coluna] == '-'){
			//é utilizada == inves de equals devido utilizar char e '';
			tabuleiro[linha][coluna] = jogadorAtual; //a posição que foi passada como parametro receber o valor de jogador
			
			if(verificarVitoria(tabuleiro, jogadorAtual)){
				jogo.setStatus("VENCEDOR: "+jogadorAtual); //se o jogador atual ganhou
			} else if (verificarEmpate(tabuleiro)) {
				jogo.setStatus("EMPATE"); //se deu empate

			} else {
				jogo.setJogadorAtual((jogadorAtual == 'X') ? 'O' : 'X'); //se não ganhou nem deu empate, troca o jogador atual
			}
		}
	}
	
	public JogoDaVelha getJogo() {
		return jogo; // Retorna o objeto JogoDaVelha atual
	}
	
	//verificar Vitoria
	private boolean verificarVitoria(char[][] tabuleiro, char jogador){
		for (int i = 0; i < 3; i++ ){
			//verificando vitoria na horizontal e vertical
			if ((tabuleiro[i][0] == jogador && tabuleiro[i][1] == jogador && tabuleiro[i][2] == jogador) ||
				(tabuleiro[0][i] == jogador && tabuleiro[1][i] == jogador && tabuleiro[2][i] == jogador)) {
				return true;
        	}
		}

		//verificarndo na diagonal
		//diagonal principal
		if ((tabuleiro[0][0] == jogador && tabuleiro[1][1] == jogador && tabuleiro[2][2] == jogador) ||
			(tabuleiro[0][2] == jogador && tabuleiro[1][1] == jogador && tabuleiro[2][0] == jogador)) {
			return true;
		}
		
		//se caso nao for não nenhuma dessas linhas
		return false; //ninguem ganhou
	}

	private boolean verificarEmpate(char[][] tabuleiro){
		for (int i = 0; i < 3; i++){
			for (int j = 0; j < 3; j++ ){
				if (tabuleiro[i][j] == '-') return false;
			}
		}
		return true; //se não tiver nenhum espaço vazio, é empate
	}
}