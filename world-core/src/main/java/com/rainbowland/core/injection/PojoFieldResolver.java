package com.rainbowland.core.injection;

import com.rainbowland.core.WorldConfiguration;

import java.util.Map;

/**
 * Field resolver for manually registered objects, for injection by type or name.
 *
 * @see WorldConfiguration#register
 * @author Daan van Yperen
 */
public interface PojoFieldResolver extends FieldResolver {

	/**
	 * Set manaully registered objects.
	 * @param pojos Map of manually registered objects.
	 */
	void setPojos(Map<String, Object> pojos);
}
