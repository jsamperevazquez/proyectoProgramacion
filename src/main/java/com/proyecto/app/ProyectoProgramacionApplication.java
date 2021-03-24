package com.proyecto.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author Angel,David
 * @version 0.1.1
 * Main de Api Rest (Tomcat embebido en puerto 8080)
 */
@SpringBootApplication
public class ProyectoProgramacionApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProyectoProgramacionApplication.class, args);

    }
    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**").allowedOrigins("http://localhost:4200");
            }
        };
    }

}
