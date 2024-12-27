package com.github.mmo.game.misc;


public class GossipMenuItem
{
	private int gossipOptionId;
	public final int getGossipOptionId()
	{
		return gossipOptionId;
	}
	public final void setGossipOptionId(int value)
	{
		gossipOptionId = value;
	}
	private int orderIndex;
	public final int getOrderIndex()
	{
		return orderIndex;
	}
	public final void setOrderIndex(int value)
	{
		orderIndex = value;
	}
	private GossipoptionNpc optionNpc = GossipOptionNpc.values()[0];
	public final GossipOptionNpc getOptionNpc()
	{
		return optionNpc;
	}
	public final void setOptionNpc(GossipOptionNpc value)
	{
		optionNpc = value;
	}
	private String optionText;
	public final String getOptionText()
	{
		return optionText;
	}
	public final void setOptionText(String value)
	{
		optionText = value;
	}
	private int language;
	public final int getLanguage()
	{
		return language;
	}
	public final void setLanguage(int value)
	{
		language = value;
	}
	private GossipOptionflags flags = GossipOptionFlags.values()[0];
	public final GossipOptionFlags getFlags()
	{
		return flags;
	}
	public final void setFlags(GossipOptionFlags value)
	{
		flags = value;
	}
	private Integer gossipNpcOptionId = null;
	public final Integer getGossipNpcOptionId()
	{
		return gossipNpcOptionId;
	}
	public final void setGossipNpcOptionId(Integer value)
	{
		gossipNpcOptionId = value;
	}
	private boolean boxCoded;
	public final boolean getBoxCoded()
	{
		return boxCoded;
	}
	public final void setBoxCoded(boolean value)
	{
		boxCoded = value;
	}
	private int boxMoney;
	public final int getBoxMoney()
	{
		return boxMoney;
	}
	public final void setBoxMoney(int value)
	{
		boxMoney = value;
	}
	private String boxText;
	public final String getBoxText()
	{
		return boxText;
	}
	public final void setBoxText(String value)
	{
		boxText = value;
	}
	private Integer spellId = null;
	public final Integer getSpellId()
	{
		return spellId;
	}
	public final void setSpellId(Integer value)
	{
		spellId = value;
	}
	private Integer overrideIconId = null;
	public final Integer getOverrideIconId()
	{
		return overrideIconId;
	}
	public final void setOverrideIconId(Integer value)
	{
		overrideIconId = value;
	}

	// action data
	private int actionMenuId;
	public final int getActionMenuId()
	{
		return actionMenuId;
	}
	public final void setActionMenuId(int value)
	{
		actionMenuId = value;
	}
	private int actionPoiId;
	public final int getActionPoiId()
	{
		return actionPoiId;
	}
	public final void setActionPoiId(int value)
	{
		actionPoiId = value;
	}

	// additional scripting identifiers
	private int sender;
	public final int getSender()
	{
		return sender;
	}
	public final void setSender(int value)
	{
		sender = value;
	}
	private int action;
	public final int getAction()
	{
		return action;
	}
	public final void setAction(int value)
	{
		action = value;
	}
}
