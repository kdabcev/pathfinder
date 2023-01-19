package com.krsto.pathfinder.model;

import java.util.LinkedHashMap;
import java.util.Map;

public class Inventory {
	
	private InventorySlot head = new InventorySlot(Slot.HEAD);
	private InventorySlot headband = new InventorySlot(Slot.HEADBAND);
	private InventorySlot eyes = new InventorySlot(Slot.EYES);
	private InventorySlot shoulders = new InventorySlot(Slot.SHOULDERS);
	private InventorySlot neck = new InventorySlot(Slot.NECK);
	private InventorySlot chest = new InventorySlot(Slot.CHEST);
	private InventorySlot body = new InventorySlot(Slot.BODY);
	private InventorySlot armor = new InventorySlot(Slot.ARMOR);
	private InventorySlot belt = new InventorySlot(Slot.BELT);
	private InventorySlot wrists = new InventorySlot(Slot.WRISTS);
	private InventorySlot hands = new InventorySlot(Slot.HANDS);
	private InventorySlot leftRing = new InventorySlot(Slot.LEFT_RING);
	private InventorySlot rightRing = new InventorySlot(Slot.RIGHT_RING);
	private InventorySlot feet = new InventorySlot(Slot.FEET);
	private InventorySlot mainHand = new InventorySlot(Slot.MAIN_HAND);
	private InventorySlot offHand = new InventorySlot(Slot.OFF_HAND);
	private InventorySlot slotless = new InventorySlot(Slot.SLOTLESS);
	
	private Map<Slot, InventorySlot> slotMap = new LinkedHashMap<>();
	
	public Inventory() {
		super();
		slotMap.put(Slot.HEAD, head);
		slotMap.put(Slot.HEADBAND, headband);
		slotMap.put(Slot.EYES, eyes);
		slotMap.put(Slot.SHOULDERS, shoulders);
		slotMap.put(Slot.NECK, neck);
		slotMap.put(Slot.CHEST, chest);
		slotMap.put(Slot.BODY, body);
		slotMap.put(Slot.ARMOR, armor);
		slotMap.put(Slot.BELT, belt);
		slotMap.put(Slot.WRISTS, wrists);
		slotMap.put(Slot.HANDS, hands);
		slotMap.put(Slot.LEFT_RING, leftRing);
		slotMap.put(Slot.RIGHT_RING, rightRing);
		slotMap.put(Slot.FEET, feet);
		slotMap.put(Slot.MAIN_HAND, mainHand);
		slotMap.put(Slot.OFF_HAND, offHand);
		slotMap.put(Slot.SLOTLESS, slotless);
		
	}



	public void addItem(Item item, Slot slot){
		InventorySlot inventorySlot = slotMap.get(slot);
		inventorySlot.addItem(item);
	}
	
}
