package com.krsto.pathfinder.model;

public abstract class BonusTargetTemplate  implements BonusTarget {
	
	BonusCalculator bonusCalculator = new BonusCalculator();
	
	public abstract int getBaseValue();
	
	public int getTotalValue() {
		return getBaseValue() + bonusCalculator.calculate();
	}

	@Override
	public void applyBonus(Bonus bonus) {
		this.bonusCalculator.addBonus(bonus);
	}
	
	@Override
	public void removeBonus(Bonus bonus) {
		this.bonusCalculator.removeBonus(bonus);
		
	}
}
