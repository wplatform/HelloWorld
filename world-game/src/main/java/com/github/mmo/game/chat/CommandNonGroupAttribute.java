package com.github.mmo.game.chat;


// C# TO JAVA CONVERTER TASK: Java annotations will not correspond to .NET attributes:
public class CommandNonGroupAttribute extends CommandAttribute
{

	public CommandNonGroupAttribute(String command, CypherStrings help, RBACPermissions rbac)
	{
		this(command, help, rbac, false);
	}

	public CommandNonGroupAttribute(String command, CypherStrings help, RBACPermissions rbac, boolean allowConsole)
	{
		super(command, help, rbac, allowConsole);
	}

	public CommandNonGroupAttribute(String command, RBACPermissions rbac)
	{
		this(command, rbac, false);
	}

	public CommandNonGroupAttribute(String command, RBACPermissions rbac, boolean allowConsole)
	{
		super(command, rbac, allowConsole);
	}
}
