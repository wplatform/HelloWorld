package com.github.mmo.game.map;



import java.time.*;public class InstanceLock {

    private final int mapId;
    private final Difficulty difficultyId;
    private final instanceLockData data = new instanceLockData();

    private int instanceId;
    private LocalDateTime expiryTime = LocalDateTime.MIN;
    private boolean extended;
    private boolean isInUse;


    public InstanceLock(int mapId, Difficulty difficultyId, LocalDateTime expiryTime, int instanceId) {
        mapId = mapId;
        difficultyId = difficultyId;
        instanceId = instanceId;
        expiryTime = expiryTime;
        extended = false;
    }

    public final boolean isExpired() {
        return expiryTime.compareTo(gameTime.GetSystemTime()) < 0;
    }

    public final LocalDateTime getEffectiveExpiryTime() {
        if (!isExtended()) {
            return getExpiryTime();
        }

        MapDb2Entries entries = new MapDb2Entries(mapId, difficultyId);

        // return next reset time
        if (isExpired()) {
            return global.getInstanceLockMgr().getNextResetTime(entries);
        }

        // if not expired, return expiration time + 1 reset period
        return getExpiryTime() + duration.FromSeconds(entries.MapDifficulty.GetRaidDuration());
    }


    public final int getMapId() {
        return mapId;
    }

    public final Difficulty getDifficultyId() {
        return difficultyId;
    }


    public final int getInstanceId() {
        return instanceId;
    }


    public final void setInstanceId(int instanceId) {
        instanceId = instanceId;
    }

    public final LocalDateTime getExpiryTime() {
        return expiryTime;
    }

    public final void setExpiryTime(LocalDateTime expiryTime) {
        expiryTime = expiryTime;
    }

    public final boolean isExtended() {
        return extended;
    }

    public final void setExtended(boolean extended) {
        extended = extended;
    }

    public final InstanceLockData getData() {
        return data;
    }

    public InstanceLockData getInstanceInitializationData() {
        return data;
    }

    public final boolean isInUse() {
        return isInUse;
    }

    public final void setInUse(boolean inUse) {
        isInUse = inUse;
    }
}
