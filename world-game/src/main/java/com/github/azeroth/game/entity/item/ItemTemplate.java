package com.github.azeroth.game.entity.item;


import com.github.azeroth.game.entity.item.enums.*;
import com.github.azeroth.game.entity.player.Player;

import java.util.ArrayList;
import java.util.BitSet;
import java.util.Locale;


public class ItemTemplate {
    private static final SkillType[] ITEMWEAPONSKILLS = {SkillType.Axes, SkillType.TwoHandedAxes, SkillType.Bows, SkillType.Guns, SkillType.Maces, SkillType.TwoHandedMaces, SkillType.Polearms, SkillType.Swords, SkillType.TwoHandedSwords, SkillType.Warglaives, SkillType.Staves, 0, 0, SkillType.FistWeapons, 0, SkillType.Daggers, 0, 0, SkillType.Crossbows, SkillType.Wands, SkillType.ClassicFishing};

    private static final SkillType[] ITEMARMORSKILLS = {0, SkillType.Cloth, SkillType.Leather, SkillType.MAIL, SkillType.PlateMail, 0, SkillType.Shield, 0, 0, 0, 0, 0};

    private static final SkillType[] ITEMPROFESSIONSKILLS = {SkillType.Blacksmithing, SkillType.Leatherworking, SkillType.Alchemy, SkillType.Herbalism, SkillType.Cooking, SkillType.Mining, SkillType.Tailoring, SkillType.Engineering, SkillType.Enchanting, SkillType.FISHING, SkillType.SKINNING, SkillType.Jewelcrafting, SkillType.Inscription, SkillType.Archaeology};

    private final SkillType[] itemProfessionSkills = {SkillType.Blacksmithing, SkillType.Leatherworking, SkillType.Alchemy, SkillType.Herbalism, SkillType.Cooking, SkillType.ClassicBlacksmithing, SkillType.ClassicLeatherworking, SkillType.ClassicAlchemy, SkillType.ClassicHerbalism, SkillType.ClassicCooking, SkillType.Mining, SkillType.Tailoring, SkillType.Engineering, SkillType.Enchanting, SkillType.FISHING, SkillType.ClassicMining, SkillType.ClassicTailoring, SkillType.ClassicEngineering, SkillType.ClassicEnchanting, SkillType.ClassicFishing, SkillType.SKINNING, SkillType.Jewelcrafting, SkillType.Inscription, SkillType.Archaeology, SkillType.ClassicSkinning, SkillType.ClassicJewelcrafting, SkillType.ClassicInscription};

    private int maxDurability;
    private ArrayList<ItemEffectRecord> effects = new ArrayList<>();
    // extra fields, not part of db2 files
    private int scriptId;
    private int foodType;
    private int minMoneyLoot;
    private int maxMoneyLoot;
    private ItemflagsCustom flagsCu = ItemFlagsCustom.values()[0];
    private float spellPPMRate;
    private int randomBonusListTemplateId;
    private BitSet[] specializations = new BitSet[3];
    private int itemSpecClassMask;
    private ItemRecord basicData;
    private ItemSparseRecord extendedData;

    public ItemTemplate(ItemRecord item, ItemSparseRecord sparse) {
        setBasicData(item);
        setExtendedData(sparse);

        getSpecializations()[0] = new bitSet(playerClass.max.getValue() * PlayerConst.MaxSpecializations);
        getSpecializations()[1] = new bitSet(playerClass.max.getValue() * PlayerConst.MaxSpecializations);
        getSpecializations()[2] = new bitSet(playerClass.max.getValue() * PlayerConst.MaxSpecializations);
    }

    public static int calculateItemSpecBit(ChrSpecializationRecord spec) {
        return (int) ((spec.ClassID - 1) * PlayerConst.MaxSpecializations + spec.orderIndex);
    }

    public final int getMaxDurability() {
        return maxDurability;
    }

    public final void setMaxDurability(int value) {
        maxDurability = value;
    }

    public final ArrayList<ItemEffectRecord> getEffects() {
        return effects;
    }

    public final void setEffects(ArrayList<ItemEffectRecord> value) {
        effects = value;
    }

    public final int getScriptId() {
        return scriptId;
    }

    public final void setScriptId(int value) {
        scriptId = value;
    }

    public final int getFoodType() {
        return foodType;
    }

    public final void setFoodType(int value) {
        foodType = value;
    }

    public final int getMinMoneyLoot() {
        return minMoneyLoot;
    }

    public final void setMinMoneyLoot(int value) {
        minMoneyLoot = value;
    }

    public final int getMaxMoneyLoot() {
        return maxMoneyLoot;
    }

    public final void setMaxMoneyLoot(int value) {
        maxMoneyLoot = value;
    }

    public final ItemFlagsCustom getFlagsCu() {
        return flagsCu;
    }

    public final void setFlagsCu(ItemFlagsCustom value) {
        flagsCu = value;
    }

    public final float getSpellPPMRate() {
        return spellPPMRate;
    }

    public final void setSpellPPMRate(float value) {
        spellPPMRate = value;
    }

    public final int getRandomBonusListTemplateId() {
        return randomBonusListTemplateId;
    }

    public final void setRandomBonusListTemplateId(int value) {
        randomBonusListTemplateId = value;
    }

    public final BitSet[] getSpecializations() {
        return specializations;
    }

    public final void setSpecializations(BitSet[] value) {
        specializations = value;
    }

    public final int getItemSpecClassMask() {
        return itemSpecClassMask;
    }

    public final void setItemSpecClassMask(int value) {
        itemSpecClassMask = value;
    }

    protected final ItemRecord getBasicData() {
        return basicData;
    }

    protected final void setBasicData(ItemRecord value) {
        basicData = value;
    }

    protected final ItemSparseRecord getExtendedData() {
        return extendedData;
    }

    protected final void setExtendedData(ItemSparseRecord value) {
        extendedData = value;
    }

    public final boolean getHasSignature() {
        return getMaxStackSize() == 1 && getClass() != itemClass.Consumable && getClass() != itemClass.Quest && !hasFlag(ItemFlags.NoCreator) && getId() != 6948;
    }

    public final int getId() {
        return getBasicData().id;
    }

    public final ItemClass getClass() {
        return getBasicData().classID;
    }

    public final int getSubClass() {
        return getBasicData().SubclassID;
    }

    public final ItemQuality getQuality() {
        return itemQuality.forValue(getExtendedData().OverallQualityID);
    }

    public final int getOtherFactionItemId() {
        return getExtendedData().FactionRelated;
    }

    public final float getPriceRandomValue() {
        return getExtendedData().PriceRandomValue;
    }

    public final float getPriceVariance() {
        return getExtendedData().PriceVariance;
    }

    public final int getBuyCount() {
        return Math.max(getExtendedData().VendorStackCount, 1);
    }

    public final int getBuyPrice() {
        return getExtendedData().BuyPrice;
    }

    public final int getSellPrice() {
        return getExtendedData().SellPrice;
    }

    public final InventoryType getInventoryType() {
        return getExtendedData().inventoryType;
    }

    public final int getAllowableClass() {
        return getExtendedData().AllowableClass;
    }

    public final long getAllowableRace() {
        return getExtendedData().AllowableRace;
    }

    public final int getBaseItemLevel() {
        return getExtendedData().itemLevel;
    }

    public final int getBaseRequiredLevel() {
        return getExtendedData().requiredLevel;
    }

    public final int getRequiredSkill() {
        return getExtendedData().RequiredSkill;
    }

    public final int getRequiredSkillRank() {
        return getExtendedData().RequiredSkillRank;
    }

    public final int getRequiredSpell() {
        return getExtendedData().RequiredAbility;
    }

    public final int getRequiredReputationFaction() {
        return getExtendedData().MinFactionID;
    }

    public final int getRequiredReputationRank() {
        return getExtendedData().MinReputation;
    }

    public final int getMaxCount() {
        return getExtendedData().maxCount;
    }

    public final int getContainerSlots() {
        return getExtendedData().ContainerSlots;
    }

    public final int getScalingStatContentTuning() {
        return getExtendedData().contentTuningID;
    }

    public final int getPlayerLevelToItemLevelCurveId() {
        return getExtendedData().PlayerLevelToItemLevelCurveID;
    }

    public final int getDamageType() {
        return getExtendedData().DamageType;
    }

    public final int getDelay() {
        return getExtendedData().ItemDelay;
    }

    public final float getRangedModRange() {
        return getExtendedData().ItemRange;
    }

    public final ItemBondingType getBonding() {
        return ItemBondingType.forValue(getExtendedData().bonding);
    }

    public final int getPageText() {
        return getExtendedData().PageID;
    }

    public final int getStartQuest() {
        return getExtendedData().StartQuestID;
    }

    public final int getLockID() {
        return getExtendedData().LockID;
    }

    public final int getItemSet() {
        return getExtendedData().ItemSet;
    }

    public final int getMap() {
        return getExtendedData().InstanceBound;
    }

    public final BagFamilyMask getBagFamily() {
        return BagFamilyMask.forValue(getExtendedData().BagFamily);
    }

    public final int getTotemCategory() {
        return getExtendedData().TotemCategoryID;
    }

    public final int getSocketBonus() {
        return getExtendedData().SocketMatchEnchantmentId;
    }

    public final int getGemProperties() {
        return getExtendedData().GemProperties;
    }

    public final float getQualityModifier() {
        return getExtendedData().QualityModifier;
    }

    public final int getDuration() {
        return getExtendedData().DurationInInventory;
    }

    public final int getItemLimitCategory() {
        return getExtendedData().limitCategory;
    }

    public final HolidayIds getHolidayID() {
        return HolidayIds.forValue(getExtendedData().RequiredHoliday);
    }

    public final float getDmgVariance() {
        return getExtendedData().DmgVariance;
    }

    public final byte getArtifactID() {
        return getExtendedData().ArtifactID;
    }

    public final byte getRequiredExpansion() {
        return (byte) getExtendedData().ExpansionID;
    }

    public final boolean isCurrencyToken() {
        return (getBagFamily().getValue() & BagFamilyMask.CurrencyTokens.getValue()) != 0;
    }

    public final int getMaxStackSize() {
        return (getExtendedData().Stackable == 2147483647 || getExtendedData().Stackable <= 0) ? (0x7FFFFFFF - 1) : getExtendedData().Stackable;
    }

    public final boolean isPotion() {
        return getClass() == itemClass.Consumable && getSubClass() == (int) ItemSubClassConsumable.Potion.getValue();
    }

    public final boolean isVellum() {
        return hasFlag(ItemFlags3.CanStoreEnchants);
    }

    public final boolean isConjuredConsumable() {
        return getClass() == itemClass.Consumable && hasFlag(ItemFlags.Conjured);
    }

    public final boolean isCraftingReagent() {
        return hasFlag(ItemFlags2.UsedInATradeskill);
    }

    public final boolean isWeapon() {
        return getClass() == itemClass.Weapon;
    }

    public final boolean isArmor() {
        return getClass() == itemClass.armor;
    }

    public final boolean isRangedWeapon() {
        return isWeapon() && (getSubClass() == (int) ItemSubClassWeapon.Bow.getValue() || getSubClass() == (int) ItemSubClassWeapon.Gun.getValue() || getSubClass() == (int) ItemSubClassWeapon.Crossbow.getValue());
    }

    public final String getName() {
        return getName(SharedConst.DefaultLocale);
    }

    public final String getName(Locale locale) {
        return getExtendedData().display.get(locale);
    }

    public final boolean hasFlag(ItemFlag flag) {
        return (getExtendedData().Flags[0] & flag.getValue()) != 0;
    }

    public final boolean hasFlag(ItemFlag2 flag) {
        return (getExtendedData().Flags[1] & flag.getValue()) != 0;
    }

    public final boolean hasFlag(ItemFlag3 flag) {
        return (getExtendedData().Flags[2] & flag.getValue()) != 0;
    }

    public final boolean hasFlag(ItemFlag4 flag) {
        return (getExtendedData().Flags[3] & flag.getValue()) != 0;
    }

    public final boolean hasFlag(ItemFlagsCustom customFlag) {
        return (getFlagsCu().getValue() & customFlag.getValue()) != 0;
    }

    public final boolean canChangeEquipStateInCombat() {
        switch (getInventoryType()) {
            case Relic:
            case Shield:
            case Holdable:
                return true;
            default:
                break;
        }

        switch (getClass()) {
            case Weapon:
            case Projectile:
                return true;
        }

        return false;
    }

    public final SkillType getSkill() {
        switch (getClass()) {
            case Weapon:
                if (getSubClass() >= ItemSubClassWeapon.max.getValue()) {
                    return 0;
                } else {
                    return ItemWeaponSkills[getSubClass()];
                }
            case Armor:
                if (getSubClass() >= ItemSubClassArmor.max.getValue()) {
                    return 0;
                } else {
                    return ItemArmorSkills[getSubClass()];
                }

            case Profession:

                if (ConfigMgr.GetDefaultValue("Professions.AllowClassicProfessionSlots", false)) {
                    if (getSubClass() >= ItemSubclassProfession.max.getValue()) {
                        return 0;
                    } else {
                        return _itemProfessionSkills[getSubClass()];
                    }
                } else if (getSubClass() >= ItemSubclassProfession.max.getValue()) {
                    return 0;
                } else {
                    return ItemProfessionSkills[getSubClass()];
                }

            default:
                return 0;
        }
    }

    public final int getArmor(int itemLevel) {
        var quality = getQuality() != itemQuality.Heirloom ? getQuality() : itemQuality.Rare;

        if (quality.getValue() > itemQuality.artifact.getValue()) {
            return 0;
        }

        // all items but shields
        if (getClass() != itemClass.armor || getSubClass() != (int) ItemSubClassArmor.Shield.getValue()) {
            var armorQuality = CliDB.ItemArmorQualityStorage.get(itemLevel);
            var armorTotal = CliDB.ItemArmorTotalStorage.get(itemLevel);

            if (armorQuality == null || armorTotal == null) {
                return 0;
            }

            var inventoryType = getInventoryType();

            if (inventoryType == inventoryType.Robe) {
                inventoryType = inventoryType.chest;
            }

            var location = CliDB.ArmorLocationStorage.get(inventoryType);

            if (location == null) {
                return 0;
            }

            if (getSubClass() < (int) ItemSubClassArmor.Cloth.getValue() || getSubClass() > (int) ItemSubClassArmor.Plate.getValue()) {
                return 0;
            }

            var total = 1.0f;
            var locationModifier = 1.0f;

            switch (ItemSubClassArmor.forValue(getSubClass())) {
                case Cloth:
                    total = armorTotal.Cloth;
                    locationModifier = location.Clothmodifier;

                    break;
                case Leather:
                    total = armorTotal.Leather;
                    locationModifier = location.Leathermodifier;

                    break;
                case Mail:
                    total = armorTotal.MAIL;
                    locationModifier = location.Chainmodifier;

                    break;
                case Plate:
                    total = armorTotal.Plate;
                    locationModifier = location.Platemodifier;

                    break;
                default:
                    break;
            }

            return (int) (armorQuality.QualityMod[quality.getValue()] * total * locationModifier + 0.5f);
        }

        // shields
        var shield = CliDB.ItemArmorShieldStorage.get(itemLevel);

        if (shield == null) {
            return 0;
        }

        return (int) (shield.Quality[quality.getValue()] + 0.5f);
    }

    public final float getDPS(int itemLevel) {
        var quality = getQuality() != itemQuality.Heirloom ? getQuality() : itemQuality.Rare;

        if (getClass() != itemClass.Weapon || quality.getValue() > itemQuality.artifact.getValue()) {
            return 0.0f;
        }

        var dps = 0.0f;

        switch (getInventoryType()) {
            case Ammo:
                dps = CliDB.ItemDamageAmmoStorage.get(itemLevel).Quality[quality.getValue()];

                break;
            case Weapon2Hand:
                if (hasFlag(ItemFlags2.CasterWeapon)) {
                    dps = CliDB.ItemDamageTwoHandCasterStorage.get(itemLevel).Quality[quality.getValue()];
                } else {
                    dps = CliDB.ItemDamageTwoHandStorage.get(itemLevel).Quality[quality.getValue()];
                }

                break;
            case Ranged:
            case Thrown:
            case RangedRight:
                switch (ItemSubClassWeapon.forValue(getSubClass())) {
                    case Wand:
                        dps = CliDB.ItemDamageOneHandCasterStorage.get(itemLevel).Quality[quality.getValue()];

                        break;
                    case Bow:
                    case Gun:
                    case Crossbow:
                        if (hasFlag(ItemFlags2.CasterWeapon)) {
                            dps = CliDB.ItemDamageTwoHandCasterStorage.get(itemLevel).Quality[quality.getValue()];
                        } else {
                            dps = CliDB.ItemDamageTwoHandStorage.get(itemLevel).Quality[quality.getValue()];
                        }

                        break;
                    default:
                        break;
                }

                break;
            case Weapon:
            case WeaponMainhand:
            case WeaponOffhand:
                if (hasFlag(ItemFlags2.CasterWeapon)) {
                    dps = CliDB.ItemDamageOneHandCasterStorage.get(itemLevel).Quality[quality.getValue()];
                } else {
                    dps = CliDB.ItemDamageOneHandStorage.get(itemLevel).Quality[quality.getValue()];
                }

                break;
            default:
                break;
        }

        return dps;
    }

    public final void getDamage(int itemLevel, tangible.OutObject<Float> minDamage, tangible.OutObject<Float> maxDamage) {
        minDamage.outArgValue = maxDamage.outArgValue = 0.0f;
        var dps = getDPS(itemLevel);

        if (dps > 0.0f) {
            var avgDamage = dps * getDelay() * 0.001f;
            minDamage.outArgValue = (getDmgVariance() * -0.5f + 1.0f) * avgDamage;
            maxDamage.outArgValue = (float) Math.floor(avgDamage * (getDmgVariance() * 0.5f + 1.0f) + 0.5f);
        }
    }

    public final boolean isUsableByLootSpecialization(Player player, boolean alwaysAllowBoundToAccount) {
        if (hasFlag(ItemFlags.IsBoundToAccount) && alwaysAllowBoundToAccount) {
            return true;
        }

        var spec = player.getLootSpecId();

        if (spec == 0) {
            spec = player.getPrimarySpecialization();
        }

        if (spec == 0) {
            spec = player.getDefaultSpecId();
        }

        var chrSpecialization = CliDB.ChrSpecializationStorage.get(spec);

        if (chrSpecialization == null) {
            return false;
        }

        var levelIndex = 0;

        if (player.getLevel() >= 110) {
            levelIndex = 2;
        } else if (player.getLevel() > 40) {
            levelIndex = 1;
        }

        return getSpecializations()[levelIndex].Get(calculateItemSpecBit(chrSpecialization));
    }

    public final int getStatModifierBonusStat(int index) {
        return getExtendedData().StatModifierBonusStat[index];
    }

    public final int getStatPercentEditor(int index) {
        return getExtendedData().StatPercentEditor[index];
    }

    public final float getStatPercentageOfSocket(int index) {
        return getExtendedData().StatPercentageOfSocket[index];
    }

    public final int getArea(int index) {
        return getExtendedData().ZoneBound[index];
    }

    public final SocketColor getSocketColor(int index) {
        return SocketColor.forValue(getExtendedData().SocketType[index]);
    }
}
