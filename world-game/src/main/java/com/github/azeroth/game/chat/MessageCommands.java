package com.github.azeroth.game.chat;


import com.github.azeroth.game.networking.packet.PrintNotification;
import game.ServerMessageType;

class MessageCommands {
    // C# TO JAVA CONVERTER TASK: Java annotations will not correspond to .NET attributes:
    private static boolean handleNameAnnounceCommand(CommandHandler handler, Tail message) {
        if (message.isEmpty()) {
            return false;
        }

        var name = "Console";
        var session = handler.getSession();

        if (session) {
            name = session.getPlayer().getName();
        }

        global.getWorldMgr().sendWorldText(CypherStrings.AnnounceColor, name, message);

        return true;
    }

    // C# TO JAVA CONVERTER TASK: Java annotations will not correspond to .NET attributes:
    private static boolean handleGMNameAnnounceCommand(CommandHandler handler, Tail message) {
        if (message.isEmpty()) {
            return false;
        }

        var name = "Console";
        var session = handler.getSession();

        if (session) {
            name = session.getPlayer().getName();
        }

        global.getWorldMgr().sendGMText(CypherStrings.AnnounceColor, name, message);

        return true;
    }

    // C# TO JAVA CONVERTER TASK: Java annotations will not correspond to .NET attributes:
    private static boolean handleAnnounceCommand(CommandHandler handler, Tail message) {
        if (message.isEmpty()) {
            return false;
        }

        global.getWorldMgr().sendServerMessage(ServerMessageType.String, handler.getParsedString(CypherStrings.Systemmessage, message));

        return true;
    }

    // C# TO JAVA CONVERTER TASK: Java annotations will not correspond to .NET attributes:
    private static boolean handleGMAnnounceCommand(CommandHandler handler, Tail message) {
        if (message.isEmpty()) {
            return false;
        }

        global.getWorldMgr().sendGMText(CypherStrings.GmBroadcast, message);

        return true;
    }

    // C# TO JAVA CONVERTER TASK: Java annotations will not correspond to .NET attributes:
    private static boolean handleNotifyCommand(CommandHandler handler, Tail message) {
        if (message.isEmpty()) {
            return false;
        }

        var str = handler.getCypherString(CypherStrings.GlobalNotify);
        str += message;

        global.getWorldMgr().sendGlobalMessage(new PrintNotification(str));

        return true;
    }

    // C# TO JAVA CONVERTER TASK: Java annotations will not correspond to .NET attributes:
    private static boolean handleGMNotifyCommand(CommandHandler handler, Tail message) {
        if (message.isEmpty()) {
            return false;
        }

        var str = handler.getCypherString(CypherStrings.GmNotify);
        str += message;

        global.getWorldMgr().sendGlobalGMMessage(new PrintNotification(str));

        return true;
    }

    // C# TO JAVA CONVERTER TASK: Java annotations will not correspond to .NET attributes:
// C# TO JAVA CONVERTER TASK: Java annotations will not correspond to .NET attributes:
    private static boolean handleWhispersCommand(CommandHandler handler, Boolean operationArg, String playerNameArg) {
        if (operationArg == null) {
            handler.sendSysMessage(CypherStrings.CommandWhisperaccepting, handler.getSession().getPlayer().isAcceptWhispers() ? handler.getCypherString(CypherStrings.on) : handler.getCypherString(CypherStrings.Off));

            return true;
        }

        if (operationArg != null) {
            handler.getSession().getPlayer().setAcceptWhispers(true);
            handler.sendSysMessage(CypherStrings.CommandWhisperon);

            return true;
        } else {
            // Remove all players from the Gamemaster's whisper whitelist
            handler.getSession().getPlayer().clearWhisperWhiteList();

            handler.getSession().getPlayer().setAcceptWhispers(false);
            handler.sendSysMessage(CypherStrings.CommandWhisperoff);

            return true;
        }

        //todo fix me
		/*if (operationArg->holds_alternative < EXACT_SEQUENCE("remove") > ())
		{
			if (!playerNameArg)
				return false;

			if (normalizePlayerName(*playerNameArg))
			{
				if (Player * player = ObjectAccessor::FindPlayerByName(*playerNameArg))
				{
					handler->GetSession()->GetPlayer()->RemoveFromWhisperWhiteList(player->GetGUID());
					handler->PSendSysMessage(LANG_COMMAND_WHISPEROFFPLAYER, playerNameArg->c_str());
					return true;
				}
				else
				{
					handler->PSendSysMessage(LANG_PLAYER_NOT_FOUND, playerNameArg->c_str());
					handler->SetSentErrorMessage(true);
					return false;
				}
			}
		}
		handler.sendSysMessage(CypherStrings.UseBol);
		return false;*/
    }
}
