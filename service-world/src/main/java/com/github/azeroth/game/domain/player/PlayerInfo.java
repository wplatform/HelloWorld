package com.github.azeroth.game.domain.player;



import com.github.azeroth.dbc.defines.ItemContext;
import com.github.azeroth.game.domain.PlayerCreateInfoAction;
import com.github.azeroth.game.domain.PlayerCreateInfoItem;

import java.util.*;


public class PlayerInfo
{
	public CreatePositionModel createPosition = new CreatePositionModel();
	public CreatePositionModel createPositionNpe = null;

	private ItemContext itemContext = getItemContext().values()[0];
	public final ItemContext getItemContext()
	{
		return itemContext;
	}
	public final void setItemContext(ItemContext value)
	{
		itemContext = value;
	}
	private ArrayList<PlayerCreateInfoItem> items = new ArrayList<>();
	public final ArrayList<PlayerCreateInfoItem> getItems()
	{
		return items;
	}
	public final void setItems(ArrayList<PlayerCreateInfoItem> value)
	{
		items = value;
	}
	private HashSet<Integer> customSpells = new HashSet<Integer>();
	public final HashSet<Integer> getCustomSpells()
	{
		return customSpells;
	}
	public final void setCustomSpells(HashSet<Integer> value)
	{
		customSpells = value;
	}
	private ArrayList<Integer>[] castSpells = new ArrayList<Integer>[PlayerCreateMode.max.getValue()];
	public final ArrayList<Integer>[] getCastSpells()
	{
		return castSpells;
	}
	public final void setCastSpells(ArrayList<Integer>[] value)
	{
		castSpells = value;
	}
	private ArrayList<PlayerCreateInfoAction> actions = new ArrayList<>();
	public final ArrayList<PlayerCreateInfoAction> getActions()
	{
		return actions;
	}
	public final void setActions(ArrayList<PlayerCreateInfoAction> value)
	{
		actions = value;
	}
	private ArrayList<SkillRaceClassInfoRecord> skills = new ArrayList<>();
	public final ArrayList<SkillRaceClassInfoRecord> getSkills()
	{
		return skills;
	}
	public final void setSkills(ArrayList<SkillRaceClassInfoRecord> value)
	{
		skills = value;
	}

	private Integer introMovieId = null;
	public final Integer getIntroMovieId()
	{
		return introMovieId;
	}
	public final void setIntroMovieId(Integer value)
	{
		introMovieId = value;
	}
	private Integer introSceneId = null;
	public final Integer getIntroSceneId()
	{
		return introSceneId;
	}
	public final void setIntroSceneId(Integer value)
	{
		introSceneId = value;
	}
	private Integer introSceneIdNpe = null;
	public final Integer getIntroSceneIdNpe()
	{
		return introSceneIdNpe;
	}
	public final void setIntroSceneIdNpe(Integer value)
	{
		introSceneIdNpe = value;
	}

	private PlayerlevelInfo[] levelInfo = new PlayerLevelInfo[WorldConfig.getIntValue(WorldCfg.MaxPlayerLevel)];
	public final PlayerLevelInfo[] getLevelInfo()
	{
		return levelInfo;
	}
	public final void setLevelInfo(PlayerLevelInfo[] value)
	{
		levelInfo = value;
	}

	public PlayerInfo()
	{
		for (var i = 0; i < getCastSpells().length; ++i)
		{
			getCastSpells()[i] = new ArrayList<>();
		}

		for (var i = 0; i < getLevelInfo().length; ++i)
		{
			getLevelInfo()[i] = new PlayerLevelInfo();
		}
	}

	public final static class CreatePositionModel
	{
		public Worldlocation loc;
		public Long transportGuid = null;


	}
}
