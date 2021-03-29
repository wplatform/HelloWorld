package com.rainbowland.core.link;

import com.rainbowland.core.Component;
import com.rainbowland.core.World;
import com.rainbowland.core.utils.reflect.Field;

/**
 * <p>Internal interface. Used for reading/writing entity
 * fields pointing to multiple entities.</p>
 */
public interface MultiFieldMutator<T, C extends Component> {
	void validate(int sourceId, T collection, LinkListener listener);
	T read(C c, Field f);
	void setWorld(World world);
}
