package com.github.mmo.game.networking.packet.adventurejournal;

import com.github.mmo.game.networking.*;class AdventureJournalOpenQuest extends ClientPacket {

    public int adventureJournalID;

    public AdventureJournalOpenQuest(WorldPacket packet) {
        super(packet);
    }

    @Override
    public void read() {
        adventureJournalID = this.readUInt();
    }
}
