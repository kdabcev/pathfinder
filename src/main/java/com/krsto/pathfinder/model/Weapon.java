package com.krsto.pathfinder.model;

public class Weapon extends Item {
	
	private WeaponCategory category;
	private Dice damageDie;
	private String type;

	public WeaponCategory getCategory() {
		return category;
	}


	public Dice getDamageDie() {
		return damageDie;
	}


	public String getType() {
		return type;
	}


	public Weapon(String type, WeaponCategory category, Dice damageDie) {
		super();
		this.type = type;
		this.category = category;
		this.damageDie = damageDie;
	}


	public static enum WeaponCategory {
		ONE_HANDED,
		TWO_HANDED,
		RANGED
		
	}
		
	
	
		
		
}
