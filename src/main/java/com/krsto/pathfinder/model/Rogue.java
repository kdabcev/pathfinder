package com.krsto.pathfinder.model;



public class Rogue extends CharacterClass {

	@Override
	public ToHit.Progression getBabProgression() {
		return ToHit.Progression.THREE_QUARTERS;
	}
	
	@Override
	public Save.Progression getFortitudeSaveProgression() {
		return Save.Progression.POOR;
	}
	
	@Override
	public Save.Progression getReflexSaveProgression() {
		return Save.Progression.GOOD;
	}
	
	@Override
	public Save.Progression getWillSaveProgression() {
		return Save.Progression.POOR;
	}

}
