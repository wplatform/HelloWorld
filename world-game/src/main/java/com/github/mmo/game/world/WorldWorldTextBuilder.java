package com.github.mmo.game.world;



import com.github.mmo.game.chat.*;
import com.github.mmo.game.entity.player.Player;

import java.util.*;

public class WorldWorldTextBuilder extends MessageBuilder
{
	private final int iTextId;
	private final Object[] iArgs;

	public WorldWorldTextBuilder(int textId, object... args)
	{
		iTextId = textId;
		iArgs = args;
	}

	@Override
	public MultiplePacketSender invoke(Locale locale)
	{
		var text = global.getObjectMgr().getCypherString(iTextId, locale);

		if (iArgs != null)
		{
			text = String.format(text, iArgs);
		}

		MultiplePacketSender sender = new MultiplePacketSender();

		var lines = new LocalizedString();

		for (var i = 0; i < lines.length; ++i)
		{
			ChatPkt messageChat = new ChatPkt();
			messageChat.initialize(ChatMsg.System, language.Universal, null, null, lines.get(i));
			messageChat.write();
			sender.packets.add(messageChat);
		}

		return sender;
	}

	public static class MultiplePacketSender implements IDoWork<Player>
	{
		public ArrayList<ServerPacket> packets = new ArrayList<>();

		public final void invoke(Player receiver)
		{
			for (var packet : packets)
			{
				receiver.sendPacket(packet);
			}
		}
	}
}