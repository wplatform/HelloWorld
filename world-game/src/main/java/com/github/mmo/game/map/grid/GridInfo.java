package com.github.mmo.game.map.grid;

public class GridInfo {
    private final PeriodicTimer visUpdate;
    private final TimeTracker timer;


    private short unloadActiveLockCount; // lock from active object spawn points (prevent clone loading)
    private boolean unloadExplicitLock; // explicit manual lock or config setting

    public GridInfo() {
        timer = new timeTracker(0);
        visUpdate = new PeriodicTimer(0, RandomUtil.IRand(0, 1000));
        unloadActiveLockCount = 0;
        unloadExplicitLock = false;
    }


    public GridInfo(long expiry) {
        this(expiry, true);
    }


    public GridInfo(long expiry, boolean unload) {

        timer = new timeTracker((int) expiry);
        visUpdate = new PeriodicTimer(0, RandomUtil.IRand(0, 1000));
        unloadActiveLockCount = 0;
        unloadExplicitLock = !unload;
    }

    public final TimeTracker getTimeTracker() {
        return timer;
    }

    public final boolean getUnloadLock() {
        return unloadActiveLockCount != 0 || unloadExplicitLock;
    }

    public final void setUnloadExplicitLock(boolean on) {
        unloadExplicitLock = on;
    }

    public final void incUnloadActiveLock() {
        ++unloadActiveLockCount;
    }

    public final void decUnloadActiveLock() {
        if (unloadActiveLockCount != 0) {
            --_unloadActiveLockCount;
        }
    }

    public final void resetTimeTracker(long interval) {

        timer.reset((int) interval);
    }

    public final void updateTimeTracker(long diff) {

        timer.update((int) diff);
    }

    public final PeriodicTimer getRelocationTimer() {
        return visUpdate;
    }
}
