package com.rainbowland.common;

import lombok.Getter;
import lombok.Setter;

import java.time.Duration;

@Setter
@Getter
public class ServerProperties {
    private int port;
    private String bindIp;
    private int selectCount;
    private int workCount;
    //DataSize
    private int minRecvBuffer;
    private int initialRecvBuffer;
    private int maxRecvBuffer;
    private Duration idleTime;
}
