const API_URL = 'https://jogodavelha-xks4.onrender.com';
// const API_URL = 'http://localhost:8080'; //url de teste

const tabuleiro = document.getElementById('tabuleiro');

function renderTabuleiro(tabuleiroData){
    tabuleiro.innerHTML = ''; // limpa o tabuleiro antes de renderizar novamente

    //montar o tabuleiro quando carregar o js
    for(let r = 0; r < 3; r++){
        for(let c = 0; c < 3; c++){
            let celula = document.createElement('div'); //cria elemento celula
            celula.setAttribute('class', 'celula'); //define a classe
            celula.setAttribute('id', `celula${r}${c}`); //adiciona o id
            celula.textContent = (tabuleiroData[r][c] == '-') ? ' ' : tabuleiroData[r][c]; //irá receber as posições clicadas quando renderizar

            //verificação de conteúdo para aplicar cor na celula
            if (tabuleiroData[r][c] === 'X') {
                celula.style.backgroundColor = '#1B263B'; // cor para X
            } else if(tabuleiroData[r][c] === 'O') {
                celula.style.backgroundColor = '#778DA9'; // cor para O
            };

            tabuleiro.appendChild(celula); //insere na div
            
            //quando clicar em cada div, terá que fazer a chamada da requisição
            celula.addEventListener('click', () => fazerJogada(r, c));
        }
    }
}

function fazerJogada(row, col){
    let status = document.getElementById('status');
    let winner = document.getElementById('winner');
    let btnPlay = document.getElementById('btnPlay');

    // inicia desativado e ativa o botão de reiniciar o jogo a partir da primeira jogada
    btnPlay.style.visibility = 'visible';

    //requisição
    fetch(`${API_URL}/play?row=${row}&col=${col}`,{
        method: 'POST', //método da requisição
    }) 
    .then(res => {
        if(!res.ok) throw new Error('Erro na jogada'); //fetch não trata erro 404
        return res.json();
    })
    .then(data => {
        // console.log("Resposta da API:", data); // para testes de retorno data

        renderTabuleiro(data.tabuleiro, data.jogadorAtual);

        status.textContent = data.status; //atualiza o status do jogo
        winner.textContent = `VEZ DE ${data.jogadorAtual}`;

        // Se o status indicar vitória, aplica destaque
        if (data.status.includes('VENCEDOR')) {
            destacarVitoria(data.tabuleiro, data.jogadorAtual);
        }
    })
    .catch(err => console.error(err));
}

// Função genérica para iniciar o jogo
function iniciarJogo() {

    // Atualiza os elementos DOM apenas se existirem (evita erro no load inicial)
    const status = document.getElementById('status');
    const winner = document.getElementById('winner');

    fetch(`${API_URL}/start`)
        .then(res => res.json())
        .then(data => {
            renderTabuleiro(data.tabuleiro);
            if (winner) winner.textContent = `VEZ DE ${data.jogadorAtual}`;
        })
        .catch(err => console.error(`Erro ao iniciar o jogo: ${err}`))
        .finally(() => {
            if(status) status.textContent = 'X O';
        })
}
// Chamar ao carregar o script
window.onload = iniciarJogo;

// Chamar ao clicar no botão
const btnPlay = document.getElementById('btnPlay');
btnPlay.addEventListener('click', iniciarJogo);



//transforme scale para destacar a linha quando tiver vitória
function destacarVitoria(tabuleiroData, jogadorAtual) {
    // Verifica linhas
    for (let r = 0; r < 3; r++) {
        if (tabuleiroData[r][0] === jogadorAtual &&
            tabuleiroData[r][1] === jogadorAtual &&
            tabuleiroData[r][2] === jogadorAtual) {
            for (let c = 0; c < 3; c++) {
                document.getElementById(`celula${r}${c}`).classList.add('vencedora');
            }
        }
    }

    // Verifica colunas
    for (let c = 0; c < 3; c++) {
        if (tabuleiroData[0][c] === jogadorAtual &&
            tabuleiroData[1][c] === jogadorAtual &&
            tabuleiroData[2][c] === jogadorAtual) {
            for (let r = 0; r < 3; r++) {
                document.getElementById(`celula${r}${c}`).classList.add('vencedora');
            }
        }
    }

    // Verifica diagonal principal
    if (tabuleiroData[0][0] === jogadorAtual &&
        tabuleiroData[1][1] === jogadorAtual &&
        tabuleiroData[2][2] === jogadorAtual) {
        for (let i = 0; i < 3; i++) {
            document.getElementById(`celula${i}${i}`).classList.add('vencedora');
        }
    }

    // Verifica diagonal secundária
    if (tabuleiroData[0][2] === jogadorAtual &&
        tabuleiroData[1][1] === jogadorAtual &&
        tabuleiroData[2][0] === jogadorAtual) {
        for (let i = 0; i < 3; i++) {
            document.getElementById(`celula${i}${2 - i}`).classList.add('vencedora');
        }
    }
}
