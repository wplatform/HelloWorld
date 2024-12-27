package com.pandaria.config;

import lombok.Data;
import org.springframework.boot.convert.DurationUnit;

import java.time.Duration;
import java.time.temporal.ChronoUnit;

@Data
public class BeanFactoryProperties {

    String externalAddress;
    String localAddress;

    @DurationUnit(ChronoUnit.MILLIS)
    Duration ticketDuration;

}
