package com.github.mmo.game.achievement;


import com.github.mmo.dbc.domain.CriteriaEntity;

public class Criteria
{
	public int id;
	public CriteriaEntity entry;
	public modifierTreeNode modifier;
	public CriteriaflagsCu flagsCu = CriteriaFlagsCu.values()[0];
}