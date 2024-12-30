package com.github.mmo.game.service.model.quest;


import com.github.mmo.common.EnumFlag;
import com.github.mmo.common.LocalizedString;

public class QuestObjective {
    public int id;
    public int questID;
    public QuestObjectiveType type;
    public byte storageIndex;
    public int objectID;
    public int amount;
    public EnumFlag<QuestObjectiveFlag> flags;
    public int flags2;
    public float progressBarWeight;
    public LocalizedString description;
    public int[] visualEffects;

    public final boolean isStoringValue() {
        switch (type) {
            case MONSTER:
            case ITEM:
            case GAME_OBJECT:
            case TALK_TO:
            case PLAYER_KILLS:
            case WIN_PVP_PET_BATTLES:
            case HAVE_CURRENCY:
            case OBTAIN_CURRENCY:
            case INCREASE_REPUTATION:
                return true;
            default:
                break;
        }

        return false;
    }

    public final boolean isStoringFlag() {
        switch (type) {
            case AREA_TRIGGER:
            case WIN_PET_BATTLE_AGAINST_NPC:
            case DEFEAT_BATTLE_PET:
            case CRITERIA_TREE:
            case AREA_TRIGGER_ENTER:
            case AREA_TRIGGER_EXIT:
                return true;
            default:
                break;
        }

        return false;
    }

    public static boolean canAlwaysBeProgressedInRaid(QuestObjectiveType type) {
        switch (type) {
            case ITEM:
            case CURRENCY:
            case LEARN_SPELL:
            case MIN_REPUTATION:
            case MAX_REPUTATION:
            case MONEY:
            case HAVE_CURRENCY:
            case INCREASE_REPUTATION:
                return true;
            default:
                break;
        }

        return false;
    }
}
