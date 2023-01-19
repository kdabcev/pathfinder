package com.krsto.pathfinder.model;

import com.krsto.pathfinder.model.AbilityFactory.AbilityEnum;
import com.krsto.pathfinder.model.CharacterSheet.CharacterAttributes;

public abstract class ActivateableAbility extends Ability {

	
	public ActivateableAbility(AbilityEnum abilityEnum) {
		super(abilityEnum);
	}

	public abstract void deactivate(CharacterSheet characterSheet);
}
