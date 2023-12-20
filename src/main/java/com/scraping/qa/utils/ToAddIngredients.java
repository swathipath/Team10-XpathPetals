package com.scraping.qa.utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ToAddIngredients {
	
	
	public boolean toAddForDiabetes(ArrayList<String> recipeIngredientsList) {
		

		List<String> addIngredients=new ArrayList<String>();
		Collections.addAll(addIngredients,"broccoli","pumpkin","Pumpkin seeds", "Chia seeds", "Flax seeds","apples","nuts","lady finger","okra","beans", "raspberries", "strawberries", "blueberries", "blackberries",
				"eggs","yogurt","bitter guard","Rolled oats", "Steel cut oats","chicken","fish","quinoa","mushroom");
		
		List<String> toAddIngredientsPresentInTherecipe=new ArrayList<String>();

		for(int i=0;i<addIngredients.size();i++) {

			for(int j=0;j<recipeIngredientsList.size();j++) {

				

				if(recipeIngredientsList.get(j).contains(addIngredients.get(i))) {
					toAddIngredientsPresentInTherecipe.add(addIngredients.get(i));

				}
				

			}
		}
		
		
		if(toAddIngredientsPresentInTherecipe.size()>0) {
			return true;

		}
		else
			return false;


		
		
	}
	
	
public boolean toAddForHypothyroid(ArrayList<String> recipeIngredientsList) {
		

		List<String> addIngredients=new ArrayList<String>();
		Collections.addAll(addIngredients,"Saltwater fish", "oyesters", "shellfish","eggs","dairy","nuts","chicken","pumpkin seeds","seaweed","iodized salt","brazil nuts","blueberries","Low-fat yogurt","Brown rice",
				"quinoa","mushroom");
		
		List<String> toAddIngredientsPresentInTherecipe=new ArrayList<String>();

		for(int i=0;i<addIngredients.size();i++) {

			for(int j=0;j<recipeIngredientsList.size();j++) {

				

				if(recipeIngredientsList.get(j).contains(addIngredients.get(i))) {
					toAddIngredientsPresentInTherecipe.add(addIngredients.get(i));

				}
				

			}
		}
		
		
		if(toAddIngredientsPresentInTherecipe.size()>0) {
			return true;

		}
		else
			return false;


		
		
	}



public boolean toAddForHypertension(ArrayList<String> recipeIngredientsList) {
	

	List<String> addIngredients=new ArrayList<String>();
	Collections.addAll(addIngredients,"beetroot","blueberries", "strawberries","bananas", "avocado", "tomato", "sweet potato", "Mushroom","celery","kiwi","dark chocolate (50-70%)","watermelon",
			"spinach", "cabbage", "romaine lettuce", "mustard greens", "broccoli", "argula", "fennel", "kale","garlic","Pomegranate","cinnamon","Pistachios","chia seeds",
			"low-fat yogurt","unsalted nuts","chicken","fish","turkey","quinoa");
	
	List<String> toAddIngredientsPresentInTherecipe=new ArrayList<String>();

	for(int i=0;i<addIngredients.size();i++) {

		for(int j=0;j<recipeIngredientsList.size();j++) {

			

			if(recipeIngredientsList.get(j).contains(addIngredients.get(i))) {
				toAddIngredientsPresentInTherecipe.add(addIngredients.get(i));

			}
			

		}
	}
	
	
	if(toAddIngredientsPresentInTherecipe.size()>0) {
		return true;

	}
	else
		return false;


	
	
}



public boolean toAddForPCOS(ArrayList<String> recipeIngredientsList) {
	

	List<String> addIngredients=new ArrayList<String>();
	Collections.addAll(addIngredients,"apple","pear","banana","avocado","pomegranate","raspberries","blackberries","blueberries","strawberries","orange","guava","kiwi","mango","grapefruit","passion fruit",
			"beans","figs","persimmons","apricot","cherries","nuts","oats");
	
	List<String> toAddIngredientsPresentInTherecipe=new ArrayList<String>();

	for(int i=0;i<addIngredients.size();i++) {

		for(int j=0;j<recipeIngredientsList.size();j++) {

			

			if(recipeIngredientsList.get(j).contains(addIngredients.get(i))) {
				toAddIngredientsPresentInTherecipe.add(addIngredients.get(i));

			}
			

		}
	}
	
	
	if(toAddIngredientsPresentInTherecipe.size()>0) {
		return true;

	}
	else
		return false;


	
	
}


}
