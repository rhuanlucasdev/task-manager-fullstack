package com.rhuan.taskmanager.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

/**
 * Configuração de CORS
 * 
 * Permite que o frontend (Vue) acesse o backend (Spring Boot)
 */
@Configuration
public class CorsConfig {

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {

            @Override
            public void addCorsMappings(CorsRegistry registry) {

                registry.addMapping("/**") // aplica para todas as rotas

                        // Permite requisições do frontend
                        .allowedOrigins("http://localhost:5173")

                        // Permite todos os métodos HTTP (GET, POST, DELETE, PATCH...)
                        .allowedMethods("*")

                        // Permite todos os headers
                        .allowedHeaders("*");
            }
        };
    }
}