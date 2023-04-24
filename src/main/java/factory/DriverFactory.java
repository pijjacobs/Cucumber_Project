package factory;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.PageFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {

	public WebDriver driver;

	
	public static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<WebDriver>();
	
 
	

	public WebDriver init_driver(String browser) {
		
	

		System.out.println("browser value is: " + browser);

		if (browser.equals("chrome")) {
			
			WebDriverManager.chromedriver().setup();
			ChromeOptions options = new ChromeOptions();

			WebDriver driver = new ChromeDriver();
			
//			ChromeOptions chromeOptions = new ChromeOptions();
//			chromeOptions.addArguments("--start-maximized");
//			chromeOptions.addArguments("--remote-allow-origins=*"); //<-this is the fix
			
			 
//			tlDriver.set(new ChromeDriver(chromeOptions));
			
			tlDriver.set(new ChromeDriver());
		}
		else if (browser.equals("edge")) {
//			WebDriverManager.edgedriver().setup();
			System.setProperty("webdriver.edge.driver","C:\\Users\\james\\Downloads\\edgedriver_win64\\msedgedriver.exe");
			tlDriver.set(new EdgeDriver() );
		}
		else if (browser.equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			tlDriver.set(new FirefoxDriver());
		} else if (browser.equals("safari")) {
			tlDriver.set(new SafariDriver());
		} else {
			System.out.println("Please pass the correct browser value: " + browser);
		}

		getDriver().manage().deleteAllCookies();
		getDriver().manage().window().maximize();
		getDriver().manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		return getDriver();

	}

	public static synchronized WebDriver getDriver() {
		return tlDriver.get();
	}


}
