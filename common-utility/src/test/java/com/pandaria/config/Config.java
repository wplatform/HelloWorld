package com.pandaria.config;

import com.github.mmo.config.RefreshableValue;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {

    @Bean
    @RefreshableValue
    @ConfigurationProperties("bnetserver.loginrest")
    BeanFactoryProperties beanFactoryProperties() {
        return new BeanFactoryProperties();
    }
}
