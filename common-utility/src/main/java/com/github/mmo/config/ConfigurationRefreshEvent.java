package com.github.mmo.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.context.ApplicationEvent;

import java.util.Map;

@Setter
@Getter
public class ConfigurationRefreshEvent extends ApplicationEvent {

    private final String fileName;
    private final Map<String, Object> source;


    public ConfigurationRefreshEvent(String fileName, Map<String, Object> source) {
        super(source);
        this.fileName = fileName;
        this.source = source;
    }
}
