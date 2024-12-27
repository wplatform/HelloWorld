
package com.github.mmo.world.systems;


import com.github.mmo.world.core.Engine;
import com.github.mmo.world.core.Entity;
import com.github.mmo.world.core.EntitySystem;
import com.github.mmo.world.core.Family;
import com.github.mmo.world.utils.ImmutableArray;


public abstract class IteratingSystem extends EntitySystem {
	private Family family;
	private ImmutableArray<Entity> entities;


	public IteratingSystem (Family family) {
		this(family, 0);
	}


	public IteratingSystem (Family family, int priority) {
		super(priority);

		this.family = family;
	}

	@Override
	public void addedToEngine (Engine engine) {
		entities = engine.getEntitiesFor(family);
	}

	@Override
	public void removedFromEngine (Engine engine) {
		entities = null;
	}

	@Override
	public void update (float deltaTime) {
		startProcessing();
		for (int i = 0; i < entities.size(); ++i) {
			processEntity(entities.get(i), deltaTime);
		}
		endProcessing();
	}

	public ImmutableArray<Entity> getEntities () {
		return entities;
	}


	public Family getFamily () {
		return family;
	}


	protected abstract void processEntity (Entity entity, float deltaTime);


	public void startProcessing() {}


	public void endProcessing() {}
}
