package com.github.azeroth.schedule;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.FactoryBean;

import java.util.concurrent.*;
@Slf4j
public class ScheduledExecutorServiceBean implements FactoryBean<ScheduledExecutorService>, DisposableBean {

    private final ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(0, Thread.ofVirtual().name("virtual-scheduled-executor").factory());



    @Override
    public ScheduledExecutorService getObject() {
        return scheduledExecutorService;
    }

    @Override
    public Class<?> getObjectType() {
        return ScheduledExecutorService.class;
    }

    @Override
    public void destroy() throws Exception {
        try {
            for (Runnable remainingTask : this.scheduledExecutorService.shutdownNow()) {
                if (remainingTask instanceof Future<?> future) {
                    future.cancel(true);
                }
            }
            if (!scheduledExecutorService.awaitTermination(5, TimeUnit.SECONDS)) {
                log.warn("Timed out while waiting for taskExecutor {} to terminate", this.scheduledExecutorService.getClass().getName());
            }
        } catch (InterruptedException ex) {
            log.warn("Interrupted while waiting for taskExecutor {} to terminate", this.scheduledExecutorService.getClass().getName());
            Thread.currentThread().interrupt();
        }

    }
}
