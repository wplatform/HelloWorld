package com.rainbowland.core;

import com.rainbowland.core.annotations.PooledWeaver;

/**
 * Component type that recycles instances.
 *
 * Expects no <code>final</code> fields.
 *
 * @see PooledWeaver to automate pooled component creation.
 */
public abstract class PooledComponent extends Component {

	/** Called whenever the component is recycled. Implementation should reset component to pristine state. */
	protected abstract void reset();
}
