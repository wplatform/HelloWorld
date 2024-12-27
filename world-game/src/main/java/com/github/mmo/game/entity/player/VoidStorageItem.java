package com.github.mmo.game.entity.player;



import java.util.*;


public class VoidStorageItem
{
	private long itemId;
	public final long getItemId()
	{
		return itemId;
	}
	public final void setItemId(long value)
	{
		itemId = value;
	}
	private int itemEntry;
	public final int getItemEntry()
	{
		return itemEntry;
	}
	public final void setItemEntry(int value)
	{
		itemEntry = value;
	}

    private ObjectGuid creatorGuid = ObjectGuid.EMPTY;
	public final ObjectGuid getCreatorGuid()
	{
		return creatorGuid;
	}
	public VoidStorageItem(long id, int entry, ObjectGuid creator, int randomBonusListId, int fixedScalingLevel, int artifactKnowledgeLevel, ItemContext context, ArrayList<Integer> bonuses)
	{
		setItemId(id);
		setItemEntry(entry);
        setCreatorGuid(creator);
		setRandomBonusListId(randomBonusListId);
		setFixedScalingLevel(fixedScalingLevel);
		setArtifactKnowledgeLevel(artifactKnowledgeLevel);
		setContext(context);

		for (var value : bonuses)
		{
			getBonusListIDs().add(value);
		}
	}
	private int randomBonusListId;
	public final int getRandomBonusListId()
	{
		return randomBonusListId;
	}
	public final void setRandomBonusListId(int value)
	{
		randomBonusListId = value;
	}
	private int fixedScalingLevel;
	public final int getFixedScalingLevel()
	{
		return fixedScalingLevel;
	}
	public final void setFixedScalingLevel(int value)
	{
		fixedScalingLevel = value;
	}
	private int artifactKnowledgeLevel;
	public final int getArtifactKnowledgeLevel()
	{
		return artifactKnowledgeLevel;
	}
	public final void setArtifactKnowledgeLevel(int value)
	{
		artifactKnowledgeLevel = value;
	}
	private Itemcontext context = itemContext.values()[0];
	public final ItemContext getContext()
	{
		return context;
	}
	public final void setContext(ItemContext value)
	{
		context = value;
	}
	private ArrayList<Integer> bonusListIDs = new ArrayList<>();
	public final ArrayList<Integer> getBonusListIDs()
	{
		return bonusListIDs;
	}
	public final void setBonusListIDs(ArrayList<Integer> value)
	{
		bonusListIDs = value;
	}

	public final void setCreatorGuid(ObjectGuid value)
	{
        creatorGuid = value;
	}
}
