package com.krsto.pathfinder.model;

public class InventorySlot {
	
	
	private Slot slot;
	private Item item;
	
	public InventorySlot(Slot slot) {
		super();
		this.slot = slot;
	}

	public Slot getSlot() {
		return slot;
	}
	
	public void addItem(Item item){
		this.item = item;
	}
	
	public boolean isEmpty() {
		return item == null;
	}
	

	
}
