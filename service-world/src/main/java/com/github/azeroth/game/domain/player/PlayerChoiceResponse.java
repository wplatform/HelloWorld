package com.github.azeroth.game.domain.player;


import com.github.azeroth.common.LocalizedString;

public class PlayerChoiceResponse {
    public int choiceId;
    public int responseID;

    public short responseIdentifier;
    public int choiceArtFileID;
    public int flags;

    public int widgetSetID;

    public int uiTextureAtlasElementID;

    public int soundKitID;

    public byte groupID;
    public int uiTextureKitID;
    public LocalizedString answer = new LocalizedString();
    public LocalizedString header = new LocalizedString();
    public LocalizedString subHeader = new LocalizedString();
    public LocalizedString buttonTooltip = new LocalizedString();
    public LocalizedString description = new LocalizedString();
    public LocalizedString confirmation = new LocalizedString();
    public PlayerChoiceResponseReward reward;

    public Integer rewardQuestID = null;
    public PlayerChoiceResponseMawPower mawPower = null;


}
