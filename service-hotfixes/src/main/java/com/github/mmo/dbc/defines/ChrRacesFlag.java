package com.github.mmo.dbc.defines;

import com.github.mmo.common.EnumFlag;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public enum ChrRacesFlag implements EnumFlag.FlagValue {
    NPCOnly(0x000001),
    DoNotComponentFeet(0x000002),
    CanMount(0x000004),
    HasBald(0x000008),
    BindToStartingArea(0x000010),
    AlternateForm(0x000020),
    CanMountSelf(0x000040),
    ForceToHDModelIfAvailable(0x000080),
    ExaltedWithAllVendors(0x000100),
    NotSelectable(0x000200),
    ReputationBonus(0x000400),
    UseLoincloth(0x000800),
    RestBonus(0x001000),
    NoStartKits(0x002000),
    NoStartingWeapon(0x004000),
    DontRedeemAccountLicenses(0x008000),
    SkinVariationIsHairColor(0x010000),
    UsePandarenRingForComponentingTexture(0x020000),
    IgnoreForAssetManifestComponentInfoParsing(0x040000),
    IsAlliedRace(0x080000),
    VoidVendorDiscount(0x100000),
    DAMMComponentNoMaleGeneration(0x200000),
    DAMMComponentNoFemaleGeneration(0x400000),
    NoAssociatedFactionReputationInRaceChange(0x800000),
    InternalOnly(0x100000);

    public final int value;
}
