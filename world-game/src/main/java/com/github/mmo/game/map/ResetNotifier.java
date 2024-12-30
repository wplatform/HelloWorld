package com.github.mmo.game.map;


import com.github.mmo.game.entity.creature.Creature;
import com.github.mmo.game.entity.player.Player;
import com.github.mmo.game.map.interfaces.IGridNotifierCreature;
import com.github.mmo.game.map.interfaces.IGridNotifierPlayer;

import java.util.list;

public class ResetNotifier implements IGridNotifierPlayer, IGridNotifierCreature {
    public ResetNotifier(GridType gridType) {
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
            creature.resetAllNotifies();
        }
    }

    public final void visit(list<Player> objs) {
        for (var i = 0; i < objs.size(); ++i) {
            var player = objs.get(i);
            player.resetAllNotifies();
        }
    }




}
