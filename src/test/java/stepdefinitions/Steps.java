package stepdefinitions;







import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import factory.DriverFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import locators.MCF_Locators;

public class Steps {
	WebDriver driver;
	Assert softAssert;
	WebDriverWait wait;
	

	@Given("open the browser")
	public void open_the_browser() {

		driver = DriverFactory.getDriver();
//		wait = new WebDriverWait(driver,Duration);

	}

	@When("Enter url")
	public void enter_url() {

		driver.get("https://www.mycontactform.com/");

	}

	@When("login using valid username and valid password")
	public void login_using_username_and_password() {

		WebElement username = driver.findElement(By.id(MCF_Locators.username));
		username.sendKeys("Prabhu123");
		WebElement password = driver.findElement(By.id(MCF_Locators.password));
		password.sendKeys("12345");
		WebElement login_button = driver.findElement(By.xpath(MCF_Locators.login_button));
		login_button.click();
		
		
		

	}

	@When("login using invalid username and valid password")
	public void login_using_invalid_username_and_valid_password() {

		WebElement username = driver.findElement(By.id(MCF_Locators.username));
		username.sendKeys("Prabhu12345");
		WebElement password = driver.findElement(By.id(MCF_Locators.password));
		password.sendKeys("12345");
		WebElement login_button = driver.findElement(By.xpath(MCF_Locators.login_button));
		login_button.click();
		WebElement loginError = driver.findElement(By.xpath(MCF_Locators.invalidLoginError));
		String error = loginError.getText();
		System.out.println("Error Message is "+ error);
		
		softAssert.assertEquals("Incorrect login, please try again.", loginError.getText());

	}

	@When("login using valid username and invalid password")
	public void login_using_valid_username_and_invalid_password() {

		WebElement username = driver.findElement(By.id(MCF_Locators.username));
		username.sendKeys("Prabhu123");
		WebElement password = driver.findElement(By.id(MCF_Locators.password));
		password.sendKeys("12");
		WebElement login_button = driver.findElement(By.xpath(MCF_Locators.login_button));
		login_button.click();
		WebElement loginError = driver.findElement(By.xpath(MCF_Locators.invalidLoginError));
		String error = loginError.getText();
		System.out.println("Error Message is "+ error);

	}

	@When("login using invalid username and invalid password")
	public void login_using_invalid_username_and_invalid_password() {

		WebElement username = driver.findElement(By.id(MCF_Locators.username));
		username.sendKeys("Prabhu");
		WebElement password = driver.findElement(By.id(MCF_Locators.password));
		password.sendKeys("12");
		WebElement login_button = driver.findElement(By.xpath(MCF_Locators.login_button));
		login_button.click();
		WebElement loginError = driver.findElement(By.xpath(MCF_Locators.invalidLoginError));
		String error = loginError.getText();
		System.out.println("Error Message is "+ error);

	}

	@When("login using empty username and empty password")
	public void login_using_empty_username_and_empty_password() throws InterruptedException {

		WebElement username = driver.findElement(By.id(MCF_Locators.username));
		username.sendKeys("");
		WebElement password = driver.findElement(By.id(MCF_Locators.password));
		password.sendKeys("");
		WebElement login_button = driver.findElement(By.xpath(MCF_Locators.login_button));
		login_button.click();
		
		WebElement loginError = driver.findElement(By.xpath(MCF_Locators.invalidLoginError));
		String error = loginError.getText();
		System.out.println("Error Message is "+ error);
		
		String title = driver.getTitle();
		System.out.println(title);
		

	}

	@Then("validate the page title")
	public void validate_the_page_title() {
		Assert.assertFalse(driver.getTitle().contentEquals("Free Contact and Email Forms - myContactForm.com"), "Title is not Matching");

	}
	@And("Navigate through all tabs")
	public void navigate_through_all_tabs() throws InterruptedException {
		
		WebElement home = driver.findElement(By.xpath(MCF_Locators.home));
		home.click();
		WebElement sample_forms = driver.findElement(By.xpath(MCF_Locators.sample_forms));
		sample_forms.click();
		WebElement features = driver.findElement(By.xpath(MCF_Locators.features));
		features.click();
		WebElement pricing = driver.findElement(By.xpath(MCF_Locators.pricing));
		pricing.click();
		WebElement help = driver.findElement(By.xpath(MCF_Locators.help));
		help.click();
		WebElement about_us = driver.findElement(By.xpath(MCF_Locators.about_us));
		about_us.click();
		WebElement resources = driver.findElement(By.xpath(MCF_Locators.resources));
		resources.click();
	   
	}
	@And("Navigate through rightside menu")
	public void navigate_through_rightside_menu() throws InterruptedException {
		

		Thread.sleep(2000);
		WebElement formSecurity = driver.findElement(By.xpath(MCF_Locators.form_security));
		formSecurity.click();
		Thread.sleep(2000);
		WebElement userInformation = driver.findElement(By.xpath(MCF_Locators.my_user_information));
		userInformation.click();
		Thread.sleep(2000);
		WebElement messageCenter = driver.findElement(By.xpath(MCF_Locators.message_center));
		messageCenter.click();
		Thread.sleep(2000);
		WebElement messagecentererror = driver.findElement(By.xpath(MCF_Locators.message_center_error));
		String errorprint1 = messagecentererror.getText();
		System.out.println(errorprint1);
		Thread.sleep(2000);
		WebElement contactManager = driver.findElement(By.xpath(MCF_Locators.contact_manager));
		contactManager.click();
		Thread.sleep(2000);
		WebElement errorMessage = driver.findElement(By.xpath(MCF_Locators.contact_error));
		String errorprint = errorMessage.getText();
		System.out.println(errorprint);
		Thread.sleep(2000);
		
		
	    
	}

}
