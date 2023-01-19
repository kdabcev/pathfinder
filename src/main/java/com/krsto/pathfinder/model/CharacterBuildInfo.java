package com.krsto.pathfinder.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.krsto.pathfinder.model.CharacterClassFactory.CharacterClassEnum;
import com.krsto.pathfinder.model.Weapon.WeaponCategory;



public class CharacterBuildInfo {
	
	public static final String LEVEL_VAR = "level";
	
	public int level;
	public CharacterClassEnum characterClassEnum;
	public int strength;
	public int dexterity;
	public int constitution;
	public int intelligence;
	public int wisdom;
	public int charisma;
	public String weaponType; // if type is string the request will pass
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	public CharacterClassEnum getCharacterClassEnum() {
		return characterClassEnum;
	}
	public void setCharacterClassEnum(CharacterClassEnum characterClassEnum) {
		this.characterClassEnum = characterClassEnum;
	}
	public int getStrength() {
		return strength;
	}
	public void setStrength(int strength) {
		this.strength = strength;
	}
	public int getDexterity() {
		return dexterity;
	}
	public void setDexterity(int dexterity) {
		this.dexterity = dexterity;
	}
	public int getConstitution() {
		return constitution;
	}
	public void setConstitution(int constitution) {
		this.constitution = constitution;
	}
	public int getIntelligence() {
		return intelligence;
	}
	public void setIntelligence(int intelligence) {
		this.intelligence = intelligence;
	}
	public int getWisdom() {
		return wisdom;
	}
	public void setWisdom(int wisdom) {
		this.wisdom = wisdom;
	}
	public int getCharisma() {
		return charisma;
	}
	public void setCharisma(int charisma) {
		this.charisma = charisma;
	}
	public String getWeaponType() {
		return weaponType;
	}
	public void setWeaponType(String weapon) {
		this.weaponType = weapon;
	}
	
	
}
