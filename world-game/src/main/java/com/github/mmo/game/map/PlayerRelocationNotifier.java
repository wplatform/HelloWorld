package com.github.mmo.game.map;


import com.github.mmo.game.entity.creature.Creature;
import com.github.mmo.game.entity.object.WorldObject;
import com.github.mmo.game.entity.player.Player;
import com.github.mmo.game.map.interfaces.*;


public class PlayerRelocationNotifier extends VisibleNotifier implements IGridNotifierPlayer, IGridNotifierCreature {
    public PlayerRelocationNotifier(com.github.mmo.game.entity.player.Player player, GridType gridType) {
        super(player, gridType);
    }

    public final void visit(list<Creature> objs) {
        visit(objs.<WorldObject>cast().ToList());

        var relocated_for_ai = (getPlayer() == getPlayer().getSeerView());

        for (var i = 0; i < objs.size(); ++i) {
            var creature = objs.get(i);
            getVisGuids().remove(creature.getGUID());

            getPlayer().updateVisibilityOf(creature, getData(), getVisibleNow());

            if (relocated_for_ai && !creature.isNeedNotify(NotifyFlag.VisibilityChanged)) {
                NotifierHelpers.creatureUnitRelocationWorker(creature, getPlayer());
            }
        }
    }

    public final void visit(list<Player> objs) {
        visit(objs.<WorldObject>cast().ToList());

        for (var i = 0; i < objs.size(); ++i) {
            var player = objs.get(i);
            getVisGuids().remove(player.getGUID());

            getPlayer().updateVisibilityOf(player, getData(), getVisibleNow());

            if (player.getSeerView().isNeedNotify(NotifyFlag.VisibilityChanged)) {
                continue;
            }

            player.updateVisibilityOf(getPlayer());
        }
    }
}
