
package com.github.azeroth.world.core;


import com.badlogic.gdx.utils.reflect.ClassReflection;
import com.badlogic.gdx.utils.reflect.ReflectionException;
import com.github.azeroth.world.signals.Listener;
import com.github.azeroth.world.signals.Signal;
import com.github.azeroth.world.utils.ImmutableArray;


public class Engine {
	private static Family empty = Family.all().get();
	
	private final Listener<Entity> componentAdded = new ComponentListener();
	private final Listener<Entity> componentRemoved = new ComponentListener();
	
	private SystemManager systemManager = new SystemManager(new EngineSystemListener());
	private EntityManager entityManager = new EntityManager(new EngineEntityListener());
	private ComponentOperationHandler componentOperationHandler = new ComponentOperationHandler(new EngineDelayedInformer());
	private FamilyManager familyManager = new FamilyManager(entityManager.getEntities());	
	private boolean updating;


	public Entity createEntity () {
		return new Entity();
	}


	public <T extends Component> T createComponent (Class<T> componentType) {
		try {
			return ClassReflection.newInstance(componentType);
		} catch (ReflectionException e) {
			return null;
		}
	}


	public void addEntity(Entity entity){
		boolean delayed = updating || familyManager.notifying();
		entityManager.addEntity(entity, delayed);
	}


	public void removeEntity(Entity entity){
		boolean delayed = updating || familyManager.notifying();
		entityManager.removeEntity(entity, delayed);
	}
	

	public void removeAllEntities(Family family) {
		boolean delayed = updating || familyManager.notifying();
		entityManager.removeAllEntities(getEntitiesFor(family), delayed);
	}


	public void removeAllEntities() {
		boolean delayed = updating || familyManager.notifying();
		entityManager.removeAllEntities(delayed);
	}

	/**
	 * Returns an {@link ImmutableArray} of {@link Entity} that is managed by the the Engine
	 *  but cannot be used to modify the state of the Engine. This Array is not Immutable in
	 *  the sense that its contents will not be modified, but in the sense that it only reflects
	 *  the state of the engine.
	 *
	 * The Array is Immutable in the sense that you cannot modify its contents through the API of
	 *  the {@link ImmutableArray} class, but is instead "Managed" by the Engine itself. The engine
	 *  may add or remove items from the array and this will be reflected in the returned array.
	 *
	 * This is an important note if you are looping through the returned entities and calling operations
	 *  that may add/remove entities from the engine, as the underlying iterator of the returned array
	 *  will reflect these modifications.
	 *
	 * The returned array will have entities removed from it if they are removed from the engine,
	 *   but there is no way to introduce new Entities through the array's interface, or remove
	 *   entities from the engine through the array interface.
	 *
	 *  Discussion of this can be found at https://github.com/libgdx/ashley/issues/224
	 *
	 * @return An unmodifiable array of entities that will match the state of the entities in the
	 *  engine.
	 */
	public ImmutableArray<Entity> getEntities() {
		return entityManager.getEntities();
	}


	public void addSystem(EntitySystem system){
		systemManager.addSystem(system);
	}


	public void removeSystem(EntitySystem system){
		systemManager.removeSystem(system);
	}


	public void removeAllSystems(){
		systemManager.removeAllSystems();
	}


	public <T extends EntitySystem> T getSystem(Class<T> systemType) {
		return systemManager.getSystem(systemType);
	}


	public ImmutableArray<EntitySystem> getSystems() {
		return systemManager.getSystems();
	}


	public ImmutableArray<Entity> getEntitiesFor(Family family){
		return familyManager.getEntitiesFor(family);
	}


	public void addEntityListener (EntityListener listener) {
		addEntityListener(empty, 0, listener);
	}


	public void addEntityListener (int priority, EntityListener listener) {
		addEntityListener(empty, priority, listener);
	}


	public void addEntityListener(Family family, EntityListener listener) {
		addEntityListener(family, 0, listener);
	}


	public void addEntityListener (Family family, int priority, EntityListener listener) {
		familyManager.addEntityListener(family, priority, listener);
	}


	public void removeEntityListener (EntityListener listener) {
		familyManager.removeEntityListener(listener);
	}


	public void update(float deltaTime){
		if (updating) {
			throw new IllegalStateException("Cannot call update() on an Engine that is already updating.");
		}
		
		updating = true;
		ImmutableArray<EntitySystem> systems = systemManager.getSystems();
		try {
			for (int i = 0; i < systems.size(); ++i) {
				EntitySystem system = systems.get(i);
				
				if (system.checkProcessing()) {
					system.update(deltaTime);
				}
	
				while(componentOperationHandler.hasOperationsToProcess() || entityManager.hasPendingOperations()) {
					componentOperationHandler.processOperations();
					entityManager.processPendingOperations();
				}
			}
		}
		finally {
			updating = false;
		}	
	}
	
	protected void addEntityInternal(Entity entity) {
		entity.componentAdded.add(componentAdded);
		entity.componentRemoved.add(componentRemoved);
		entity.componentOperationHandler = componentOperationHandler;
		
		familyManager.updateFamilyMembership(entity);
	}
	
	protected void removeEntityInternal(Entity entity) {
		familyManager.updateFamilyMembership(entity);

		entity.componentAdded.remove(componentAdded);
		entity.componentRemoved.remove(componentRemoved);
		entity.componentOperationHandler = null;
	}
	
	private class ComponentListener implements Listener<Entity> {
		@Override
		public void receive(Signal<Entity> signal, Entity object) {
			familyManager.updateFamilyMembership(object);
		}
	}
	
	private class EngineSystemListener implements SystemManager.SystemListener {
		@Override
		public void systemAdded (EntitySystem system) {
			system.addedToEngineInternal(Engine.this);
		}

		@Override
		public void systemRemoved (EntitySystem system) {
			system.removedFromEngineInternal(Engine.this);
		}
	}
	
	private class EngineEntityListener implements EntityListener {
		@Override
		public void entityAdded (Entity entity) {
			addEntityInternal(entity);
		}

		@Override
		public void entityRemoved (Entity entity) {
			removeEntityInternal(entity);
		}
	}
	
	private class EngineDelayedInformer implements ComponentOperationHandler.BooleanInformer {
		@Override
		public boolean value () {
			return updating;
		}
	}
}
