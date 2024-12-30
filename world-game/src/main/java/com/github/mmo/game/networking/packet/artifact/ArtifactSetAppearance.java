package com.github.mmo.game.networking.packet.artifact;

import com.github.mmo.game.networking.ClientPacket;
import com.github.mmo.game.networking.WorldPacket;

class ArtifactSetAppearance extends ClientPacket {
    public ObjectGuid artifactGUID = ObjectGuid.EMPTY;
    public ObjectGuid forgeGUID = ObjectGuid.EMPTY;
    public int artifactAppearanceID;

    public ArtifactSetAppearance(WorldPacket packet) {
        super(packet);
    }

    @Override
    public void read() {
        artifactGUID = this.readPackedGuid();
        forgeGUID = this.readPackedGuid();
        artifactAppearanceID = this.readInt32();
    }
}
