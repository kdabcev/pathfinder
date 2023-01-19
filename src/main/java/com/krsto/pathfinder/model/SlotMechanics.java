package com.krsto.pathfinder.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class SlotMechanics {
	

	private List<SlotType> slotTypes;
	private SlotCondition slotCondition;	
	
	public boolean check(Collection<InventorySlot> slots) {
		int slotsAvailable = 0;
		
		
		for (InventorySlot slot : slots) {
			if (slot.isEmpty() && slotTypes.contains(slot.getSlot().getType()) ) {
				slotsAvailable++;
			}
		}
		
		if (slotCondition == SlotCondition.OR) {
			return slotsAvailable > 0;
		} else {
			return slotsAvailable >= slotTypes.size();
		}
	}
	
	private enum SlotCondition {
		AND,
		OR
	}
	
	public interface BuilderStart {
		
		public BuilderCondition slotType(SlotType slotType);
		
	}
	
	public interface BuilderCondition extends BuilderFinal {
		
		public BuilderFinal and(SlotType slotType);
		
		public BuilderFinal or(SlotType slotType);
		
	}
	
	public interface BuilderFinal {
		public SlotMechanics build();
	}
	
	
	public static class Builder implements BuilderStart, BuilderCondition, BuilderFinal {
		private List<SlotType> slotTypes = new ArrayList<>();
		private SlotCondition slotCondition;
		
		private Builder() {};
		
		public BuilderCondition slotType(SlotType slotType) {
			slotTypes.add(slotType);
			return this;
		}
		
		public BuilderFinal and(SlotType slotType) {
			slotTypes.add(slotType);
			slotCondition = SlotCondition.AND;
			return this;
		}
		
		public BuilderFinal or(SlotType slotType) {
			slotTypes.add(slotType);
			slotCondition = slotCondition.OR;
			return this;
		}
		
		public SlotMechanics build() {
			SlotMechanics slotMechanics = new SlotMechanics();
			slotMechanics.slotCondition = this.slotCondition;
			slotMechanics.slotTypes = new ArrayList<SlotType>(this.slotTypes);
			return slotMechanics;
		}
		
		public static BuilderStart create() {
			return new Builder();
		}
	}
	
	
	private static void example() {
		
		SlotMechanics shield = Builder.create()
				.slotType(SlotType.OFF_HAND)
				.build();
		
		SlotMechanics oneHanded = Builder.create()
				.slotType(SlotType.MAIN_HAND)
				.or(SlotType.OFF_HAND)
				.build();
		
		
		SlotMechanics twoHanded = Builder.create()
				.slotType(SlotType.MAIN_HAND)
				.and(SlotType.OFF_HAND)
				.build();
	}
}
