package com.krsto.pathfinder.model;

import java.util.ArrayList;
import java.util.List;

import com.krsto.pathfinder.model.CharacterSheet.CharacterAttributes;
import com.krsto.pathfinder.model.Weapon.WeaponType;

public class Damage extends BonusTargetTemplate {
	
	private AbilityScore abilityScore;
	private WeaponType weaponCategory;
	
	
	public int mainHand() {
		
		
		
		if (weaponCategory == WeaponType.ONE_HANDED) {
			return abilityScore.getTotalModifier();
		}
		if (weaponCategory == WeaponType.TWO_HANDED) {
			return (int) (abilityScore.getTotalModifier() * 1.5);
		}
		if (weaponCategory == WeaponType.ONE_HANDED_RANGED){
			return 0;
		}
		if (weaponCategory == WeaponType.TWO_HANDED_RANGED){
			return 0;
		}
		throw new RuntimeException("Choose 1 for One handed or 2 for Two handed");
		
			
	}
	
	public Damage (WeaponType weaponCategory, AbilityScore abilityScore) {
		this.weaponCategory = weaponCategory;
		this.abilityScore = abilityScore;
		
	}
	
	public int meleeDamage(){
		
		
		int damage = mainHand();  
		
		
		return damage;
	}
	
	public static BonusDesignation getDesignation() {
		return new BonusDesignation() {
			
			@Override
			public BonusTarget getBonusTarget(CharacterAttributes characterAttributes) {
				return characterAttributes.damage;
			}
		};
	}

	@Override
	public int getBaseValue() {
		
		return meleeDamage();
	}
}
