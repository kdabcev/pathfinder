package com.krsto.pathfinder.model;

import java.util.HashMap;
import java.util.Scanner;
import java.io.IOException;


public class CharDataInput {
	
	public static HashMap<String, Integer> userInput() {
		
		HashMap<String, Integer> charData = new HashMap<>();
	
		Scanner inputScanner = new Scanner(System.in);
	
		System.out.println("What is your level?");
		int level = inputScanner.nextInt();
		charData.put("Level", level);
	
		System.out.println("What is your strength?");
		int strength = inputScanner.nextInt();
		charData.put("Strength", strength);
	
		System.out.println("What is your dexterity?");
		int dexterity = inputScanner.nextInt();
		charData.put("Dexterity", dexterity);
	
		System.out.println("What is your constitution?");
		int constitution = inputScanner.nextInt();
		charData.put("Constitution", constitution);
	
		System.out.println("What is your intelligence?");
		int intelligence = inputScanner.nextInt();
		charData.put("Intelligence", intelligence);
	
		System.out.println("What is your wisdom?");
		int wisdom = inputScanner.nextInt();
		charData.put("Wisdom", wisdom);
	
		System.out.println("What is your charisma?");
		int charisma = inputScanner.nextInt();
		charData.put("Charisma", charisma);
	
		return charData;
	}

}
