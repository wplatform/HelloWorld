package com.github.mmo.config;

import org.springframework.boot.env.OriginTrackedMapPropertySource;
import org.springframework.boot.env.PropertySourceLoader;
import org.springframework.core.env.PropertySource;
import org.springframework.core.io.Resource;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class ConfigurationSourceLoader implements PropertySourceLoader {

    @Override
    public String[] getFileExtensions() {
        return new String[]{"conf"};
    }

    @Override
    public List<PropertySource<?>> load(String name, Resource resource) throws IOException {
        Configuration configuration = Configuration.getInstance();
        configuration.load(resource);
        Map<String, Object> source = configuration.getConfig(resource.getFilename());
        OriginTrackedMapPropertySource propertySource = new OriginTrackedMapPropertySource(resource.getFilename(), source);
        return List.of(propertySource);
    }
}
