package com.github.mmo.game.entity.areatrigger.model;

import com.github.mmo.game.networking.WorldPacket;

public final class AreaTriggerMovementScriptInfo {

    public int spellScriptID;
    public Vector3 center;

    public void write(WorldPacket data) {
        data.writeInt32(spellScriptID);
        data.writeVector3(center);
    }

    public AreaTriggerMovementScriptInfo clone() {
        AreaTriggerMovementScriptInfo varCopy = new AreaTriggerMovementScriptInfo();

        varCopy.spellScriptID = this.spellScriptID;
        varCopy.center = this.center;

        return varCopy;
    }
}
