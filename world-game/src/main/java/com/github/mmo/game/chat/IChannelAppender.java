package com.github.mmo.game.chat;


import com.github.mmo.game.networking.packet.ChannelNotify;

interface IChannelAppender
{
	void append(ChannelNotify data);
	ChatNotify getNotificationType();
}
