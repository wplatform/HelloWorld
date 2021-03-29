package com.rainbowland.core.systems;

import com.rainbowland.core.Aspect;
import com.rainbowland.core.Entity;
import com.rainbowland.core.EntitySubscription;
import com.rainbowland.core.EntitySystem;
import com.rainbowland.core.utils.Array;

/**
 * Entity reference iterating system.
 * <p/>
 * System that iterates over {@link EntitySubscription} member entities by
 * entity reference.
 * <p/>
 * Use this when you need to process entities matching an {@link Aspect},
 * and you prefer to work with {@link Entity}.
 * <p/>
 * This is a convenience system. We suggest to use {@link IteratingSystem}
 * instead, it sits closer to the metal and enjoys better long term support.
 *
 * @author Arni Arent
 * @author Adrian Papari
 */
public abstract class EntityProcessingSystem extends EntitySystem {

	/**
	 * Creates a new EntityProcessingSystem.
	 * @param aspect
	 * 		the aspect to match entities
	 */
	public EntityProcessingSystem(Aspect.Builder aspect) {
		super(aspect);
	}

	public EntityProcessingSystem() {
	}

	/**
	 * Process a entity this system is interested in.
	 * @param e
	 * 		the entity to process
	 */
	protected abstract void process(Entity e);

	/** @inheritDoc */
	@Override
	protected final void processSystem() {
		Array<Entity> entities = getEntities();
		Object[] array = entities.getData();
		for (int i = 0, s = entities.size(); s > i; i++) {
			process((Entity) array[i]);
		}
	}
}
