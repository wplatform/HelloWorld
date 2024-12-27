package com.github.mmo.game.entity.areatrigger.model;

import com.github.mmo.game.networking.*;// C# TO JAVA CONVERTER WARNING: Java does not allow user-defined value types. The behavior of this class may differ from the original:
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
