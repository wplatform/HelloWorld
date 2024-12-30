package com.github.mmo.game.networking.packet.artifact;

import com.github.mmo.game.networking.ServerPacket;

public class OpenArtifactForge extends ServerPacket {
    public ObjectGuid artifactGUID = ObjectGuid.EMPTY;
    public ObjectGuid forgeGUID = ObjectGuid.EMPTY;

    public OpenArtifactForge() {
        super(ServerOpcode.OpenArtifactForge);
    }

    @Override
    public void write() {
        this.writeGuid(artifactGUID);
        this.writeGuid(forgeGUID);
    }
}
