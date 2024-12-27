package com.github.mmo.dbc.defines;

import com.github.mmo.common.EnumFlag;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public enum SkillLineFlags implements EnumFlag.FlagValue {
    AlwaysShownInUI(0x0001),
    NeverShownInUI(0x0002),
    FirstTierIsSelfTaught(0x0004),
    GrantedIncrementallyByCharacterUpgrade(0x0008),
    AutomaticRank(0x0010),
    InheritParentRankWhenLearned(0x0020),
    ShowsInSpellTooltip(0x0040),
    AppearsInMiscTabOfSpellbook(0x0080),
    // unused                                       (0x0100),
    IgnoreCategoryMods(0x0200),
    DisplaysAsProficiency(0x0400),
    PetsOnly(0x0800),
    UniqueBitfield(0x1000),
    RacialForThePurposeOfPaidRaceOrFactionChange(0x2000),
    ProgressiveSkillUp(0x4000),
    RacialForThePurposeOfTemporaryRaceChange(0x8000);

    public final int value;
}
