package com.jinxMovies.JinxMovies.config;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class AppConfig {


    @Value("${tmdb.api.key}")
    private String apiKey;

    @Bean
    public RequestInterceptor tmdbApiKeyInterceptor(){
        return new RequestInterceptor() {
            @Override
            public void apply(RequestTemplate requestTemplate) {
                requestTemplate.query("api_key",apiKey);
            }
        };
    }
}
