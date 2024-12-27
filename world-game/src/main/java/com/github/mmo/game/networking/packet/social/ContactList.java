package com.github.mmo.game.networking.packet.social;


import com.github.mmo.game.entity.player.SocialFlag;

import java.util.*;


public class ContactList extends ServerPacket
{
	public ArrayList<ContactInfo> contacts;
	public SocialFlag flags = SocialFlag.values()[0];

	public ContactList()
	{
		super(ServerOpcode.ContactList);
		contacts = new ArrayList<>();
	}

	@Override
	public void write()
	{
        this.writeInt32((int) flags.getValue());
        this.writeBits(contacts.size(), 8);
        this.flushBits();

		for (var contact : contacts)
		{
			contact.write(this);
		}
	}
}
