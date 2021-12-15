package br.com.beer.webflux.beerwebflux.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class WebClientConfig {

    @Value("${client.file-upload.url}")
    private String basePath;

    @Bean
    public WebClient webClient() {
        return WebClient.builder()
            .baseUrl(basePath)
            .build();
    }

}
