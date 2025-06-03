# 🎮 Jogo da Velha — Java + Frontend Web
<div align="center"> <img src="https://img.shields.io/badge/Java-17-blue?logo=java" /> <img src="https://img.shields.io/badge/SpringBoot-3.4.6-green?logo=spring" /> <img src="https://img.shields.io/badge/Docker-Containerized-blue?logo=docker" /> <img src="https://img.shields.io/badge/Frontend-HTML%2FCSS%2FJS-orange" /> </div>

![banner](https://github.com/champs-8/champs-8.github.io/blob/main/media/jogodavelha.png)

---

## 🧠 Sobre o projeto

> Este projeto é uma aplicação completa do clássico Jogo da Velha, desenvolvido com:

- **🚀 Backend**: API REST em Java Spring Boot

- **🎨 Frontend**: Página web utilizando HTML, CSS e JavaScript puro

- **🐳 Containerizado**: Via Docker, facilitando deploy em qualquer ambiente

O jogo permite que dois jogadores joguem no navegador, com controle de partidas, verificação de vitória, empate e reinício de jogo.

---

📸 Demonstração
<p align="center"> <img src="https://user-images.githubusercontent.com/000000/0000000000.gif" alt="Demonstração do Jogo da Velha" width="600"/> </p>

## 🔗 Acesso ao Projeto

- **🔥 Frontend Online**: https://champs-8.github.io/JogoDaVelha/

- **🔥 API Backend**: https://jogodavelha-xks4.onrender.com

---

## 🚀 Funcionalidades

- 🎯 Jogar partidas interativas

- 🧠 Verificação automática de vitória

- ➕ Verificação de empate

- ♻️ Reinício de jogo a qualquer momento

- 🌐 Backend e Frontend acessíveis online

- 📦 Totalmente Dockerizado e pronto para produção

---

## 🏗️ Tecnologias Utilizadas
### 🔧 Backend
- Java 17

- Spring Boot 3.4.6

- Maven

- API REST

- Docker

### 🎨 Frontend
- HTML5

- CSS3

- JavaScript Vanilla

---

## 🗺️ Arquitetura do Projeto

```
/meu-projeto
 ├── backend/         --> API REST em Spring Boot
 │    ├── src/
 │    └── Dockerfile  --> Docker do backend
 ├── frontend/        --> Página web (HTML + JS)
 └── docker-compose.yml --> Orquestra backend e frontend
```

---
 
## 🐳 Executando com Docker
⚙️ Pré-requisitos:
*Docker instalado → https://docs.docker.com/get-docker/*

🚀 Rodar localmente:

```
git clone https://github.com/seu-usuario/jogodavelha.git
cd jogodavelha
docker-compose up --build
```

### 🔗 Acesse:
🎨 Frontend → http://localhost:8081

🔗 Backend → http://localhost:8080

---

🧠 API - Endpoints
Método	Endpoint	Descrição
```
GET	/status	 Verificar status API
POST	/play?row=''&col=''	Enviar jogada
GET	/start	Inicia/Reiniciar jogo
```

---


📜 Licença
Distribuído sob a licença MIT.
Veja LICENSE para mais informações.

🤝 Contato
Desenvolvido com 💙 por ÇHAMP$.

💼 [LinkedIn](https://linkedin.com/in/fabios8)

🌎 [Portfólio](https://champs-8.github.io)

