package com.krsto.pathfinder.model;

import com.krsto.pathfinder.model.CharacterSheet.CharacterAttributes;

public class ToHit extends BonusTargetTemplate {

	public enum Progression {
		FULL (1),
		THREE_QUARTERS (3/4),
		HALF (0.5);
		
		
		private final double factor;

		private Progression(double factor) {
			this.factor = factor;
		}
		
		public double getProgression() {
			return factor;
		}
		
		
	}
	
	private int level;
	private Progression progression;
	private AbilityScore abilityScore;
	
	public ToHit(int level, Progression progression, AbilityScore abilityScore) {
		this.level = level;
		this.progression = progression;
		this.abilityScore = abilityScore;
	}
	
	public static BonusDesignation getDesignation() {
		return new BonusDesignation() {
			
			@Override
			public BonusTarget getBonusTarget(CharacterAttributes characterAttributes) {
				return characterAttributes.toHit;
			}
		};
	}
	
	@Override
	public int getBaseValue() {
		
		return (int) ((progression.getProgression() * level) + this.abilityScore.getTotalModifier());
	}

}
