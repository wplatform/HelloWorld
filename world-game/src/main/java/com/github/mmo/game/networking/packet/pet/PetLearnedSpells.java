package com.github.mmo.game.networking.packet.pet;


import java.util.*;import com.github.mmo.game.networking.ServerPacket;
public class PetLearnedSpells extends ServerPacket {
   
    public ArrayList<Integer> spells = new ArrayList<>();

    public PetLearnedSpells() {
        super(ServerOpcode.PetLearnedSpells, ConnectionType.instance);
    }

    @Override
    public void write() {
        this.writeInt32(spells.size());

        for (var spell : spells) {
            this.writeInt32(spell);
        }
    }
}