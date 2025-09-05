package com.github.azeroth.common;

import java.lang.invoke.MethodHandles;
import java.lang.invoke.VarHandle;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

public class TaskFeature implements Delayed {

    private volatile int state;
    private static final int NEW          = 0;
    private static final int COMPLETING   = 1;
    private static final int CANCELLED    = 2;

    final Runnable task;
    final long uptime;
    final long delayTime;
    final boolean period;

    public TaskFeature(Runnable task, long uptime, long delayTime) {
        this(task, uptime, delayTime, false);
    }

    public TaskFeature(Runnable task, long uptime, long delayTime, boolean period) {
        this.task = task;
        this.uptime = uptime;
        this.delayTime = delayTime;
        this.period = period;
    }

    public boolean isDone() {
        return state != NEW;
    }

    public boolean cancel() {
        return state == NEW && STATE.compareAndSet
                (this, NEW, CANCELLED);
    }

    @Override
    public long getDelay(TimeUnit unit) {
        return unit.convert(uptime + delayTime, TimeUnit.MILLISECONDS);
    }

    @Override
    public int compareTo(Delayed o) {
        TaskFeature o1 = (TaskFeature) o;
        return (int) (this.uptime + this.delayTime - o1.uptime - o1.delayTime);
    }



    void run() {
        if (task != null && state == NEW) {
            if(STATE.compareAndSet(this, NEW, COMPLETING)) {
                try {
                    task.run();
                } catch (Throwable ex) {

                }
            }
        }
    }



    // VarHandle mechanics
    private static final VarHandle STATE;
    static {
        try {
            MethodHandles.Lookup l = MethodHandles.lookup();
            STATE = l.findVarHandle(TaskFeature.class, "state", int.class);
        } catch (ReflectiveOperationException e) {
            throw new ExceptionInInitializerError(e);
        }
    }
}
