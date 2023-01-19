package com.krsto.pathfinder.model;

public class AbilityFactory {
	
public enum AbilityEnum {
		
		RAGE(1),
		POWER_ATTACK(2);
		
		private final int value;

		private AbilityEnum(int value) {
			this.value = value;
		}

		public int getValue() {
			return value;
		}
		
		public static AbilityEnum getByValue(int value) {
			for (AbilityEnum abilityEnum : AbilityEnum.values()) {
				if (abilityEnum.value == value) {
					return abilityEnum;
				}
			}
			throw new RuntimeException("unrecognized ability value");
		}
	
	}

	public static Ability getAbility(AbilityEnum abilityEnum) {
		if (abilityEnum == AbilityEnum.RAGE) {
			 return new Rage(abilityEnum);
		}
		
		if (abilityEnum == AbilityEnum.POWER_ATTACK) {
			 return new PowerAttack(abilityEnum);
			
		}
		
		throw new RuntimeException("Unsupported ability name");
		
	}

}
