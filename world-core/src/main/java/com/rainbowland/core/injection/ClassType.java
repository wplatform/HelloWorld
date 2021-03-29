package com.rainbowland.core.injection;

import com.rainbowland.core.BaseSystem;
import com.rainbowland.core.ComponentMapper;
import com.rainbowland.core.World;

/**
 * Enum used to cache class type according to their usage in Artemis.
 *
 * @author Snorre E. Brekke
 */
public enum ClassType {
	/**
	 * Used for (sub)classes of {@link ComponentMapper}
	 */
	MAPPER,
	/**
	 * Used for (sub)classes of {@link BaseSystem}
	 */
	SYSTEM,
	/**
	 * Used for (sub)classes of {@link World}
	 */
	WORLD,
	/**
	 * Used for everything else.
	 */
	CUSTOM
}
