package com.github.mmo.game.chat;

public final class ChatCommandResult {
    // C# TO JAVA CONVERTER TASK: There is no Java equivalent to the C# 'dynamic' keyword:
    private final dynamic value;
    private boolean result;
    private String errorMessage;


    public ChatCommandResult() {
        this("");
    }

    public ChatCommandResult() {
    }

    public ChatCommandResult(String value) {
        result = true;
        this.value = value;
        errorMessage = null;
    }

    public static ChatCommandResult fromErrorMessage(String str) {
        var result = new ChatCommandResult();
        result.setErrorMessage(str);

        return result;
    }

    public boolean isSuccessful() {
        return result;
    }

    public boolean getHasErrorMessage() {
        return !errorMessage.isEmpty();
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String value) {
        result = false;
        errorMessage = value;
    }

// C# TO JAVA CONVERTER TASK: The following operator overload is not converted by C# to Java Converter:
//	public static implicit operator string(ChatCommandResult stringResult)
//		{
//			return stringResult.value;
//		}

    public ChatCommandResult clone() {
        ChatCommandResult varCopy = new ChatCommandResult();

        varCopy.result = this.result;
        varCopy.value = this.value;
        varCopy.errorMessage = this.errorMessage;

        return varCopy;
    }
}
