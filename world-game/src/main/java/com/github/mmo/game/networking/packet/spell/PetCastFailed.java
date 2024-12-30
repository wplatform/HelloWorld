package com.github.mmo.game.networking.packet.spell;


class PetCastFailed extends CastFailedBase {
    public PetCastFailed() {
        super(ServerOpcode.PetCastFailed, ConnectionType.instance);
    }

    @Override
    public void write() {
        this.writeGuid(castID);
        this.writeInt32(spellID);
        this.writeInt32(reason.getValue());
        this.writeInt32(failedArg1);
        this.writeInt32(failedArg2);
    }
}
