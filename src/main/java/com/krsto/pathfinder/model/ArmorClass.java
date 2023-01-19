package com.krsto.pathfinder.model;

import com.krsto.pathfinder.model.CharacterSheet.CharacterAttributes;

public class ArmorClass extends BonusTargetTemplate {

	
	private int dexterityModifier;
	
	public ArmorClass(int dexterityModifier) {
		this.dexterityModifier = dexterityModifier;
		
	}
	
	@Override
	public int getBaseValue() {
		
		return (10 + this.dexterityModifier);
	}
	
	
	public static BonusDesignation getDesignation() {
		return new BonusDesignation() {
			
			@Override
			public BonusTarget getBonusTarget(CharacterAttributes characterAttributes) {
				return characterAttributes.armorClass;
			}
		};
	}


}
