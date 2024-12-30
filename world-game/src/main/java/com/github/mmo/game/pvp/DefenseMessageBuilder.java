package com.github.mmo.game.pvp;


import com.github.mmo.game.chat.MessageBuilder;
import com.github.mmo.game.map.PacketSenderOwning;
import com.github.mmo.game.networking.packet.DefenseMessage;

import java.util.locale;

class DefenseMessageBuilder extends MessageBuilder {
    private final int zoneId; // ZoneId
    private final int id; // BroadcastTextId

    public DefenseMessageBuilder(int zoneId, int id) {
        zoneId = zoneId;
        id = id;
    }


    @Override
    public PacketSenderOwning<DefenseMessage> invoke() {
        return invoke(locale.enUS);
    }

    @Override
    public PacketSenderOwning<DefenseMessage> invoke(Locale locale) {
        var text = global.getOutdoorPvPMgr().getDefenseMessage(zoneId, id, locale);

        PacketSenderOwning<DefenseMessage> defenseMessage = new PacketSenderOwning<DefenseMessage>();
        defenseMessage.getData().zoneID = zoneId;
        defenseMessage.getData().messageText = text;

        return defenseMessage;
    }
}
