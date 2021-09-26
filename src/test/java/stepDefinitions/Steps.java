package stepDefinitions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


import io.cucumber.java.en.*;
import pageObjects.CalculatorPage;


public class Steps {

	public WebDriver driver; 
	
	/*
	 * public GoogleHomePage ghp;
	 * 
	 * public SecurePayHomePage sphp;
	 * 
	 * public SecurePayContactUsPage spcp;
	 */
	
	public CalculatorPage calPage;
	
	//public String url = "https://www.google.com.au";	
	
	public String url = "https://www.anz.com.au/personal/home-loans/calculators-tools/much-borrow/";	
	
	/*
	 * @Given
	 * ("User Launch browser and naviagte to Google and search Secure Pay and navigate to Secure Pay website"
	 * ) public void launch_browser_and_search_secure_pay() {
	 * 
	 * System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+
	 * "//LatestDriver/chromedriver.exe");
	 * 
	 * ChromeOptions options = new ChromeOptions();
	 * options.setExperimentalOption("excludeSwitches", new
	 * String[]{"enable-automation"}); WebDriver driver = new ChromeDriver(options);
	 * 
	 * driver.navigate().to(url); driver.manage().window().maximize();
	 * 
	 * ghp = new GoogleHomePage(driver);
	 * 
	 * ghp.search();
	 * 
	 * ghp.clickOnSearchResult();
	 * 
	 * }
	 */
	
	/*
	 * @When("User clicks on Contact us link and navigates to contact us page")
	 * public void user_clicks_on_contact_us_link() {
	 * 
	 * sphp = new SecurePayHomePage(driver);
	 * 
	 * sphp.ClickOnContactUsLink();
	 * 
	 * driver.getPageSource().contains("Contact our Sales Team");
	 * 
	 * }
	 */
	
	/*
	 * @Then("User should be able to fill the details in Contact us page") public
	 * void User_should_be_able_to_fill_the_details() {
	 * 
	 * spcp = new SecurePayContactUsPage(driver); spcp.enter_firstName();
	 * spcp.enter_lastName(); spcp.enter_email(); spcp.enter_phone();
	 * spcp.enter_company(); spcp.enter_website(); spcp.select_amount();
	 * spcp.enter_message();
	 * 
	 * }
	 */
	
	
	@Given ("Launch anz page")
	public void launch_browser_and_open_anz_page() {
		
		
		System.out.println(System.getProperty("user.dir"));
		System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"//LatestDriver/chromedriver.exe");
		
		//ChromeOptions options = new ChromeOptions(); 
		//options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"}); 
		driver = new ChromeDriver(); 
		
		driver.navigate().to(url);
		driver.manage().window().maximize();
		
		
	}
	
	@When("User enter details")
	public void user_enter_details() {
		
		calPage = new CalculatorPage(driver);
		
		calPage.select_app_type();
		
		  System.out.println("Completed When");
		
		
		
	}
	
	@Then("User should be able to see the outcome")
	public void user_should_be_able_to_see_the_outcome() {
	    // Write code here that turns the phrase above into concrete actions
		
		calPage.verify_outcome();
		
	  System.out.println("Completed Then");
	}
	
	@And("User should be able to start over")
	
	public void user_should_be_able_to_start_over() {
		
		calPage.start_over();
		
	}
	
	@And ("User should be able to try to work out with living expenses only")
	public void user_living_expenses_only() {
		calPage.error_message();
	}
		
		
}
