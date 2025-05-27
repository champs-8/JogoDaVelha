// const API_URL = 'https://jogodavelha-xks4.onrender.com';
const API_URL = 'http://localhost:8080'; //url de teste

const tabuleiro = document.getElementById('tabuleiro');

function renderTabuleiro(){
    //montar o tabuleiro quando carregar o js
    for(let r = 0; r < 3; r++){
        for(let c = 0; c < 3; c++){
            let celula = document.createElement('div'); //cria elemento celula
            celula.setAttribute('class', 'celula'); //define a classe
            celula.setAttribute('id', `celula${r}${c}`); //adiciona o id
            celula.textContent = tabuleiro[r][c] || "-" ; //irá receber as posições clicadas quando renderizar
            tabuleiro.appendChild(celula); //insere na div

            //quando clicar em cada div, terá que fazer a chamada da requisição
            celula.addEventListener('click', () => fazerJogada(r, c));
        }
    }
}

async function fazerJogada(row, col){
    await fetch(`${API_URL}/play?row=${row}&col=${col}`,{
        method: 'POST', //método da requisição
    }) //requisição
    .then(res => {
        if(!res.ok) throw new Error('Erro na jogada'); //fetch não trata erro 404
        return res.json();
    })
    .then(data => renderTabuleiro(data))
    .catch(err => console.error(err));
}

async window.onload = function(){ //irá carregar o tabuleiro na API quando carregar o script
    await fetch(`${API_URL}/start`)
    .then(res => res.json())
    .then(data => renderTabuleiro(data.tabuleiro))
    .catch(err => console.error(`Erro ao carregar o estado inicial: ${err}`));
}
