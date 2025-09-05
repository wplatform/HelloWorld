package com.github.azeroth.time;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class PeriodicTimer {
    // Getters and setters (optional but recommended for Java)
    private int period;
    private int expireTime;

    public PeriodicTimer(int period, int startTime) {
        this.period = period;
        this.expireTime = startTime;
    }

    public boolean update(int diff) {
        expireTime -= diff;
        if (expireTime > 0) {
            return false;
        }

        expireTime += Math.max(period, diff);
        return true;
    }

    public void setPeriodic(int period, int startTime) {
        this.expireTime = startTime;
        this.period = period;
    }

    // Tracker interface
    public void tUpdate(int diff) {
        expireTime -= diff;
    }

    public boolean tPassed() {
        return expireTime <= 0;
    }

    public void tReset(int diff, int period) {
        expireTime += Math.max(period, diff);
    }

}
