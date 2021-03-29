package com.rainbowland.core.link;

import com.rainbowland.core.Component;
import com.rainbowland.core.World;
import com.rainbowland.core.utils.reflect.Field;

/**
 * <p>Internal interface. Used for reading/writing entity
 * fields pointing to a single entity.</p>
 */
public interface UniFieldMutator {
	int read(Component c, Field f);
	void write(int value, Component c, Field f);
	void setWorld(World world);
}
