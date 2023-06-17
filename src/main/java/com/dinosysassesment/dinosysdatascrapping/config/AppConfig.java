package com.dinosysassesment.dinosysdatascrapping.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class AppConfig {

    @Bean
    WebClient webClient() {
        return WebClient.create();
    }

    @Bean
    ObjectMapper objectMapper() {
        return new ObjectMapper();
    }

}
