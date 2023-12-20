package com.scraping.qa.utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CheckingIngredients {
	
	public boolean ingredientsChecking(ArrayList<String> recipeIngredientsList) {

		List<String> avoidingredients=new ArrayList<String>();
		Collections.addAll(avoidingredients, "cream of rice","rice flour","rice ravva","corn","sugar",
				"white rice","white bread","pasta","soda","gatorade","flavoured water","Apple juice",
				"orange juice,pomegranate juice","flavoured curd/yogurt","honey","maplesyrup",
				"jaggery","sweets","candies","chocolates","jams","jelly","chips","mayonaise","palmolien oil",
				"donuts","cakes","pastries","cookies","croissants","sweetened tea","Sweetened coffee",
				"banana","melon","butter","cheese","sweetened cereals","sweetened corn flakes",
				"sweetened puffed rice","sweetened bran flakes","sweetened instant oatmeal",
				"refined/all purpose flour","Alcoholic beverages","Processed meat",
				"processed Bacon","sausages","hot dogs","chicken nuggets","deli meat",
				"chicken pattie","backon","pickled mango","pickled tomatoes",
				"pickled cucmber","Canned fruits/vegetables ", "canned pineapple","canned peaches",
				"canned  mangos","canned pear", "canned mixed fruit", "canned mandarine", 
				"canned oranges", "canned cherries","packaged snacks","powdered milk",
				"dried beans","dried corn","dried peas","soft drinks","dairy milk","peanut butter","frozen food",
				"margarines","spreads","maida");




		List<String> eliminatedIngredientsPresentInTherecipe=new ArrayList<String>();

		for(int i=0;i<avoidingredients.size();i++) {

			for(int j=0;j<recipeIngredientsList.size();j++) {

				

				if(recipeIngredientsList.get(j).contains(avoidingredients.get(i))) {
					eliminatedIngredientsPresentInTherecipe.add(avoidingredients.get(i));

				}
				


			}
		}
		
		
		if(eliminatedIngredientsPresentInTherecipe.size()>0) {
			return true;

		}
		else
			return false;


	}
	
	public boolean ingredientsPCOSChecking(ArrayList<String> recipeIngredientsList) {

		List<String> avoidingPCOSredients=new ArrayList<String>();
		Collections.addAll(avoidingPCOSredients, "Cakes", "Pastries", "White bread", 
				"Fried food", "Pizza", "Burger", "Carbonated beverages", "Sugary foods", "sweets", "icecreams", "beverages-soda", "beverages-juices",
				"Red meat", "Processed meat", "Dairy", "Soy products", "Gluten", "Pasta", "White rice", "Doughnuts", "Fries",
				"Coffee", "Seed oils", "vegetable oil", "soybean oil", "canola oil", "rapeseed oil", "sunflower oil", "safflower oil",
				"Fried food");
		
		List<String> eliminatedIngredientsPresentInTherecipe=new ArrayList<String>();
		
		for(int i=0;i<avoidingPCOSredients.size();i++) {
			
			for(int j=0;j<recipeIngredientsList.size();j++) {
				
				//System.out.println(avoidingredients.get(i).indexOf(pizza.get(j)));
				
				if(recipeIngredientsList.get(j).contains(avoidingPCOSredients.get(i))) {
					eliminatedIngredientsPresentInTherecipe.add(avoidingPCOSredients.get(i));
					
				}
				
			}
		}
		
		if(eliminatedIngredientsPresentInTherecipe.size()>0) {
			return true;
		}
		else
			return false;	
	}
	
	public boolean ingredientsHyperTensionChecking(ArrayList<String> recipeIngredientsList) {

		List<String> avoidingHyperTensionredients=new ArrayList<String>();
		Collections.addAll(avoidingHyperTensionredients, "Salty food-chips","Salty food-pretzels","Salty food-crackers","snacks-chips","snacks-pretzels",
				"snacks-crackers","Caffeine-coffee","Caffeine-tea","soft drinks", "Alcohol", "Frozen food","meat-bacon","meat-ham", "Pickles", "Processed food",
				"canned food","Fried food","Sauces", "mayonnaise", "Processed meat-bacon","Processed meat-sausages","Processed meat-deli meats",
				"White rice", "white bread", "Peaches");
		
		
		List<String> eliminatedIngredientsPresentInTherecipe=new ArrayList<String>();
		
		for(int i=0;i<avoidingHyperTensionredients.size();i++) {
			
			for(int j=0;j<recipeIngredientsList.size();j++) {
				
				
				
				if(recipeIngredientsList.get(j).contains(avoidingHyperTensionredients.get(i))) {
					eliminatedIngredientsPresentInTherecipe.add(avoidingHyperTensionredients.get(i));
					
				}
				
			}
		}
		
		if(eliminatedIngredientsPresentInTherecipe.size()>0) {
			return true;	
		}
		else
			return false;
				
	}
	
	public boolean ingredientsHyperThyrodismChecking(ArrayList<String> recipeIngredientsList) {

		List<String> avoidhyperthyroidingredients=new ArrayList<String>();
		Collections.addAll(avoidhyperthyroidingredients, "Tofu","Edamame","Tempeh","Cauliflower","Cabbage",
				"Broccoli","Kale","Spinach","Sweet potatoes","Strawberries","Pine nuts","Peanuts","Peaches",
				"Green tea","Coffee","Alcohol","Soy milk","White bread","Cakes","pastries","Fried food","Sugar",
				"Processed food-ham","Processed food-bacon","Processed food-salami","Processed food-sausages","Frozen food","Gluten",
				"Sodas","Energy drinks containing caffeine","Packaged food-noodles","Packaged food-soups","Packaged food-salad",
				"Packaged food-dressings","Packaged food-sauces","Candies");
				
		List<String> eliminatedIngredientsPresentInTherecipe=new ArrayList<String>();
		
		for(int i=0;i<avoidhyperthyroidingredients.size();i++) {
			
			for(int j=0;j<recipeIngredientsList.size();j++) {
				
				
				
				if(recipeIngredientsList.get(j).contains(avoidhyperthyroidingredients.get(i))) {
					eliminatedIngredientsPresentInTherecipe.add(avoidhyperthyroidingredients.get(i));
					
				}
				
			
			}
		}
		
		if(eliminatedIngredientsPresentInTherecipe.size()>0) {
			return true;
			
		}
		else
			return false;
		
		}



}
