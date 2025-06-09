package com.gco.producto.infraestructura.security.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author Edward P. Legaspi | czetsuya@gmail.com
 * @since
 */
@Configuration

public class CorsConfiguracion implements WebMvcConfigurer {

    public void addCorsMappings(CorsRegistry registry) {
        registry
                .addMapping("/**")
                .allowedOrigins("http://localhost:4200")
                .allowedMethods("GET", "POST", "PUT","DELETE")
                .allowCredentials(true);
    }
}