package pageObjects;

import static org.junit.Assert.assertTrue;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class CalculatorPage {

	public WebDriver ldriver;

	public CalculatorPage(WebDriver rdriver) {

		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);

	}

	@FindBy(xpath = "//input[@id='application_type_single']")
	WebElement application_type;

	@FindBy(xpath = "//select[@title='Number of dependants']")
	WebElement dependents;

	@FindBy(xpath = "//input[@id='borrow_type_home']")
	WebElement home_type;

	@FindBy(xpath = "//input[@aria-labelledby='q2q1']")
	WebElement total_income;

	@FindBy(xpath = "//input[@aria-labelledby='q2q2']")
	WebElement other_income;

	@FindBy(xpath = "//input[@aria-labelledby='q3q1']")
	WebElement living_expenses;

	@FindBy(xpath = "//input[@aria-labelledby='q3q2']")
	WebElement home_loan_payment;

	@FindBy(xpath = "//input[@aria-labelledby='q3q3']")
	WebElement other_loan_payment;

	@FindBy(xpath = "//input[@aria-labelledby='q3q4']")
	WebElement other_commitments;

	@FindBy(xpath = "//input[@aria-labelledby='q3q5']")
	WebElement credit_card_limits;

	@FindBy(xpath = "//*[@id='btnBorrowCalculater']")
	WebElement workout_button;

	////button[text()='Work out how much I could borrow']

	@FindBy(xpath = "//*[@id='borrowResultTextAmount']")
	WebElement result;

	@FindBy(xpath = "//button[@aria-label='Start over']")
	WebElement start_over;

	@FindBy(xpath = "//div[@class='borrow__error__text']")
	WebElement error_message;

	public void enter_details() {

		application_type.click();

		Select dependent = new Select(dependents);

		dependent.selectByIndex(0);

		home_type.click();
		total_income.click();
		total_income.sendKeys("80000");

		other_income.click();
		other_income.sendKeys("10000");

		living_expenses.click();
		living_expenses.sendKeys("500");

		home_loan_payment.click();
		home_loan_payment.sendKeys("0");

		other_loan_payment.click();
		other_loan_payment.sendKeys("100");

		other_commitments.click();
		other_commitments.sendKeys("0");

		credit_card_limits.click();
		credit_card_limits.sendKeys("10000");

		workout_button.click();

	}

	public void verify_outcome() {


		assertTrue(result.getAttribute("value").equals("407,000"));
	}

	public void click_start_over() {

		start_over.click();

	}

	public void validate_start_over() {

		assertTrue(application_type.isSelected());
		Select dependent = new Select(dependents);
		assertTrue(dependent.getFirstSelectedOption().getText().equals("0"));
		assertTrue(home_type.isSelected());

		assertTrue(total_income.getAttribute("value").equals("0"));
		assertTrue(other_income.getAttribute("value").equals("0"));
		
		assertTrue(living_expenses.getAttribute("value").equals("0"));
		assertTrue(home_loan_payment.getAttribute("value").equals("0"));
		assertTrue(other_loan_payment.getAttribute("value").equals("0"));
		assertTrue(other_commitments.getAttribute("value").equals("0"));
		assertTrue(credit_card_limits.getAttribute("value").equals("0"));
	}
	
	public void click_workout_with_only_living_expenses() {

		living_expenses.click();
		living_expenses.sendKeys("1");
		workout_button.click();
	}

	public void validate_error_message() {

		String message = "Based on the details you've entered, we're unable to give you an estimate of your borrowing power with this calculator. For questions, call us on 1800 100 641.";
		assertTrue(error_message.getText().equalsIgnoreCase(message));

	}

}
