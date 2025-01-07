/*******************************************************************************
 * Copyright 2014 See AUTHORS file.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 ******************************************************************************/

package com.github.azeroth.world.core;


import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.Bits;
import com.github.azeroth.world.signals.Signal;
import com.github.azeroth.world.utils.Bag;
import com.github.azeroth.world.utils.ImmutableArray;


public class Entity {
	public int flags;
	public final Signal<Entity> componentAdded;
	public final Signal<Entity> componentRemoved;

	boolean scheduledForRemoval;
	boolean removing;
	ComponentOperationHandler componentOperationHandler;

	private Bag<Component> components;
	private Array<Component> componentsArray;
	private ImmutableArray<Component> immutableComponentsArray;
	private Bits componentBits;
	private Bits familyBits;

	public Entity () {
		components = new Bag<Component>();
		componentsArray = new Array<Component>(false, 16);
		immutableComponentsArray = new ImmutableArray<Component>(componentsArray);
		componentBits = new Bits();
		familyBits = new Bits();
		flags = 0;

		componentAdded = new Signal<Entity>();
		componentRemoved = new Signal<Entity>();
	}


	public Entity add (Component component) {
		if (addInternal(component)) {
			if (componentOperationHandler != null) {
				componentOperationHandler.add(this);
			}
			else {
				notifyComponentAdded();
			}
		}
		
		return this;
	}


	public <T extends Component> T addAndReturn(T component) {
		add(component);
		return component;
	}


	public <T extends Component> T remove (Class<T> componentClass) {
		ComponentType componentType = ComponentType.getFor(componentClass);
		int componentTypeIndex = componentType.getIndex();
		
		if(components.isIndexWithinBounds(componentTypeIndex)){
			Component removeComponent = components.get(componentTypeIndex);
	
			if (removeComponent != null && removeInternal(componentClass) != null) {
				if (componentOperationHandler != null) {
					componentOperationHandler.remove(this);
				}
				else {
					notifyComponentRemoved();
				}
			}
	
			return (T) removeComponent;
		}
		
		return null;
	}

	public void removeAll () {
		while (componentsArray.size > 0) {
			remove(componentsArray.get(0).getClass());
		}
	}

	public ImmutableArray<Component> getComponents () {
		return immutableComponentsArray;
	}


	public <T extends Component> T getComponent (Class<T> componentClass) {
		return getComponent(ComponentType.getFor(componentClass));
	}

	@SuppressWarnings("unchecked")
	<T extends Component> T getComponent (ComponentType componentType) {
		int componentTypeIndex = componentType.getIndex();

		if (componentTypeIndex < components.getCapacity()) {
			return (T)components.get(componentType.getIndex());
		} else {
			return null;
		}
	}


	boolean hasComponent (ComponentType componentType) {
		return componentBits.get(componentType.getIndex());
	}


	Bits getComponentBits () {
		return componentBits;
	}

	Bits getFamilyBits () {
		return familyBits;
	}

	boolean addInternal (Component component) {
		Class<? extends Component> componentClass = component.getClass();
		Component oldComponent = getComponent(componentClass);

		if (component == oldComponent) {
			return false;
		}

		if (oldComponent != null) {
			removeInternal(componentClass);
		}

		int componentTypeIndex = ComponentType.getIndexFor(componentClass);
		components.set(componentTypeIndex, component);
		componentsArray.add(component);
		componentBits.set(componentTypeIndex);
		
		return true;
	}

	Component removeInternal (Class<? extends Component> componentClass) {
		ComponentType componentType = ComponentType.getFor(componentClass);
		int componentTypeIndex = componentType.getIndex();
		Component removeComponent = components.get(componentTypeIndex);

		if (removeComponent != null) {
			components.set(componentTypeIndex, null);
			componentsArray.removeValue(removeComponent, true);
			componentBits.clear(componentTypeIndex);
			
			return removeComponent;
		}

		return null;
	}
	
	void notifyComponentAdded() {
		componentAdded.dispatch(this);
	}
	
	void notifyComponentRemoved() {
		componentRemoved.dispatch(this);
	}

}
