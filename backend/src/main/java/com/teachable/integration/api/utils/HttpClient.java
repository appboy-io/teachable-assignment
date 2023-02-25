package com.teachable.integration.api.utils;

import okhttp3.OkHttpClient;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class HttpClient {
    @Bean
    public OkHttpClient okHttpClientFactory() {
        return new OkHttpClient();
    }
}
