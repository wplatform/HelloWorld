package com.github.mmo.game.entity.creatures;


import java.util.ArrayList;


public class VendorItemData {
    private final ArrayList<VendorItem> items = new ArrayList<>();

    public final VendorItem getItem(int slot) {
        if (slot >= items.size()) {
            return null;
        }

        return items.get((int) slot);
    }

    public final boolean empty() {
        return items.isEmpty();
    }

    public final int getItemCount() {
        return items.size();
    }

    public final void addItem(VendorItem vItem) {
        items.add(vItem);
    }

    public final boolean removeItem(int item_id, ItemVendorType type) {
        var i = tangible.ListHelper.removeAll(items, p -> p.item == item_id && p.type == type);

        if (i == 0) {
            return false;
        } else {
            return true;
        }
    }

    public final VendorItem findItemCostPair(int itemId, int extendedCost, ItemVendorType type) {
        return tangible.ListHelper.find(items, p -> p.item == itemId && p.extendedCost == extendedCost && p.type == type);
    }

    public final void clear() {
        items.clear();
    }
}
