package com.github.mmo.game.networking.packet.authentication;
import com.github.mmo.game.networking.ServerPacket;
public class AuthChallenge extends ServerPacket
{
	public byte[] challenge = new byte[16];
	public byte[] dosChallenge = new byte[32]; // Encryption seeds
	public byte dosZeroBits;
	public AuthChallenge()
	{
		super(ServerOpcode.AuthChallenge);
	}

	@Override
	public void write()
	{
		this.writeBytes(dosChallenge);
		this.writeBytes(challenge);
		this.writeInt8(dosZeroBits);
	}
}
