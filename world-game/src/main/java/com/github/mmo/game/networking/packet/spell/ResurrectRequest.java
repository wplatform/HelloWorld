package com.github.mmo.game.networking.packet.spell;
import com.github.mmo.game.networking.ServerPacket;
public class ResurrectRequest extends ServerPacket
{
    public ObjectGuid resurrectOffererGUID = ObjectGuid.EMPTY;
	public int resurrectOffererVirtualRealmAddress;
	public int petNumber;
	public int spellID;
	public boolean useTimer;
	public boolean sickness;
	public String name;
	public ResurrectRequest()
	{
		super(ServerOpcode.ResurrectRequest);
	}

	@Override
	public void write()
	{
        this.writeGuid(resurrectOffererGUID);
        this.writeInt32(resurrectOffererVirtualRealmAddress);
        this.writeInt32(petNumber);
        this.writeInt32(spellID);
        this.writeBits(name.GetByteCount(), 11);
        this.writeBit(useTimer);
        this.writeBit(sickness);
        this.flushBits();

        this.writeString(name);
	}
}
