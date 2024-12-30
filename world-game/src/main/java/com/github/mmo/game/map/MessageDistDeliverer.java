package com.github.mmo.game.map;


import com.github.mmo.game.entity.creature.Creature;
import com.github.mmo.game.entity.dynamic.DynamicObject;
import com.github.mmo.game.entity.object.WorldObject;
import com.github.mmo.game.entity.player.Player;
import com.github.mmo.game.map.interfaces.*;

public class MessageDistDeliverer<T extends IDoWork<Player>> implements IGridNotifierPlayer, IGridNotifierDynamicObject, IGridNotifierCreature {
    private final WorldObject source;
    private final T packetSender;
    private final PhaseShift phaseShift;
    private final float distSq;
    private final TeamFaction team;
    private final Player skippedReceiver;
    private final boolean required3dDist;

    public MessageDistDeliverer(WorldObject src, T packetSender, float dist, boolean own_team_only, Player skipped) {
        this(src, packetSender, dist, own_team_only, skipped, false);
    }

    public MessageDistDeliverer(WorldObject src, T packetSender, float dist, boolean own_team_only) {
        this(src, packetSender, dist, own_team_only, null, false);
    }    private gridType gridType = gridType.World;

    public MessageDistDeliverer(WorldObject src, T packetSender, float dist) {
        this(src, packetSender, dist, false, null, false);
    }

    public MessageDistDeliverer(WorldObject src, T packetSender, float dist, boolean own_team_only, Player skipped, boolean req3dDist) {
        source = src;
        packetSender = packetSender;
        phaseShift = src.getPhaseShift();
        distSq = dist * dist;

        if (own_team_only && src.isPlayer()) {
            team = src.toPlayer().getEffectiveTeam();
        }

        skippedReceiver = skipped;
        required3dDist = req3dDist;
    }

    public final GridType getGridType() {
        return gridType;
    }

    public final void setGridType(GridType value) {
        gridType = value;
    }

    public final void visit(list<Creature> objs) {
        for (var i = 0; i < objs.size(); ++i) {
            var creature = objs.get(i);

            if (!creature.inSamePhase(phaseShift)) {
                continue;
            }

            if ((!_required3dDist ? creature.getLocation().getExactDist2DSq(source.getLocation()) : creature.getLocation().getExactDistSq(source.getLocation())) > distSq) {
                continue;
            }

            // Send packet to all who are sharing the creature's vision
            if (creature.getHasSharedVision()) {
                for (var visionPlayer : creature.getSharedVisionList()) {
                    if (visionPlayer.getSeerView() == creature) {
                        sendPacket(visionPlayer);
                    }
                }
            }
        }
    }

    public final void visit(list<DynamicObject> objs) {
        for (var i = 0; i < objs.size(); ++i) {
            var dynamicObject = objs.get(i);

            if (!dynamicObject.inSamePhase(phaseShift)) {
                continue;
            }

            if ((!_required3dDist ? dynamicObject.getLocation().getExactDist2DSq(source.getLocation()) : dynamicObject.getLocation().getExactDistSq(source.getLocation())) > distSq) {
                continue;
            }

            // Send packet back to the caster if the caster has vision of dynamic object
            var caster = dynamicObject.getCaster();

            if (caster) {
                var player = caster.toPlayer();

                if (player && player.getSeerView() == dynamicObject) {
                    sendPacket(player);
                }
            }
        }
    }

    public final void visit(list<Player> objs) {
        for (var i = 0; i < objs.size(); ++i) {
            var player = objs.get(i);

            if (!player.inSamePhase(phaseShift)) {
                continue;
            }

            if ((!_required3dDist ? player.getLocation().getExactDist2DSq(source.getLocation()) : player.getLocation().getExactDistSq(source.getLocation())) > distSq) {
                continue;
            }

            // Send packet to all who are sharing the player's vision
            if (player.getHasSharedVision()) {
                for (var visionPlayer : player.getSharedVisionList()) {
                    if (visionPlayer.getSeerView() == player) {
                        sendPacket(visionPlayer);
                    }
                }
            }

            if (player.getSeerView() == player || player.getVehicle1() != null) {
                sendPacket(player);
            }
        }
    }

    private void sendPacket(Player player) {
        // never send packet to self
        if (source == player || (team != 0 && player.getEffectiveTeam() != team) || skippedReceiver == player) {
            return;
        }

        if (!player.haveAtClient(source)) {
            return;
        }

        packetSender.invoke(player);
    }




}
