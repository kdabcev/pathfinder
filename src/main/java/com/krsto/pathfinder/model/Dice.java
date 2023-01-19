package com.krsto.pathfinder.model;

public class Dice {

	private int number;
	private int sides;
	
	public String toString() {
		if (number == 1) {
			return "d"+sides;
		}
		return number + "d" + sides;
	}

	private Dice(int number, int sides) {
		this.number = number;
		this.sides = sides;
	}
	
	public static Dice d4() {
		return new Dice(1, 4);
	}
	
	public static Dice d6() {
		return new Dice(1, 6);
	}
	
	public static Dice d8() {
		return new Dice(1, 8);
	}
	
	public static Dice d10() {
		return new Dice(1, 10);
	}
	
	public static Dice d12() {
		return new Dice(1, 12);
	}
	
	public static Dice other(int number, int sides) {
		return new Dice(number, sides);
	}
	
	
}
