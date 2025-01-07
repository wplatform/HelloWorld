package com.github.azeroth.game.networking.packet.hotfix;

import com.github.azeroth.game.networking.ClientPacket;
import com.github.azeroth.game.networking.WorldPacket;

import java.util.ArrayList;


class HotfixRequest extends ClientPacket {
    public int clientBuild;
    public int dataBuild;
    public ArrayList<Integer> hotfixes = new ArrayList<>();

    public HotfixRequest(WorldPacket packet) {
        super(packet);
    }

    @Override
    public void read() {
        clientBuild = this.readUInt();
        dataBuild = this.readUInt();

        var hotfixCount = this.readUInt();

        for (var i = 0; i < hotfixCount; ++i) {
            hotfixes.add(this.readInt32());
        }
    }
}
