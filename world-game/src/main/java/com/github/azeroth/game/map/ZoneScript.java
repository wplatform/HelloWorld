package com.github.azeroth.game.map;


import com.github.azeroth.game.entity.creature.Creature;
import com.github.azeroth.game.entity.gobject.GameObject;
import com.github.azeroth.game.entity.object.WorldObject;
import com.github.azeroth.game.entity.unit.Unit;

public class ZoneScript {
    protected eventMap events = new eventMap();


    public void triggerGameEvent(int gameEventId, WorldObject source) {
        triggerGameEvent(gameEventId, source, null);
    }

    public void triggerGameEvent(int gameEventId) {
        triggerGameEvent(gameEventId, null, null);
    }

    public void triggerGameEvent(int gameEventId, WorldObject source, WorldObject target) {
        if (source != null) {
            GameEvents.trigger(gameEventId, source, target);
        } else {
            processEvent(null, gameEventId, null);
        }
    }

    public int getCreatureEntry(long guidlow, CreatureData data) {
        return data.id;
    }

    public int getGameObjectEntry(long spawnId, int entry) {
        return entry;
    }

    public void onCreatureCreate(Creature creature) {
    }

    public void onCreatureRemove(Creature creature) {
    }

    public void onGameObjectCreate(GameObject go) {
    }

    public void onGameObjectRemove(GameObject go) {
    }

    public void onUnitDeath(Unit unit) {
    }

    //All-purpose data storage 64 bit
    public ObjectGuid getGuidData(int DataId) {
        return ObjectGuid.Empty;
    }

    public void setGuidData(int DataId, ObjectGuid value) {
    }

    public long getData64(int dataId) {
        return 0;
    }

    public void setData64(int dataId, long value) {
    }

    //All-purpose data storage 32 bit
    public int getData(int dataId) {
        return 0;
    }

    public void setData(int dataId, int value) {
    }

    public void processEvent(WorldObject obj, int eventId, WorldObject invoker) {
    }
}
