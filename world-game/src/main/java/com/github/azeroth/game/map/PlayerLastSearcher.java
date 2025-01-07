package com.github.azeroth.game.map;


import com.github.azeroth.game.entity.object.WorldObject;
import com.github.azeroth.game.entity.player.Player;
import com.github.azeroth.game.map.interfaces.*;


public class PlayerLastSearcher implements IGridNotifierPlayer {
    private final PhaseShift phaseShift;
    private final ICheck<Player> check;
    private Player object;

    public PlayerLastSearcher(WorldObject searcher, ICheck<Player> check, GridType gridType) {
        phaseShift = searcher.getPhaseShift();
        check = check;
        setGridType(gridType);
    }    private gridType gridType = getGridType().values()[0];

    public final GridType getGridType() {
        return gridType;
    }

    public final void setGridType(GridType value) {
        gridType = value;
    }

    public final void visit(list<Player> objs) {
        for (var i = 0; i < objs.size(); ++i) {
            var player = objs.get(i);

            if (!player.inSamePhase(phaseShift)) {
                continue;
            }

            if (check.invoke(player)) {
                object = player;
            }
        }
    }

    public final Player getTarget() {
        return object;
    }


}
