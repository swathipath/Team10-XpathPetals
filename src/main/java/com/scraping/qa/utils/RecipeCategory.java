package com.scraping.qa.utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RecipeCategory {
	
	
	String category=null;
	List<String> CategoriesList=new ArrayList<String>();
	List<String> recipeCategory=new ArrayList<String>();
	
	public String getRecipeCategory(ArrayList<String> recipeList) {
		
	
	Collections.addAll(CategoriesList,"Breakfast","Lunch","Snacks","Dinner");
	System.out.println(recipeList);
	


	for(int i=0;i<CategoriesList.size();i++) {

		for(int j=0;j<recipeList.size();j++) {

			

			if(recipeList.get(j).contains(CategoriesList.get(i))) {
				recipeCategory.add(CategoriesList.get(i));

			}
			/*else {
				if(CategoriesList.get(i).contains(recipeList.get(j))) {
					recipeCategory.add(CategoriesList.get(i));

				}*/

			}


		}
	if(recipeCategory.size()==0) {
		
		category="lunch/dinner/snacks";
	}
	else {
		
	
	//System.out.println(recipeCategory);
	
	
	category=recipeCategory.get(0);
	
	for(int i=1;i<recipeCategory.size();i++) {
		
	
		if(!category.contains(recipeCategory.get(i))) {
		
		category=category+" , "+recipeCategory.get(i);
	}
		else
			category=category;
	}
	recipeCategory.clear();
	
	//System.out.println(category);
	
	

}
	return category;
}
}

