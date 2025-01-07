package com.github.azeroth.game;


class ItemSpecStats {
    public int itemType;
    public ItemSpecStat[] itemSpecStatTypes = new ItemSpecStat[ItemConst.MaxStats];
    public int itemSpecStatCount;

    public ItemSpecStats(ItemRecord item, ItemSparseRecord sparse) {
        if (item.classID == itemClass.Weapon) {
            itemType = 5;

            switch (ItemSubClassWeapon.forValue(item.SubclassID)) {
                case Axe:
                    addStat(ItemSpecStat.OneHandedAxe);

                    break;
                case Axe2:
                    addStat(ItemSpecStat.TwoHandedAxe);

                    break;
                case Bow:
                    addStat(ItemSpecStat.Bow);

                    break;
                case Gun:
                    addStat(ItemSpecStat.Gun);

                    break;
                case Mace:
                    addStat(ItemSpecStat.OneHandedMace);

                    break;
                case Mace2:
                    addStat(ItemSpecStat.TwoHandedMace);

                    break;
                case Polearm:
                    addStat(ItemSpecStat.Polearm);

                    break;
                case Sword:
                    addStat(ItemSpecStat.OneHandedSword);

                    break;
                case Sword2:
                    addStat(ItemSpecStat.TwoHandedSword);

                    break;
                case Warglaives:
                    addStat(ItemSpecStat.Warglaives);

                    break;
                case Staff:
                    addStat(ItemSpecStat.Staff);

                    break;
                case Fist:
                    addStat(ItemSpecStat.FistWeapon);

                    break;
                case Dagger:
                    addStat(ItemSpecStat.Dagger);

                    break;
                case Thrown:
                    addStat(ItemSpecStat.Thrown);

                    break;
                case Crossbow:
                    addStat(ItemSpecStat.Crossbow);

                    break;
                case Wand:
                    addStat(ItemSpecStat.wand);

                    break;
                default:
                    break;
            }
        } else if (item.classID == itemClass.armor) {
            switch (ItemSubClassArmor.forValue(item.SubclassID)) {
                case Cloth:
                    if (sparse.inventoryType != inventoryType.Cloak) {
                        itemType = 1;

                        break;
                    }

                    itemType = 0;
                    addStat(ItemSpecStat.Cloak);

                    break;
                case Leather:
                    itemType = 2;

                    break;
                case Mail:
                    itemType = 3;

                    break;
                case Plate:
                    itemType = 4;

                    break;
                default:
                    if (item.SubclassID == ItemSubClassArmor.Shield.getValue()) {
                        itemType = 6;
                        addStat(ItemSpecStat.Shield);
                    } else if (item.SubclassID > ItemSubClassArmor.Shield.getValue() && item.SubclassID <= ItemSubClassArmor.Relic.getValue()) {
                        itemType = 6;
                        addStat(ItemSpecStat.Relic);
                    } else {
                        itemType = 0;
                    }

                    break;
            }
        } else if (item.classID == itemClass.Gem) {
            itemType = 7;
            var gem = CliDB.GemPropertiesStorage.get(sparse.GemProperties);

            if (gem != null) {
                if (gem.type.hasFlag(SocketColor.RelicIron)) {
                    addStat(ItemSpecStat.RelicIron);
                }

                if (gem.type.hasFlag(SocketColor.RelicBlood)) {
                    addStat(ItemSpecStat.RelicBlood);
                }

                if (gem.type.hasFlag(SocketColor.RelicShadow)) {
                    addStat(ItemSpecStat.RelicShadow);
                }

                if (gem.type.hasFlag(SocketColor.RelicFel)) {
                    addStat(ItemSpecStat.RelicFel);
                }

                if (gem.type.hasFlag(SocketColor.RelicArcane)) {
                    addStat(ItemSpecStat.RelicArcane);
                }

                if (gem.type.hasFlag(SocketColor.RelicFrost)) {
                    addStat(ItemSpecStat.RelicFrost);
                }

                if (gem.type.hasFlag(SocketColor.RelicFire)) {
                    addStat(ItemSpecStat.RelicFire);
                }

                if (gem.type.hasFlag(SocketColor.RelicWater)) {
                    addStat(ItemSpecStat.RelicWater);
                }

                if (gem.type.hasFlag(SocketColor.RelicLife)) {
                    addStat(ItemSpecStat.RelicLife);
                }

                if (gem.type.hasFlag(SocketColor.RelicWind)) {
                    addStat(ItemSpecStat.RelicWind);
                }

                if (gem.type.hasFlag(SocketColor.RelicHoly)) {
                    addStat(ItemSpecStat.RelicHoly);
                }
            }
        } else {
            itemType = 0;
        }

        for (int i = 0; i < ItemConst.MaxStats; ++i) {
            if (sparse.StatModifierBonusStat[i] != -1) {
                addModStat(sparse.StatModifierBonusStat[i]);
            }
        }
    }

    private void addStat(ItemSpecStat statType) {
        if (itemSpecStatCount >= ItemConst.MaxStats) {
            return;
        }

        for (int i = 0; i < ItemConst.MaxStats; ++i) {
            if (ItemSpecStatTypes[i] == statType) {
                return;
            }
        }

        ItemSpecStatTypes[ItemSpecStatCount++] = statType;
    }

    private void addModStat(int itemStatType) {
        switch (ItemModType.forValue(itemStatType)) {
            case Agility:
                addStat(ItemSpecStat.Agility);

                break;
            case Strength:
                addStat(ItemSpecStat.Strength);

                break;
            case Intellect:
                addStat(ItemSpecStat.Intellect);

                break;
            case DodgeRating:
                addStat(ItemSpecStat.Dodge);

                break;
            case ParryRating:
                addStat(ItemSpecStat.Parry);

                break;
            case CritMeleeRating:
            case CritRangedRating:
            case CritSpellRating:
            case CritRating:
                addStat(ItemSpecStat.crit);

                break;
            case HasteRating:
                addStat(ItemSpecStat.Haste);

                break;
            case HitRating:
                addStat(ItemSpecStat.hit);

                break;
            case ExtraArmor:
                addStat(ItemSpecStat.BonusArmor);

                break;
            case AgiStrInt:
                addStat(ItemSpecStat.Agility);
                addStat(ItemSpecStat.Strength);
                addStat(ItemSpecStat.Intellect);

                break;
            case AgiStr:
                addStat(ItemSpecStat.Agility);
                addStat(ItemSpecStat.Strength);

                break;
            case AgiInt:
                addStat(ItemSpecStat.Agility);
                addStat(ItemSpecStat.Intellect);

                break;
            case StrInt:
                addStat(ItemSpecStat.Strength);
                addStat(ItemSpecStat.Intellect);

                break;
        }
    }
}
