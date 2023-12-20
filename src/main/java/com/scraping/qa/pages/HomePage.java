package com.scraping.qa.pages;

import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeoutException;

import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.scraping.qa.utils.CheckingIngredients;
import com.scraping.qa.utils.ExcelWriter;
import com.scraping.qa.utils.RecipeCategory;
import com.scraping.qa.utils.ToAddIngredients;

public class HomePage {

	CheckingIngredients ci = new CheckingIngredients();
	ExcelWriter excelwriter = new ExcelWriter();
	RecipeCategory recipecategory = new RecipeCategory();
	ToAddIngredients toadd = new ToAddIngredients();

	WebDriver driver;
	// ArrayList<String> recipeLink;
	ArrayList<String> recipeName;
	// ArrayList<String> ingredientsLinks;
	ArrayList<String> ingredientsLists;
	ArrayList<String> nutrientsList;
	ArrayList<String> recipeIds;
	ArrayList<String> dataToExcel;
	ArrayList<String> methodPreparationList;
	String pagesUrl;
	String replaceAlpha = "P";
	ArrayList<String> tagsData;
	ArrayList<String> captionsList;
	ArrayList<String> foodCategoryList;
	ArrayList<String> linkForPages;
	String eachRecipeId;
	String eachRecipeName;
	String category;
	String excelRecipeCategory;
	String ingredient;
	String ingredientToExcel;
	String prepTimeToExcel;
	String cookTimeToExcel;
	String methodPrep;
	String methodPrepToExcel;
	String nutrients;
	String nutrientsToExcel;
	String recipeLink;
	String recipeLinkToExcel;
	String replaceEachPage;
	String replaceEachPopUp;
	// String categoryOfFood;
	String foodCategoryToExcel;
	boolean verifyingredientsfordiabetes;
	String commonPathForEachLink = "//*[@id=\"replcaestr\"]/div[3]/span[1]/a";
	String commonPathForEachAplhabet = "//table[@class='mnualphaitem ctl00_cntleftpanel_mnuAlphabets_4']//a[text()='"
			+ replaceAlpha + "']";
	String commonPathForRecipeLink = "//*[@id=\"replcaestr\"]/div[3]/span[1]/a";
	String commonPathForEachPage = "//a[@class='respglink' and text()='replaceEachPage']";
	String pathForNutrientsTable = "//table[@id='rcpnutrients']";
	String commonPathForPopUp = "//div[@id='replaceEachPopUp']//div[@class='popupbg']";
	String pathForPreparationTime = "//*[@id=\"ctl00_cntrightpanel_pnlRecipeScale\"]/section/p[2]/time";

	@FindBy(id = ("ctl00_txtsearch"))
	WebElement searchText;
	@FindBy(id = "ctl00_imgsearch")
	WebElement searchButton;
	@FindBy(xpath = "//*[@id=\"ctl00_cntrightpanel_pnlRecipeScale\"]/section/p[2]/time")
	List<WebElement> prepTimeElement;
	@FindBy(xpath = "//span[contains(@itemprop,'recipeIngredient')]")
	List<WebElement> ingredientsLinks;
	@FindBy(xpath = "//table[@id='rcpnutrients']")
	WebElement nutrientTable;
	@FindBy(xpath = "//div[@id='ctl00_cntrightpanel_pnlRcpMethod']//div//span[contains(@itemprop,'text')]")
	List<WebElement> methodelements;
	@FindBy(className = "respglink")
	List<WebElement> linksOfNumOfPages;
	@FindBy(xpath = "//a[@class='respglink' and text()='3']")
	WebElement thirdPageLink;
	@FindBy(className = "rcc_recipename")
	List<WebElement> recepiesListOnThePage;
	@FindBy(className = "rcc_recipecard")
	List<WebElement> recepieIdPath;
	@FindBy(xpath = "//a[text()='Recipe A To Z']")
	WebElement AtoZRecipies;
	@FindBy(xpath = "//table[@class='mnualphaitem ctl00_cntleftpanel_mnuAlphabets_4']")
	WebElement commonPathForAtoZLinks;
	@FindBy(xpath = "//table[@class='mnualphaitem ctl00_cntleftpanel_mnuAlphabets_4']//a[text()='B']")
	WebElement linkForU;
	@FindBy(xpath = "//*[@id=\"nav\"]/li[1]/a/div")
	WebElement recipeButton;
	@FindBy(xpath = "//a[@id='ctl00_cntleftpanel_ttlhealthtree_tvTtlHealtht46']")
	WebElement diabeticlink;
	@FindBy(xpath = "//div[@id='recipe_tags']//span[contains(@itemprop,'name')]")
	List<WebElement> tagsRecipeList;
	@FindBy(xpath = "//div[@class='rcc_caticons']")
	List<WebElement> recipeCaptions;

	

	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void clickOnAtoZRecipies() {

		AtoZRecipies.click();
		linkForU.click();

	}


	

	public String getTagsData() throws TimeoutException {

		tagsData = new ArrayList<>();
		for (WebElement i : tagsRecipeList) {
		
			tagsData.add(i.getText());
		}

		category = recipecategory.getRecipeCategory(tagsData);
		return category;

	}

	public String verifyJain(String recipeName) {

		boolean tagContainsJain = false;
		String s = null;

		tagsData = new ArrayList<>();
		for (WebElement i : tagsRecipeList) {
		
			tagsData.add(i.getText());
		}
		for (String data : tagsData) {
			tagContainsJain = data.contains("Jain");
		}

		if (recipeName.contains("Jain)") || tagContainsJain) {
			s = "Jain";
		}

		return s;

	}

	public String verifyFoodCategory(String recipeName) {

		ArrayList<String> containsEgg = new ArrayList<>();
		String foodCategory = null;

		tagsData = new ArrayList<>();
		for (WebElement i : tagsRecipeList) {
			
			tagsData.add(i.getText());
		}

		containsEgg = getRecepieIngredients();
		String listOfIngredients = ingredientsAsAString(containsEgg);

		for (String tag : tagsData) {
			if (tag.contains("Jain") || recipeName.contains("Jain")) {
				foodCategory = "Jain";
			} else if (tag.contains("Vegan") || recipeName.contains("Vegan")) {
				foodCategory = "Vegan";
			}

			else if (listOfIngredients.contains("eggs")) {
				foodCategory = "Eggitarian";

			} else
				foodCategory = "Vegitarian";

		}

		return foodCategory;

	}

	public String getPrepTime() {

		String prepTimeCombined;
		String PreparationTime = null;
		List<String> preptime = new ArrayList<>();

		for (WebElement e : prepTimeElement) {

			preptime.add(e.getAttribute("itemprop"));
			preptime.add(e.getText());

		}
		
		prepTimeCombined = preptime.get(0);
		for (int i = 1; i < preptime.size(); i++) {
			prepTimeCombined = prepTimeCombined + preptime.get(i);
		}
		
		if (prepTimeCombined.contains("prepTime")) {
			String s1 = prepTimeCombined.substring(prepTimeCombined.indexOf("prepTime"));
			PreparationTime = s1.substring(8, 14);
			System.out.println("Prep Time=" + PreparationTime);
		}

		else

			PreparationTime = "0";

		return PreparationTime;
	}

	public String getCookingTime() {

		String cookTimeCombined;
		String cookTime = null;
		List<String> timeCook = new ArrayList<>();
		for (WebElement e : prepTimeElement) {
			timeCook.add(e.getAttribute("itemprop"));
			timeCook.add(e.getText());

		}
		cookTimeCombined = timeCook.get(0);
		for (int i = 1; i < timeCook.size(); i++) {
			cookTimeCombined = cookTimeCombined + timeCook.get(i);

		}

		if (cookTimeCombined.contains("cookTime")) {
			String s1 = cookTimeCombined.substring(cookTimeCombined.indexOf("cookTime"));
			cookTime = s1.substring(8, 14);
			

		}

		else
			cookTime = "0";

		return cookTime;

	}

	public ArrayList<String> getRecepieIngredients() {

		ingredientsLists = new ArrayList<>();
		

		for (WebElement e : ingredientsLinks) {
			ingredientsLists.add(e.getText());
			

		}
		return ingredientsLists;

	}

	public String ingredientsAsAString(ArrayList<String> ingredientsList) {

		if (ingredientsList.size() > 0) {
			ingredient = ingredientsList.get(0);
			for (String s : ingredientsList) {

				ingredient = ingredient + s;
			}
		} else
			ingredient = null;

		return ingredient;
	}

	public String getNutrientsList() {

		nutrientsList = new ArrayList<>();
		
		List<WebElement> rows = nutrientTable.findElements(By.xpath("//tr"));
		for (WebElement row : rows) {
			List<WebElement> cells = row.findElements(By.xpath(".//td"));
			for (WebElement cell : cells) {
				
				nutrientsList.add(cell.getText());
			}
		}
		nutrients = nutrientsList.get(0);
		for (String n : nutrientsList) {

			nutrients = nutrients + n;

		}
		return nutrients;

	}

	public String getMethodPreparation() {

		methodPreparationList = new ArrayList<>();
		
		for (WebElement i : methodelements) {

			methodPreparationList.add(i.getText());
			

		}

		methodPrep = methodPreparationList.get(0);
		for (String mp : methodPreparationList) {
			methodPrep = methodPrep + mp;

		}
		return methodPrep;

	}

	public boolean verifyMorbidityForDiabetes() {

		verifyingredientsfordiabetes = ci.ingredientsChecking(getRecepieIngredients());
		
		if (verifyingredientsfordiabetes == false) {
			ingredientToExcel = ingredientsAsAString(getRecepieIngredients());
			dataToExcel.add(ingredientToExcel);
			
		}
		return verifyingredientsfordiabetes;

	}

	public boolean verifyMorbidityForHyporthyroid() {

		boolean verifyingredientsforHyperthyroid = ci.ingredientsHyperThyrodismChecking(getRecepieIngredients());
		
		if (verifyingredientsforHyperthyroid == false) {
			ingredientToExcel = ingredientsAsAString(getRecepieIngredients());
			dataToExcel.add(ingredientToExcel);

		}
		return verifyingredientsforHyperthyroid;

	}

	public boolean verifyMorbidityForHypertension() {

		boolean verifyingredientsforHypertension = ci.ingredientsHyperTensionChecking(getRecepieIngredients());
		
		if (verifyingredientsforHypertension == false) {
			ingredientToExcel = ingredientsAsAString(getRecepieIngredients());
			dataToExcel.add(ingredientToExcel);

		}
		return verifyingredientsforHypertension;

	}

	public boolean verifyMorbidityForPCOS() {

		boolean verifyingredientsforPCOS = ci.ingredientsPCOSChecking(getRecepieIngredients());
		
		if (verifyingredientsforPCOS == false) {
			ingredientToExcel = ingredientsAsAString(getRecepieIngredients());
			dataToExcel.add(ingredientToExcel);

		}
		return verifyingredientsforPCOS;

	}

	public boolean verifyToAddForDiabetes() {

		boolean verifyAddForDiabetes = toadd.toAddForDiabetes(getRecepieIngredients());
		
		if (verifyAddForDiabetes == true) {
			ingredientToExcel = ingredientsAsAString(getRecepieIngredients());
		}

		return verifyAddForDiabetes;
	}

	public boolean verifyToAddForHypothyroid() {

		boolean verifyAddForHypothyroid = toadd.toAddForHypothyroid(getRecepieIngredients());
	
		if (verifyAddForHypothyroid == true) {
			ingredientToExcel = ingredientsAsAString(getRecepieIngredients());
		}

		return verifyAddForHypothyroid;
	}

	public boolean verifyToAddForHypertension() {

		boolean verifyAddForHypertension = toadd.toAddForHypertension(getRecepieIngredients());
		
		if (verifyAddForHypertension == true) {
			ingredientToExcel = ingredientsAsAString(getRecepieIngredients());
		}

		return verifyAddForHypertension;
	}

	public boolean verifyToAddForPCOS() {

		boolean verifyAddForPCOS = toadd.toAddForPCOS(getRecepieIngredients());
		
		if (verifyAddForPCOS == true) {
			ingredientToExcel = ingredientsAsAString(getRecepieIngredients());
		}

		return verifyAddForPCOS;
	}

	

	public void writingDataToExcel(String eachRecipeId2, String eachRecipeName2, String excelRecipeCategory2,
			String foodCategoryToExcel2, String ingredientToExcel2, String prepTimeToExcel2, String cookTimeToExcel2,
			String methodPrepToExcel2, String nutrientsToExcel2, String morbidity, String recipeLink2, String sheetName)
			throws IOException {

		excelwriter.writingDataToExcel(eachRecipeId2, 1, sheetName);
		excelwriter.writingDataToExcel(eachRecipeName2, 2, sheetName);
		excelwriter.writingDataToExcel(excelRecipeCategory2, 3, sheetName);
		excelwriter.writingDataToExcel(foodCategoryToExcel2, 4, sheetName);
		excelwriter.writingDataToExcel(ingredientToExcel2, 5, sheetName);
		excelwriter.writingDataToExcel(prepTimeToExcel2, 6, sheetName);
		excelwriter.writingDataToExcel(cookTimeToExcel2, 7, sheetName);
		excelwriter.writingDataToExcel(methodPrepToExcel2, 8, sheetName);
		excelwriter.writingDataToExcel(nutrientsToExcel2, 9, sheetName);
		excelwriter.writingDataToExcel(morbidity, 10, sheetName);
		excelwriter.writingDataToExcel(recipeLink2, 11, sheetName);

	}

	public ArrayList<String> numOfPages() {
		int pageNo;
		int totalPages = 1;
		List<WebElement> noOfPages = driver.findElements(By.xpath("//a[@class='respglink']"));
		
		pageNo = noOfPages.size() / 2 - 1;
		totalPages = Integer.parseInt(noOfPages.get(pageNo).getText());
		System.out.println(totalPages);
		linkForPages = new ArrayList<>();

		for (int i = 1; i <= totalPages; i++) {

			String s = noOfPages.get(i).getAttribute("href");
			
			if (!linkForPages.contains(s)) {
				linkForPages.add(s);
			}

		}
		System.out.println(linkForPages.size());
		return linkForPages;
	}



	public void iteratePages() throws IOException, TimeoutException {

		ArrayList<String> pageLink = new ArrayList<>();

		
		int pageNo = 1;
		String alp, url;
		int totalPages = 1;
		for (char c = 'A'; c <= 'Z'; c++) {
			
			url = "https://www.tarladalal.com/RecipeAtoZ.aspx?beginswith=" + c + "&pageindex=" + totalPages;
			
			driver.get(url);
			List<WebElement> page = driver.findElements(By.xpath("//a[@class='respglink']"));
			
			pageNo = page.size() / 2 - 1;
			totalPages = Integer.parseInt(page.get(pageNo).getText());
			for (int i = 1; i <= totalPages; i++) {
				url = "https://www.tarladalal.com/RecipeAtoZ.aspx?beginswith=" + c + "&pageindex=" + i;
				driver.get(url);
				readingEachRecipe();
			}

		}

	}

	public void readingEachRecipe() throws IOException, TimeoutException {

		recipeName = new ArrayList<>();
		recipeIds = new ArrayList<>();
		dataToExcel = new ArrayList<>();

		String pageUrl = driver.getCurrentUrl();

		for (WebElement id : recepieIdPath) {

			recipeIds.add(id.getAttribute("id"));

		}
		for (int i = 0; i < recipeIds.size(); i++) {

			// recipe id
			eachRecipeId = recipeIds.get(i);

			System.out.println(eachRecipeId);
			// recipe link and recipe name
			String linkForEachRecipie = commonPathForEachLink.replace("replcaestr", eachRecipeId);
			String linkForEachRecipe = commonPathForRecipeLink.replace("replcaestr", eachRecipeId);
			recipeLink = driver.findElement(By.xpath(linkForEachRecipe)).getAttribute("href");
			eachRecipeName = (driver.findElement(By.xpath(linkForEachRecipie)).getText());

			System.out.println(eachRecipeName);
			try {
				driver.findElement(By.xpath(linkForEachRecipie)).click();
				String url = driver.getCurrentUrl();
			} catch (UnhandledAlertException f) {
				try {
					String popUpLink = commonPathForPopUp.replace("replaceEachPopUp", eachRecipeId);
					Boolean ispopupPresent = driver.findElements(By.xpath(popUpLink)).size() > 0;
					if (ispopupPresent) {

						Set<String> a = driver.getWindowHandles();
						Iterator<String> it = a.iterator();
						String chlwnd = it.next();
						String pwnd = it.next();

						driver.switchTo().alert().accept();
						;
						// alert.accept();
						driver.switchTo().window(pwnd);
					}
				} catch (NoAlertPresentException e) {
					e.printStackTrace();
				}
			}

			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

			// recipe category

			excelRecipeCategory = getTagsData();
			dataToExcel.add(excelRecipeCategory);

			// food category

			foodCategoryToExcel=(verifyFoodCategory(eachRecipeName));

			// preparation time

			prepTimeToExcel = getPrepTime();
			dataToExcel.add(prepTimeToExcel);
			// }

			// cooking time
			cookTimeToExcel = getCookingTime();
			dataToExcel.add(cookTimeToExcel);
			// method preparation
			methodPrepToExcel = getMethodPreparation();
			dataToExcel.add(methodPrepToExcel);

			boolean verifyForDiabetes = verifyMorbidityForDiabetes();
			boolean verifyForHyperthyroid = verifyMorbidityForHyporthyroid();
			boolean verifyForHypertension = verifyMorbidityForHypertension();
			boolean verifyForPCOS = verifyMorbidityForPCOS();

			// nutrition values
			Boolean isPresent = driver.findElements(By.xpath(pathForNutrientsTable)).size() > 0;

			if (isPresent) {
				nutrientsToExcel = getNutrientsList();
				dataToExcel.add(nutrientsToExcel);
				driver.navigate().to(pageUrl);
			} else {
				driver.navigate().to(pageUrl);
			}

			if (verifyForDiabetes == false) {

				writingDataToExcel(eachRecipeId, eachRecipeName, excelRecipeCategory, foodCategoryToExcel,
						ingredientToExcel, prepTimeToExcel, cookTimeToExcel, methodPrepToExcel, nutrientsToExcel,
						"Diabeties", recipeLink, "diabetic");

				boolean verifyToAdd = verifyToAddForDiabetes();
				if (verifyToAdd) {
					writingDataToExcel(eachRecipeId, eachRecipeName, excelRecipeCategory, foodCategoryToExcel,
							ingredientToExcel, prepTimeToExcel, cookTimeToExcel, methodPrepToExcel, nutrientsToExcel,
							"Diabeties", recipeLink, "ToAddDiabetes");

				}

			}

			if (verifyForHyperthyroid == false) {

				writingDataToExcel(eachRecipeId, eachRecipeName, excelRecipeCategory, foodCategoryToExcel,
						ingredientToExcel, prepTimeToExcel, cookTimeToExcel, methodPrepToExcel, nutrientsToExcel,
						"Hyporthyroid", recipeLink, "Hypothyroid");

				boolean verifyToAdd = verifyToAddForHypothyroid();
				if (verifyToAdd) {
					writingDataToExcel(eachRecipeId, eachRecipeName, excelRecipeCategory, foodCategoryToExcel,
							ingredientToExcel, prepTimeToExcel, cookTimeToExcel, methodPrepToExcel, nutrientsToExcel,
							"Hyporthyroid", recipeLink, "ToAddHypothyroid");

				}
			}

			if (verifyForHypertension == false) {

				writingDataToExcel(eachRecipeId, eachRecipeName, excelRecipeCategory, foodCategoryToExcel,
						ingredientToExcel, prepTimeToExcel, cookTimeToExcel, methodPrepToExcel, nutrientsToExcel,
						"Hypertension", recipeLink, "Hypertension");

				boolean verifyToAdd = verifyToAddForHypertension();
				if (verifyToAdd) {
					writingDataToExcel(eachRecipeId, eachRecipeName, excelRecipeCategory, foodCategoryToExcel,
							ingredientToExcel, prepTimeToExcel, cookTimeToExcel, methodPrepToExcel, nutrientsToExcel,
							"Hypertension", recipeLink, "ToAddHypertension");
				}

			}

			if (verifyForPCOS == false) {

				writingDataToExcel(eachRecipeId, eachRecipeName, excelRecipeCategory, foodCategoryToExcel,
						ingredientToExcel, prepTimeToExcel, cookTimeToExcel, methodPrepToExcel, nutrientsToExcel,
						"PCOS", recipeLink, "PCOS");

				boolean verifyToAdd = verifyToAddForPCOS();
				if (verifyToAdd) {
					writingDataToExcel(eachRecipeId, eachRecipeName, excelRecipeCategory, foodCategoryToExcel,
							ingredientToExcel, prepTimeToExcel, cookTimeToExcel, methodPrepToExcel, nutrientsToExcel,
							"PCOS", recipeLink, "ToAddPCOS");
				}

			}

		}
		recipeIds.clear();
		driver.get(pageUrl);

	}

}
