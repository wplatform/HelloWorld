package com.github.mmo.game.networking.packet.artifact;


import com.github.mmo.game.networking.ServerPacket;

class ArtifactXpGain extends ServerPacket {
    public ObjectGuid artifactGUID = ObjectGuid.EMPTY;

    public long amount;

    public ArtifactXpGain() {
        super(ServerOpcode.ArtifactXpGain);
    }

    @Override
    public void write() {
        this.writeGuid(artifactGUID);
        this.writeInt64(amount);
    }
}
