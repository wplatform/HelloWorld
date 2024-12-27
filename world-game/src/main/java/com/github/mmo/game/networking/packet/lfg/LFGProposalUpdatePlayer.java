package com.github.mmo.game.networking.packet.lfg;

import com.github.mmo.game.networking.*;
public final class LFGProposalUpdatePlayer
{
	public void write(WorldPacket data)
	{
		data.writeInt32(roles);
		data.writeBit(me);
		data.writeBit(sameParty);
		data.writeBit(myParty);
		data.writeBit(responded);
		data.writeBit(accepted);
		data.flushBits();
	}

	public int roles;
	public boolean me;
	public boolean sameParty;
	public boolean myParty;
	public boolean responded;
	public boolean accepted;

	public LFGProposalUpdatePlayer clone()
	{
		LFGProposalUpdatePlayer varCopy = new LFGProposalUpdatePlayer();

		varCopy.roles = this.roles;
		varCopy.me = this.me;
		varCopy.sameParty = this.sameParty;
		varCopy.myParty = this.myParty;
		varCopy.responded = this.responded;
		varCopy.accepted = this.accepted;

		return varCopy;
	}
}
