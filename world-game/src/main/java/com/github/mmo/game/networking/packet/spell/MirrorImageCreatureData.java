package com.github.mmo.game.networking.packet.spell;
import com.github.mmo.game.networking.ServerPacket;
public class MirrorImageCreatureData extends ServerPacket
{
	public ObjectGuid unitGUID = ObjectGuid.EMPTY;
	public int displayID;
	public int spellVisualKitID;
	public MirrorImageCreatureData()
	{
		super(ServerOpcode.MirrorImageCreatureData);
	}

	@Override
	public void write()
	{
		this.writeGuid(unitGUID);
		this.writeInt32(displayID);
		this.writeInt32(spellVisualKitID);
	}
}
