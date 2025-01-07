package com.github.azeroth.game.map;


import com.github.azeroth.game.entity.gobject.GameObject;
import com.github.azeroth.game.entity.object.WorldObject;
import com.github.azeroth.game.map.interfaces.*;

import java.util.ArrayList;
import java.util.Objects;


public class GameObjectListSearcher implements IGridNotifierGameObject {
    private final PhaseShift phaseShift;
    private final ArrayList<GameObject> objects;
    private final ICheck<GameObject> check;

    public GameObjectListSearcher(WorldObject searcher, ArrayList<GameObject> objects, ICheck<GameObject> check, GridType gridType) {
        phaseShift = searcher.getPhaseShift();
        objects = objects;
        check = check;
        setGridType(gridType);
    }    private gridType gridType = getGridType().values()[0];

    public final GridType getGridType() {
        return gridType;
    }

    public final void setGridType(GridType value) {
        gridType = value;
    }

    public final void visit(list<GameObject> objs) {
        for (var i = 0; i < objs.size(); ++i) {
            var gameObject = objs.get(i);

            if (gameObject.inSamePhase(phaseShift)) {
                if (check.invoke(gameObject)) {
                    Objects.add(gameObject);
                }
            }
        }
    }


}
