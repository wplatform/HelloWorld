package com.github.mmo.game.networking.packet.ticket;


import java.util.*;


public class GMTicketCaseStatus extends ServerPacket
{
	public ArrayList<GMTicketCase> cases = new ArrayList<>();
	public GMTicketCaseStatus()
	{
		super(ServerOpcode.GmTicketCaseStatus);
	}

	@Override
	public void write()
	{
        this.writeInt32(cases.size());

		for (var c : cases)
		{
            this.writeInt32(c.caseID);
            this.writeInt64(c.caseOpened);
            this.writeInt32(c.caseStatus);
			this.writeInt16(c.cfgRealmID);
			this.writeInt64(c.characterID);
            this.writeInt32(c.waitTimeOverrideMinutes);

            this.writeBits(c.url.GetByteCount(), 11);
            this.writeBits(c.waitTimeOverrideMessage.GetByteCount(), 10);

            this.writeString(c.url);
            this.writeString(c.waitTimeOverrideMessage);
		}
	}

	public final static class GMTicketCase
	{
		public int caseID;
		public long caseOpened;
		public int caseStatus;
		public short cfgRealmID;
		public long characterID;
		public int waitTimeOverrideMinutes;
		public String url;
		public String waitTimeOverrideMessage;

		public GMTicketCase clone()
		{
			GMTicketCase varCopy = new GMTicketCase();

			varCopy.caseID = this.caseID;
			varCopy.caseOpened = this.caseOpened;
			varCopy.caseStatus = this.caseStatus;
			varCopy.cfgRealmID = this.cfgRealmID;
			varCopy.characterID = this.characterID;
			varCopy.waitTimeOverrideMinutes = this.waitTimeOverrideMinutes;
			varCopy.url = this.url;
			varCopy.waitTimeOverrideMessage = this.waitTimeOverrideMessage;

			return varCopy;
		}
	}
}
