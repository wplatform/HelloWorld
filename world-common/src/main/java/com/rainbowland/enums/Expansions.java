package com.rainbowland.enums;

public enum Expansions {
    //EXPANSION_LEVEL_CURRENT            =-1,
    EXPANSION_CLASSIC,
    EXPANSION_THE_BURNING_CRUSADE,
    EXPANSION_WRATH_OF_THE_LICH_KING,
    EXPANSION_CATACLYSM,
    EXPANSION_MISTS_OF_PANDARIA,
    EXPANSION_WARLORDS_OF_DRAENOR,
    EXPANSION_LEGION,
    EXPANSION_BATTLE_FOR_AZEROTH,
    EXPANSION_SHADOWLANDS,
    MAX_EXPANSIONS,
    MAX_ACCOUNT_EXPANSIONS;


    public int getMaxLevelForExpansion(Expansions expansion) {
        switch (expansion) {
            case EXPANSION_CLASSIC:
                return 30;
            case EXPANSION_THE_BURNING_CRUSADE:
                return 30;
            case EXPANSION_WRATH_OF_THE_LICH_KING:
                return 30;
            case EXPANSION_CATACLYSM:
                return 35;
            case EXPANSION_MISTS_OF_PANDARIA:
                return 35;
            case EXPANSION_WARLORDS_OF_DRAENOR:
                return 40;
            case EXPANSION_LEGION:
                return 45;
            case EXPANSION_BATTLE_FOR_AZEROTH:
                return 50;
            case EXPANSION_SHADOWLANDS:
                return 60;
            default:
                break;
        }
        return 0;
    }

}


