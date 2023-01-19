package com.krsto.pathfinder.model;

import com.krsto.pathfinder.model.CharacterSheet.CharacterAttributes;
import com.krsto.pathfinder.model.EffectFactory.EffectEnum;

public abstract class ActivateableEffect extends Effect {

	public ActivateableEffect(EffectEnum effectEnum) {
		super(effectEnum);
		// TODO Auto-generated constructor stub
	}
	
	public abstract void deactivate(CharacterAttributes attributes);
	

}
