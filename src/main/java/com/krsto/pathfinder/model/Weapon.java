package com.krsto.pathfinder.model;

public class Weapon extends Item {
	
	private WeaponType category;
	private Dice damageDie;
	private String type;

	public WeaponType getWeaponType() {
		return category;
	}


	public Dice getDamageDie() {
		return damageDie;
	}


	public String getType() {
		return type;
	}


	public Weapon(String type, WeaponType category, Dice damageDie) {
		super();
		this.type = type;
		this.category = category;
		this.damageDie = damageDie;
	}


	public static enum WeaponType {
		ONE_HANDED,
		TWO_HANDED,
		LIGHT,
		ONE_HANDED_RANGED,
		TWO_HANDED_RANGED,
		
	}
		
	
	
		
		
}
