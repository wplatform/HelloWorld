package com.github.mmo.game.chat;


@FunctionalInterface
public interface HandleCommandDelegate
{
	boolean invoke(CommandHandler handler, StringArguments args);
}
