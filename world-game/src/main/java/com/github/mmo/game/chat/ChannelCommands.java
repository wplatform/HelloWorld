package com.github.mmo.game.chat;


// C# TO JAVA CONVERTER TASK: Java annotations will not correspond to .NET attributes:
class ChannelCommands
{
// C# TO JAVA CONVERTER TASK: Java annotations will not correspond to .NET attributes:
	private static class ChannelSetCommands
	{
// C# TO JAVA CONVERTER TASK: Java annotations will not correspond to .NET attributes:
		private static boolean handleChannelSetOwnership(CommandHandler handler, String channelName, boolean grantOwnership)
		{
			int channelId = 0;

			for (var channelEntry : CliDB.ChatChannelsStorage.values())
			{
				if (channelEntry.name.charAt(handler.getSessionDbcLocale()).Equals(channelName, StringComparison.OrdinalIgnoreCase))
				{
					channelId = channelEntry.id;

					break;
				}
			}

			AreaTableRecord zoneEntry = null;

			for (var entry : CliDB.AreaTableStorage.values())
			{
				if (entry.AreaName[handler.getSessionDbcLocale()].Equals(channelName, StringComparison.OrdinalIgnoreCase))
				{
					zoneEntry = entry;

					break;
				}
			}

			var player = handler.getSession().getPlayer();
			Channel channel = null;

			var cMgr = ChannelManager.forTeam(player.getTeam());

			if (cMgr != null)
			{
				channel = cMgr.getChannel(channelId, channelName, player, false, zoneEntry);
			}

			if (grantOwnership)
			{
				if (channel != null)
				{
					channel.setOwnership(true);
				}

				var stmt = DB.characters.GetPreparedStatement(CharStatements.UPD_CHANNEL_OWNERSHIP);
				stmt.AddValue(0, 1);
				stmt.AddValue(1, channelName);
				DB.characters.execute(stmt);
				handler.sendSysMessage(CypherStrings.ChannelEnableOwnership, channelName);
			}
			else
			{
				if (channel != null)
				{
					channel.setOwnership(false);
				}

				var stmt = DB.characters.GetPreparedStatement(CharStatements.UPD_CHANNEL_OWNERSHIP);
				stmt.AddValue(0, 0);
				stmt.AddValue(1, channelName);
				DB.characters.execute(stmt);
				handler.sendSysMessage(CypherStrings.ChannelDisableOwnership, channelName);
			}

			return true;
		}
	}
}
