package com.krsto.pathfinder.model;

import java.util.List;

public class Bonus {
	
	private BonusType type;
	private int value;
	private List<BonusDesignation> targets;
	
	
	private Boolean isStacking = null;
	

	
	public Bonus(BonusType type, int value, List<BonusDesignation> targets, Boolean isStacking) {
		this.type = type;
		this.value = value;
		this.targets = targets;
		this.isStacking = isStacking;
	}

	public Bonus(BonusType type, int value, List<BonusDesignation> targets) {
		this.type = type;
		this.value = value;
		this.targets = targets;
	}
	
	public Bonus(BonusType type, int value) {
		this.type = type;
		this.value = value;
	}


	public Boolean isStacking() {
		if (isStacking == null) {
			return type.isStacking();
		}
		return isStacking;
	}



	public BonusType getType() {
		return type;
	}



	public int getValue() {
		return value;
	}
	
	
	
		
}
