package com.github.mmo.game.service.domain.player;





import java.util.*;

public class PlayerChoiceResponseReward
{
	public int choiceId;
	public int responseId;
	public int titleID;
	public int packageID;
	public int skillLineID;

	public int skillPointCount;

	public int arenaPointCount;

	public int honorPointCount;

	public long money;

	public int xp;
	public ArrayList<PlayerChoiceResponseRewardEntry> items = new ArrayList<>();
	public ArrayList<PlayerChoiceResponseRewardEntry> currencies = new ArrayList<>();
	public ArrayList<PlayerChoiceResponseRewardEntry> factions = new ArrayList<>();
	public ArrayList<PlayerChoiceResponseRewardEntry> itemChoices = new ArrayList<>();

}
