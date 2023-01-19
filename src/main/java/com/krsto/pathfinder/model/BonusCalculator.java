package com.krsto.pathfinder.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

public class BonusCalculator {
	
	private List<Bonus> bonusList = new ArrayList<>();
	
	public void addBonus(Bonus bonus) {
		this.bonusList.add(bonus);
	}
	
	public void removeBonus(Bonus bonus) {
		this.bonusList.remove(bonus);
	}
	
	private Map<BonusType, List<Bonus>> getBonusMapByType() {
		
		Map<BonusType, List<Bonus>> bonusMap = new HashMap<>();
		for(Bonus bonus : bonusList) {
			List<Bonus> typeBonusList = bonusMap.get(bonus.getType());
			if (typeBonusList == null) {
				typeBonusList = new ArrayList<>();
				bonusMap.put(bonus.getType(), typeBonusList);
			}
			typeBonusList.add(bonus);
		}
			
		return bonusMap;
	}
	
	
	public int calculate() {
		Map<BonusType, List<Bonus>> bonusMap = getBonusMapByType();
		int value = 0;
		
		for (Entry<BonusType, List<Bonus>> keyValuePair : bonusMap.entrySet()) {
			BonusType bonusType = keyValuePair.getKey();
			List<Bonus> bonusList = keyValuePair.getValue();
			int stacking = 0;
			int nonStacking = Integer.MIN_VALUE;
			for (Bonus bonus : bonusList) {
				if(bonus.isStacking()) {
					stacking += bonus.getValue();
				} else {
					nonStacking = Math.max(stacking, bonus.getValue());
				}
			}
			if (bonusType.isStacking()) {
				value += Math.max(nonStacking, stacking);
			} else {
				value += stacking + nonStacking;
			}
			
		}
		
		return value;
	}
}
