package com.github.azeroth.game.chat.commands;


import com.github.azeroth.game.chat.CommandHandler;
import com.github.azeroth.game.chat.QuotedString;
import com.github.azeroth.game.supportsystem.BugTicket;
import com.github.azeroth.game.supportsystem.ComplaintTicket;
import com.github.azeroth.game.supportsystem.SuggestionTicket;
import game.*;

class TicketCommands {
    // C# TO JAVA CONVERTER TASK: Java annotations will not correspond to .NET attributes:
    private static boolean handleToggleGMTicketSystem(CommandHandler handler) {
        if (!WorldConfig.getBoolValue(WorldCfg.SupportTicketsEnabled)) {
            handler.sendSysMessage(CypherStrings.DisallowTicketsConfig);

            return true;
        }

        var status = !global.getSupportMgr().getSupportSystemStatus();
        global.getSupportMgr().setSupportSystemStatus(status);
        handler.sendSysMessage(status ? CypherStrings.AllowTickets : CypherStrings.DisallowTickets);

        return true;
    }


    private static <T extends ticket> boolean handleTicketAssignToCommand(CommandHandler handler, int ticketId, String targetName) {
        if (targetName.isEmpty()) {
            return false;
        }

        tangible.RefObject<String> tempRef_targetName = new tangible.RefObject<String>(targetName);
        if (!ObjectManager.normalizePlayerName(tempRef_targetName)) {
            targetName = tempRef_targetName.refArgValue;
            return false;
        } else {
            targetName = tempRef_targetName.refArgValue;
        }

        var ticket = global.getSupportMgr().<T>GetTicket(ticketId);

        if (ticket == null || ticket.isClosed()) {
            handler.sendSysMessage(CypherStrings.CommandTicketnotexist);

            return true;
        }

        var targetGuid = global.getCharacterCacheStorage().getCharacterGuidByName(targetName);
        var accountId = global.getCharacterCacheStorage().getCharacterAccountIdByGuid(targetGuid);

        // Target must exist and have administrative rights
        if (!global.getAccountMgr().hasPermission(accountId, RBACPermissions.CommandsBeAssignedTicket, global.getWorldMgr().getRealm().id.index)) {
            handler.sendSysMessage(CypherStrings.CommandTicketassignerrorA);

            return true;
        }

        // If already assigned, leave
        if (ticket.isAssignedTo(targetGuid)) {
            handler.sendSysMessage(CypherStrings.CommandTicketassignerrorB, ticket.getId());

            return true;
        }

        // If assigned to different player other than current, leave
        //! Console can override though
        var player = handler.getSession() != null ? handler.getSession().getPlayer() : null;

        if (player && ticket.isAssignedNotTo(player.getGUID())) {
            handler.sendSysMessage(CypherStrings.CommandTicketalreadyassigned, ticket.getId());

            return true;
        }

        // Assign ticket
        ticket.setAssignedTo(targetGuid, global.getAccountMgr().isAdminAccount(global.getAccountMgr().getSecurity(accountId, (int) global.getWorldMgr().getRealm().id.index)));
        ticket.saveToDB();

        var msg = ticket.formatViewMessageString(handler, null, targetName, null, null);
        handler.sendGlobalGMSysMessage(msg);

        return true;
    }


    private static <T extends ticket> boolean handleCloseByIdCommand(CommandHandler handler, int ticketId) {
        var ticket = global.getSupportMgr().<T>GetTicket(ticketId);

        if (ticket == null || ticket.isClosed()) {
            handler.sendSysMessage(CypherStrings.CommandTicketnotexist);

            return true;
        }

        // Ticket should be assigned to the player who tries to close it.
        // Console can override though
        var player = handler.getSession() != null ? handler.getSession().getPlayer() : null;

        if (player && ticket.isAssignedNotTo(player.getGUID())) {
            handler.sendSysMessage(CypherStrings.CommandTicketcannotclose, ticket.getId());

            return true;
        }

        var closedByGuid = ObjectGuid.Empty;

        if (player) {
            closedByGuid = player.getGUID();
        } else {
            closedByGuid.SetRawValue(0, Long.MAX_VALUE);
        }

        global.getSupportMgr().<T>CloseTicket(ticket.getId(), closedByGuid);

        var msg = ticket.formatViewMessageString(handler, player ? player.getName() : "Console", null, null, null);
        handler.sendGlobalGMSysMessage(msg);

        return true;
    }

    private static <T extends ticket> boolean handleClosedListCommand(CommandHandler handler) {
        global.getSupportMgr().<T>ShowClosedList(handler);

        return true;
    }


    private static <T extends ticket> boolean handleCommentCommand(CommandHandler handler, int ticketId, QuotedString comment) {
        if (comment.isEmpty()) {
            return false;
        }

        var ticket = global.getSupportMgr().<T>GetTicket(ticketId);

        if (ticket == null || ticket.isClosed()) {
            handler.sendSysMessage(CypherStrings.CommandTicketnotexist);

            return true;
        }

        // Cannot comment ticket assigned to someone else
        //! Console excluded
        var player = handler.getSession() != null ? handler.getSession().getPlayer() : null;

        if (player && ticket.isAssignedNotTo(player.getGUID())) {
            handler.sendSysMessage(CypherStrings.CommandTicketalreadyassigned, ticket.getId());

            return true;
        }

        ticket.setComment(comment);
        ticket.saveToDB();
        global.getSupportMgr().updateLastChange();

        var msg = ticket.formatViewMessageString(handler, null, ticket.getAssignedToName(), null, null);
        msg += String.format(handler.getCypherString(CypherStrings.CommandTicketlistaddcomment), player ? player.getName() : "Console", comment);
        handler.sendGlobalGMSysMessage(msg);

        return true;
    }


    private static <T extends ticket> boolean handleDeleteByIdCommand(CommandHandler handler, int ticketId) {
        var ticket = global.getSupportMgr().<T>GetTicket(ticketId);

        if (ticket == null) {
            handler.sendSysMessage(CypherStrings.CommandTicketnotexist);

            return true;
        }

        if (!ticket.isClosed()) {
            handler.sendSysMessage(CypherStrings.CommandTicketclosefirst);

            return true;
        }

        var msg = ticket.formatViewMessageString(handler, null, null, null, handler.getSession() != null ? handler.getSession().getPlayer().getName() : "Console");
        handler.sendGlobalGMSysMessage(msg);

        global.getSupportMgr().<T>RemoveTicket(ticket.getId());

        return true;
    }

    private static <T extends ticket> boolean handleListCommand(CommandHandler handler) {
        global.getSupportMgr().<T>ShowList(handler);

        return true;
    }

    private static <T extends ticket> boolean handleResetCommand(CommandHandler handler) {
        if (global.getSupportMgr().<T>GetOpenTicketCount() != 0) {
            handler.sendSysMessage(CypherStrings.CommandTicketpending);

            return true;
        } else {
            global.getSupportMgr().<T>ResetTickets();
            handler.sendSysMessage(CypherStrings.CommandTicketreset);
        }

        return true;
    }


    private static <T extends ticket> boolean handleUnAssignCommand(CommandHandler handler, int ticketId) {
        var ticket = global.getSupportMgr().<T>GetTicket(ticketId);

        if (ticket == null || ticket.isClosed()) {
            handler.sendSysMessage(CypherStrings.CommandTicketnotexist);

            return true;
        }

        // Ticket must be assigned
        if (!ticket.isAssigned()) {
            handler.sendSysMessage(CypherStrings.CommandTicketnotassigned, ticket.getId());

            return true;
        }

        // Get security level of player, whom this ticket is assigned to
        AccountTypes security;
        var assignedPlayer = ticket.getAssignedPlayer();

        if (assignedPlayer && assignedPlayer.isInWorld()) {
            security = assignedPlayer.getSession().getSecurity();
        } else {
            var guid = ticket.getAssignedToGUID();
            var accountId = global.getCharacterCacheStorage().getCharacterAccountIdByGuid(guid);
            security = global.getAccountMgr().getSecurity(accountId, (int) global.getWorldMgr().getRealm().id.index);
        }

        // Check security
        //! If no m_session present it means we're issuing this command from the console
        var mySecurity = handler.getSession() != null ? handler.getSession().getSecurity() : AccountTypes.Console;

        if (security.getValue() > mySecurity.getValue()) {
            handler.sendSysMessage(CypherStrings.CommandTicketunassignsecurity);

            return true;
        }

        var assignedTo = ticket.getAssignedToName(); // copy assignedto name because we need it after the ticket has been unnassigned

        ticket.setUnassigned();
        ticket.saveToDB();
        var msg = ticket.formatViewMessageString(handler, null, assignedTo, handler.getSession() != null ? handler.getSession().getPlayer().getName() : "Console", null);
        handler.sendGlobalGMSysMessage(msg);

        return true;
    }


    private static <T extends ticket> boolean handleGetByIdCommand(CommandHandler handler, int ticketId) {
        var ticket = global.getSupportMgr().<T>GetTicket(ticketId);

        if (ticket == null || ticket.isClosed()) {
            handler.sendSysMessage(CypherStrings.CommandTicketnotexist);

            return true;
        }

        handler.sendSysMessage(ticket.formatViewMessageString(handler, true));

        return true;
    }

    // C# TO JAVA CONVERTER TASK: Java annotations will not correspond to .NET attributes:
    private static class TicketBugCommands {
        // C# TO JAVA CONVERTER TASK: Java annotations will not correspond to .NET attributes:
        private static boolean handleTicketBugAssignCommand(CommandHandler handler, int ticketId, String targetName) {
            return TicketCommands.<BugTicket>HandleTicketAssignToCommand(handler, ticketId, targetName);
        }

        // C# TO JAVA CONVERTER TASK: Java annotations will not correspond to .NET attributes:
        private static boolean handleTicketBugCloseCommand(CommandHandler handler, int ticketId) {
            return TicketCommands.<BugTicket>HandleCloseByIdCommand(handler, ticketId);
        }

        // C# TO JAVA CONVERTER TASK: Java annotations will not correspond to .NET attributes:
        private static boolean handleTicketBugClosedListCommand(CommandHandler handler) {
            return TicketCommands.<BugTicket>HandleClosedListCommand(handler);
        }

        // C# TO JAVA CONVERTER TASK: Java annotations will not correspond to .NET attributes:
        private static boolean handleTicketBugCommentCommand(CommandHandler handler, int ticketId, QuotedString comment) {
            return TicketCommands.<BugTicket>HandleCommentCommand(handler, ticketId, comment);
        }

        // C# TO JAVA CONVERTER TASK: Java annotations will not correspond to .NET attributes:
        private static boolean handleTicketBugDeleteCommand(CommandHandler handler, int ticketId) {
            return TicketCommands.<BugTicket>HandleDeleteByIdCommand(handler, ticketId);
        }

        // C# TO JAVA CONVERTER TASK: Java annotations will not correspond to .NET attributes:
        private static boolean handleTicketBugListCommand(CommandHandler handler) {
            return TicketCommands.<BugTicket>HandleListCommand(handler);
        }

        // C# TO JAVA CONVERTER TASK: Java annotations will not correspond to .NET attributes:
        private static boolean handleTicketBugUnAssignCommand(CommandHandler handler, int ticketId) {
            return TicketCommands.<BugTicket>HandleUnAssignCommand(handler, ticketId);
        }

        // C# TO JAVA CONVERTER TASK: Java annotations will not correspond to .NET attributes:
        private static boolean handleTicketBugViewCommand(CommandHandler handler, int ticketId) {
            return TicketCommands.<BugTicket>HandleGetByIdCommand(handler, ticketId);
        }
    }

    // C# TO JAVA CONVERTER TASK: Java annotations will not correspond to .NET attributes:
    private static class TicketComplaintCommands {
        // C# TO JAVA CONVERTER TASK: Java annotations will not correspond to .NET attributes:
        private static boolean handleTicketComplaintAssignCommand(CommandHandler handler, int ticketId, String targetName) {
            return TicketCommands.<ComplaintTicket>HandleTicketAssignToCommand(handler, ticketId, targetName);
        }

        // C# TO JAVA CONVERTER TASK: Java annotations will not correspond to .NET attributes:
        private static boolean handleTicketComplaintCloseCommand(CommandHandler handler, int ticketId) {
            return TicketCommands.<ComplaintTicket>HandleCloseByIdCommand(handler, ticketId);
        }

        // C# TO JAVA CONVERTER TASK: Java annotations will not correspond to .NET attributes:
        private static boolean handleTicketComplaintClosedListCommand(CommandHandler handler) {
            return TicketCommands.<ComplaintTicket>HandleClosedListCommand(handler);
        }

        // C# TO JAVA CONVERTER TASK: Java annotations will not correspond to .NET attributes:
        private static boolean handleTicketComplaintCommentCommand(CommandHandler handler, int ticketId, QuotedString comment) {
            return TicketCommands.<ComplaintTicket>HandleCommentCommand(handler, ticketId, comment);
        }

        // C# TO JAVA CONVERTER TASK: Java annotations will not correspond to .NET attributes:
        private static boolean handleTicketComplaintDeleteCommand(CommandHandler handler, int ticketId) {
            return TicketCommands.<ComplaintTicket>HandleDeleteByIdCommand(handler, ticketId);
        }

        // C# TO JAVA CONVERTER TASK: Java annotations will not correspond to .NET attributes:
        private static boolean handleTicketComplaintListCommand(CommandHandler handler) {
            return TicketCommands.<ComplaintTicket>HandleListCommand(handler);
        }

        // C# TO JAVA CONVERTER TASK: Java annotations will not correspond to .NET attributes:
        private static boolean handleTicketComplaintUnAssignCommand(CommandHandler handler, int ticketId) {
            return TicketCommands.<ComplaintTicket>HandleUnAssignCommand(handler, ticketId);
        }

        // C# TO JAVA CONVERTER TASK: Java annotations will not correspond to .NET attributes:
        private static boolean handleTicketComplaintViewCommand(CommandHandler handler, int ticketId) {
            return TicketCommands.<ComplaintTicket>HandleGetByIdCommand(handler, ticketId);
        }
    }

    // C# TO JAVA CONVERTER TASK: Java annotations will not correspond to .NET attributes:
    private static class TicketSuggestionCommands {
        // C# TO JAVA CONVERTER TASK: Java annotations will not correspond to .NET attributes:
        private static boolean handleTicketSuggestionAssignCommand(CommandHandler handler, int ticketId, String targetName) {
            return TicketCommands.<SuggestionTicket>HandleTicketAssignToCommand(handler, ticketId, targetName);
        }

        // C# TO JAVA CONVERTER TASK: Java annotations will not correspond to .NET attributes:
        private static boolean handleTicketSuggestionCloseCommand(CommandHandler handler, int ticketId) {
            return TicketCommands.<SuggestionTicket>HandleCloseByIdCommand(handler, ticketId);
        }

        // C# TO JAVA CONVERTER TASK: Java annotations will not correspond to .NET attributes:
        private static boolean handleTicketSuggestionClosedListCommand(CommandHandler handler) {
            return TicketCommands.<SuggestionTicket>HandleClosedListCommand(handler);
        }

        // C# TO JAVA CONVERTER TASK: Java annotations will not correspond to .NET attributes:
        private static boolean handleTicketSuggestionCommentCommand(CommandHandler handler, int ticketId, QuotedString comment) {
            return TicketCommands.<SuggestionTicket>HandleCommentCommand(handler, ticketId, comment);
        }

        // C# TO JAVA CONVERTER TASK: Java annotations will not correspond to .NET attributes:
        private static boolean handleTicketSuggestionDeleteCommand(CommandHandler handler, int ticketId) {
            return TicketCommands.<SuggestionTicket>HandleDeleteByIdCommand(handler, ticketId);
        }

        // C# TO JAVA CONVERTER TASK: Java annotations will not correspond to .NET attributes:
        private static boolean handleTicketSuggestionListCommand(CommandHandler handler) {
            return TicketCommands.<SuggestionTicket>HandleListCommand(handler);
        }

        // C# TO JAVA CONVERTER TASK: Java annotations will not correspond to .NET attributes:
        private static boolean handleTicketSuggestionUnAssignCommand(CommandHandler handler, int ticketId) {
            return TicketCommands.<SuggestionTicket>HandleUnAssignCommand(handler, ticketId);
        }

        // C# TO JAVA CONVERTER TASK: Java annotations will not correspond to .NET attributes:
        private static boolean handleTicketSuggestionViewCommand(CommandHandler handler, int ticketId) {
            return TicketCommands.<SuggestionTicket>HandleGetByIdCommand(handler, ticketId);
        }
    }

    // C# TO JAVA CONVERTER TASK: Java annotations will not correspond to .NET attributes:
    private static class TicketResetCommands {
        // C# TO JAVA CONVERTER TASK: Java annotations will not correspond to .NET attributes:
        private static boolean handleTicketResetAllCommand(CommandHandler handler) {
            if (global.getSupportMgr().<BugTicket>GetOpenTicketCount() != 0 || global.getSupportMgr().<ComplaintTicket>GetOpenTicketCount() != 0 || global.getSupportMgr().<SuggestionTicket>GetOpenTicketCount() != 0) {
                handler.sendSysMessage(CypherStrings.CommandTicketpending);

                return true;
            } else {
                global.getSupportMgr().<BugTicket>ResetTickets();
                global.getSupportMgr().<ComplaintTicket>ResetTickets();
                global.getSupportMgr().<SuggestionTicket>ResetTickets();
                handler.sendSysMessage(CypherStrings.CommandTicketreset);
            }

            return true;
        }

        // C# TO JAVA CONVERTER TASK: Java annotations will not correspond to .NET attributes:
        private static boolean handleTicketResetBugCommand(CommandHandler handler) {
            return TicketCommands.<BugTicket>HandleResetCommand(handler);
        }

        // C# TO JAVA CONVERTER TASK: Java annotations will not correspond to .NET attributes:
        private static boolean handleTicketResetComplaintCommand(CommandHandler handler) {
            return TicketCommands.<ComplaintTicket>HandleResetCommand(handler);
        }

        // C# TO JAVA CONVERTER TASK: Java annotations will not correspond to .NET attributes:
        private static boolean handleTicketResetSuggestionCommand(CommandHandler handler) {
            return TicketCommands.<SuggestionTicket>HandleResetCommand(handler);
        }
    }
}
