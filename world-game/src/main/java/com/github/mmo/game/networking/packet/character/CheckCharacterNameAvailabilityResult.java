package com.github.mmo.game.networking.packet.character;
import com.github.mmo.game.networking.ServerPacket;
public class CheckCharacterNameAvailabilityResult extends ServerPacket
{
	public int sequenceIndex;
	public ResponseCodes result = ResponseCodes.values()[0];

	public CheckCharacterNameAvailabilityResult(int sequenceIndex, ResponseCodes result)
	{
		super(ServerOpcode.CheckCharacterNameAvailabilityResult);
		sequenceIndex = sequenceIndex;
		result = result;
	}

	@Override
	public void write()
	{
        this.writeInt32(sequenceIndex);
        this.writeInt32((int) result.getValue());
	}
}
