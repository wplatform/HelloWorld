package com.github.azeroth.game.map;

import com.github.azeroth.game.entity.player.Player;

public class PacketSenderRef implements IDoWork<Player> {
    private final ServerPacket data;

    public PacketSenderRef(ServerPacket message) {
        data = message;
    }

    public void invoke(Player player) {
        player.sendPacket(data);
    }
}
