package com.github.azeroth.common;

import java.util.concurrent.*;

public class EventProcessor implements EventPublisher {

    private long uptime = 0;

    private final DelayQueue<TaskFeature> events = new DelayQueue<>();


    public void update(int delta) {
        uptime += delta;
        while (!events.isEmpty()) {
            TaskFeature event = events.poll();
            if (event == null) {
                break;
            }
            event.run();
            if (event.period) {
                publish(event.task, event.delayTime, TimeUnit.MILLISECONDS);
            }
        }

    }

    public void clear() {
        events.clear();
    }



    @Override
    public void publish(Runnable command, long delay, TimeUnit unit) {
        events.offer(new TaskFeature(command, uptime, unit.convert(delay, TimeUnit.MILLISECONDS)));
    }

    @Override
    public void publishAtFixedRate(Runnable command, long period, TimeUnit unit) {
        events.offer(new TaskFeature(command, uptime, unit.convert(period, TimeUnit.MILLISECONDS), true));
    }

    @Override
    public void publish(Runnable command) {
        events.offer(new TaskFeature(command, uptime, 0));
    }
}
