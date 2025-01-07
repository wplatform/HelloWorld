
package com.github.azeroth.world.core;


import lombok.Getter;
import lombok.Setter;

public abstract class EntitySystem {
	public int priority;

    @Setter
    private boolean processing;

    @Getter
    private Engine engine;

	public EntitySystem () {
		this(0);
	}


	public EntitySystem (int priority) {
		this.priority = priority;
		this.processing = true;
	}


	public void addedToEngine (Engine engine) {
	}


	public void removedFromEngine (Engine engine) {
	}


	public void update (float deltaTime) {
	}

	public boolean checkProcessing () {
		return processing;
	}

    final void addedToEngineInternal(Engine engine) {
		this.engine = engine;
		addedToEngine(engine);
	}
	
	final void removedFromEngineInternal(Engine engine) {
		this.engine = null;
		removedFromEngine(engine);
	}
}
