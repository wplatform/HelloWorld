package com.github.mmo.config;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.dataformat.toml.TomlMapper;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.core.io.Resource;
import org.springframework.util.StringUtils;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@Slf4j
public class Configuration {

    @Getter
    private static final Configuration instance = new Configuration();


    private static final TomlMapper mapper = new TomlMapper();


    private final Map<String, Map<String, Object>> config = HashMap.newHashMap(2);

    @Setter(AccessLevel.PACKAGE)
    private ApplicationEventPublisher reloadEventPublisher;


    void load(Resource resource) throws IOException {
        final Map<String, Object> resultMap = mapper.readValue(resource.getInputStream(), new TypeReference<>() {
        });
        config.put(resource.getFilename(), normalize(resultMap));

        Map<String, Object> stringObjectMap = config.get(resource.getFilename());



    }

    private void reload0(Resource resource) throws IOException {
        final Map<String, Object> resultMap = mapper.readValue(resource.getInputStream(), new TypeReference<>() {
        });
        Map<String, Object> normalizedMap = normalize(resultMap);
        Map<String, Object> original = config.get(resource.getFilename());

        if (original != null) {
            Map<String, Object> diff = diff(normalizedMap, original);
            if(!diff.isEmpty() && reloadEventPublisher != null) {
                original.clear();
                original.putAll(normalizedMap);
                reloadEventPublisher.publishEvent(new ConfigurationRefreshEvent(resource.getFilename(), normalizedMap));

            }
        } else {
            config.put(resource.getFilename(), normalizedMap);
            reloadEventPublisher.publishEvent(new ConfigurationRefreshEvent(resource.getFilename(), normalizedMap));
        }

    }

    Map<String, Object> diff(Map<String, Object> newValues, Map<String, Object> oldValues) {
        Map<String, Object> diff = new HashMap<>();
        newValues.forEach((key, value) -> {
            if (!oldValues.containsKey(key)) {
                diff.put(key, value);
            } else if(!Objects.equals(value, oldValues.get(key))) {
                diff.put(key, value);
            }
        });
        return diff;
    }


    public static void reload(Resource resource) {
        try {
            instance.reload0(resource);
        } catch (IOException e) {
            log.error("reload the configuration from {} error.", resource.getFilename(), e);
        }
    }

    private Map<String, Object> normalize(Map<String, Object> source) {
        Map<String, Object> normalizedConfig = HashMap.newHashMap(source.size());
        fillMap(null, source, normalizedConfig);
        return normalizedConfig;
    }

    Map<String, Object> getConfig(String filename) {
        return config.get(filename);
    }


    static String normalizeKey(String name) {
        return toKebabCase(name);
    }


    static String toKebabCase(String input) {
        if (!StringUtils.hasText(input)) {
            return null;
        }
        int length = input.length();
        StringBuilder result = new StringBuilder(length * 2);
        int resultLength = 0;
        boolean wasPrevTranslated = false;
        for (int i = 0; i < length; i++) {
            char c = input.charAt(i);
            if (i > 0 && c == '_') {
                result.append('-');
                resultLength++;
                continue;
            }
            if (i > 0 || c != '-') {
                if (Character.isUpperCase(c)) {
                    if (!wasPrevTranslated && resultLength > 0 && result.charAt(resultLength - 1) != '-') {
                        result.append('-');
                        resultLength++;
                    }
                    c = Character.toLowerCase(c);
                    wasPrevTranslated = true;
                } else {
                    wasPrevTranslated = false;
                }
                result.append(c);
                resultLength++;
            }
        }
        return resultLength > 0 ? result.toString() : input;
    }


    private static void fillMap(String prefix, Map<String, Object> source, Map<String, Object> result) {
        source.forEach((k, v) -> {
            String key = prefix == null ? k : prefix.toLowerCase() + "." + k;
            if (v instanceof Map map) {
                fillMap(key, map, result);
            } else {
                result.put(key, v);
            }
        });
    }


    private Configuration() {
    }


}
