package com.github.mmo.game.networking.packet.npc;
import com.github.mmo.game.networking.ServerPacket;
public class TrainerBuyFailed extends ServerPacket
{
    public ObjectGuid trainerGUID = ObjectGuid.EMPTY;
	public int spellID;
	public TrainerFailReason trainerFailedReason = TrainerFailReason.values()[0];
	public TrainerBuyFailed()
	{
		super(ServerOpcode.TrainerBuyFailed);
	}

	@Override
	public void write()
	{
        this.writeGuid(trainerGUID);
        this.writeInt32(spellID);
        this.writeInt32((int) trainerFailedReason.getValue());
	}
}
