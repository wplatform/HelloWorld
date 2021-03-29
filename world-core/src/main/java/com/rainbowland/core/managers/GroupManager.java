package com.rainbowland.core.managers;

import static com.rainbowland.core.Aspect.all;

import java.util.HashMap;
import java.util.Map;

import com.rainbowland.core.BaseSystem;
import com.rainbowland.core.Entity;
import com.rainbowland.core.EntitySubscription;
import com.rainbowland.core.utils.Array;
import com.rainbowland.core.utils.ImmunityArray;
import com.rainbowland.core.utils.ImmutableIntArray;
import com.rainbowland.core.utils.IntArray;

/**
 * If you need to group your entities together, e.g tanks going into "units"
 * group or explosions into "effects", then use this manager.
 * <p>
 * You must retrieve it using world instance.
 * </p>
 * <p>
 * A entity can be assigned to more than one group.
 * </p>
 *
 * @author Arni Arent
 */
public class GroupManager extends BaseSystem {
    private static final ImmunityArray<String> EMPTY_BAG = new Array<String>();

    /**
     * All entities and groups mapped with group names as key.
     */
    private final Map<String, Array<Entity>> entitiesByGroup;
    private final Map<String, IntArray> identitiesByGroup;
    /**
     * All entities and groups mapped with entities as key.
     */
    private final Map<Entity, Array<String>> groupsByEntity;

    /**
     * Creates a new GroupManager instance.
     */
    public GroupManager() {
        entitiesByGroup = new HashMap<>();
        identitiesByGroup = new HashMap<>();
        groupsByEntity = new HashMap<>();
    }

    @Override
    protected void processSystem() {
    }

    @Override
    protected void initialize() {
        world.getAspectSubscriptionManager().get(all())
                .addSubscriptionListener(new EntitySubscription.SubscriptionListener() {
                    @Override
                    public void inserted(IntArray entities) {
                    }

                    @Override
                    public void removed(IntArray entities) {
                        deleted(entities);
                    }
                });
    }

    /**
     * Set the group of the entity.
     *
     * @param group group to add the entity into
     * @param e     entity to add into the group
     */
    public void add(Entity e, String group) {
        Array<Entity> entities = entitiesByGroup.get(group);
        if (entities == null) {
            entities = new Array<>();
            entitiesByGroup.put(group, entities);
        }
        IntArray identities = identitiesByGroup.get(group);
        if (identities == null) {
            identities = new IntArray();
            identitiesByGroup.put(group, identities);
        }
        if (!entities.contains(e)) {
            entities.add(e);
            identities.add(e.getId());
        }

        Array<String> groups = groupsByEntity.get(e);
        if (groups == null) {
            groups = new Array<>();
            groupsByEntity.put(e, groups);
        }
        if (!groups.contains(group)) {
            groups.add(group);
        }
    }

    public void add(final int entityId, String group) {
        final Entity e = world.getEntity(entityId);
        add(e, group);
    }

    /**
     * Set the group of the entity.
     *
     * @param g1 group to add the entity into
     * @param g2 group to add the entity into
     * @param e  entity to add into the group
     */

    public void add(Entity e, String g1, String g2) {
        add(e, g1);
        add(e, g2);
    }

    public void add(final int entityId, String g1, String g2) {
        final Entity e = world.getEntity(entityId);
        add(e, g1, g2);
    }

    /**
     * Set the group of the entity.
     *
     * @param g1 group to add the entity into
     * @param g2 group to add the entity into
     * @param g3 group to add the entity into
     * @param e  entity to add into the group
     */

    public void add(Entity e, String g1, String g2, String g3) {
        add(e, g1);
        add(e, g2);
        add(e, g3);
    }

    public void add(final int entityId, String g1, String g2, String g3) {
        final Entity e = world.getEntity(entityId);
        add(e, g1, g2, g3);
    }

    /**
     * Set the group of the entity.
     *
     * @param groups groups to add the entity into
     * @param e      entity to add into the group
     */

    public void add(Entity e, String... groups) {
        for (String group : groups) {
            add(e, group);
        }
    }

    public void add(final int entityId, String... groups) {
        final Entity e = world.getEntity(entityId);
        add(e, groups);
    }

    /**
     * Remove the entity from the specified group.
     *
     * @param e     entity to remove from group
     * @param group group to remove the entity from
     */
    public void remove(Entity e, String group) {
        final Array<Entity> entities = entitiesByGroup.get(group);
        if (entities != null) {
            entities.remove(e);
        }
        final IntArray identities = identitiesByGroup.get(group);
        if (identities != null) {
            identities.removeValue(e.getId());
        }

        Array<String> groups = groupsByEntity.get(e);
        if (groups != null) {
            groups.remove(group);
            if (groups.size() == 0)
                groupsByEntity.remove(e);
        }
    }

    public void remove(final int entityId, String group) {
        remove(world.getEntity(entityId), group);
    }

    /**
     * Removes the entity from the specified groups.
     *
     * @param e  entity to remove from group
     * @param g1 group to remove the entity from
     * @param g2 group to remove the entity from
     */

    public void remove(Entity e, String g1, String g2) {
        remove(e, g1);
        remove(e, g2);
    }

    public void remove(final int entityId, String g1, String g2) {
        remove(world.getEntity(entityId), g1, g2);
    }

    /**
     * Removes the entity from the specified groups.
     *
     * @param e  entity to remove from group
     * @param g1 group to remove the entity from
     * @param g2 group to remove the entity from
     * @param g3 group to remove the entity from
     */

    public void remove(Entity e, String g1, String g2, String g3) {
        remove(e, g1);
        remove(e, g2);
        remove(e, g3);
    }

    public void remove(final int entityId, String g1, String g2, String g3) {
        remove(world.getEntity(entityId), g1, g2, g3);
    }

    /**
     * Removes the entity from the specified groups
     *
     * @param e      entity to remove from group
     * @param groups groups to remove the entity from
     */

    public void remove(Entity e, String... groups) {
        for (String group : groups) {
            remove(e, group);
        }
    }

    public void remove(final int entityId, String... groups) {
        remove(world.getEntity(entityId), groups);
    }

    /**
     * Remove the entity from all groups.
     *
     * @param e the entity to remove
     */
    public void removeFromAllGroups(Entity e) {
        Array<String> groups = groupsByEntity.get(e);
        if (groups == null)
            return;
        for (int i = 0, s = groups.size(); s > i; i++) {
            Array<Entity> entities = entitiesByGroup.get(groups.get(i));
            if (entities != null) {
                entities.remove(e);
            }
            IntArray identities = identitiesByGroup.get(groups.get(i));
            if (identities != null) {
                identities.removeValue(e.getId());
            }
        }
        groupsByEntity.remove(e);
    }

    public void removeFromAllGroups(final int entityId) {
        final Entity e = world.getEntity(entityId);
        removeFromAllGroups(e);
    }

    /**
     * Get all entities that belong to the provided group.
     *
     * @param group name of the group
     * @return read-only bag of entities belonging to the group
     */
    public ImmunityArray<Entity> getEntities(String group) {
        Array<Entity> entities = entitiesByGroup.get(group);
        if (entities == null) {
            entities = new Array<>();
            entitiesByGroup.put(group, entities);
        }
        return entities;
    }

    public ImmutableIntArray getEntityIds(final String group) {
        IntArray identities = identitiesByGroup.get(group);
        if (identities == null) {
            identities = new IntArray();
            identitiesByGroup.put(group, identities);
        }
        return identities;
    }

    /**
     * Get all groups the entity belongs to. An empty Bag is returned if the
     * entity doesn't belong to any groups.
     *
     * @param e the entity
     * @return the groups the entity belongs to.
     */
    public ImmunityArray<String> getGroups(Entity e) {
        Array<String> groups = groupsByEntity.get(e);
        return groups != null ? groups : EMPTY_BAG;
    }

    public ImmunityArray<String> getGroups(final int entityId) {
        final Entity e = world.getEntity(entityId);
        return getGroups(e);
    }

    /**
     * Checks if the entity belongs to any group.
     *
     * @param e the entity to check
     * @return true. if it is in any group, false if none
     */
    public boolean isInAnyGroup(Entity e) {
        return getGroups(e).size() > 0;
    }

    public boolean isInAnyGroup(final int entityId) {
        final Entity e = world.getEntity(entityId);
        return isInAnyGroup(e);
    }

    /**
     * Check if the entity is in the supplied group.
     *
     * @param group the group to check in
     * @param e     the entity to check for
     * @return true if the entity is in the supplied group, false if not
     */
    public boolean isInGroup(Entity e, String group) {
        if (group != null) {
            Array<String> array = groupsByEntity.get(e);
            if (array != null) {
                Object[] groups = array.getData();
                for (int i = 0, s = array.size(); s > i; i++) {
                    String g = (String) groups[i];
                    if (group.equals(g)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public boolean isInGroup(final int entityId, String group) {
        final Entity e = world.getEntity(entityId);
        return isInGroup(e, group);
    }

    void deleted(IntArray entities) {
        int[] ids = entities.getData();
        for (int i = 0, s = entities.size(); s > i; i++) {
            removeFromAllGroups(world.getEntity(ids[i]));
        }
    }
}
