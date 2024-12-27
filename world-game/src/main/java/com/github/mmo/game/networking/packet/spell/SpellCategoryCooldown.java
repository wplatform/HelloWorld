package com.github.mmo.game.networking.packet.spell;


import com.github.mmo.game.networking.*;

import java.util.*;

public class SpellCategoryCooldown extends ServerPacket {
    public ArrayList<CategoryCooldownInfo> categoryCooldowns = new ArrayList<>();

    public SpellCategoryCooldown() {
        super(ServerOpcode.CategoryCooldown, ConnectionType.instance);
    }

    @Override
    public void write() {
        this.writeInt32(categoryCooldowns.size());

        for (var cooldown : categoryCooldowns) {
            this.writeInt32(cooldown.category);
            this.writeInt32(cooldown.modCooldown);
        }
    }

    public static class CategoryCooldownInfo {

        public int category; // SpellCategory Id
        public int modCooldown; // Reduced Cooldown in ms


        public CategoryCooldownInfo(int category, int cooldown) {
            category = category;
            modCooldown = cooldown;
        }
    }
}
