package com.github.mmo.game.domain.gossip;


import com.github.mmo.common.Locale;
import lombok.AllArgsConstructor;


@AllArgsConstructor
public class GossipMenuItemsLocale
{
	public int menuId;
	public int optionId;
	public Locale locale;
	public String optionText;
	public String boxText;
}
