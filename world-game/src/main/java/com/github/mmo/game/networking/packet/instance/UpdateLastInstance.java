package com.github.mmo.game.networking.packet.instance;


import com.github.mmo.game.networking.ServerPacket;

public class UpdateLastInstance extends ServerPacket {

    public int mapID;

    public UpdateLastInstance() {
        super(ServerOpcode.UpdateLastInstance);
    }

    @Override
    public void write() {
        this.writeInt32(mapID);
    }
}

//Structs

