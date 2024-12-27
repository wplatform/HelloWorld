package com.github.mmo.dbc.defines;

import com.github.mmo.common.EnumFlag;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public enum SpellShapeshiftFormFlags implements EnumFlag.FlagValue {
    Stance(0x00000001),
    NotToggleable(0x00000002),   // player cannot cancel the aura giving this shapeshift
    PersistOnDeath(0x00000004),
    CanInteractNPC(0x00000008),   // if the form does not have SHAPESHIFT_FORM_IS_NOT_A_SHAPESHIFT then this flag must be present to allow NPC interaction
    DontUseWeapon(0x00000010),

    CanUseEquippedItems(0x00000040),   // if the form does not have SHAPESHIFT_FORM_IS_NOT_A_SHAPESHIFT then this flag allows equipping items without ITEM_FLAG_USABLE_WHEN_SHAPESHIFTED
    CanUseItems(0x00000080),   // if the form does not have SHAPESHIFT_FORM_IS_NOT_A_SHAPESHIFT then this flag allows using items without ITEM_FLAG_USABLE_WHEN_SHAPESHIFTED
    DontAutoUnshift(0x00000100),   // clientside
    ConsideredDead(0x00000200),
    CanOnlyCastShapeshiftSpells(0x00000400),   // prevents using spells that don't have any shapeshift requirement
    StanceCancelsAtFlightmaster(0x00000800),
    NoEmoteSounds(0x00001000),
    NoTriggerTeleport(0x00002000),
    CannotChangeEquippedItems(0x00004000),

    CannotUseGameObjects(0x00010000);

    public final int value;
}
