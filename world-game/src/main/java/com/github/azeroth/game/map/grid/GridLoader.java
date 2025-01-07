package com.github.azeroth.game.map.grid;


import com.github.azeroth.common.Logs;
import com.github.azeroth.game.CellObjectGuids;
import com.github.azeroth.game.globals.ObjectManager;
import com.github.azeroth.game.map.Map;
import com.github.azeroth.game.map.MapDefine;


public class GridLoader {

    public Cell cell;
    public NGrid grid;
    public Map map;
    public int gameObjects;
    public int creatures;
    public int corpses;
    public int areaTriggers;

    public ObjectManager objectManager;

    public GridLoader(ObjectManager objectManager, NGrid grid, Map map, Cell cell) {
        this.objectManager = objectManager;
        this.grid = grid;
        this.map = map;
        this.cell =cell;

    }



    void loadGameObject()
    {
        Coordinate cellCoord = cell.getCellCoordinate();
        CellObjectGuids cellObjectGuids = objectManager.getCellObjectGuids(map.getId(), map.getDifficultyID(), cellCoord.getId());

        if (CellObjectGuids const* cell_guids = sObjectMgr->GetCellObjectGuids(i_map->GetId(), i_map->GetDifficultyID(), cellCoord.GetId()))
        LoadHelper(cell_guids->gameobjects, cellCoord, m, i_gameObjects, i_map);
    }

    void loadCreature()
    {
        CellCoord cellCoord = i_cell.GetCellCoord();
        if (CellObjectGuids const* cell_guids = sObjectMgr->GetCellObjectGuids(i_map->GetId(), i_map->GetDifficultyID(), cellCoord.GetId()))
        LoadHelper(cell_guids->creatures, cellCoord, m, i_creatures, i_map);
    }

    void loadAreaTrigger()
    {
        CellCoord cellCoord = i_cell.GetCellCoord();
        if (CellGuidSet const* areaTriggers = sAreaTriggerDataStore->GetAreaTriggersForMapAndCell(i_map->GetId(), i_map->GetDifficultyID(), cellCoord.GetId()))
        LoadHelper(*areaTriggers, cellCoord, m, i_areaTriggers, i_map);
    }



    public final void loadN() {
        creatures = 0;
        gameObjects = 0;
        corpses = 0;
        areaTriggers = 0;

        for (int x = 0; x < MapDefine.MAX_NUMBER_OF_CELLS; ++x) {
            for (int y = 0; y < MapDefine.MAX_NUMBER_OF_CELLS; ++y) {
                Grid gridCell = grid.getGrid(x, y);
            }
        }

        Logs.MAPS.debug("{} GameObjects, {} Creatures, {} AreaTriggers, and {} Corpses/Bones loaded for grid {} on map {}",
                gameObjects, creatures, areaTriggers, corpses, grid.getGridId(), map.getId());
    }


}


