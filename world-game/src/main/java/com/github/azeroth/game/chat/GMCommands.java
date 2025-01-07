package com.github.azeroth.game.chat;


// C# TO JAVA CONVERTER TASK: Java annotations will not correspond to .NET attributes:
class GMCommands {
    // C# TO JAVA CONVERTER TASK: Java annotations will not correspond to .NET attributes:
    private static boolean handleGMChatCommand(CommandHandler handler, Boolean enableArg) {
        var session = handler.getSession();

        if (session != null) {
            if (enableArg == null) {
                if (session.hasPermission(RBACPermissions.ChatUseStaffBadge) && session.getPlayer().isGMChat()) {
                    session.sendNotification(CypherStrings.GmChatOn);
                } else {
                    session.sendNotification(CypherStrings.GmChatOff);
                }

                return true;
            }

            if (enableArg != null) {
                session.getPlayer().setGMChat(true);
                session.sendNotification(CypherStrings.GmChatOn);
            } else {
                session.getPlayer().setGMChat(false);
                session.sendNotification(CypherStrings.GmChatOff);
            }

            return true;
        }

        handler.sendSysMessage(CypherStrings.UseBol);

        return false;
    }

    // C# TO JAVA CONVERTER TASK: Java annotations will not correspond to .NET attributes:
    private static boolean handleGMFlyCommand(CommandHandler handler, boolean enable) {
        var target = handler.getSelectedPlayer();

        if (target == null) {
            target = handler.getPlayer();
        }

        if (enable) {
            target.setCanFly(true);
            target.setCanTransitionBetweenSwimAndFly(true);
        } else {
            target.setCanFly(false);
            target.setCanTransitionBetweenSwimAndFly(false);
        }

        handler.sendSysMessage(CypherStrings.CommandFlymodeStatus, handler.getNameLink(target), enable ? "on" : "off");

        return true;
    }

    // C# TO JAVA CONVERTER TASK: Java annotations will not correspond to .NET attributes:
    private static boolean handleGMListIngameCommand(CommandHandler handler) {
        var first = true;
        var footer = false;

        for (var player : global.getObjAccessor().getPlayers()) {
            var playerSec = player.getSession().getSecurity();

            if ((player.isGameMaster() || (player.getSession().hasPermission(RBACPermissions.CommandsAppearInGmList) && playerSec.getValue() <= AccountTypes.forValue(WorldConfig.getIntValue(WorldCfg.GmLevelInGmList)))) && (handler.getSession() == null || player.isVisibleGloballyFor(handler.getSession().getPlayer()))) {
                if (first) {
                    first = false;
                    footer = true;
                    handler.sendSysMessage(CypherStrings.GmsOnSrv);
                    handler.sendSysMessage("========================");
                }

                var size = player.getName().length();
                var security = (byte) playerSec.getValue();
                var max = ((16 - size) / 2);
                var max2 = max;

                if ((max + max2 + size) == 16) {
                    max2 = max - 1;
                }

                if (handler.getSession() != null) {
                    handler.sendSysMessage("|    {0} GMLevel {1}", player.getName(), security);
                } else {
                    handler.sendSysMessage("|{0}{1}{2}|   {3}  |", max, " ", player.getName(), max2, " ", security);
                }
            }
        }

        if (footer) {
            handler.sendSysMessage("========================");
        }

        if (first) {
            handler.sendSysMessage(CypherStrings.GmsNotLogged);
        }

        return true;
    }

    // C# TO JAVA CONVERTER TASK: Java annotations will not correspond to .NET attributes:
    private static boolean handleGMListFullCommand(CommandHandler handler) {
        // Get the accounts with GM level >0
        var stmt = DB.Login.GetPreparedStatement(LoginStatements.SEL_GM_ACCOUNTS);
        stmt.AddValue(0, (byte) AccountTypes.moderator.getValue());
        stmt.AddValue(1, global.getWorldMgr().getRealm().id.index);
        var result = DB.Login.query(stmt);

        if (!result.isEmpty()) {
            handler.sendSysMessage(CypherStrings.Gmlist);
            handler.sendSysMessage("========================");

            // Cycle through them. Display username and GM level
            do {
                var name = result.<String>Read(0);
                var security = result.<Byte>Read(1);
                var max = (16 - name.length) / 2;
                var max2 = max;

                if ((max + max2 + name.length) == 16) {
                    max2 = max - 1;
                }

                var padding = "";

                if (handler.getSession() != null) {
                    handler.sendSysMessage("|    {0} GMLevel {1}", name, security);
                } else {
                    handler.sendSysMessage("|{0}{1}{2}|   {3}  |", tangible.StringHelper.padRight(padding, max), name, tangible.StringHelper.padRight(padding, max2), security);
                }
            } while (result.NextRow());

            handler.sendSysMessage("========================");
        } else {
            handler.sendSysMessage(CypherStrings.GmlistEmpty);
        }

        return true;
    }

    // C# TO JAVA CONVERTER TASK: Java annotations will not correspond to .NET attributes:
    private static boolean handleGMOffCommand(CommandHandler handler) {
        handler.getPlayer().setGameMaster(false);
        handler.getPlayer().updateTriggerVisibility();
        handler.getSession().sendNotification(CypherStrings.GmOff);

        return true;
    }

    // C# TO JAVA CONVERTER TASK: Java annotations will not correspond to .NET attributes:
    private static boolean handleGMOnCommand(CommandHandler handler) {
        handler.getPlayer().setGameMaster(true);
        handler.getPlayer().updateTriggerVisibility();
        handler.getSession().sendNotification(CypherStrings.GmOn);

        return true;
    }

    // C# TO JAVA CONVERTER TASK: Java annotations will not correspond to .NET attributes:
    private static boolean handleGMVisibleCommand(CommandHandler handler, Boolean visibleArg) {
        var player = handler.getSession().getPlayer();

        if (visibleArg == null) {
            handler.sendSysMessage(CypherStrings.YouAre, player.isGMVisible() ? global.getObjectMgr().getCypherString(CypherStrings.Visible) : global.getObjectMgr().getCypherString(CypherStrings.Invisible));

            return true;
        }

        int VISUAL_AURA = 37800;

        if (visibleArg.booleanValue()) {
            if (player.hasAura(VISUAL_AURA, ObjectGuid.Empty)) {
                player.removeAura(VISUAL_AURA);
            }

            player.setGMVisible(true);
            player.updateObjectVisibility();
            handler.getSession().sendNotification(CypherStrings.InvisibleVisible);
        } else {
            player.addAura(VISUAL_AURA, player);
            player.setGMVisible(false);
            player.updateObjectVisibility();
            handler.getSession().sendNotification(CypherStrings.InvisibleInvisible);
        }

        return true;
    }
}
