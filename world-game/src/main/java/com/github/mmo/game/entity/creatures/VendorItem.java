package com.github.mmo.game.entity.creatures;


import java.util.ArrayList;


public class VendorItem {
    private int item;
    private int maxcount;
    private int incrtime;
    private int extendedCost;
    private ItemVendortype type = ItemVendorType.values()[0];
    private ArrayList<Integer> bonusListIDs = new ArrayList<>();
    private int playerConditionId;
    private boolean ignoreFiltering;

    public VendorItem() {
    }

    public VendorItem(int item, int maxcount, int incrtime, int extendedCost, ItemVendorType type) {
        setItem(item);
        setMaxcount((int) maxcount);
        setIncrtime(incrtime);
        setExtendedCost(extendedCost);
        setType(type);
    }

    public final int getItem() {
        return item;
    }

    public final void setItem(int value) {
        item = value;
    }

    public final int getMaxcount() {
        return maxcount;
    }

    public final void setMaxcount(int value) {
        maxcount = value;
    }

    public final int getIncrtime() {
        return incrtime;
    }

    public final void setIncrtime(int value) {
        incrtime = value;
    }

    public final int getExtendedCost() {
        return extendedCost;
    }

    public final void setExtendedCost(int value) {
        extendedCost = value;
    }

    public final ItemVendorType getType() {
        return type;
    }

    public final void setType(ItemVendorType value) {
        type = value;
    }

    public final ArrayList<Integer> getBonusListIDs() {
        return bonusListIDs;
    }

    public final void setBonusListIDs(ArrayList<Integer> value) {
        bonusListIDs = value;
    }

    public final int getPlayerConditionId() {
        return playerConditionId;
    }

    public final void setPlayerConditionId(int value) {
        playerConditionId = value;
    }

    public final boolean getIgnoreFiltering() {
        return ignoreFiltering;
    }

    public final void setIgnoreFiltering(boolean value) {
        ignoreFiltering = value;
    }
}
