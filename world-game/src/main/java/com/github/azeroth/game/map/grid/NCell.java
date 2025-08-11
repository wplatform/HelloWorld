package com.github.azeroth.game.map.grid;


import com.github.azeroth.common.Assert;
import com.github.azeroth.game.entity.areatrigger.AreaTrigger;
import com.github.azeroth.game.entity.conversation.Conversation;
import com.github.azeroth.game.entity.corpse.Corpse;
import com.github.azeroth.game.entity.creature.Creature;
import com.github.azeroth.game.entity.dynamic.DynamicObject;
import com.github.azeroth.game.entity.gobject.GameObject;
import com.github.azeroth.game.entity.object.WorldObject;
import com.github.azeroth.game.entity.player.Player;
import com.github.azeroth.game.entity.scene.SceneObject;

public class NCell {

    //AllGridObjectTypes: GameObject, Creature(except pets), DynamicObject, Corpse(Bones), AreaTrigger, SceneObject, Conversation
    private final GridRefManager<GameObject> gridGameObjects = new GridRefManager<>();
    private final GridRefManager<Creature> gridCreatures = new GridRefManager<>();
    private final GridRefManager<DynamicObject> gridDynamicObjects = new GridRefManager<>();
    private final GridRefManager<Corpse> gridCorpses = new GridRefManager<>();
    private final GridRefManager<AreaTrigger> gridAreaTriggers = new GridRefManager<>();
    private final GridRefManager<SceneObject> gridSceneObjects = new GridRefManager<>();
    private final GridRefManager<Conversation> gridConversations = new GridRefManager<>();

    //AllWorldObjectTypes: Player, Creature(pets), Corpse(resurrectable), DynamicObject(farsight target)
    private final GridRefManager<Player> worldPlayers = new GridRefManager<>();
    private final GridRefManager<Creature> worldPets = new GridRefManager<>();
    private final GridRefManager<Corpse> worldCorpses = new GridRefManager<>();
    private final GridRefManager<DynamicObject> worldDynamicObjects = new GridRefManager<>();


    public void addGridObject(GameObject gameObject) {
        gameObject.addToGrid(gridGameObjects);
        Assert.state(gameObject.isInGrid());
    }

    public void addGridObject(Creature pet) {
        pet.addToGrid(gridCreatures);
        Assert.state(pet.isInGrid());
    }

    public void addGridObject(DynamicObject dynamicObject) {
        dynamicObject.addToGrid(gridDynamicObjects);
        Assert.state(dynamicObject.isInGrid());
    }

    public void addGridObject(Corpse bone) {
        bone.addToGrid(gridCorpses);
        Assert.state(bone.isInGrid());
    }

    public void addGridObject(AreaTrigger areaTrigger) {
        areaTrigger.addToGrid(gridAreaTriggers);
        Assert.state(areaTrigger.isInGrid());
    }

    public void addGridObject(SceneObject sceneObject) {
        sceneObject.addToGrid(gridSceneObjects);
        Assert.state(sceneObject.isInGrid());
    }

    public void addGridObject(Conversation conversation) {
        conversation.addToGrid(gridConversations);
        Assert.state(conversation.isInGrid());
    }

    public void addGridObject(WorldObject object) {
        switch (object.getTypeId()) {
            case GAME_OBJECT -> addGridObject(object.toGameObject());
            case CORPSE -> addGridObject(object.toCorpse());
            case UNIT -> addGridObject(object.toCreature());
            case DYNAMIC_OBJECT -> addGridObject(object.toDynObject());
            case AREA_TRIGGER -> addGridObject(object.toAreaTrigger());
            case SCENE_OBJECT -> addGridObject(object.toSceneObject());
            case CONVERSATION -> addGridObject(object.toConversation());
            default -> throw new IllegalArgumentException("Unsupported type for addGridObject: " + object.getTypeId());
        }
    }

    public void addWorldObject(Player player) {
        player.addToGrid(worldPlayers);
        Assert.state(player.isInGrid());
    }

    public void addWorldObject(Creature pet) {
        pet.addToGrid(worldPets);
        Assert.state(pet.isInGrid());
    }

    public void addWorldObject(Corpse resurRectable) {
        resurRectable.addToGrid(worldCorpses);
        Assert.state(resurRectable.isInGrid());
    }

    public void addWorldObject(DynamicObject farSightTarget) {
        farSightTarget.addToGrid(worldDynamicObjects);
        Assert.state(farSightTarget.isInGrid());
    }


    public void addWorldObject(WorldObject object) {
        switch (object.getTypeId()) {
            case PLAYER -> addWorldObject(object.toPlayer());
            case CORPSE -> addWorldObject(object.toCorpse());
            case UNIT -> addWorldObject(object.toCreature());
            case DYNAMIC_OBJECT -> addWorldObject(object.toDynObject());
            default -> throw new IllegalArgumentException("Unsupported type for addWorldObject: " + object.getTypeId());
        }
    }


    public void visit(GridVisitor visitor) {
        if (visitor.test(GridVisitOption.GRID_GAME_OBJECT)) {
            visitor.visit(gridGameObjects);
        }
        if (visitor.test(GridVisitOption.GRID_CREATURE)) {
            visitor.visit(gridCreatures);
        }

        if (visitor.test(GridVisitOption.GRID_DYNAMIC_OBJECT)) {
            visitor.visit(gridDynamicObjects);
        }
        if (visitor.test(GridVisitOption.GRID_CORPSE)) {
            visitor.visit(gridCorpses);
        }
        if (visitor.test(GridVisitOption.GRID_AREA_TRIGGER)) {
            visitor.visit(gridAreaTriggers);
        }
        if (visitor.test(GridVisitOption.GRID_SCENE_OBJECT)) {
            visitor.visit(gridSceneObjects);
        }
        if (visitor.test(GridVisitOption.GRID_CONVERSATION)) {
            visitor.visit(gridConversations);
        }

        if (visitor.test(GridVisitOption.WORLD_PLAYER)) {
            visitor.visit(worldPlayers);
        }
        if (visitor.test(GridVisitOption.WORLD_CREATURE)) {
            visitor.visit(worldPets);
        }
        if (visitor.test(GridVisitOption.WORLD_CORPSE)) {
            visitor.visit(worldCorpses);
        }
        if (visitor.test(GridVisitOption.WORLD_DYNAMIC_OBJECT)) {
            visitor.visit(worldDynamicObjects);
        }

    }

    public int getWorldObjectCountInGrid() {
        return worldPlayers.size() + worldPets.size() + worldCorpses.size() + worldDynamicObjects.size();
    }

}
