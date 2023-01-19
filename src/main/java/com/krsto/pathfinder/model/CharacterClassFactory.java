package com.krsto.pathfinder.model;

public class CharacterClassFactory {
	
	
	public enum CharacterClassEnum {
		
		BLOODRAGER(1),
		ROGUE(2);
		
		private final int value;

		private CharacterClassEnum(int value) {
			this.value = value;
		}

		public int getValue() {
			return value;
		}
		
		public static CharacterClassEnum getByValue(int value) {
			for (CharacterClassEnum classEnum : CharacterClassEnum.values()) {
				if (classEnum.value == value) {
					return classEnum;
				}
			}
			throw new RuntimeException("unrecognize character class value");
		}
				
}

	public static CharacterClass getCharacterClass(CharacterClassEnum characterClassEnum) {
		if (characterClassEnum == CharacterClassEnum.BLOODRAGER) {
			 return new Bloodrager();
		}
		
		if (characterClassEnum == CharacterClassEnum.ROGUE) {
			 return new Rogue();
		}
		
		throw new RuntimeException("Unsupported class name");
		
	}
	
}
