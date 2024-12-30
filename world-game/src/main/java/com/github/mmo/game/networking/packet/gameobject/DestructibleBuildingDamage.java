package com.github.mmo.game.networking.packet.gameobject;

import com.github.mmo.game.networking.ServerPacket;

public class DestructibleBuildingDamage extends ServerPacket {
    public ObjectGuid target = ObjectGuid.EMPTY;
    public ObjectGuid caster = ObjectGuid.EMPTY;
    public ObjectGuid owner = ObjectGuid.EMPTY;
    public int damage;
    public int spellID;

    public DestructibleBuildingDamage() {
        super(ServerOpcode.DestructibleBuildingDamage, ConnectionType.instance);
    }

    @Override
    public void write() {
        this.writeGuid(target);
        this.writeGuid(owner);
        this.writeGuid(caster);
        this.writeInt32(damage);
        this.writeInt32(spellID);
    }
}
