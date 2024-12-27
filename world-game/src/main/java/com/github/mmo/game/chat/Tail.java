package com.github.mmo.game.chat;

final class Tail
{
	private String str;

	public boolean isEmpty()
	{
		return str.isEmpty();
	}

// C# TO JAVA CONVERTER TASK: The following operator overload is not converted by C# to Java Converter:
//	public static implicit operator string(Tail tail)
//		{
//			return tail.str;
//		}

	public ChatCommandResult tryConsume(CommandHandler handler, String args)
	{
		str = args;

		return new ChatCommandResult(str);
	}

	public Tail clone()
	{
		Tail varCopy = new tail();

		varCopy.str = this.str;

		return varCopy;
	}
}
