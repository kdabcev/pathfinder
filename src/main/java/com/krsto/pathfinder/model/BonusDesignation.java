package com.krsto.pathfinder.model;

import com.krsto.pathfinder.model.CharacterSheet.CharacterAttributes;

public interface BonusDesignation {

	public BonusTarget getBonusTarget(CharacterAttributes characterAttributes);
}
