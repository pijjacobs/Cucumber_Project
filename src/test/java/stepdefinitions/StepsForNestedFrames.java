package stepdefinitions;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import factory.DriverFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import locators.MCF_Locators;

public class StepsForNestedFrames {

	WebDriver driver;

	@Given("Open Browser and open URL")
	public void open_browser_and_open_url() {
		driver = DriverFactory.getDriver();
		driver.get("http://the-internet.herokuapp.com/?ref=hackernoon.com");

	}

	@When("Switch between Frames")
	public void switch_between_frames() {
		WebElement nested = driver.findElement(By.xpath(MCF_Locators.nested_frames));
		nested.click();

		driver.switchTo().frame("frame-top");
		driver.switchTo().frame("frame-right");
		WebElement rightFrame = driver.findElement(By.tagName("body"));
		String rightFrameText = rightFrame.getText();
		System.out.println(rightFrameText);
	}

	@Given("Open Browser enter URl and click notification messages")
	public void open_browser_enter_u_rl_and_click_notification_messages() {

		driver = DriverFactory.getDriver();
		driver.get("http://the-internet.herokuapp.com/?ref=hackernoon.com");

	}

	@When("notification message handling")
	public void notification_message_handling() throws InterruptedException {

		driver.findElement(By.xpath(MCF_Locators.notification_message)).click();

		Thread.sleep(5000);

		Alert alert = driver.switchTo().alert(); // switch to alert

		String alertMessage = driver.switchTo().alert().getText(); // capture alert message

		System.out.println(alertMessage); // Print Alert Message
		Thread.sleep(5000);
		alert.dismiss();

		String success = driver.findElement(By.xpath(MCF_Locators.alertmessage_success)).getText();
		System.out.println(success);
		Thread.sleep(3000);

		String unsuccess = driver.findElement(By.xpath(MCF_Locators.alertmessage_unsuccess)).getText();

		System.out.println(unsuccess);
		Thread.sleep(5000);
		alert.dismiss();
	}

	@When("click on redirect link")
	public void click_on_redirect_link() throws InterruptedException {

		driver.findElement(By.xpath(MCF_Locators.redirect_link)).click();
		driver.findElement(By.xpath(MCF_Locators.redirect_link1)).click();
		driver.findElement(By.xpath(MCF_Locators.code_200)).click();
		driver.findElement(By.xpath(MCF_Locators.code_200_back)).click();
		driver.findElement(By.xpath(MCF_Locators.code_301)).click();
		driver.findElement(By.xpath(MCF_Locators.code_301_back)).click();
		driver.findElement(By.xpath(MCF_Locators.code_404)).click();
		driver.findElement(By.xpath(MCF_Locators.code_404_back)).click();
		driver.findElement(By.xpath(MCF_Locators.code_500)).click();
		driver.findElement(By.xpath(MCF_Locators.code_500_back)).click();
		driver.findElement(By.xpath(MCF_Locators.redirect_link2)).click();
		Thread.sleep(3000);
		String title = driver.getTitle();
		System.out.println(title);

	}

}
