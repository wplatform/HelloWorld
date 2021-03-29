package com.rainbowland.service;

import lombok.Getter;
import lombok.Setter;

import java.time.Duration;
@Setter
@Getter
public class R2dbcProperties {
    private String url;
    private String username;
    private String password;
    private Duration maxCreateConnectionTime;
    private Duration maxAcquireTime;
    private int acquireRetry;
    private Duration  maxIdleTime;
    private int initialSize;
    private int maxSize;
    private String validationQuery;
}
