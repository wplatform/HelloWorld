package com.github.azeroth.boot;

import com.github.azeroth.cache.MapdbCacheProvider;
import com.github.azeroth.config.ConfigurationRefreshProcessor;
import com.github.azeroth.converter.IntToBool;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ConversionServiceFactoryBean;

import java.util.Set;

@Configuration
public class CommonAutoConfiguration {

    @Bean
    ConversionServiceFactoryBean conversionServiceFactoryBean() {
        ConversionServiceFactoryBean conversionServiceFactoryBean = new ConversionServiceFactoryBean();
        conversionServiceFactoryBean.setConverters(Set.of(
                new IntToBool()
        ));
        return conversionServiceFactoryBean;
    };


    @Bean
    MapdbCacheProvider mapdbCacheProvider() {
        return new MapdbCacheProvider();
    };

    @Bean
    ConfigurationRefreshProcessor configurationRefreshProcessor() {
        return new ConfigurationRefreshProcessor();
    };

}
