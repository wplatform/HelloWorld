package com.github.azeroth.game.domain.quest;

import com.github.azeroth.common.EnumFlag;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public
enum QuestSpecialFlag implements EnumFlag.FlagValue {
    NONE(0x000),
    // Trinity flags for set SpecialFlags in DB if required but used only at server
    REPEATABLE(0x001),   // Set by 1 in SpecialFlags from DB
    AUTO_PUSH_TO_PARTY(0x002),   // Set by 2 in SpecialFlags from DB will make quest be pushed to entire party when one member accepts it
    AUTO_ACCEPT(0x004),   // Set by 4 in SpecialFlags in DB if the quest is to be auto-accepted.
    DF_QUEST(0x008),   // Set by 8 in SpecialFlags in DB if the quest is used by Dungeon Finder.
    MONTHLY(0x010),   // Set by 16 in SpecialFlags in DB if the quest is reset at the begining of the month
    // room for more custom flags

    DB_ALLOWED(REPEATABLE.value | AUTO_PUSH_TO_PARTY.value | AUTO_ACCEPT.value | DF_QUEST.value | MONTHLY.value),

    SEQUENCED_OBJECTIVES(0x020);    // Internal flag computed only
    public final int value;
}
