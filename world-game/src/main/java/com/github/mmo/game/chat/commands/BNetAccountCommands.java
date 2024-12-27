package com.github.mmo.game.chat.commands;


import com.github.mmo.game.chat.commandHandler;

import java.util.Objects;


// C# TO JAVA CONVERTER TASK: Java annotations will not correspond to .NET attributes:
class BNetAccountCommands
{
// C# TO JAVA CONVERTER TASK: Java annotations will not correspond to .NET attributes:
	private static boolean handleAccountCreateCommand(CommandHandler handler, String accountName, String password, Boolean createGameAccount)
	{
		if (accountName.isEmpty() || !accountName.contains('@'))
		{
			handler.sendSysMessage(CypherStrings.AccountInvalidBnetName);

			return false;
		}

		String gameAccountName;
		switch (global.getBNetAccountMgr().createBattlenetAccount(accountName, password, (createGameAccount == null ? true : createGameAccount.booleanValue()), gameAccountName))
		{
			case Ok:
				if (createGameAccount != null && createGameAccount.booleanValue())
				{
					handler.sendSysMessage(CypherStrings.AccountCreatedBnetWithGame, accountName, gameAccountName);
				}
				else
				{
					handler.sendSysMessage(CypherStrings.AccountCreated, accountName);
				}

				if (handler.getSession() != null)
				{
					Log.outInfo(LogFilter.player, "Account: {0} (IP: {1}) Character:[{2}] ({3}) created Battle.net account {4}{5}{6}", handler.getSession().getAccountId(), handler.getSession().getRemoteAddress(), handler.getSession().getPlayer().getName(), handler.getSession().getPlayer().getGUID().toString(), accountName, createGameAccount.booleanValue() ? " with game account " : "", createGameAccount.booleanValue() ? gameAccountName : "");
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
			default:
				break;
		}

		return true;
	}

// C# TO JAVA CONVERTER TASK: Java annotations will not correspond to .NET attributes:
	private static boolean handleGameAccountCreateCommand(CommandHandler handler, String bnetAccountName)
	{
		var accountId = global.getBNetAccountMgr().getId(bnetAccountName);

		if (accountId == 0)
		{
			handler.sendSysMessage(CypherStrings.AccountNotExist, bnetAccountName);

			return false;
		}

		var index = (byte)(global.getBNetAccountMgr().getMaxIndex(accountId) + 1);
		var accountName = String.valueOf(accountId) + '#' + index;

		// Generate random hex string for password, these accounts must not be logged on with GRUNT
		var randPassword = Array.<Byte>Empty().GenerateRandomKey(8);

		switch (global.getAccountMgr().createAccount(accountName, randPassword.ToHexString(), bnetAccountName, accountId, index))
		{
			case Ok:
				handler.sendSysMessage(CypherStrings.AccountCreated, accountName);

				if (handler.getSession() != null)
				{
					Log.outInfo(LogFilter.player, "Account: {0} (IP: {1}) Character:[{2}] ({3}) created Account {4} (Email: '{5}')", handler.getSession().getAccountId(), handler.getSession().getRemoteAddress(), handler.getSession().getPlayer().getName(), handler.getSession().getPlayer().getGUID().toString(), accountName, bnetAccountName);
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
	private static boolean handleAccountLinkCommand(CommandHandler handler, String bnetAccountName, String gameAccountName)
	{
		switch (global.getBNetAccountMgr().linkWithGameAccount(bnetAccountName, gameAccountName))
		{
			case Ok:
				handler.sendSysMessage(CypherStrings.AccountBnetLinked, bnetAccountName, gameAccountName);

				break;
			case NameNotExist:
				handler.sendSysMessage(CypherStrings.AccountOrBnetDoesNotExist, bnetAccountName, gameAccountName);

				break;
			case BadLink:
				handler.sendSysMessage(CypherStrings.AccountAlreadyLinked, gameAccountName);

				break;
			default:
				break;
		}

		return true;
	}

// C# TO JAVA CONVERTER TASK: Java annotations will not correspond to .NET attributes:
	private static boolean handleListGameAccountsCommand(CommandHandler handler, String battlenetAccountName)
	{
		var stmt = DB.Login.GetPreparedStatement(LoginStatements.SEL_BNET_GAME_ACCOUNT_LIST);
		stmt.AddValue(0, battlenetAccountName);

		var accountList = DB.Login.query(stmt);

		if (!accountList.isEmpty())
		{
			var formatDisplayName = (String arg) ->
			{
					var index = name.indexOf('#');

					if (index > 0)
					{
						return "WoW" + name[++index..];
					}
					else
					{
						return name;
					}
			};

			handler.sendSysMessage("----------------------------------------------------");
			handler.sendSysMessage(CypherStrings.AccountBnetListHeader);
			handler.sendSysMessage("----------------------------------------------------");

			do
			{
				handler.sendSysMessage("| {0,10} | {1,16} | {2,16} |", accountList.<Integer>Read(0), accountList.<String>Read(1), formatDisplayName.invoke(accountList.<String>Read(1)));
			} while (accountList.NextRow());

			handler.sendSysMessage("----------------------------------------------------");
		}
		else
		{
			handler.sendSysMessage(CypherStrings.AccountBnetListNoAccounts, battlenetAccountName);
		}

		return true;
	}

// C# TO JAVA CONVERTER TASK: Java annotations will not correspond to .NET attributes:
	private static boolean handleAccountPasswordCommand(CommandHandler handler, String oldPassword, String newPassword, String passwordConfirmation)
	{
		// We compare the old, saved password to the entered old password - no chance for the unauthorized.
		if (!global.getBNetAccountMgr().checkPassword(handler.getSession().getBattlenetAccountId(), oldPassword))
		{
			handler.sendSysMessage(CypherStrings.CommandWrongoldpassword);

			Log.outInfo(LogFilter.player, "Battle.net account: {0} (IP: {1}) Character:[{2}] ({3}) Tried to change password, but the provided old password is wrong.", handler.getSession().getBattlenetAccountId(), handler.getSession().getRemoteAddress(), handler.getSession().getPlayer().getName(), handler.getSession().getPlayer().getGUID().toString());

			return false;
		}

		// Making sure that newly entered password is correctly entered.
		if (!Objects.equals(newPassword, passwordConfirmation))
		{
			handler.sendSysMessage(CypherStrings.NewPasswordsNotMatch);

			return false;
		}

		// Changes password and prints result.
		var result = global.getBNetAccountMgr().changePassword(handler.getSession().getBattlenetAccountId(), newPassword);

		switch (result)
		{
			case Ok:
				handler.sendSysMessage(CypherStrings.CommandPassword);

				Log.outInfo(LogFilter.player, "Battle.net account: {0} (IP: {1}) Character:[{2}] ({3}) Changed password.", handler.getSession().getBattlenetAccountId(), handler.getSession().getRemoteAddress(), handler.getSession().getPlayer().getName(), handler.getSession().getPlayer().getGUID().toString());

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
	private static boolean handleAccountUnlinkCommand(CommandHandler handler, String gameAccountName)
	{
		switch (global.getBNetAccountMgr().unlinkGameAccount(gameAccountName))
		{
			case Ok:
				handler.sendSysMessage(CypherStrings.AccountBnetUnlinked, gameAccountName);

				break;
			case NameNotExist:
				handler.sendSysMessage(CypherStrings.AccountNotExist, gameAccountName);

				break;
			case BadLink:
				handler.sendSysMessage(CypherStrings.AccountBnetNotLinked, gameAccountName);

				break;
			default:
				break;
		}

		return true;
	}

// C# TO JAVA CONVERTER TASK: Java annotations will not correspond to .NET attributes:
	private static class AccountLockCommands
	{
// C# TO JAVA CONVERTER TASK: Java annotations will not correspond to .NET attributes:
		private static boolean handleAccountLockCountryCommand(CommandHandler handler, boolean state)
		{
			/*if (state)
			{
				if (IpLocationRecord const* location = sIPLocation->GetLocationRecord(handler->GetSession()->GetRemoteAddress()))
		{
					LoginDatabasePreparedStatement* stmt = DB.Login.GetPreparedStatement(LOGIN_UPD_BNET_ACCOUNT_LOCK_CONTRY);
					stmt->setString(0, location->CountryCode);
					stmt->setUInt32(1, handler->GetSession()->GetBattlenetAccountId());
					LoginDatabase.execute(stmt);
					handler->PSendSysMessage(LANG_COMMAND_ACCLOCKLOCKED);
				}
		else
				{
					handler->PSendSysMessage("IP2Location] No information");
					TC_LOG_DEBUG("server.bnetserver", "IP2Location] No information");
				}
			}
			else
			{
				LoginDatabasePreparedStatement* stmt = DB.Login.GetPreparedStatement(LOGIN_UPD_BNET_ACCOUNT_LOCK_CONTRY);
				stmt->setString(0, "00");
				stmt->setUInt32(1, handler->GetSession()->GetBattlenetAccountId());
				LoginDatabase.execute(stmt);
				handler->PSendSysMessage(LANG_COMMAND_ACCLOCKUNLOCKED);
			}
			*/
			return true;
		}

// C# TO JAVA CONVERTER TASK: Java annotations will not correspond to .NET attributes:
		private static boolean handleAccountLockIpCommand(CommandHandler handler, boolean state)
		{
			var stmt = DB.Login.GetPreparedStatement(LoginStatements.UPD_BNET_ACCOUNT_LOCK);

			if (state)
			{
				stmt.AddValue(0, true); // locked
				handler.sendSysMessage(CypherStrings.CommandAcclocklocked);
			}
			else
			{
				stmt.AddValue(0, false); // unlocked
				handler.sendSysMessage(CypherStrings.CommandAcclockunlocked);
			}

			stmt.AddValue(1, handler.getSession().getBattlenetAccountId());

			DB.Login.execute(stmt);

			return true;
		}
	}

// C# TO JAVA CONVERTER TASK: Java annotations will not correspond to .NET attributes:
	private static class AccountSetCommands
	{
// C# TO JAVA CONVERTER TASK: Java annotations will not correspond to .NET attributes:
		private static boolean handleAccountSetPasswordCommand(CommandHandler handler, String accountName, String password, String passwordConfirmation)
		{
			var targetAccountId = global.getBNetAccountMgr().getId(accountName);

			if (targetAccountId == 0)
			{
				handler.sendSysMessage(CypherStrings.AccountNotExist, accountName);

				return false;
			}

			if (!Objects.equals(password, passwordConfirmation))
			{
				handler.sendSysMessage(CypherStrings.NewPasswordsNotMatch);

				return false;
			}

			var result = global.getBNetAccountMgr().changePassword(targetAccountId, password);

			switch (result)
			{
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
					break;
			}

			return true;
		}
	}
}
