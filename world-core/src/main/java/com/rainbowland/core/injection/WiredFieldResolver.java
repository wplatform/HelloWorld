package com.rainbowland.core.injection;

import com.rainbowland.core.MundaneWireException;
import com.rainbowland.core.World;
import com.rainbowland.core.WorldConfiguration;
import com.rainbowland.core.utils.reflect.Field;
import com.rainbowland.core.annotations.Wire;

import java.util.HashMap;
import java.util.Map;

/**
 * Can inject arbitrary fields annotated with {@link Wire},
 * typically registered via registered via {@link WorldConfiguration#register}
 *
 * @author Snorre E. Brekke
 */
public class WiredFieldResolver implements UseInjectionCache, PojoFieldResolver {
	private InjectionCache cache;

	private Map<String, Object> pojos = new HashMap<String, Object>();
	private World world;

	public WiredFieldResolver() {
	}

	@Override
	public void initialize(World world) {
		this.world = world;
	}

	@Override
	public Object resolve(Object target, Class<?> fieldType, Field field) {
		ClassType injectionType = cache.getFieldClassType(fieldType);
		CachedField cachedField = cache.getCachedField(field);

		if (injectionType == ClassType.CUSTOM || injectionType == ClassType.WORLD) {
			if (cachedField.wireType == WireType.WIRE) {
				String key = cachedField.name;
				if ("".equals(key)) {
					key = field.getType().getName();
				}

				if (!pojos.containsKey(key) && cachedField.failOnNull) {
					String err = "Not registered: " + key + "=" + fieldType;
					throw new MundaneWireException(err);
				}

				return pojos.get(key);
			}
		}
		return null;
	}

	@Override
	public void setCache(InjectionCache cache) {
		this.cache = cache;
	}

	@Override
	public void setPojos(Map<String, Object> pojos) {
		this.pojos = pojos;
	}
}
