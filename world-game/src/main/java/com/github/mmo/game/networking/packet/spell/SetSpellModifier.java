package com.github.mmo.game.networking.packet.spell;


import java.util.ArrayList;


public class SetSpellModifier extends ServerPacket {
    public ArrayList<SpellModifierInfo> modifiers = new ArrayList<>();

    public SetSpellModifier(ServerOpCode opcode) {
        super(opcode, ConnectionType.instance);
    }

    @Override
    public void write() {
        this.writeInt32(modifiers.size());

        for (var spellMod : modifiers) {
            spellMod.write(this);
        }
    }
}
