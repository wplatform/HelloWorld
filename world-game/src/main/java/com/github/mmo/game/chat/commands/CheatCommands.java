package com.github.mmo.game.chat.commands;


import com.github.mmo.defines.Power;
import com.github.mmo.game.chat.*;

// C# TO JAVA CONVERTER TASK: Java annotations will not correspond to .NET attributes:
class CheatCommands
{
// C# TO JAVA CONVERTER TASK: Java annotations will not correspond to .NET attributes:
	private static boolean handleCasttimeCheatCommand(CommandHandler handler, Boolean enableArg)
	{
		var enable = !handler.getSession().getPlayer().getCommandStatus(PlayerCommandStates.Casttime);

		if (enableArg != null)
		{
			enable = enableArg.booleanValue();
		}

		if (enable)
		{
			handler.getSession().getPlayer().setCommandStatusOn(PlayerCommandStates.Casttime);
			handler.sendSysMessage("CastTime Cheat is ON. Your spells won't have a casttime.");
		}
		else
		{
			handler.getSession().getPlayer().setCommandStatusOff(PlayerCommandStates.Casttime);
			handler.sendSysMessage("CastTime Cheat is OFF. Your spells will have a casttime.");
		}

		return true;
	}

// C# TO JAVA CONVERTER TASK: Java annotations will not correspond to .NET attributes:
	private static boolean handleCoolDownCheatCommand(CommandHandler handler, Boolean enableArg)
	{
		var enable = !handler.getSession().getPlayer().getCommandStatus(PlayerCommandStates.cooldown);

		if (enableArg != null)
		{
			enable = enableArg.booleanValue();
		}

		if (enable)
		{
			handler.getSession().getPlayer().setCommandStatusOn(PlayerCommandStates.cooldown);
			handler.sendSysMessage("Cooldown Cheat is ON. You are not on the global cooldown.");
		}
		else
		{
			handler.getSession().getPlayer().setCommandStatusOff(PlayerCommandStates.cooldown);
			handler.sendSysMessage("Cooldown Cheat is OFF. You are on the global cooldown.");
		}

		return true;
	}

// C# TO JAVA CONVERTER TASK: Java annotations will not correspond to .NET attributes:
	private static boolean handleExploreCheatCommand(CommandHandler handler, boolean reveal)
	{
		var chr = handler.getSelectedPlayer();

		if (!chr)
		{
			handler.sendSysMessage(CypherStrings.NoCharSelected);

			return false;
		}

		if (reveal)
		{
			handler.sendSysMessage(CypherStrings.YouSetExploreAll, handler.getNameLink(chr));

			if (handler.needReportToTarget(chr))
			{
				chr.sendSysMessage(CypherStrings.YoursExploreSetAll, handler.getNameLink());
			}
		}
		else
		{
			handler.sendSysMessage(CypherStrings.YouSetExploreNothing, handler.getNameLink(chr));

			if (handler.needReportToTarget(chr))
			{
				chr.sendSysMessage(CypherStrings.YoursExploreSetNothing, handler.getNameLink());
			}
		}

		for (short i = 0; i < PlayerConst.EXPLOREDZONESSIZE; ++i)
		{
			if (reveal)
			{
				handler.getSession().getPlayer().addExploredZones(i, (long)0xFFFFFFFFFFFFFFFF);
			}
			else
			{
				handler.getSession().getPlayer().removeExploredZones(i, (long)0xFFFFFFFFFFFFFFFF);
			}
		}

		return true;
	}

// C# TO JAVA CONVERTER TASK: Java annotations will not correspond to .NET attributes:
	private static boolean handleGodModeCheatCommand(CommandHandler handler, Boolean enableArg)
	{
		var enable = !handler.getSession().getPlayer().getCommandStatus(PlayerCommandStates.God);

		if (enableArg != null)
		{
			enable = enableArg.booleanValue();
		}

		if (enable)
		{
			handler.getSession().getPlayer().setCommandStatusOn(PlayerCommandStates.God);
			handler.sendSysMessage("Godmode is ON. You won't take damage.");
		}
		else
		{
			handler.getSession().getPlayer().setCommandStatusOff(PlayerCommandStates.God);
			handler.sendSysMessage("Godmode is OFF. You can take damage.");
		}

		return true;
	}

// C# TO JAVA CONVERTER TASK: Java annotations will not correspond to .NET attributes:
	private static boolean handlePowerCheatCommand(CommandHandler handler, Boolean enableArg)
	{
		var enable = !handler.getSession().getPlayer().getCommandStatus(PlayerCommandStates.power);

		if (enableArg != null)
		{
			enable = enableArg.booleanValue();
		}

		if (enable)
		{
			var player = handler.getSession().getPlayer();

			// Set max power to all powers
			for (Power powerType = 0; powerType.getValue() < powerType.max.getValue(); ++powerType)
			{
				player.setPower(powerType, player.getMaxPower(powerType));
			}

			player.setCommandStatusOn(PlayerCommandStates.power);
			handler.sendSysMessage("Power Cheat is ON. You don't need mana/rage/energy to use spells.");
		}
		else
		{
			handler.getSession().getPlayer().setCommandStatusOff(PlayerCommandStates.power);
			handler.sendSysMessage("Power Cheat is OFF. You need mana/rage/energy to use spells.");
		}

		return true;
	}

// C# TO JAVA CONVERTER TASK: Java annotations will not correspond to .NET attributes:
	private static boolean handleCheatStatusCommand(CommandHandler handler)
	{
		var player = handler.getSession().getPlayer();

		var enabled = "ON";
		var disabled = "OFF";

		handler.sendSysMessage(CypherStrings.CommandCheatStatus);
		handler.sendSysMessage(CypherStrings.CommandCheatGod, player.getCommandStatus(PlayerCommandStates.God) ? enabled : disabled);
		handler.sendSysMessage(CypherStrings.CommandCheatCd, player.getCommandStatus(PlayerCommandStates.cooldown) ? enabled : disabled);
		handler.sendSysMessage(CypherStrings.CommandCheatCt, player.getCommandStatus(PlayerCommandStates.Casttime) ? enabled : disabled);
		handler.sendSysMessage(CypherStrings.CommandCheatPower, player.getCommandStatus(PlayerCommandStates.power) ? enabled : disabled);
		handler.sendSysMessage(CypherStrings.CommandCheatWw, player.getCommandStatus(PlayerCommandStates.Waterwalk) ? enabled : disabled);
		handler.sendSysMessage(CypherStrings.CommandCheatTaxinodes, player.isTaxiCheater() ? enabled : disabled);

		return true;
	}

// C# TO JAVA CONVERTER TASK: Java annotations will not correspond to .NET attributes:
	private static boolean handleTaxiCheatCommand(CommandHandler handler, Boolean enableArg)
	{
		var chr = handler.getSelectedPlayer();

		if (!chr)
		{
			chr = handler.getSession().getPlayer();
		}
		else if (handler.hasLowerSecurity(chr, ObjectGuid.Empty)) // check online security
		{
			return false;
		}

		var enable = !chr.isTaxiCheater();

		if (enableArg != null)
		{
			enable = enableArg.booleanValue();
		}

		if (enable)
		{
			chr.setTaxiCheater(true);
			handler.sendSysMessage(CypherStrings.YouGiveTaxis, handler.getNameLink(chr));

			if (handler.needReportToTarget(chr))
			{
				chr.sendSysMessage(CypherStrings.YoursTaxisAdded, handler.getNameLink());
			}
		}
		else
		{
			chr.setTaxiCheater(false);
			handler.sendSysMessage(CypherStrings.YouRemoveTaxis, handler.getNameLink(chr));

			if (handler.needReportToTarget(chr))
			{
				chr.sendSysMessage(CypherStrings.YoursTaxisRemoved, handler.getNameLink());
			}
		}

		return true;
	}

// C# TO JAVA CONVERTER TASK: Java annotations will not correspond to .NET attributes:
	private static boolean handleWaterWalkCheatCommand(CommandHandler handler, Boolean enableArg)
	{
		var enable = !handler.getSession().getPlayer().getCommandStatus(PlayerCommandStates.Waterwalk);

		if (enableArg != null)
		{
			enable = enableArg.booleanValue();
		}

		if (enable)
		{
			handler.getSession().getPlayer().setCommandStatusOn(PlayerCommandStates.Waterwalk);
			handler.getSession().getPlayer().setWaterWalking(true);
			handler.sendSysMessage("Waterwalking is ON. You can walk on water.");
		}
		else
		{
			handler.getSession().getPlayer().setCommandStatusOff(PlayerCommandStates.Waterwalk);
			handler.getSession().getPlayer().setWaterWalking(false);
			handler.sendSysMessage("Waterwalking is OFF. You can't walk on water.");
		}

		return true;
	}
}
