package com.github.mmo.game.networking.packet.artifact;

import com.github.mmo.game.networking.ClientPacket;
import com.github.mmo.game.networking.WorldPacket;

class ConfirmArtifactRespec extends ClientPacket {
    public ObjectGuid artifactGUID = ObjectGuid.EMPTY;
    public ObjectGuid npcGUID = ObjectGuid.EMPTY;

    public ConfirmArtifactRespec(WorldPacket packet) {
        super(packet);
    }

    @Override
    public void read() {
        artifactGUID = this.readPackedGuid();
        npcGUID = this.readPackedGuid();
    }
}
