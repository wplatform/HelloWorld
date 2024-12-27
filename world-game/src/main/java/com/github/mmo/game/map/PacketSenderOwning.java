package com.github.mmo.game.map;

import com.github.mmo.game.entity.player.Player;
import com.github.mmo.game.networking.ServerPacket;// C# TO JAVA CONVERTER TASK: The C# 'new()' constraint has no equivalent in Java:
public class PacketSenderOwning<T extends ServerPacket> implements IDoWork<Player> {
    private T data = new T();

    public final T getData() {
        return data;
    }

    public final void setData(T value) {
        data = value;
    }

    public final void invoke(Player player) {
        player.sendPacket(getData());
    }
}
