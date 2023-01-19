package com.krsto.pathfinder.model;

import com.krsto.pathfinder.model.CharacterSheet.CharacterAttributes;

public class AbilityScore extends BonusTargetTemplate {
	
	public enum Type implements BonusDesignation{
		
		STRENGTH,
		DEXTERITY,
		CONSTITUTION,
		INTELLIGENCE,
		WISDOM,
		CHARISMA;

		@Override
		public BonusTarget getBonusTarget(CharacterAttributes characterAttributes) {
			
			if (this == STRENGTH) {
				return characterAttributes.strength;
			}
			if (this == DEXTERITY) {
				return characterAttributes.dexterity;
			}
			if (this == CONSTITUTION) {
				return characterAttributes.constitution;
			}
			if (this == INTELLIGENCE) {
				return characterAttributes.intelligence;
			}
			if (this == WISDOM) {
				return characterAttributes.wisdom;
			}
			if (this == CHARISMA) {
				return characterAttributes.charisma;
			}
			throw new RuntimeException("Unrecognized ability score");
		}
	}
	
	private Type type;
	private int baseValue;
	
	public AbilityScore(Type type, int baseValue) {
		super();
		this.type = type;
		this.baseValue = baseValue;
	}

	
	public int getTotalModifier() {
		return (getTotalValue() - 10)/2;
		
	}

	@Override
	public int getBaseValue() {
		return baseValue;
	}



}
