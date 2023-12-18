package stepDefinitions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


import io.cucumber.java.en.*;
import pageObjects.CalculatorPage;


public class Steps {

	public WebDriver driver; 
	
	public CalculatorPage calPage;	
	
	public String url = "https://www.anz.com.au/personal/home-loans/calculators-tools/much-borrow/";	
	

	@Given ("^User launches the anz home loan calculator page$")
	public void launch_browser_and_open_anz_page() {
		
		
		System.out.println(System.getProperty("user.dir"));
		
		System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"//LatestDriver/chromedriver");
		 
		driver = new ChromeDriver(); 
		
		driver.navigate().to(url);
		
		driver.manage().window().maximize();
		
		
	}
	
	@When("^User enters the income details$")
	public void enter_details() {
		
		calPage = new CalculatorPage(driver);
		
		calPage.enter_details();		 
		
		
	}
	
	@Then("^Borrowing estimate should be displayed$")
	public void veriyOutcome() {
		
		calPage.verify_outcome();
		
		driver.quit();

	}
	
	@When("^User clicks start over to check borrowing estimate after initial estimate$")
	public void clickStartOover() {
		
		calPage = new CalculatorPage(driver);
		
		calPage.enter_details();
		
		calPage.verify_outcome();
		
		calPage.click_start_over();			
		
	}
	
	@Then("^Form should be cleared$")
	public void validateStartOver() {
		
		calPage.validate_start_over();
		
		driver.quit();

	}
	
	@When("^User enters only living expenses$")
	public void click_workout_with_only_living_expenses() {
		
		calPage = new CalculatorPage(driver);
		
		calPage.click_workout_with_only_living_expenses();		
		
	}
	
	@Then("^Error message should be displayed$")
	public void validateErrorMessage() {
		
		calPage.validate_error_message();
		
		driver.quit();

	}

		
		
}
