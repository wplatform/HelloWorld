package com.github.mmo.game.networking.packet.gameobject;


import com.github.mmo.game.networking.*;
class GameObjectCustomAnim extends ServerPacket {
    public ObjectGuid objectGUID = ObjectGuid.EMPTY;

    public int customAnim;
    public boolean playAsDespawn;

    public GameObjectCustomAnim() {

        super(ServerOpcode.GameObjectCustomAnim, ConnectionType.instance);
    }

    @Override
    public void write() {
        this.writeGuid(objectGUID);
        this.writeInt32(customAnim);
        this.writeBit(playAsDespawn);
        this.flushBits();
    }
}
