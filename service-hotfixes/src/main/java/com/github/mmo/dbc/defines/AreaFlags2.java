package com.github.mmo.dbc.defines;

import com.github.mmo.common.EnumFlag;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public enum AreaFlags2 implements EnumFlag.FlagValue {
    ForceMicroDungeonArtMap(0x00000001), // Ask Programmer
    UseSubzonePlayerLoot(0x00000002),
    AllowPetBattleDuelingEvenIfNoDuelingAllowed(0x00000004),
    UseMapTransferLocsForCemeteries(0x00000008),
    IsGarrison(0x00000010),
    UseSubzoneForChatChannel(0x00000020),
    DontRealmCoalesceChatChannel(0x00000040),
    NotExplorable(0x00000080), // Don't assign area bit
    DontUseParentMapForCemeteries(0x00000100),
    DontShowSanctuaryText(0x00000200),
    CrossFactionZoneChat(0x00000400),
    ForceNoResting(0x00000800),
    AllowWarModeToggle(0x00001000);
    public final int value;
}
