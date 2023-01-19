package com.krsto.pathfinder.model;

import com.krsto.pathfinder.model.AbilityFactory.AbilityEnum;

public class EffectFactory {
	
public enum EffectEnum {
		
		BLESS(1);
				
		private final int value;

		private EffectEnum(int value) {
			this.value = value;
		}

		public int getValue() {
			return value;
		}
		
		public static EffectEnum getByValue(int value) {
			for (EffectEnum effectEnum : EffectEnum.values()) {
				if (effectEnum.value == value) {
					return effectEnum;
				}
			}
			throw new RuntimeException("unrecognized ability value");
		}
	
	}

	public static Effect getEffect(EffectEnum effectEnum) {
		if (effectEnum == EffectEnum.BLESS) {
			 return new Bless(effectEnum);
		}
		
		throw new RuntimeException("Unsupported ability name");
		
	}
}

