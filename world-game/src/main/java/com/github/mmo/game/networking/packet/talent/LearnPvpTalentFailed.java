package com.github.mmo.game.networking.packet.talent;


import java.util.ArrayList;
import com.github.mmo.game.networking.ServerPacket;
public class LearnPvpTalentFailed extends ServerPacket
{
	public int reason;
	public int spellID;
	public ArrayList<PvPTalent> talents = new ArrayList<>();
	public LearnPvpTalentFailed()
	{
		super(ServerOpcode.LearnPvpTalentFailed);
	}

	@Override
	public void write()
	{
        this.writeBits(reason, 4);
        this.writeInt32(spellID);
        this.writeInt32(talents.size());

		for (var pvpTalent : talents)
		{
			pvpTalent.write(this);
		}
	}
}
