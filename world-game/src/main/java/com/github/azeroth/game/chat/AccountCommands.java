package com.github.azeroth.game.chat;


import java.util.Objects;


// C# TO JAVA CONVERTER TASK: Java annotations will not correspond to .NET attributes:
class AccountCommands {
    // C# TO JAVA CONVERTER TASK: Java annotations will not correspond to .NET attributes:
    private static boolean handleAccountCommand(CommandHandler handler) {
        if (handler.getSession() == null) {
            return false;
        }

        // GM Level
        var securityLevel = handler.getSession().getSecurity();
        handler.sendSysMessage(CypherStrings.AccountLevel, securityLevel);

        // Security level required
        var session = handler.getSession();
        var hasRBAC = (session.hasPermission(RBACPermissions.EmailConfirmForPassChange));
        int pwConfig = 0; // 0 - PW_NONE, 1 - PW_EMAIL, 2 - PW_RBAC

        handler.sendSysMessage(CypherStrings.AccountSecType, (pwConfig == 0 ? "Lowest level: No Email input required." : pwConfig == 1 ? "Highest level: Email input required." : pwConfig == 2 ? "Special level: Your account may require email input depending on settings. That is the case if another lien is printed." : "Unknown security level: Notify technician for details."));

        // RBAC required display - is not displayed for console
        if (pwConfig == 2 && hasRBAC) {
            handler.sendSysMessage(CypherStrings.RbacEmailRequired);
        }

        // Email display if sufficient rights
        if (session.hasPermission(RBACPermissions.MayCheckOwnEmail)) {
            String emailoutput;
            var accountId = session.getAccountId();

            var stmt = DB.Login.GetPreparedStatement(LoginStatements.GET_EMAIL_BY_ID);
            stmt.AddValue(0, accountId);
            var result = DB.Login.query(stmt);

            if (!result.isEmpty()) {
                emailoutput = result.<String>Read(0);
                handler.sendSysMessage(CypherStrings.CommandEmailOutput, emailoutput);
            }
        }

        return true;
    }

    // C# TO JAVA CONVERTER TASK: Java annotations will not correspond to .NET attributes:
    private static boolean handleAccount2FARemoveCommand(CommandHandler handler, Integer token) {
		/*var masterKey = global.SecretMgr.GetSecret(Secrets.TOTPMasterKey);
		if (!masterKey.isAvailable())
		{
			handler.sendSysMessage(CypherStrings.TwoFACommandsNotSetup);
			return false;
		}

		uint accountId = handler.GetSession().getAccountId();
		byte[] secret;
		{ // get current TOTP secret
			PreparedStatement stmt = DB.Login.GetPreparedStatement(LoginStatements.SEL_ACCOUNT_TOTP_SECRET);
			stmt.AddValue(0, accountId);
			SQLResult result = DB.Login.query(stmt);

			if (result.isEmpty())
			{
				Log.outError(LogFilter.misc, $"Account {accountId} not found in login database when processing .account 2fa setup command.");
				handler.sendSysMessage(CypherStrings.UnknownError);
				return false;
			}

			if (result.IsNull(0))
			{ // 2FA not enabled
				handler.sendSysMessage(CypherStrings.TwoFANotSetup);
				return false;
			}

			secret = result.Read<byte[]>(0);
		}

		if (token.HasValue)
		{
			if (masterKey.isValid())
			{
				bool success = AES.Decrypt(secret, masterKey.getValue());
				if (!success)
				{
					Log.outError(LogFilter.misc, $"Account {accountId} has invalid ciphertext in TOTP token.");
					handler.sendSysMessage(CypherStrings.UnknownError);
					return false;
				}
			}

			if (TOTP.ValidateToken(secret, token.value))
			{
				PreparedStatement stmt = DB.Login.GetPreparedStatement(LoginStatements.UPD_ACCOUNT_TOTP_SECRET);
				stmt.AddNull(0);
				stmt.AddValue(1, accountId);
				DB.Login.execute(stmt);
				handler.sendSysMessage(CypherStrings.TwoFARemoveComplete);
				return true;
			}
			else
				handler.sendSysMessage(CypherStrings.TwoFAInvalidToken);
		}

		handler.sendSysMessage(CypherStrings.TwoFARemoveNeedToken);*/
        return false;
    }

    // C# TO JAVA CONVERTER TASK: Java annotations will not correspond to .NET attributes:
    private static boolean handleAccount2FASetupCommand(CommandHandler handler, Integer token) {
		/*var masterKey = global.SecretMgr.GetSecret(Secrets.TOTPMasterKey);
		if (!masterKey.isAvailable())
		{
			handler.sendSysMessage(CypherStrings.TwoFACommandsNotSetup);
			return false;
		}

		uint accountId = handler.GetSession().getAccountId();

		{ // check if 2FA already enabled
			PreparedStatement stmt = DB.Login.GetPreparedStatement(LoginStatements.SEL_ACCOUNT_TOTP_SECRET);
			stmt.AddValue(0, accountId);
			SQLResult result = DB.Login.query(stmt);

			if (result.isEmpty())
			{
				Log.outError(LogFilter.misc, $"Account {accountId} not found in login database when processing .account 2fa setup command.");
				handler.sendSysMessage(CypherStrings.UnknownError);
				return false;
			}

			if (!result.IsNull(0))
			{
				handler.sendSysMessage(CypherStrings.TwoFAAlreadySetup);
				return false;
			}
		}

		// store random suggested secrets
		Dictionary<uint, byte[]> suggestions = new();
		var pair = suggestions.TryAdd(accountId, new byte[20]); // std::vector 1-argument size_t constructor invokes resize
		if (pair) // no suggestion yet, generate random secret
			suggestions[accountId] = new byte[0].GenerateRandomKey(20);

		if (!pair && token.HasValue) // suggestion already existed and token specified - validate
		{
			if (TOTP.ValidateToken(suggestions[accountId], token.value))
			{
				if (masterKey.isValid())
					AES.Encrypt(suggestions[accountId], masterKey.getValue());

				PreparedStatement stmt = DB.Login.GetPreparedStatement(LoginStatements.UPD_ACCOUNT_TOTP_SECRET);
				stmt.AddValue(0, suggestions[accountId]);
				stmt.AddValue(1, accountId);
				DB.Login.execute(stmt);
				suggestions.remove(accountId);
				handler.sendSysMessage(CypherStrings.TwoFASetupComplete);
				return true;
			}
			else
				handler.sendSysMessage(CypherStrings.TwoFAInvalidToken);
		}

		// new suggestion, or no token specified, output TOTP parameters
		handler.sendSysMessage(CypherStrings.TwoFASecretSuggestion, suggestions[accountId].ToBase32());*/
        return false;
    }

    // C# TO JAVA CONVERTER TASK: Java annotations will not correspond to .NET attributes:
    private static boolean handleAccountAddonCommand(CommandHandler handler, byte expansion) {
        if (expansion > WorldConfig.getIntValue(WorldCfg.expansion)) {
            handler.sendSysMessage(CypherStrings.ImproperValue);

            return false;
        }

        var stmt = DB.Login.GetPreparedStatement(LoginStatements.UPD_EXPANSION);
        stmt.AddValue(0, expansion);
        stmt.AddValue(1, handler.getSession().getAccountId());
        DB.Login.execute(stmt);

        handler.sendSysMessage(CypherStrings.AccountAddon, expansion);

        return true;
    }

    // C# TO JAVA CONVERTER TASK: Java annotations will not correspond to .NET attributes:
// C# TO JAVA CONVERTER TASK: Java annotations will not correspond to .NET attributes:
    private static boolean handleAccountCreateCommand(CommandHandler handler, String accountName, String password, String email) {
        if (accountName.contains("@")) {
            handler.sendSysMessage(CypherStrings.AccountUseBnetCommands);

            return false;
        }

        var result = global.getAccountMgr().createAccount(accountName, password, email != null ? email : "");

        switch (result) {
            case Ok:
                handler.sendSysMessage(CypherStrings.AccountCreated, accountName);

                if (handler.getSession() != null) {
                    Log.outInfo(LogFilter.player, "Account: {0} (IP: {1}) Character:[{2}] (GUID: {3}) created Account {4} (Email: '{5}')", handler.getSession().getAccountId(), handler.getSession().getRemoteAddress(), handler.getSession().getPlayer().getName(), handler.getSession().getPlayer().getGUID().toString(), accountName, email != null ? email : "");
                }

                break;
            case NameTooLong:
                handler.sendSysMessage(CypherStrings.AccountNameTooLong);

                return false;
            case PassTooLong:
                handler.sendSysMessage(CypherStrings.AccountPassTooLong);

                return false;
            case NameAlreadyExist:
                handler.sendSysMessage(CypherStrings.AccountAlreadyExist);

                return false;
            case DBInternalError:
                handler.sendSysMessage(CypherStrings.AccountNotCreatedSqlError, accountName);

                return false;
            default:
                handler.sendSysMessage(CypherStrings.AccountNotCreated, accountName);

                return false;
        }

        return true;
    }

    // C# TO JAVA CONVERTER TASK: Java annotations will not correspond to .NET attributes:
    private static boolean handleAccountDeleteCommand(CommandHandler handler, String accountName) {
        var accountId = global.getAccountMgr().getId(accountName);

        if (accountId == 0) {
            handler.sendSysMessage(CypherStrings.AccountNotExist, accountName);

            return false;
        }

        if (handler.hasLowerSecurityAccount(null, accountId, true)) {
            return false;
        }

        var result = global.getAccountMgr().deleteAccount(accountId);

        switch (result) {
            case Ok:
                handler.sendSysMessage(CypherStrings.AccountDeleted, accountName);

                break;
            case NameNotExist:
                handler.sendSysMessage(CypherStrings.AccountNotExist, accountName);

                return false;
            case DBInternalError:
                handler.sendSysMessage(CypherStrings.AccountNotDeletedSqlError, accountName);

                return false;
            default:
                handler.sendSysMessage(CypherStrings.AccountNotDeleted, accountName);

                return false;
        }

        return true;
    }

    // C# TO JAVA CONVERTER TASK: Java annotations will not correspond to .NET attributes:
    private static boolean handleAccountEmailCommand(CommandHandler handler, String oldEmail, String password, String email, String emailConfirm) {
        if (!global.getAccountMgr().checkEmail(handler.getSession().getAccountId(), oldEmail)) {
            handler.sendSysMessage(CypherStrings.CommandWrongemail);

            Log.outInfo(LogFilter.player, "Account: {0} (IP: {1}) Character:[{2}] (GUID: {3}) Tried to change email, but the provided email [{4}] is not equal to registration email [{5}].", handler.getSession().getAccountId(), handler.getSession().getRemoteAddress(), handler.getSession().getPlayer().getName(), handler.getSession().getPlayer().getGUID().toString(), email, oldEmail);

            return false;
        }

        if (!global.getAccountMgr().checkPassword(handler.getSession().getAccountId(), password)) {
            handler.sendSysMessage(CypherStrings.CommandWrongoldpassword);

            Log.outInfo(LogFilter.player, "Account: {0} (IP: {1}) Character:[{2}] (GUID: {3}) Tried to change email, but the provided password is wrong.", handler.getSession().getAccountId(), handler.getSession().getRemoteAddress(), handler.getSession().getPlayer().getName(), handler.getSession().getPlayer().getGUID().toString());

            return false;
        }

        if (Objects.equals(email, oldEmail)) {
            handler.sendSysMessage(CypherStrings.OldEmailIsNewEmail);

            return false;
        }

        if (!Objects.equals(email, emailConfirm)) {
            handler.sendSysMessage(CypherStrings.NewEmailsNotMatch);

            Log.outInfo(LogFilter.player, "Account: {0} (IP: {1}) Character:[{2}] (GUID: {3}) Tried to change email, but the provided password is wrong.", handler.getSession().getAccountId(), handler.getSession().getRemoteAddress(), handler.getSession().getPlayer().getName(), handler.getSession().getPlayer().getGUID().toString());

            return false;
        }


        var result = global.getAccountMgr().changeEmail(handler.getSession().getAccountId(), email);

        switch (result) {
            case Ok:
                handler.sendSysMessage(CypherStrings.CommandEmail);

                Log.outInfo(LogFilter.player, "Account: {0} (IP: {1}) Character:[{2}] (GUID: {3}) Changed Email from [{4}] to [{5}].", handler.getSession().getAccountId(), handler.getSession().getRemoteAddress(), handler.getSession().getPlayer().getName(), handler.getSession().getPlayer().getGUID().toString(), oldEmail, email);

                break;
            case EmailTooLong:
                handler.sendSysMessage(CypherStrings.EmailTooLong);

                return false;
            default:
                handler.sendSysMessage(CypherStrings.CommandNotchangeemail);

                return false;
        }

        return true;
    }

    // C# TO JAVA CONVERTER TASK: Java annotations will not correspond to .NET attributes:
// C# TO JAVA CONVERTER TASK: Java annotations will not correspond to .NET attributes:
    private static boolean handleAccountPasswordCommand(CommandHandler handler, String oldPassword, String newPassword, String confirmPassword, String confirmEmail) {
        // first, we check config. What security type (sec type) is it ? Depending on it, the command branches out
        var pwConfig = WorldConfig.getUIntValue(WorldCfg.AccPasschangesec); // 0 - PW_NONE, 1 - PW_EMAIL, 2 - PW_RBAC

        // We compare the old, saved password to the entered old password - no chance for the unauthorized.
        if (!global.getAccountMgr().checkPassword(handler.getSession().getAccountId(), oldPassword)) {
            handler.sendSysMessage(CypherStrings.CommandWrongoldpassword);

            Log.outInfo(LogFilter.player, "Account: {0} (IP: {1}) Character:[{2}] (GUID: {3}) Tried to change password, but the provided old password is wrong.", handler.getSession().getAccountId(), handler.getSession().getRemoteAddress(), handler.getSession().getPlayer().getName(), handler.getSession().getPlayer().getGUID().toString());

            return false;
        }

        // This compares the old, current email to the entered email - however, only...
        if ((pwConfig == 1 || (pwConfig == 2 && handler.getSession().hasPermission(RBACPermissions.EmailConfirmForPassChange))) && !global.getAccountMgr().checkEmail(handler.getSession().getAccountId(), confirmEmail)) // ... and returns false if the comparison fails.
        {
            handler.sendSysMessage(CypherStrings.CommandWrongemail);

            Log.outInfo(LogFilter.player, "Account: {0} (IP: {1}) Character:[{2}] (GUID: {3}) Tried to change password, but the entered email [{4}] is wrong.", handler.getSession().getAccountId(), handler.getSession().getRemoteAddress(), handler.getSession().getPlayer().getName(), handler.getSession().getPlayer().getGUID().toString(), confirmEmail);

            return false;
        }

        // Making sure that newly entered password is correctly entered.
        if (!Objects.equals(newPassword, confirmPassword)) {
            handler.sendSysMessage(CypherStrings.NewPasswordsNotMatch);

            return false;
        }

        // Changes password and prints result.
        var result = global.getAccountMgr().changePassword(handler.getSession().getAccountId(), newPassword);

        switch (result) {
            case Ok:
                handler.sendSysMessage(CypherStrings.CommandPassword);

                Log.outInfo(LogFilter.player, "Account: {0} (IP: {1}) Character:[{2}] (GUID: {3}) Changed password.", handler.getSession().getAccountId(), handler.getSession().getRemoteAddress(), handler.getSession().getPlayer().getName(), handler.getSession().getPlayer().getGUID().toString());

                break;
            case PassTooLong:
                handler.sendSysMessage(CypherStrings.PasswordTooLong);

                return false;
            default:
                handler.sendSysMessage(CypherStrings.CommandNotchangepassword);

                return false;
        }

        return true;
    }

    // C# TO JAVA CONVERTER TASK: Java annotations will not correspond to .NET attributes:
    private static class AccountLockCommands {
        // C# TO JAVA CONVERTER TASK: Java annotations will not correspond to .NET attributes:
        private static boolean handleAccountLockCountryCommand(CommandHandler handler, boolean state) {
            if (state) {
				/*var ipBytes = System.Net.IPAddress.parse(handler.GetSession().GetRemoteAddress()).GetAddressBytes();
				Array.reverse(ipBytes);

				PreparedStatement stmt = DB.Login.GetPreparedStatement(LoginStatements.SEL_LOGON_COUNTRY);
				stmt.AddValue(0, BitConverter.ToUInt32(ipBytes, 0));

				SQLResult result = DB.Login.query(stmt);
				if (!result.isEmpty())
				{
					string country = result.Read<string>(0);
					stmt = DB.Login.GetPreparedStatement(LoginStatements.UPD_ACCOUNT_LOCK_COUNTRY);
					stmt.AddValue(0, country);
					stmt.AddValue(1, handler.GetSession().getAccountId());
					DB.Login.execute(stmt);
					handler.sendSysMessage(CypherStrings.CommandAcclocklocked);
				}
				else
				{
					handler.sendSysMessage("[IP2NATION] Table empty");
					Log.outDebug(LogFilter.Server, "[IP2NATION] Table empty");
				}*/
            } else {
                var stmt = DB.Login.GetPreparedStatement(LoginStatements.UPD_ACCOUNT_LOCK_COUNTRY);
                stmt.AddValue(0, "00");
                stmt.AddValue(1, handler.getSession().getAccountId());
                DB.Login.execute(stmt);
                handler.sendSysMessage(CypherStrings.CommandAcclockunlocked);
            }

            return true;
        }

        // C# TO JAVA CONVERTER TASK: Java annotations will not correspond to .NET attributes:
        private static boolean handleAccountLockIpCommand(CommandHandler handler, boolean state) {
            var stmt = DB.Login.GetPreparedStatement(LoginStatements.UPD_ACCOUNT_LOCK);

            if (state) {
                stmt.AddValue(0, true); // locked
                handler.sendSysMessage(CypherStrings.CommandAcclocklocked);
            } else {
                stmt.AddValue(0, false); // unlocked
                handler.sendSysMessage(CypherStrings.CommandAcclockunlocked);
            }

            stmt.AddValue(1, handler.getSession().getAccountId());

            DB.Login.execute(stmt);

            return true;
        }
    }

    // C# TO JAVA CONVERTER TASK: Java annotations will not correspond to .NET attributes:
    private static class AccountOnlineListCommands {
        // C# TO JAVA CONVERTER TASK: Java annotations will not correspond to .NET attributes:
        private static boolean handleAccountOnlineListCommand(CommandHandler handler) {
            return handleAccountOnlineListCommandWithParameters(handler, null, null, null, null);
        }

        // C# TO JAVA CONVERTER TASK: Java annotations will not correspond to .NET attributes:
        private static boolean handleAccountOnlineListWithIpFilterCommand(CommandHandler handler, String ipAddress) {
            return handleAccountOnlineListCommandWithParameters(handler, ipAddress, null, null, null);
        }

        // C# TO JAVA CONVERTER TASK: Java annotations will not correspond to .NET attributes:
        private static boolean handleAccountOnlineListWithLimitCommand(CommandHandler handler, int limit) {
            return handleAccountOnlineListCommandWithParameters(handler, null, limit, null, null);
        }

        // C# TO JAVA CONVERTER TASK: Java annotations will not correspond to .NET attributes:
        private static boolean handleAccountOnlineListWithMapFilterCommand(CommandHandler handler, int mapId) {
            return handleAccountOnlineListCommandWithParameters(handler, null, null, mapId, null);
        }

        // C# TO JAVA CONVERTER TASK: Java annotations will not correspond to .NET attributes:
        private static boolean handleAccountOnlineListWithZoneFilterCommand(CommandHandler handler, int zoneId) {
            return handleAccountOnlineListCommandWithParameters(handler, null, null, null, zoneId);
        }

        private static boolean handleAccountOnlineListCommandWithParameters(CommandHandler handler, String ipAddress, Integer limit, Integer mapId, Integer zoneId) {
            var sessionsMatchCount = 0;

            for (var session : global.getWorldMgr().getAllSessions()) {
                var player = session.getPlayer();

                // Ignore sessions on character selection screen
                if (player == null) {
                    continue;
                }

                var playerMapId = player.getLocation().getMapId();
                var playerZoneId = player.getZone();

                // Apply optional ipAddress filter
                if (!ipAddress.isEmpty() && !Objects.equals(ipAddress, session.getRemoteAddress())) {
                    continue;
                }

                // Apply optional mapId filter
                if (mapId != null && !mapId.equals(playerMapId)) {
                    continue;
                }

                // Apply optional zoneId filter
                if (zoneId != null && !zoneId.equals(playerZoneId)) {
                    continue;
                }

                if (sessionsMatchCount == 0) {
                    /**- Display the list of account/character online on the first matched sessions
                     */
                    handler.sendSysMessage(CypherStrings.AccountListBarHeader);
                    handler.sendSysMessage(CypherStrings.AccountListHeader);
                    handler.sendSysMessage(CypherStrings.AccountListBar);
                }

                handler.sendSysMessage(CypherStrings.AccountListLine, session.getAccountName(), session.getPlayerName(), session.getRemoteAddress(), playerMapId, playerZoneId, session.getAccountExpansion(), session.getSecurity());

                ++sessionsMatchCount;

                // Apply optional count limit
// C# TO JAVA CONVERTER TASK: Comparisons involving nullable type instances are not converted to null-value logic:
                if (limit != null && sessionsMatchCount >= limit) {
                    break;
                }
            }

            // Header is printed on first matched session. If it wasn't printed then no sessions matched the criteria
            if (sessionsMatchCount == 0) {
                handler.sendSysMessage(CypherStrings.AccountListEmpty);

                return true;
            }

            handler.sendSysMessage(CypherStrings.AccountListBar);

            return true;
        }
    }

    // C# TO JAVA CONVERTER TASK: Java annotations will not correspond to .NET attributes:
    private static class AccountSetCommands {
        // C# TO JAVA CONVERTER TASK: Java annotations will not correspond to .NET attributes:
        private static boolean handleAccountSet2FACommand(CommandHandler handler, String accountName, String secret) {
			/*uint targetAccountId = global.AccountMgr.getId(accountName);
			if (targetAccountId == 0)
			{
				handler.sendSysMessage(CypherStrings.AccountNotExist, accountName);
				return false;
			}

			if (handler.hasLowerSecurityAccount(null, targetAccountId, true))
				return false;

			PreparedStatement stmt;
			if (secret == "off")
			{
				stmt = DB.Login.GetPreparedStatement(LoginStatements.UPD_ACCOUNT_TOTP_SECRET);
				stmt.AddNull(0);
				stmt.AddValue(1, targetAccountId);
				DB.Login.execute(stmt);
				handler.sendSysMessage(CypherStrings.TwoFARemoveComplete);
				return true;
			}

			var masterKey = global.SecretMgr.GetSecret(Secrets.TOTPMasterKey);
			if (!masterKey.isAvailable())
			{
				handler.sendSysMessage(CypherStrings.TwoFACommandsNotSetup);
				return false;
			}

			var decoded = secret.FromBase32();
			if (decoded == null)
			{
				handler.sendSysMessage(CypherStrings.TwoFASecretInvalid);
				return false;
			}
			if (128 < (decoded.length + 12 + 12))
			{
				handler.sendSysMessage(CypherStrings.TwoFASecretTooLong);
				return false;
			}

			if (masterKey.isValid())
				AES.Encrypt(decoded, masterKey.getValue());

			stmt = DB.Login.GetPreparedStatement(LoginStatements.UPD_ACCOUNT_TOTP_SECRET);
			stmt.AddValue(0, decoded);
			stmt.AddValue(1, targetAccountId);
			DB.Login.execute(stmt);
			handler.sendSysMessage(CypherStrings.TwoFASecretSetComplete, accountName);*/
            return true;
        }

        // C# TO JAVA CONVERTER TASK: Java annotations will not correspond to .NET attributes:
// C# TO JAVA CONVERTER TASK: Java annotations will not correspond to .NET attributes:
        private static boolean handleAccountSetAddonCommand(CommandHandler handler, String accountName, byte expansion) {
            int accountId;

            if (!accountName.isEmpty()) {
                // Convert Account name to Upper Format
                accountName = accountName.toUpperCase();

                accountId = global.getAccountMgr().getId(accountName);

                if (accountId == 0) {
                    handler.sendSysMessage(CypherStrings.AccountNotExist, accountName);

                    return false;
                }
            } else {
                var player = handler.getSelectedPlayer();

                if (!player) {
                    return false;
                }

                accountId = player.getSession().getAccountId();
                tangible.OutObject<String> tempOut_accountName = new tangible.OutObject<String>();
                global.getAccountMgr().getName(accountId, tempOut_accountName);
                accountName = tempOut_accountName.outArgValue;
            }

            // Let set addon state only for lesser (strong) security level
            // or to self account
            if (handler.getSession() != null && handler.getSession().getAccountId() != accountId && handler.hasLowerSecurityAccount(null, accountId, true)) {
                return false;
            }

            if (expansion > WorldConfig.getIntValue(WorldCfg.expansion)) {
                return false;
            }

            var stmt = DB.Login.GetPreparedStatement(LoginStatements.UPD_EXPANSION);

            stmt.AddValue(0, expansion);
            stmt.AddValue(1, accountId);

            DB.Login.execute(stmt);

            handler.sendSysMessage(CypherStrings.AccountSetaddon, accountName, accountId, expansion);

            return true;
        }

        // C# TO JAVA CONVERTER TASK: Java annotations will not correspond to .NET attributes:
        private static boolean handleAccountSetPasswordCommand(CommandHandler handler, String accountName, String password, String confirmPassword) {
            var targetAccountId = global.getAccountMgr().getId(accountName);

            if (targetAccountId == 0) {
                handler.sendSysMessage(CypherStrings.AccountNotExist, accountName);

                return false;
            }

            // can set password only for target with less security
            // This also restricts setting handler's own password
            if (handler.hasLowerSecurityAccount(null, targetAccountId, true)) {
                return false;
            }

            if (!password.equals(confirmPassword)) {
                handler.sendSysMessage(CypherStrings.NewPasswordsNotMatch);

                return false;
            }

            var result = global.getAccountMgr().changePassword(targetAccountId, password);

            switch (result) {
                case Ok:
                    handler.sendSysMessage(CypherStrings.CommandPassword);

                    break;
                case NameNotExist:
                    handler.sendSysMessage(CypherStrings.AccountNotExist, accountName);

                    return false;
                case PassTooLong:
                    handler.sendSysMessage(CypherStrings.PasswordTooLong);

                    return false;
                default:
                    handler.sendSysMessage(CypherStrings.CommandNotchangepassword);

                    return false;
            }

            return true;
        }

        // C# TO JAVA CONVERTER TASK: Java annotations will not correspond to .NET attributes:
// C# TO JAVA CONVERTER TASK: Java annotations will not correspond to .NET attributes:
        private static boolean handleAccountSetSecLevelCommand(CommandHandler handler, String accountName, byte securityLevel, Integer realmId) {
            int accountId;

            if (!accountName.isEmpty()) {
                accountId = global.getAccountMgr().getId(accountName);

                if (accountId == 0) {
                    handler.sendSysMessage(CypherStrings.AccountNotExist, accountName);

                    return false;
                }
            } else {
                var player = handler.getSelectedPlayer();

                if (!player) {
                    return false;
                }

                accountId = player.getSession().getAccountId();
                tangible.OutObject<String> tempOut_accountName = new tangible.OutObject<String>();
                global.getAccountMgr().getName(accountId, tempOut_accountName);
                accountName = tempOut_accountName.outArgValue;
            }

            if (securityLevel > (int) AccountTypes.Console.getValue()) {
                handler.sendSysMessage(CypherStrings.BadValue);

                return false;
            }

            var realmID = -1;

            if (realmId != null) {
                realmID = realmId.intValue();
            }

            AccountTypes playerSecurity;

            if (handler.isConsole()) {
                playerSecurity = AccountTypes.Console;
            } else {
                playerSecurity = global.getAccountMgr().getSecurity(handler.getSession().getAccountId(), realmID);
            }

            // can set security level only for target with less security and to less security that we have
            // This is also reject self apply in fact
            var targetSecurity = global.getAccountMgr().getSecurity(accountId, realmID);

            if (targetSecurity.getValue() >= playerSecurity.getValue() || AccountTypes.forValue(securityLevel) >= playerSecurity.getValue()) {
                handler.sendSysMessage(CypherStrings.YoursSecurityIsLow);

                return false;
            }

            PreparedStatement stmt;

            // Check and abort if the target gm has a higher rank on one of the realms and the new realm is -1
            if (realmID == -1 && !global.getAccountMgr().isConsoleAccount(playerSecurity)) {
                stmt = DB.Login.GetPreparedStatement(LoginStatements.SEL_ACCOUNT_ACCESS_SECLEVEL_TEST);
                stmt.AddValue(0, accountId);
                stmt.AddValue(1, securityLevel);

                var result = DB.Login.query(stmt);

                if (!result.isEmpty()) {
                    handler.sendSysMessage(CypherStrings.YoursSecurityIsLow);

                    return false;
                }
            }

            // Check if provided realmID has a negative value other than -1
            if (realmID < -1) {
                handler.sendSysMessage(CypherStrings.InvalidRealmid);

                return false;
            }

            global.getAccountMgr().updateAccountAccess(null, accountId, (byte) securityLevel, realmID);

            handler.sendSysMessage(CypherStrings.YouChangeSecurity, accountName, securityLevel);

            return true;
        }

        // C# TO JAVA CONVERTER TASK: Java annotations will not correspond to .NET attributes:
        private static class SetSecCommands {
            // C# TO JAVA CONVERTER TASK: Java annotations will not correspond to .NET attributes:
            private static boolean handleAccountSetEmailCommand(CommandHandler handler, String accountName, String email, String confirmEmail) {
                var targetAccountId = global.getAccountMgr().getId(accountName);

                if (targetAccountId == 0) {
                    handler.sendSysMessage(CypherStrings.AccountNotExist, accountName);

                    return false;
                }

                // can set email only for target with less security
                // This also restricts setting handler's own email.
                if (handler.hasLowerSecurityAccount(null, targetAccountId, true)) {
                    return false;
                }

                if (!email.equals(confirmEmail)) {
                    handler.sendSysMessage(CypherStrings.NewEmailsNotMatch);

                    return false;
                }

                var result = global.getAccountMgr().changeEmail(targetAccountId, email);

                switch (result) {
                    case Ok:
                        handler.sendSysMessage(CypherStrings.CommandEmail);
                        Log.outInfo(LogFilter.player, "ChangeEmail: Account {0} [Id: {1}] had it's email changed to {2}.", accountName, targetAccountId, email);

                        break;
                    case NameNotExist:
                        handler.sendSysMessage(CypherStrings.AccountNotExist, accountName);

                        return false;
                    case EmailTooLong:
                        handler.sendSysMessage(CypherStrings.EmailTooLong);

                        return false;
                    default:
                        handler.sendSysMessage(CypherStrings.CommandNotchangeemail);

                        return false;
                }

                return true;
            }

            // C# TO JAVA CONVERTER TASK: Java annotations will not correspond to .NET attributes:
            private static boolean handleAccountSetRegEmailCommand(CommandHandler handler, String accountName, String email, String confirmEmail) {
                var targetAccountId = global.getAccountMgr().getId(accountName);

                if (targetAccountId == 0) {
                    handler.sendSysMessage(CypherStrings.AccountNotExist, accountName);

                    return false;
                }

                // can set email only for target with less security
                // This also restricts setting handler's own email.
                if (handler.hasLowerSecurityAccount(null, targetAccountId, true)) {
                    return false;
                }

                if (!email.equals(confirmEmail)) {
                    handler.sendSysMessage(CypherStrings.NewEmailsNotMatch);

                    return false;
                }

                var result = global.getAccountMgr().changeRegEmail(targetAccountId, email);

                switch (result) {
                    case Ok:
                        handler.sendSysMessage(CypherStrings.CommandEmail);
                        Log.outInfo(LogFilter.player, "ChangeRegEmail: Account {0} [Id: {1}] had it's Registration Email changed to {2}.", accountName, targetAccountId, email);

                        break;
                    case NameNotExist:
                        handler.sendSysMessage(CypherStrings.AccountNotExist, accountName);

                        return false;
                    case EmailTooLong:
                        handler.sendSysMessage(CypherStrings.EmailTooLong);

                        return false;
                    default:
                        handler.sendSysMessage(CypherStrings.CommandNotchangeemail);

                        return false;
                }

                return true;
            }
        }
    }
}
