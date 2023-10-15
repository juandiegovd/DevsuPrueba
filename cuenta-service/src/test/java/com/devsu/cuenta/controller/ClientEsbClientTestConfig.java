package com.devsu.cuenta.controller;

import com.devsu.cuenta.client.ClientEsbClient;
import feign.Feign;
import feign.jackson.JacksonDecoder;
import org.springframework.cloud.openfeign.support.SpringMvcContract;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ClientEsbClientTestConfig {
    @Bean
    public ClientEsbClient clientEsbClient() {
        // Provide the base URL here. You can use a real URL or a test URL.
        return Feign.builder()
                .contract(new SpringMvcContract())
                .decoder(new JacksonDecoder())
                .target(ClientEsbClient.class, "http://localhost:9561/clientes");
    }
}
