package com.github.mmo.game.service.domain.player;


import java.util.ArrayList;

public class PlayerChoiceResponseRewardItem
{
	public int id;
	public ArrayList<Integer> bonusListIDs = new ArrayList<>();
	public int quantity;
	public PlayerChoiceResponseRewardItem()
	{
	}

	public PlayerChoiceResponseRewardItem(int id, ArrayList<Integer> bonusListIDs, int quantity)
	{
		id = id;
		bonusListIDs = bonusListIDs;
		quantity = quantity;
	}
}
