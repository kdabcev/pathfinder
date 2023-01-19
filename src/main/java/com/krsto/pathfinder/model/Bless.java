package com.krsto.pathfinder.model;

import java.util.ArrayList;
import java.util.List;


import com.krsto.pathfinder.model.CharacterSheet.CharacterAttributes;
import com.krsto.pathfinder.model.EffectFactory.EffectEnum;

public class Bless extends ActivateableEffect {
	
	private Bonus toHit;
	private Bonus damage;
	private Bonus will;
	private Bonus reflex;
	private Bonus fortitude;
	
	public Bless(EffectEnum effectEnum) {
		super(effectEnum);
		
		List<BonusDesignation> targets = new ArrayList<>();
		targets.add(ToHit.getDesignation());
		this.toHit = new Bonus(BonusType.MORALE, 1, targets );
		
		targets = new ArrayList<>();
		targets.add(Damage.getDesignation());
		this.damage = new Bonus(BonusType.MORALE, 1, targets);
		
		targets = new ArrayList<>();
		targets.add (Save.Type.WILL);
		this.will = new Bonus(BonusType.MORALE, 1, targets );
		
		targets = new ArrayList<>();
		targets.add (Save.Type.FORTITUDE);
		this.fortitude = new Bonus(BonusType.MORALE, 1, targets );
		
		targets = new ArrayList<>();
		targets.add (Save.Type.REFLEX);
		this.reflex = new Bonus(BonusType.MORALE, 1, targets );
		
		
		
		
	}
	

	@Override
	public void deactivate(CharacterAttributes attributes) {
		this.isActive = false;
		
		attributes.toHit.applyBonus(toHit);
		attributes.damage.applyBonus(damage);
		attributes.will.applyBonus(will);
		attributes.fortitude.applyBonus(fortitude);
		attributes.reflex.applyBonus(reflex);
		
		
	}

	@Override
	public void activate(CharacterAttributes attributes) {
		this.isActive = true;
	
		attributes.toHit.removeBonus(toHit);
		attributes.damage.removeBonus(damage);
		attributes.will.removeBonus(will);
		attributes.fortitude.removeBonus(fortitude);
		attributes.reflex.removeBonus(reflex);
			
		
	}

}
