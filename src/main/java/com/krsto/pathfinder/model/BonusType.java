package com.krsto.pathfinder.model;

public enum BonusType {
			

	ALCHEMICAL (false),
	ARMOR (false),
	BAB (false),
	CIRCUMSTANCE (true),	
	COMPETENCE (false),
	DEFLECTION (false),
	DODGE (true),
	ENHANCEMENT (false),
	INHERENT (false),
	INSIGHT (false),
	LUCK (false),
	MORALE (false),
	NATURAL_ARMOR (false),
	PROFANE (false),
	RACIAL (true),
	RESISTANCE (false),
	SACRED (false),
	SHIELD (false),
	SIZE (false),
	TRAIT (false),
	UNTYPED (true),
	PENALTY (true);
	
	private BonusType(boolean isStacking) {
		this.isStacking = isStacking;
	}
	
	private final boolean isStacking;

	public boolean isStacking() {
		return isStacking;
	}
	
	

	
}
