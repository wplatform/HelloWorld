package com.github.mmo.game.networking.packet.gameobject;


import com.github.mmo.game.entity.object.ObjectGuid;
import com.github.mmo.game.networking.ServerPacket;

public class GameObjectActivateAnimKit extends ServerPacket {
    public ObjectGuid objectGUID = ObjectGuid.EMPTY;
    public int animKitID;
    public boolean maintain;

    public GameObjectActivateAnimKit() {
        super(ServerOpcode.GameObjectActivateAnimKit, ConnectionType.instance);
    }

    @Override
    public void write() {
        this.writeGuid(objectGUID);
        this.writeInt32(animKitID);
        this.writeBit(maintain);
        this.flushBits();
    }
}
