package com.github.mmo.game.map;


import com.github.mmo.game.entity.object.WorldObject;
import com.github.mmo.game.entity.player.Player;
import com.github.mmo.game.entity.unit.Unit;
import com.github.mmo.game.map.interfaces.*;
import game.PhaseShift;

import java.util.ArrayList;
import java.util.Objects;


public class PlayerListSearcher implements IGridNotifierPlayer {
    private final PhaseShift phaseShift;
    private final ArrayList<Unit> objects;
    private final ICheck<Player> check;

    public PlayerListSearcher(WorldObject searcher, ArrayList<Unit> objects, ICheck<Player> check) {
        this(searcher, objects, check, gridType.World);
    }    private gridType gridType = getGridType().values()[0];

    public PlayerListSearcher(WorldObject searcher, ArrayList<Unit> objects, ICheck<Player> check, GridType gridType) {
        phaseShift = searcher.getPhaseShift();
        objects = objects;
        check = check;
        setGridType(gridType);
    }

    public PlayerListSearcher(PhaseShift phaseShift, ArrayList<Unit> objects, ICheck<Player> check) {
        this(phaseShift, objects, check, gridType.World);
    }


    public PlayerListSearcher(PhaseShift phaseShift, ArrayList<Unit> objects, ICheck<Player> check, GridType gridType) {
        phaseShift = phaseShift;
        objects = objects;
        check = check;
        setGridType(gridType);
    }

    public final GridType getGridType() {
        return gridType;
    }

    public final void setGridType(GridType value) {
        gridType = value;
    }

    public final void visit(list<Player> objs) {
        for (var i = 0; i < objs.size(); ++i) {
            var player = objs.get(i);

            if (player != null && player.inSamePhase(phaseShift)) {
                if (check.invoke(player)) {
                    Objects.add(player);
                }
            }
        }
    }


}
