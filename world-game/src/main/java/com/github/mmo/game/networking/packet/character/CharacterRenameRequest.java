package com.github.mmo.game.networking.packet.character;

import com.github.mmo.game.networking.WorldPacket;

public class CharacterRenameRequest extends ClientPacket {
    public CharacterrenameInfo renameInfo;

    public CharacterRenameRequest(WorldPacket packet) {
        super(packet);
    }

    @Override
    public void read() {
        renameInfo = new CharacterRenameInfo();
        renameInfo.guid = this.readPackedGuid();
        renameInfo.newName = this.readString(this.<Integer>readBit(6));
    }
}
