package com.github.azeroth.game.domain.areatrigger;

import com.github.azeroth.game.networking.WorldPacket;

public final class AreaTriggerMovementScriptInfo {

    public int spellScriptID;
    public Vector3 center;

    public void write(WorldPacket data) {
        data.writeInt32(spellScriptID);
        data.writeVector3(center);
    }

}
