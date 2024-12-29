package com.github.mmo.boot;

import com.github.mmo.cache.MapdbCacheProvider;
import com.github.mmo.config.ConfigurationRefreshProcessor;
import com.github.mmo.converter.ClangStyleBoolean;
import com.github.mmo.converter.IntToEnumConverterFactory;
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
                new ClangStyleBoolean(),
                new IntToEnumConverterFactory()
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
