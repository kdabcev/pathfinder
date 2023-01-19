package com.krsto.pathfinder.model;

import java.util.List;
import java.util.Objects;

import com.krsto.pathfinder.model.AbilityFactory.AbilityEnum;
import com.krsto.pathfinder.model.CharacterSheet.CharacterAttributes;



public abstract class Ability {
	

	private AbilityEnum abilityEnum;
		
	protected boolean isActive;
	
	public abstract void activate(CharacterSheet characterSheet);

	public Ability(AbilityEnum abilityEnum) {
		this.abilityEnum = abilityEnum;
	}

	@Override
	public int hashCode() {
		return Objects.hash(abilityEnum);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Ability other = (Ability) obj;
		return Objects.equals(abilityEnum, other.abilityEnum);
	}

	public AbilityEnum getAbilityEnum() {
		return abilityEnum;
	}
	

	
}

