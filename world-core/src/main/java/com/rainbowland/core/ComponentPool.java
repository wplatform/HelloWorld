package com.rainbowland.core;

import com.rainbowland.core.utils.Array;
import com.rainbowland.core.utils.reflect.ClassReflection;
import com.rainbowland.core.utils.reflect.ReflectionException;

public class ComponentPool<T extends PooledComponent> {
	private final Array<T> cache;
	private Class<T> type;

	ComponentPool(Class<T> type) {
		this.type = type;
		cache = new Array<T>(type);
	}

	@SuppressWarnings("unchecked")
	<T extends PooledComponent> T obtain() {
		try {
			return (T) ((cache.size() > 0)
				? cache.removeLast()
				: ClassReflection.newInstance(type));
		} catch (ReflectionException e) {
			throw new InvalidComponentException(type, e.getMessage(), e);
		}
	}

	void free(T component) {
		component.reset();
		cache.add(component);
	}
}
