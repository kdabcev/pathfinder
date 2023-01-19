package com.krsto.pathfinder.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.jar.Attributes;

import com.krsto.pathfinder.model.AbilityFactory.AbilityEnum;
import com.krsto.pathfinder.model.AbilityScore.Type;
import com.krsto.pathfinder.model.Bab.Progression;
import com.krsto.pathfinder.model.CharacterSheet.CharacterAttributes;

public class Rage extends ActivateableAbility {
	
	//add level scaling
	
	private Bonus strength;
	private Bonus constitution;
	private Bonus will;
	private Bonus armorClassPenalty;

	public Rage(AbilityEnum abilityEnum) {
		super(abilityEnum);

	}
	

	@Override
	public void deactivate(CharacterSheet characterSheet) {
		this.isActive = false;
		
		CharacterSheet.CharacterAttributes attributes = characterSheet.getAttributes();
		
		attributes.strength.removeBonus(strength);
		attributes.constitution.removeBonus(constitution);
		attributes.will.removeBonus(will);
		attributes.armorClass.removeBonus(armorClassPenalty);
		
		
	}

	@Override
	public void activate(CharacterSheet characterSheet) {
		this.isActive = true;
		
		//ifology for level scaling
		
		CharacterSheet.CharacterAttributes attributes = characterSheet.getAttributes();
		
		List<BonusDesignation> targets = new ArrayList<>();
		targets.add (AbilityScore.Type.STRENGTH);
		this.strength = new Bonus(BonusType.MORALE, 4, targets );
		
		
		targets = new ArrayList<>();
		targets.add (AbilityScore.Type.CONSTITUTION);
		this.constitution = new Bonus(BonusType.MORALE, 4, targets );
		
		targets = new ArrayList<>();
		targets.add (Save.Type.WILL);
		this.will = new Bonus(BonusType.MORALE, 2, targets );
		
		targets = new ArrayList<>();
		targets.add(ArmorClass.getDesignation());
		this.armorClassPenalty = new Bonus(BonusType.PENALTY, -2, targets );
		
		attributes.strength.applyBonus(strength);
		attributes.constitution.applyBonus(constitution);
		attributes.will.applyBonus(will);
		attributes.armorClass.applyBonus(armorClassPenalty);
			
		
	}



	
}
