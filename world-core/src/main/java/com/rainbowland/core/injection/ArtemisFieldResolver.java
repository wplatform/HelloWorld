package com.rainbowland.core.injection;

import com.rainbowland.core.BaseSystem;
import com.rainbowland.core.Component;
import com.rainbowland.core.ComponentMapper;
import com.rainbowland.core.World;
import com.rainbowland.core.Manager;
import com.rainbowland.core.utils.reflect.Field;

import java.util.IdentityHashMap;
import java.util.Map;

/**
 * Can resolve {@link World}, {@link ComponentMapper}, {@link BaseSystem} and
 * {@link Manager} types registered in the {@link World}
 *
 * @author Snorre E. Brekke
 */
public class ArtemisFieldResolver implements FieldResolver, UseInjectionCache {

	private World world;
	private InjectionCache cache;

	private Map<Class<?>, Class<?>> systems;

	public ArtemisFieldResolver() {
		systems = new IdentityHashMap<Class<?>, Class<?>>();
	}

	@Override
	public void initialize(World world) {
		this.world = world;

		for (BaseSystem es : world.getSystems()) {
			Class<?> origin = es.getClass();
			Class<?> clazz = origin;
			do {
				systems.put(clazz, origin);
			} while ((clazz = clazz.getSuperclass()) != Object.class);
		}
	}

	@Override
	@SuppressWarnings("unchecked")
	public Object resolve(Object target, Class<?> fieldType, Field field) {
		ClassType injectionType = cache.getFieldClassType(fieldType);
		switch (injectionType) {
			case MAPPER:
				return getComponentMapper(field);
			case SYSTEM:
				return world.getSystem((Class<BaseSystem>) systems.get(fieldType));
			case WORLD:
				return world;
			default:
				return null;

		}
	}

	@SuppressWarnings("unchecked")
	private ComponentMapper<?> getComponentMapper(Field field) {
		Class<?> mapperType = cache.getGenericType(field);
		return world.getMapper((Class<? extends Component>) mapperType);

	}

	@Override
	public void setCache(InjectionCache cache) {
		this.cache = cache;
	}
}
