package com.github.mmo.game.networking.packet.petition;


public class PetitionAlreadySigned extends ServerPacket
{
    public ObjectGuid signerGUID = ObjectGuid.EMPTY;
	public PetitionAlreadySigned()
	{
		super(ServerOpcode.PetitionAlreadySigned);
	}

	@Override
	public void write()
	{
        this.writeGuid(signerGUID);
	}
}
