package com.krsto.pathfinder.model;

import java.util.HashMap;

import com.krsto.pathfinder.model.AbilityScore.Type;
import com.krsto.pathfinder.model.CharacterSheet.CharacterAttributes;

public class Save extends BonusTargetTemplate {
	
	public enum Progression {
		
		POOR (1.0/3.0),
		GOOD (0.5);
		
		private final double factor;

		private Progression(double factor) {
			this.factor = factor;
		}
		
		public int getProgression(int level) {
			if(this == GOOD) {
				return (int) (2 + (this.factor* level));
			}
			return (int) (0 + (this.factor* level));
		}
		
		
	}
	
	public enum Type implements BonusDesignation{
		
		FORTITUDE,
		REFLEX,
		WILL;

		@Override
		public BonusTarget getBonusTarget(CharacterAttributes characterAttributes) {
			if (this == FORTITUDE) {
				return characterAttributes.fortitude;
			}
			if (this == REFLEX) {
				return characterAttributes.reflex;
			}
			if (this == WILL) {
				return characterAttributes.will;
			}
			throw new RuntimeException("Unrecognized ability score");
		}
		
	}
	
	private Type type;
	private int level;
	private Progression progression;
	private AbilityScore abilityScore;
	
	
	

	public Save(Type type, int level, Progression progression, AbilityScore abilityScore) {
		super();
		this.type = type;
		this.level = level;
		this.progression = progression;
		this.abilityScore = abilityScore;
	}


	

	@Override
	public int getBaseValue() {
		return progression.getProgression(level) + this.abilityScore.getTotalModifier();
	}
	

		
	
}
