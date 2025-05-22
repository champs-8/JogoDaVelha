🎮 Jogo da Velha — Java + Frontend Web
<div align="center"> <img src="https://img.shields.io/badge/Java-17-blue?logo=java" /> <img src="https://img.shields.io/badge/SpringBoot-3.x-green?logo=spring" /> <img src="https://img.shields.io/badge/Docker-Containerized-blue?logo=docker" /> <img src="https://img.shields.io/badge/Frontend-HTML%2FCSS%2FJS-orange" /> </div>
🧠 Sobre o projeto
Este projeto é uma aplicação completa do clássico Jogo da Velha, desenvolvido com:

🚀 Backend: API REST em Java Spring Boot

🎨 Frontend: Página web utilizando HTML, CSS e JavaScript puro

🐳 Containerizado: Via Docker, facilitando deploy em qualquer ambiente

O jogo permite que dois jogadores joguem no navegador, com controle de partidas, verificação de vitória, empate e reinício de jogo.

📸 Demonstração
<p align="center"> <img src="https://user-images.githubusercontent.com/000000/0000000000.gif" alt="Demonstração do Jogo da Velha" width="600"/> </p>
🔗 Acesso ao Projeto
🔥 Frontend Online: https://seu-usuario.github.io/jogodavelha-frontend/

🔥 API Backend: https://jogodavelha-backend.onrender.com/api

🚀 Funcionalidades
🎯 Jogar partidas interativas

🧠 Verificação automática de vitória

➕ Verificação de empate

♻️ Reinício de jogo a qualquer momento

🌐 Backend e Frontend acessíveis online

📦 Totalmente Dockerizado e pronto para produção

🏗️ Tecnologias Utilizadas
🔧 Backend
Java 17

Spring Boot 3.x

Maven

API REST

Docker

🎨 Frontend
HTML5

CSS3

JavaScript Vanilla

Nginx (para container Docker)

🗺️ Arquitetura do Projeto
plaintext
Copiar
Editar
/meu-projeto
 ├── backend/         --> API REST em Spring Boot
 │    ├── src/
 │    └── Dockerfile  --> Docker do backend
 ├── frontend/        --> Página web (HTML + JS)
 │    └── Dockerfile  --> Docker do frontend (nginx)
 └── docker-compose.yml --> Orquestra backend e frontend
🐳 Executando com Docker
⚙️ Pré-requisitos:
Docker instalado → https://docs.docker.com/get-docker/

🚀 Rodar localmente:
bash
Copiar
Editar
git clone https://github.com/seu-usuario/jogodavelha.git
cd jogodavelha
docker-compose up --build
🔗 Acesse:
🎨 Frontend → http://localhost:8081

🔗 Backend → http://localhost:8080/api

🧠 API - Endpoints
Método	Endpoint	Descrição
GET	/api/status	Verificar status API
POST	/api/move	Enviar jogada
POST	/api/reset	Reiniciar jogo
GET	/api/state	Estado atual do jogo

(→ A definir mais endpoints se desejar)

🌍 Deploy na Nuvem
O projeto pode ser facilmente hospedado em:

Plataforma	Suporte Docker	Observação
Render	✅	✅ Free Tier
Railway	✅	✅ Free para testes
Fly.io	✅	Global Edge Deploy
Vercel	Frontend Only	Frontend rápido
GitHub Pages	Frontend Only	Super simples

🌐 Hospedagem no GitHub Pages (Frontend)
🚀 Como fazer:
Suba o conteúdo do frontend para um repositório.

Vá em Settings → Pages → Source → Branch: main (root).

O GitHub gera um link assim:

arduino
Copiar
Editar
https://seu-usuario.github.io/jogodavelha-frontend/
👨‍💻 Como Contribuir
Fork este repositório

Crie uma branch: git checkout -b feature/sua-feature

Commit: git commit -m 'Adiciona sua feature'

Push: git push origin feature/sua-feature

Abra um Pull Request ✅

📜 Licença
Distribuído sob a licença MIT.
Veja LICENSE para mais informações.

🤝 Contato
Desenvolvido com 💙 por Seu Nome.

💼 LinkedIn

📧 seuemail@exemplo.com

🌎 Portfólio

