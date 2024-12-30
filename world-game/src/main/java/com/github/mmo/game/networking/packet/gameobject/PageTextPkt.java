package com.github.mmo.game.networking.packet.gameobject;


import com.github.mmo.game.entity.ObjectGuid;
import com.github.mmo.game.networking.ServerPacket;

class PageTextPkt extends ServerPacket {
    public ObjectGuid gameObjectGUID = ObjectGuid.EMPTY;

    public PageTextPkt() {
        super(ServerOpcode.PageText);
    }

    @Override
    public void write() {
        this.writeGuid(gameObjectGUID);
    }
}
