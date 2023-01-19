package com.krsto.pathfinder.model;

public enum Slot {
	HEAD(SlotType.HEAD),
	HEADBAND(SlotType.HEADBAND),
	EYES(SlotType.EYES),
	SHOULDERS(SlotType.SHOULDERS),
	NECK(SlotType.NECK),
	CHEST(SlotType.CHEST),
	BODY(SlotType.BODY),
	ARMOR(SlotType.ARMOR),
	BELT(SlotType.BELT),
	WRISTS(SlotType.WRISTS),
	HANDS(SlotType.HANDS),
	LEFT_RING(SlotType.RING),
	RIGHT_RING(SlotType.RING),
	FEET(SlotType.FEET),
	MAIN_HAND(SlotType.MAIN_HAND),
	OFF_HAND(SlotType.OFF_HAND),
	SLOTLESS(SlotType.SLOTLESS);

	
	private final SlotType type;

	private Slot(SlotType type) {
		this.type = type;
	}

	public SlotType getType() {
		return type;
	}
	
	
	
	
	
}
