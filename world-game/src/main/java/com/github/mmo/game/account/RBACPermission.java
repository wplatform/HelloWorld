package com.github.mmo.game.account;

import java.util.*;


public class RBACPermission
{
	private final int id; // id of the object
	private final String name; // name of the object
	private final ArrayList<Integer> perms = new ArrayList<>(); // Set of permissions

	// Gets the Name of the Object

	public final String getName()
	{
		return name;
	}

	// Gets the Id of the Object

	public final int getId()
	{
		return id;
	}

	// Gets the Permissions linked to this permission

	public final ArrayList<Integer> getLinkedPermissions()
	{
		return perms;
	}


	public RBACPermission(int id)
	{
		this(id, "");
	}

	public RBACPermission()
	{
		this(0, "");
	}

	public RBACPermission(int id, String name)
	{
		id = id;
		name = name;
	}

	// Adds a new linked Permission
	public final void addLinkedPermission(int id)
	{
		perms.add(id);
	}

	// Removes a linked Permission
	public final void removeLinkedPermission(int id)
	{
		perms.remove((Integer)id);
	}
}
