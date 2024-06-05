package com.jc4balos.logging_service.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.jc4balos.logging_service.model.ServiceComponent;

@Configuration
public class ModelConfig {

    @Bean
    public ServiceComponent serviceComponent() {
        return new ServiceComponent();
    }
}
