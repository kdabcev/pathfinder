package com.krsto.pathfinder.model;

import java.util.ArrayList;
import java.util.List;

public class Bab {
	
	public enum Progression {
		FULL (1),
		TWO_THIRDS (2/3),
		HALF (0.5);
		
		private final double factor;

		private Progression(double factor) {
			this.factor = factor;
		}
		
		
	}
	
	public List<Integer> baseAttackBonus(int level, Progression progression) {
		
		
		
		ArrayList<Integer> bab = new ArrayList();
		
		bab.add(level);
		
		
		if (level*progression.factor >= 6) {
			bab.add(level -5);
		}
		
		if (level*progression.factor >= 11) {
			bab.add(level -10);
		}
		
		if (level*progression.factor >= 16) {
			bab.add(level -15);
		}
		
	
		return bab;
	}
}
