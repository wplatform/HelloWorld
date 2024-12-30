package com.github.mmo.game.condition;


import com.github.mmo.game.entity.object.WorldObject;
import com.github.mmo.game.map.Map;

public class ConditionSourceInfo {
    public WorldObject[] mConditionTargets = new WorldObject[SharedConst.MaxConditionTargets]; // an array of targets available for conditions
    public Map mConditionMap;
    public Condition mLastFailedCondition;


    public ConditionSourceInfo(WorldObject target0, WorldObject target1) {
        this(target0, target1, null);
    }

    public ConditionSourceInfo(WorldObject target0) {
        this(target0, null, null);
    }

    public ConditionSourceInfo(WorldObject target0, WorldObject target1, WorldObject target2) {
        mConditionTargets[0] = target0;
        mConditionTargets[1] = target1;
        mConditionTargets[2] = target2;
        mConditionMap = target0 != null ? target0.getMap() : null;
        mLastFailedCondition = null;
    }

    public ConditionSourceInfo(Map map) {
        mConditionMap = map;
        mLastFailedCondition = null;
    }
}
