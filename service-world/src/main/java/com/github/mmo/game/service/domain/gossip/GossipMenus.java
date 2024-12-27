package com.github.mmo.game.service.domain.gossip;

import com.github.mmo.game.condition.*;

import java.util.*;


public class GossipMenus
{
	private int menuId;
	public final int getMenuId()
	{
		return menuId;
	}
	public final void setMenuId(int value)
	{
		menuId = value;
	}
	private int textId;
	public final int getTextId()
	{
		return textId;
	}
	public final void setTextId(int value)
	{
		textId = value;
	}
	private ArrayList<Condition> conditions = new ArrayList<>();
	public final ArrayList<Condition> getConditions()
	{
		return conditions;
	}
	public final void setConditions(ArrayList<Condition> value)
	{
		conditions = value;
	}
}
