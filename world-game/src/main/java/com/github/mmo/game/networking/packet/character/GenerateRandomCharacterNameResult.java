package com.github.mmo.game.networking.packet.character;


public class GenerateRandomCharacterNameResult extends ServerPacket
{
	public String name;
	public boolean success;
	public GenerateRandomCharacterNameResult()
	{
		super(ServerOpcode.GenerateRandomCharacterNameResult);
	}

	@Override
	public void write()
	{
        this.writeBit(success);
        this.writeBits(name.GetByteCount(), 6);

        this.writeString(name);
	}
}
