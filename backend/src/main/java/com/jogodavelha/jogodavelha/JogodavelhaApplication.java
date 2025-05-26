package com.jogodavelha.jogodavelha;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SpringBootApplication
public class JogodavelhaApplication {
    private static final Logger logger = LoggerFactory.getLogger(JogodavelhaApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(JogodavelhaApplication.class, args);
        logger.info("✅ API do Jogo da Velha está ativa no Render!");
    }
}

