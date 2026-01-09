package br.com.diegopimenta.clientapi.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Value("${cors.originsPatterns}")
    private String corsOriginsPatterns;

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        var corsOrigins = corsOriginsPatterns;

        registry.addMapping("/**")
                .allowedOrigins(corsOrigins)
                .allowedMethods("*")
                .allowedHeaders("*");
    }
}
