package com.github.azeroth.time;

public class IntervalTimer {

    private long interval;
    private long current;

    public IntervalTimer(int interval) {
        this.interval = interval;
        this.current = 0;
    }

    public void update(long diff) {
        current += diff;
        if (current < 0) {
            current = 0;
        }
    }

    public boolean passed() {
        return current >= interval;
    }

    public void reset() {
        if (current >= interval) {
            current %= interval;
        }
    }

    public void setCurrent(long current) {
        this.current = current;
    }

    public void setInterval(long interval) {
        this.interval = interval;
    }

    public long getInterval() {
        return interval;
    }

    public long getCurrent() {
        return current;
    }
}
