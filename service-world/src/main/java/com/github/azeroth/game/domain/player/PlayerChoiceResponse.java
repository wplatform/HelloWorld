package com.github.azeroth.game.domain.player;





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
    public String answer;
    public String header;
    public String subHeader;
    public String buttonTooltip;
    public String description;
    public String confirmation;
    public PlayerChoiceResponseReward reward;

    public Integer rewardQuestID = null;
    public PlayerChoiceResponseMawPower mawPower = null;


}
