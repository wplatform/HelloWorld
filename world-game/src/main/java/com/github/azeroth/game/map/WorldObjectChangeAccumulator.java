package com.github.azeroth.game.map;


import com.github.azeroth.game.entity.creature.Creature;
import com.github.azeroth.game.entity.dynamic.DynamicObject;
import com.github.azeroth.game.entity.object.WorldObject;
import com.github.azeroth.game.entity.player.Player;
import com.github.azeroth.game.map.interfaces.IGridNotifierCreature;
import com.github.azeroth.game.map.interfaces.IGridNotifierDynamicObject;
import com.github.azeroth.game.map.interfaces.IGridNotifierPlayer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.list;

public class WorldObjectChangeAccumulator implements IGridNotifierPlayer, IGridNotifierCreature, IGridNotifierDynamicObject {
    private final HashMap<Player, UpdateData> updateData;
    private final WorldObject worldObject;
    private final ArrayList<ObjectGuid> plrList = new ArrayList<>();

    public WorldObjectChangeAccumulator(WorldObject obj, HashMap<Player, UpdateData> d, GridType gridType) {
        updateData = d;
        worldObject = obj;
        setGridType(gridType);
    }

    public final GridType getGridType() {
        return gridType;
    }    private gridType gridType = getGridType().values()[0];

    public final void setGridType(GridType value) {
        gridType = value;
    }

    public final void visit(list<Creature> objs) {
        for (var i = 0; i < objs.size(); ++i) {
            var creature = objs.get(i);

            if (!creature.getSharedVisionList().isEmpty()) {
                for (var visionPlayer : creature.getSharedVisionList()) {
                    buildPacket(visionPlayer);
                }
            }
        }
    }

    public final void visit(list<DynamicObject> objs) {
        for (var i = 0; i < objs.size(); ++i) {
            var dynamicObject = objs.get(i);

            var guid = dynamicObject.getCasterGUID();

            if (guid.isPlayer()) {
                //Caster may be NULL if DynObj is in removelist
                var caster = global.getObjAccessor().findPlayer(guid);

                if (caster != null) {
                    if (caster.getActivePlayerData().farsightObject == dynamicObject.getGUID()) {
                        buildPacket(caster);
                    }
                }
            }
        }
    }

    public final void visit(list<Player> objs) {
        for (var i = 0; i < objs.size(); ++i) {
            var player = objs.get(i);
            buildPacket(player);

            if (!player.getSharedVisionList().isEmpty()) {
                for (var visionPlayer : player.getSharedVisionList()) {
                    buildPacket(visionPlayer);
                }
            }
        }
    }

    private void buildPacket(Player player) {
        // Only send update once to a player
        if (!plrList.contains(player.getGUID()) && player.haveAtClient(worldObject)) {
            worldObject.buildFieldsUpdate(player, updateData);
            plrList.add(player.getGUID());
        }
    }




}
