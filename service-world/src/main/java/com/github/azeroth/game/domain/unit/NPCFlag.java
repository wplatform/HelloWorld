package com.github.azeroth.game.domain.unit;

import com.github.azeroth.common.EnumFlag;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

/// Non Player Character flags
// EnumUtils: DESCRIBE THIS
@Getter
@RequiredArgsConstructor
public enum NPCFlag implements EnumFlag.FlagValue {
    NONE(0x00000000),
    GOSSIP(0x00000001),     // TITLE has gossip menu DESCRIPTION 100%
    QUEST_GIVER(0x00000002),     // TITLE is quest giver DESCRIPTION 100%
    UNK1(0x00000004),
    UNK2(0x00000008),
    TRAINER(0x00000010),     // TITLE is trainer DESCRIPTION 100%
    TRAINER_CLASS(0x00000020),     // TITLE is class trainer DESCRIPTION 100%
    TRAINER_PROFESSION(0x00000040),     // TITLE is profession trainer DESCRIPTION 100%
    VENDOR(0x00000080),     // TITLE is vendor (generic) DESCRIPTION 100%
    VENDOR_AMMO(0x00000100),     // TITLE is vendor (ammo) DESCRIPTION 100%, general goods vendor
    VENDOR_FOOD(0x00000200),     // TITLE is vendor (food) DESCRIPTION 100%
    VENDOR_POISON(0x00000400),     // TITLE is vendor (poison) DESCRIPTION guessed
    VENDOR_REAGENT(0x00000800),     // TITLE is vendor (reagents) DESCRIPTION 100%
    REPAIR(0x00001000),     // TITLE can repair DESCRIPTION 100%
    FLIGHT_MASTER(0x00002000),     // TITLE is flight master DESCRIPTION 100%
    SPIRIT_HEALER(0x00004000),     // TITLE is spirit healer
    AREA_SPIRIT_HEALER(0x00008000),     // TITLE is area spirit healer
    INNKEEPER(0x00010000),     // TITLE is innkeeper
    BANKER(0x00020000),     // TITLE is banker DESCRIPTION 100%
    PETITIONER(0x00040000),     // TITLE handles guild/arena petitions DESCRIPTION 100% 0xC0000 = guild petitions, 0x40000 = arena team petitions
    TABARD_DESIGNER(0x00080000),     // TITLE is guild tabard designer DESCRIPTION 100%
    BATTLE_MASTER(0x00100000),     // TITLE is battlemaster DESCRIPTION 100%
    AUCTIONEER(0x00200000),     // TITLE is auctioneer DESCRIPTION 100%
    STABLE_MASTER(0x00400000),     // TITLE is stable master DESCRIPTION 100%
    GUILD_BANKER(0x00800000),     // TITLE is guild banker DESCRIPTION
    SPELL_CLICK(0x01000000),     // TITLE has spell click enabled
    PLAYER_VEHICLE(0x02000000),     // TITLE is player vehicle DESCRIPTION players with mounts that have vehicle data should have it set
    MAILBOX(0x04000000),     // TITLE is mailbox
    ARTIFACT_POWER_RE_SPEC(0x08000000),     // TITLE can reset artifact powers
    TRANSMOGRIFICATION(0x10000000),     // TITLE transmogrification
    VAULT_KEEPER(0x20000000),     // TITLE is void storage
    WILD_BATTLE_PET(0x40000000),     // TITLE is wild battle pet DESCRIPTION Pet that player can fight (Battle pet)
    BLACK_MARKET(0x80000000);     // TITLE is black market

    public final int value;
}
