package com.github.mmo.game.networking.packet.query;


import java.util.*;


public class GameObjectStats
{
	public String[] name = new String[4];
	public String iconName;
	public String castBarCaption;
	public String unkString;
	public int type;
	public int displayID;
	public int[] data = new int[SharedConst.MaxGOData];
	public float size;
	public ArrayList<Integer> questItems = new ArrayList<>();
	public int contentTuningId;
}