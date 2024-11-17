package edu.villanova.csc8542.preeclampsia.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration

public class CorsConfig  implements WebMvcConfigurer {

    public void addCorsMapping(CorsRegistry registry) {
        registry.addMapping("/**") //Allow CORS for all endpoints
                .allowedOrigins("http://localhost:3000")
                .allowedMethods("*")
                .allowedHeaders("*");

    }
}