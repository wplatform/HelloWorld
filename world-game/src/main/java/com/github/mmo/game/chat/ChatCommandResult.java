package com.github.mmo.game.chat;

public final class ChatCommandResult
{
	private boolean result;
// C# TO JAVA CONVERTER TASK: There is no Java equivalent to the C# 'dynamic' keyword:
	private final dynamic value;
	private String errorMessage;


	public ChatCommandResult()
	{
		this("");
	}

	public ChatCommandResult()
	{
	}

	public ChatCommandResult(String value)
	{
		result = true;
		this.value = value;
		errorMessage = null;
	}

	public boolean isSuccessful()
	{
		return result;
	}

	public boolean getHasErrorMessage()
	{
		return !errorMessage.isEmpty();
	}

	public String getErrorMessage()
	{
		return errorMessage;
	}

	public void setErrorMessage(String value)
	{
		result = false;
		errorMessage = value;
	}

	public static ChatCommandResult fromErrorMessage(String str)
	{
		var result = new ChatCommandResult();
		result.setErrorMessage(str);

        return result;
	}

// C# TO JAVA CONVERTER TASK: The following operator overload is not converted by C# to Java Converter:
//	public static implicit operator string(ChatCommandResult stringResult)
//		{
//			return stringResult.value;
//		}

	public ChatCommandResult clone()
	{
		ChatCommandResult varCopy = new ChatCommandResult();

		varCopy.result = this.result;
		varCopy.value = this.value;
		varCopy.errorMessage = this.errorMessage;

		return varCopy;
	}
}
