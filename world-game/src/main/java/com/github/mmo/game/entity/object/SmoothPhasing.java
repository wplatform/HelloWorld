package com.github.mmo.game.entity.object;

import java.util.HashMap;


public class SmoothPhasing {
    private final HashMap<ObjectGuid, SmoothPhasingInfo> smoothPhasingInfoViewerDependent = new HashMap<ObjectGuid, SmoothPhasingInfo>();
    private SmoothPhasingInfo smoothPhasingInfoSingle;

    public final void setViewerDependentInfo(ObjectGuid seer, SmoothPhasingInfo info) {
        smoothPhasingInfoViewerDependent.put(seer, info);
    }

    public final void clearViewerDependentInfo(ObjectGuid seer) {
        smoothPhasingInfoViewerDependent.remove(seer);
    }

    public final void setSingleInfo(SmoothPhasingInfo info) {
        smoothPhasingInfoSingle = info;
    }

    public final boolean isReplacing(ObjectGuid guid) {
        return smoothPhasingInfoSingle != null && smoothPhasingInfoSingle.replaceObject.equals(guid);
    }

    public final boolean isBeingReplacedForSeer(ObjectGuid seer) {
        var smoothPhasingInfo = smoothPhasingInfoViewerDependent.get(seer);

        if (smoothPhasingInfo != null) {
            return !smoothPhasingInfo.disabled;
        }

        return false;
    }

    public final SmoothPhasingInfo getInfoForSeer(ObjectGuid seer) {
        if (smoothPhasingInfoViewerDependent.containsKey(seer)) {
            return smoothPhasingInfoViewerDependent.get(seer);
        }

        return smoothPhasingInfoSingle;
    }

    public final void disableReplacementForSeer(ObjectGuid seer) {
        var smoothPhasingInfo = smoothPhasingInfoViewerDependent.get(seer);

        if (smoothPhasingInfo != null) {
            smoothPhasingInfo.disabled = true;
        }
    }
}
