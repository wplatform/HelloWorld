package com.rainbowland.core.link;

import com.rainbowland.core.Component;
import com.rainbowland.core.EntitySubscription;
import com.rainbowland.core.World;
import com.rainbowland.core.utils.IntArray;
import com.rainbowland.core.utils.reflect.Field;
import com.rainbowland.core.utils.reflect.ReflectionException;
import com.rainbowland.core.Aspect;

import static com.rainbowland.core.Aspect.all;

class IntBagFieldMutator implements MultiFieldMutator<IntArray, Component> {
	private final IntArray empty = new IntArray();
	private EntitySubscription all;

	@Override
	public void validate(int sourceId, IntArray ids, LinkListener listener) {
		for (int i = 0; ids.size() > i; i++) {
			int id = ids.get(i);
			if (!all.getActiveEntityIds().unsafeGet(id)) {
				ids.removeIndex(i--);
				if (listener != null)
					listener.onTargetDead(sourceId, id);
			}
		}
	}

	@Override
	public IntArray read(Component c, Field f) {
		try {
			final boolean isNotAccessible = !f.isAccessible();
			if (isNotAccessible) {
				f.setAccessible(true);
			}
			IntArray e = (IntArray) f.get(c);
			if (isNotAccessible) {
				f.setAccessible(false);
			}
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
