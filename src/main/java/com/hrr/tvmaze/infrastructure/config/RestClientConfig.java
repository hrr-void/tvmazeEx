package com.hrr.tvmaze.infrastructure.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestClient;

@Configuration
public class RestClientConfig {

    @Bean
    public RestClient tvMazeRestClient(){
        return RestClient.builder().baseUrl("https://api.tvmaze.com").build();
    }
}
