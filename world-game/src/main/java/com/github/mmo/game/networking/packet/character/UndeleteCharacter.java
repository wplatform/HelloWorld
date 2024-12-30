package com.github.mmo.game.networking.packet.character;

import com.github.mmo.game.networking.ClientPacket;
import com.github.mmo.game.networking.WorldPacket;

public class UndeleteCharacter extends ClientPacket {
    public CharacterundeleteInfo undeleteInfo;

    public UndeleteCharacter(WorldPacket packet) {
        super(packet);
    }

    @Override
    public void read() {
        undeleteInfo = new CharacterUndeleteInfo();
        this.writeInt32(undeleteInfo.clientToken);
        this.writeGuid(undeleteInfo.characterGuid);
    }
}
