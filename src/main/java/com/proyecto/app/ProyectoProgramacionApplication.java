package com.proyecto.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.Arrays;

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
    @EnableWebSecurity
    public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

        @Override
        protected void configure(HttpSecurity http) throws Exception{
            http.cors().and().csrf().disable();
        }

        @Bean
        CorsConfigurationSource corsConfigurationSource() {
            CorsConfiguration configuration = new CorsConfiguration();
            configuration.setAllowedOrigins(Arrays.asList("*"));
            configuration.setAllowedMethods(Arrays.asList("*"));
            configuration.setAllowedHeaders(Arrays.asList("*"));
            configuration.setAllowCredentials(true);
            UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
            source.registerCorsConfiguration("/**", configuration);
            return source;
        }

    }
}
