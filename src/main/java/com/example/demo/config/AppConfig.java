package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * AppConfig is a configuration class that defines beans for the Spring application context.
 * It centralizes configuration and bean creation to be managed by the Spring container.
 */
@Configuration
public class AppConfig {

    /**
     * Creates and returns a RestTemplate bean.
     * RestTemplate is used for making RESTful web service calls.
     *
     * @return a new instance of RestTemplate.
     */
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
