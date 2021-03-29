package com.rainbowland.core.link;

import com.rainbowland.core.Component;
import com.rainbowland.core.World;
import com.rainbowland.core.utils.reflect.Field;
import com.rainbowland.core.utils.reflect.ReflectionException;

class IntFieldMutator implements UniFieldMutator {
	@Override
	public int read(Component c, Field f) {
		try {
			return (Integer) f.get(c);
		} catch (ReflectionException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public void write(int value, Component c, Field f) {
		try {
			f.set(c, value);
		} catch (ReflectionException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public void setWorld(World world) {}
}
