package br.edu.ifpb.maicon.cinema;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**") // Permite todas as rotas
                .allowedOrigins("http://localhost:4200") // Permite a origem do Angular
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS") // Permite esses métodos HTTP
                .allowedHeaders("*") // Permite todos os cabeçalhos
                .allowCredentials(true); // Permite envio de credenciais (opcional)
    }
}
