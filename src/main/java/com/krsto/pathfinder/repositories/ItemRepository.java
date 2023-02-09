package com.krsto.pathfinder.repositories;

import java.util.ArrayList;
import java.util.List;


import com.krsto.pathfinder.model.Dice;
import com.krsto.pathfinder.model.Weapon;
import com.krsto.pathfinder.model.Weapon.WeaponType;

public class ItemRepository {

	public static List<Weapon> getWeapons() {
		List<Weapon> weapons = new ArrayList<Weapon>();
		weapons.add(new Weapon("Greataxe", WeaponType.TWO_HANDED, Dice.d12()));
		weapons.add(new Weapon("Greatsword", WeaponType.TWO_HANDED, Dice.other(2, 6)));
		weapons.add(new Weapon("Dagger", WeaponType.ONE_HANDED, Dice.d4()));
		return weapons;
	}
	
	public static Weapon getWeaponByType(String type) {
		List<Weapon> allWeapons = getWeapons();
		for (Weapon weapon : allWeapons) {
			if (weapon.getType().equals(type)) {
				return weapon;
			}
		}
		return null;
	}
}
