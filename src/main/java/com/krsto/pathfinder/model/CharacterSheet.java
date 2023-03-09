package com.krsto.pathfinder.model;

import java.util.ArrayList;
import java.util.List;

import com.krsto.pathfinder.model.AbilityFactory.AbilityEnum;


import com.krsto.pathfinder.model.Save.Progression;
import com.krsto.pathfinder.repositories.ItemRepository;



public class CharacterSheet {
	
	private CharacterClass characterClass;
	private int level;
	private Weapon weapon;
	
	private CharacterAttributes attributes = new CharacterAttributes();
	
	public static class CharacterAttributes {
		public AbilityScore strength;
		public AbilityScore dexterity;
		public AbilityScore constitution;
		public AbilityScore intelligence;
		public AbilityScore wisdom;
		public AbilityScore charisma;
		public Save fortitude;
		public Save reflex;
		public Save will;
		public ToHit toHit;
		public Damage damage;
		public ArmorClass armorClass;
		
	}
	
	
	private List<ActivateableAbility> activeAbilities = new ArrayList<>();

	public void initialize(CharacterBuildInfo buildInfo) {
			
		this.characterClass = CharacterClassFactory.getCharacterClass(buildInfo.characterClassEnum); 
		this.level = buildInfo.level;
		
		this.attributes.strength = new AbilityScore(AbilityScore.Type.STRENGTH, buildInfo.strength);
		this.attributes.dexterity = new AbilityScore(AbilityScore.Type.DEXTERITY, buildInfo.dexterity);
		this.attributes.constitution = new AbilityScore(AbilityScore.Type.CONSTITUTION, buildInfo.constitution);
		this.attributes.intelligence = new AbilityScore(AbilityScore.Type.INTELLIGENCE, buildInfo.intelligence);
		this.attributes.wisdom = new AbilityScore(AbilityScore.Type.WISDOM, buildInfo.wisdom);
		this.attributes.charisma = new AbilityScore(AbilityScore.Type.CHARISMA, buildInfo.charisma);
		
		this.attributes.fortitude = new Save(Save.Type.FORTITUDE, level, characterClass.getFortitudeSaveProgression(), this.attributes.constitution);
		this.attributes.reflex = new Save(Save.Type.REFLEX, level, characterClass.getReflexSaveProgression(), this.attributes.dexterity);
		this.attributes.will = new Save(Save.Type.WILL, level, characterClass.getWillSaveProgression(), this.attributes.wisdom);		

		this.weapon = ItemRepository.getWeaponByType( buildInfo.getWeaponType() );
		
		this.attributes.damage = new Damage(weapon.getWeaponType(), this.attributes.strength);
		
		this.attributes.toHit = new ToHit(this.level, this.characterClass.getBabProgression(), this.attributes.strength);
	
		this.attributes.armorClass = new ArmorClass(getDexterityModifier());
		
		
		
	}

	public ArrayList<String> abilityList() {
		
		ArrayList<String> abilityList = new ArrayList<>();
		abilityList.add("1. Rage;");
		abilityList.add("2. Power Attack;");
		
		return abilityList;
	}

	public void activateAbility(AbilityEnum abilityEnum) {
		
		if (this.isAbilityActive(abilityEnum)) {
			return;
		}
		
		Ability ability = AbilityFactory.getAbility(abilityEnum);
		
		ability.activate(this);
		if (ability instanceof ActivateableAbility) {
			this.activeAbilities.add((ActivateableAbility) ability);
		}
		
	}
	
	
	public void deactivateAbility(AbilityEnum abilityEnum) {
		
		
		for(ActivateableAbility activatedAbility : this.activeAbilities) {
			if(activatedAbility.getAbilityEnum() == abilityEnum) {
				activatedAbility.deactivate(this);
				this.activeAbilities.remove(activatedAbility);
				return;
			}
		}
	}
	
	public boolean isAbilityActive(AbilityEnum abilityEnum) {
	
		for(ActivateableAbility activatedAbility : this.activeAbilities) {
			if(activatedAbility.getAbilityEnum() == abilityEnum) {
				return true;
				
			}	
		}
		return false;
		
	}
	
	
	
	public int getStrength() {
		return attributes.strength.getTotalValue();
	}
	
	public int getDexterity() {
		return this.attributes.dexterity.getTotalValue();
	}
	
	public int getConstitution() {
		return this.attributes.constitution.getTotalValue();
	}
	
	public int getIntelligence() {
		return this.attributes.intelligence.getTotalValue();
	}
	
	public int getWisdom() {
		return this.attributes.wisdom.getTotalValue();
	}
	
	public int getCharisma() {
		return this.attributes.charisma.getTotalValue();
	}
	
	public int getFortitude() {
		return this.attributes.fortitude.getTotalValue();
	}
	
	public int getReflex() {
		return this.attributes.reflex.getTotalValue();
	}
	
	public int getWill() {
		return this.attributes.will.getTotalValue();
	}
	
	public int getToHit() {
		return this.attributes.toHit.getTotalValue();
	}
	
	public int getDamage() {
		return this.attributes.damage.getTotalValue();
	}
	
	public int getArmorClass() {
		return this.attributes.armorClass.getTotalValue();
	}
	
	public int getStrengthModifier() {
		return this.attributes.strength.getTotalModifier();
	}
	
	public int getDexterityModifier() {
		return this.attributes.dexterity.getTotalModifier();
	}
	
	public int getConstitutionModifier() {
		return this.attributes.constitution.getTotalModifier();
	}
	
	public int getIntelligenceModifier() {
		return this.attributes.intelligence.getTotalModifier();
	}
	
	public int getWisdomModifier() {
		return this.attributes.wisdom.getTotalModifier();
	}
	
	public int getCharismaModifier() {
		return this.attributes.charisma.getTotalModifier();
	}

	public CharacterAttributes getAttributes() {
		return attributes;
	}

	public int getLevel() {
		return level;
	}

	public Weapon getWeapon() {
		return weapon;
	}
	
	public void equipWeapon(Weapon weapon){
		this.weapon = weapon;
		
		this.attributes.damage = new Damage(weapon.getWeaponType(), this.attributes.strength);
		
		this.attributes.toHit = new ToHit(this.level, this.characterClass.getBabProgression(), this.attributes.strength);
	}

}
