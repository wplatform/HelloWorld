package com.github.mmo.game.networking.packet.quest;

import com.github.mmo.game.networking.ClientPacket;
import com.github.mmo.game.networking.WorldPacket;
class ChoiceResponse extends ClientPacket {
    public int choiceID;
    public int responseIdentifier;
    public boolean isReroll;

    public ChoiceResponse(WorldPacket packet) {
        super(packet);
    }

    @Override
    public void read() {
        choiceID = this.readInt32();
        responseIdentifier = this.readInt32();
        isReroll = this.readBit();
    }
}
