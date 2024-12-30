package com.github.mmo.game.map;


import com.github.mmo.game.entity.creature.Creature;
import com.github.mmo.game.entity.object.FindCreatureOptions;
import com.github.mmo.game.entity.object.WorldObject;

public class CreatureWithOptionsInObjectRangeCheck<T extends NoopCheckCustomizer> implements ICheck<Creature> {
    private final WorldObject obj;
    private final T customizer;
    private final FindCreatureOptions args;

    public CreatureWithOptionsInObjectRangeCheck(WorldObject obj, T customizer, FindCreatureOptions args) {
        obj = obj;
        args = args;
        customizer = customizer;
    }

    public final boolean invoke(Creature u) {
        if (u.deathState == deathState.Dead) // Despawned
        {
            return false;
        }

        if (Objects.equals(u.getGUID(), obj.getGUID())) {
            return false;
        }

        if (!customizer.test(u)) {
            return false;
        }

        if (args.creatureId != null && !args.creatureId.equals(u.getEntry())) {
            return false;
        }

        if (args.stringId != null && !u.hasStringId(args.stringId)) {
            return false;
        }

        if (args.isAlive != null && !args.isAlive.equals(u.isAlive())) {
            return false;
        }

        if (args.isSummon != null && !args.isSummon.equals(u.isSummon())) {
            return false;
        }

        if (args.isInCombat != null && !args.isInCombat.equals(u.isInCombat())) {
            return false;
        }

        if ((args.ownerGuid != null && !args.ownerGuid.equals(u.getOwnerGUID())) || (args.charmerGuid != null && !args.charmerGuid.equals(u.getCharmerGUID())) || (args.creatorGuid != null && !args.creatorGuid.equals(u.getCreatorGUID())) || (args.demonCreatorGuid != null && !args.demonCreatorGuid.equals(u.getDemonCreatorGUID())) || (args.privateObjectOwnerGuid != null && !args.privateObjectOwnerGuid.equals(u.getPrivateObjectOwner()))) {
            return false;
        }

        if (args.ignorePrivateObjects && u.isPrivateObject()) {
            return false;
        }

        if (args.ignoreNotOwnedPrivateObjects && !u.checkPrivateObjectOwnerVisibility(obj)) {
            return false;
        }

        if (args.auraSpellId != null && !u.hasAura((int) args.auraSpellId)) {
            return false;
        }

        customizer.update(u);

        return true;
    }
}
