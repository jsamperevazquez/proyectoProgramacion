package com.proyecto.app;

import com.proyecto.app.form.Portal;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

/**
 * @author Angel,Aira
 * @version 0.1.1
 * Main de Api Rest (Tomcat embebido en puerto 8080)
 */
@SpringBootApplication
public class ProyectoProgramacionApplication {

    public ProyectoProgramacionApplication() {
    }

    public static void main(String[] args) {
        //Portal portal = new Portal();
        //portal.iniciar();
        SpringApplication.run(ProyectoProgramacionApplication.class, args);

    }
    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**")
                        .allowedOrigins("http://samaria-bucket.s3-website-eu-west-1.amazonaws.com:4200")
                        .allowedMethods("*")
                        .allowedHeaders("*");
            }
        };
    }

}
