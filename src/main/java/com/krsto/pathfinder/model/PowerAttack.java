package com.krsto.pathfinder.model;

import java.util.ArrayList;
import java.util.List;

import com.krsto.pathfinder.model.AbilityFactory.AbilityEnum;


public class PowerAttack extends ActivateableAbility {

	private Bonus toHit;
	private Bonus damage;
	
	public PowerAttack(AbilityEnum abilityEnum) {
		super(abilityEnum);
		
		
		
	}

	@Override
	public void activate(CharacterSheet characterSheet) {
		this.isActive = true;
		
		int levelMultiplier = 1+characterSheet.getLevel()/4;
		
		
		List<BonusDesignation> targets = new ArrayList<>();
		targets.add(ToHit.getDesignation());
		this.toHit = new Bonus(BonusType.PENALTY, -1*levelMultiplier, targets );
		
		targets = new ArrayList<>();
		targets.add(Damage.getDesignation());
		
		int categoryMultiplier = 2;
		if (characterSheet.getWeapon().getCategory() == Weapon.WeaponCategory.TWO_HANDED) {
			categoryMultiplier = 3;
		}
		
		this.damage = new Bonus(BonusType.UNTYPED, categoryMultiplier*levelMultiplier, targets);
		
		CharacterSheet.CharacterAttributes attributes = characterSheet.getAttributes();
		attributes.toHit.applyBonus(toHit);
		attributes.damage.applyBonus(damage);
	}

	@Override
	public void deactivate(CharacterSheet characterSheet) {
		this.isActive = false;
		
		CharacterSheet.CharacterAttributes attributes = characterSheet.getAttributes();
		attributes.toHit.removeBonus(toHit);
		attributes.damage.removeBonus(damage);
		
	}

	

}
