package com.krsto.pathfinder.model;

public abstract class CharacterClass {
	
//	public enum BabProgression {
//		FULL (1),
//		THREE_QUARTERS (3/4),
//		HALF (0.5);
//		
//		
//		private final double factor;
//
//		private BabProgression(double factor) {
//			this.factor = factor;
//		}
//		
//		public double getFactor() {
//			return factor;
//		}
//		
//		
//	}
	
	
	
	public abstract ToHit.Progression getBabProgression();
	public abstract Save.Progression getFortitudeSaveProgression();
	public abstract Save.Progression getReflexSaveProgression();
	public abstract Save.Progression getWillSaveProgression();
	
	//napraviti za saveove i za bab progression
}
