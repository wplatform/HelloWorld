package com.pandaria.config;

import com.github.azeroth.config.RefreshableValue;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@ConfigurationProperties("bnetserver")
@Component
@Data
@RefreshableValue
public class TestPropertiess {
    String sourceDirectory;

    String logsDir;

}
