package com.github.mmo.game.networking.packet.quest;


import com.github.mmo.game.entity.object.ObjectGuid;

import java.util.*;


public class QuestGiverQuestDetails extends ServerPacket
{
    public ObjectGuid questGiverGUID = ObjectGuid.EMPTY;
    public ObjectGuid informUnit = ObjectGuid.EMPTY;
	public int questID;
	public int questPackageID;
	public int[] questFlags = new int[3];
	public int suggestedPartyMembers;
	public Questrewards rewards = new questRewards();
	public ArrayList<QuestObjectiveSimple> objectives = new ArrayList<>();
	public ArrayList<QuestDescEmote> descEmotes = new ArrayList<>();
	public ArrayList<Integer> learnSpells = new ArrayList<>();
	public int portraitTurnIn;
	public int portraitGiver;
	public int portraitGiverMount;
	public int portraitGiverModelSceneID;
	public int questStartItemID;
	public int questSessionBonus;
	public int questGiverCreatureID;
	public String portraitGiverText = "";
	public String portraitGiverName = "";
	public String portraitTurnInText = "";
	public String portraitTurnInName = "";
	public String questTitle = "";
	public String logDescription = "";
	public String descriptionText = "";
	public ArrayList<ConditionalQuestText> conditionalDescriptionText = new ArrayList<>();
	public boolean displayPopup;
	public boolean startCheat;
	public boolean autoLaunched;
	public QuestGiverQuestDetails()
	{
		super(ServerOpcode.QuestGiverQuestDetails);
	}

	@Override
	public void write()
	{
        this.writeGuid(questGiverGUID);
        this.writeGuid(informUnit);
        this.writeInt32(questID);
        this.writeInt32(questPackageID);
        this.writeInt32(portraitGiver);
        this.writeInt32(portraitGiverMount);
        this.writeInt32(portraitGiverModelSceneID);
        this.writeInt32(portraitTurnIn);
        this.writeInt32(QuestFlags[0]); // Flags
        this.writeInt32(QuestFlags[1]); // FlagsEx
        this.writeInt32(QuestFlags[2]); // FlagsEx
        this.writeInt32(suggestedPartyMembers);
        this.writeInt32(learnSpells.size());
        this.writeInt32(descEmotes.size());
        this.writeInt32(objectives.size());
        this.writeInt32(questStartItemID);
        this.writeInt32(questSessionBonus);
        this.writeInt32(questGiverCreatureID);
        this.writeInt32(conditionalDescriptionText.size());

		for (var spell : learnSpells)
		{
            this.writeInt32(spell);
		}

		for (var emote : descEmotes)
		{
            this.writeInt32(emote.type);
            this.writeInt32(emote.delay);
		}

		for (var obj : objectives)
		{
            this.writeInt32(obj.id);
            this.writeInt32(obj.objectID);
            this.writeInt32(obj.amount);
			this.writeInt8(obj.type);
		}

        this.writeBits(questTitle.GetByteCount(), 9);
        this.writeBits(descriptionText.GetByteCount(), 12);
        this.writeBits(logDescription.GetByteCount(), 12);
        this.writeBits(portraitGiverText.GetByteCount(), 10);
        this.writeBits(portraitGiverName.GetByteCount(), 8);
        this.writeBits(portraitTurnInText.GetByteCount(), 10);
        this.writeBits(portraitTurnInName.GetByteCount(), 8);
        this.writeBit(autoLaunched);
        this.writeBit(false); // unused in client
        this.writeBit(startCheat);
        this.writeBit(displayPopup);
        this.flushBits();

		rewards.write(this);

        this.writeString(questTitle);
        this.writeString(descriptionText);
        this.writeString(logDescription);
        this.writeString(portraitGiverText);
        this.writeString(portraitGiverName);
        this.writeString(portraitTurnInText);
        this.writeString(portraitTurnInName);

		for (var conditionalQuestText : conditionalDescriptionText)
		{
			conditionalQuestText.write(this);
		}
	}
}
