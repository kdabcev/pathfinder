package com.krsto.pathfinder.model;

public class Bloodrager extends CharacterClass {

	@Override
	public ToHit.Progression getBabProgression() {
		return ToHit.Progression.FULL;
	}
	
	@Override
	public Save.Progression getFortitudeSaveProgression() {
		return Save.Progression.GOOD;
	}
	
	@Override
	public Save.Progression getReflexSaveProgression() {
		return Save.Progression.POOR;
	}
	
	@Override
	public Save.Progression getWillSaveProgression() {
		return Save.Progression.POOR;
	}
	

	

	//@Override
	//public babProgression getBabProgression() {
		
		//return babProgression.FULL;
	//}



}
