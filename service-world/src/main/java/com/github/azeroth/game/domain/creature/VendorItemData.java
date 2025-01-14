package com.github.azeroth.game.domain.creature;


import com.github.azeroth.game.domain.creature.ItemVendorType;
import com.github.azeroth.game.domain.creature.VendorItem;

import java.util.ArrayList;


public class VendorItemData {
    private final ArrayList<VendorItem> items = new ArrayList<>();

    public final VendorItem getItem(int slot) {
        if (slot >= items.size()) {
            return null;
        }

        return items.get(slot);
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
        return items.removeIf(vendorItem -> vendorItem.item == item_id && vendorItem.type == type);
    }

    public final VendorItem findItemCostPair(int itemId, int extendedCost, ItemVendorType type) {
        return items.stream().filter(vendorItem -> vendorItem.item == itemId && vendorItem.extendedCost == extendedCost && vendorItem.type == type)
                .findFirst().orElse(null);
    }

    public final void clear() {
        items.clear();
    }
}
