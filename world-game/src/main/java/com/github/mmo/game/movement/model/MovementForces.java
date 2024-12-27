package com.github.mmo.game.movement.model;

import com.github.mmo.game.entity.object.ObjectGuid;

import java.util.ArrayList;


public class MovementForces
{
	private final ArrayList<MovementForce> forces = new ArrayList<>();
	private float modMagnitude = 1.0f;

	public final float getModMagnitude()
	{
		return modMagnitude;
	}
	public final void setModMagnitude(float value)
	{
		modMagnitude = value;
	}

	public final boolean isEmpty()
	{
		return forces.isEmpty() && modMagnitude == 1.0f;
	}

	public final ArrayList<MovementForce> getForces()
	{
		return forces;
	}

	public final boolean add(MovementForce newForce)
	{
        var movementForce = findMovementForce(newForce.getID());

		if (movementForce == null)
		{
			forces.add(newForce);

			return true;
		}

		return false;
	}

	public final boolean remove(ObjectGuid id)
	{
        var movementForce = findMovementForce(id);

		if (movementForce != null)
		{
			forces.remove(movementForce);

			return true;
		}

		return false;
	}

	private MovementForce findMovementForce(ObjectGuid id)
	{
		return tangible.ListHelper.find(forces, force -> Objects.equals(force.ID, id));
	}
}
