package com.krsto.pathfinder.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SlotCapture {

	private List<SlotType> capture = new ArrayList<>();
	
	
	public static SlotCapture createForSlot(SlotType slotType) {
		return createForSlots(slotType);
	}
	
	public static SlotCapture createForSlots(SlotType... slotTypes) {
		SlotCapture sc = new SlotCapture();
		sc.capture.addAll(Arrays.asList(slotTypes));
		return sc;
	}
	
	public static SlotCapture createForTwoHandedWeapon() {
		return createForSlots(SlotType.MAIN_HAND, SlotType.OFF_HAND);
	}
	
	public static SlotCapture createForOneHandedWeapon() {
		return createForSlots(SlotType.MAIN_HAND);
	}
	
	public static SlotCapture createForShield() {
		return createForSlots(SlotType.OFF_HAND);
	}
	
}
