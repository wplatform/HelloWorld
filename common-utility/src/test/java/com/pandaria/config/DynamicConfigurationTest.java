package com.pandaria.config;


import com.github.mmo.config.Configuration;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.ClassPathResource;

import java.time.Duration;

@SpringBootTest
@SpringBootApplication
public class DynamicConfigurationTest {


    @Autowired
    private TestPropertiess pro;

    @Autowired
    private BeanFactoryProperties beanFactoryProperties;

    @BeforeAll
    static void beforeAll() {
        System.setProperty("spring.config.location", "file:../test-resources/etc/bnetserver.conf,file:../test-resources/etc/worldserver.conf");
    }





    @Test
    public void testDynamicConfiguration() {

        Assertions.assertEquals(Duration.ofMillis(3600), beanFactoryProperties.getTicketDuration());
        Assertions.assertEquals("", pro.sourceDirectory);
        Assertions.assertEquals("", pro.logsDir);
        Configuration.reload(new ClassPathResource("bnetserver_reload.conf"));
        Assertions.assertEquals("192.168.1.1", beanFactoryProperties.getExternalAddress());
        Assertions.assertEquals("192.168.1.1", beanFactoryProperties.getLocalAddress());
        Assertions.assertEquals(Duration.ofMillis(5600), beanFactoryProperties.getTicketDuration());
        Assertions.assertEquals("test-reload", pro.sourceDirectory);
        Assertions.assertEquals("test-reload", pro.logsDir);

    }


}
