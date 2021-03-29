package com.rainbowland.core.link;

import com.rainbowland.core.Component;
import com.rainbowland.core.Entity;
import com.rainbowland.core.EntitySubscription;
import com.rainbowland.core.World;
import com.rainbowland.core.utils.Array;
import com.rainbowland.core.utils.reflect.Field;
import com.rainbowland.core.utils.reflect.ReflectionException;
import com.rainbowland.core.*;

import static com.rainbowland.core.Aspect.all;

class EntityBagFieldMutator implements MultiFieldMutator<Array<Entity>, Component> {
	private final Array<Entity> empty = new Array<Entity>();
	private EntitySubscription all;

	@Override
	public void validate(int sourceId, Array<Entity> entities, LinkListener listener) {
		for (int i = 0; entities.size() > i; i++) {
			Entity e = entities.get(i);
			if (!all.getActiveEntityIds().unsafeGet(e.getId())) {
				entities.remove(i--);
				if (listener != null)
					listener.onTargetDead(sourceId, e.getId());
			}
		}
	}

	@Override
	public Array<Entity> read(Component c, Field f) {
		try {
			Array<Entity> e = (Array<Entity>) f.get(c);
			return (e != null) ? e : empty;
		} catch (ReflectionException exc) {
			throw new RuntimeException(exc);
		}
	}

	@Override
	public void setWorld(World world) {
		all = world.getAspectSubscriptionManager().get(Aspect.all());
	}
}
