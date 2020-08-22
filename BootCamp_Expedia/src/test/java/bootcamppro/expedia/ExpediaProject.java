package bootcamppro.expedia;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;

public class ExpediaProject {
	
	WebDriver wdr;
	
	WebDriverWait w;
	
	@BeforeTest
	public void beforeTest() {
		String path = System.getProperty("user.dir");
		String browserName = "chrome";
		
		if (browserName.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", "/Users/rashidaislam/Documents/EclipseProject/Expedia_Project/Driver/chromedriver 8");
			wdr = new ChromeDriver();

		} else if (browserName.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", path + "\\drivers\\geckodriver.exe");
			wdr = new FirefoxDriver();
		} else if (browserName.equalsIgnoreCase("ie")) {
			System.setProperty("webdriver.ie.driver", path + "\\drivers\\IEDriverServer.exe");
			wdr = new InternetExplorerDriver();
		} else if (browserName.equalsIgnoreCase("edge")) {
			System.setProperty("webdriver.edge.driver", path + "\\drivers\\msedgedriver.exe");
			wdr = new EdgeDriver();
		} else if (browserName.equalsIgnoreCase("opera")) {
			System.setProperty("webdriver.opera.driver", path + "\\drivers\\operadriver.exe");
			wdr = new OperaDriver();
		}
		wdr.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}@Test
	public void f() throws InterruptedException {
		wdr.get("https://www.goggle.com");
		wdr.manage().window().maximize();
		wdr.get("https://www.expedia.com");
		wdr.findElement(By.linkText("Flights")).click();
		wdr.findElement(By.xpath("//button[@aria-label='Leaving from']")).click();
		wdr.findElement(By.id("location-field-leg1-origin")).sendKeys("DCA");
		Thread.sleep(4000);
		
		wdr.findElements(By.xpath("//*[@data-stid='location-field-leg1-origin-result-item']")).get(1).click();
		Thread.sleep(4000);

		WebElement destination = wdr.findElement(By.xpath("//*[@aria-label='Going to']"));
		destination.click();
		wdr.findElement(By.cssSelector("input#location-field-leg1-destination")).sendKeys("Arizona");
		Thread.sleep(3000);
		wdr.findElements(By.xpath("//*[@data-stid='location-field-leg1-destination-result-item']")).get(1).click();
		Thread.sleep(6000);
		
		Thread.sleep(3000);
		wdr.findElement(By.linkText("2 travelers")).click();
		wdr.findElement(By.xpath("//*[@id=\"adaptive-menu\"]/div/div/section/div[1]/div[1]/div/button[1]")).click();
		wdr.findElement(By.cssSelector("#adaptive-menu > div > div > div.uitk-scrim.guestsDoneBtn.fade-button > button"))
				.click();


		wdr.findElement(By.xpath("//button[@data-testid='submit-button']")).click();

		WebElement drop = wdr.findElement(By.id("sortDropdown"));

		Select s = new Select(drop);
		s.selectByIndex(2);
		Thread.sleep(2000);
		wdr.findElement(By.xpath("//*[@data-omniture-rfrr='FLT.SR.Filter.FareOptions.0']")).click();
		Thread.sleep(2000);
		wdr.findElement(By.cssSelector("[data-omniture-rfrr='FLT.SR.Filter.Stops.0")).click();
		Thread.sleep(3000);


		wdr.findElements(By.xpath("//button[@data-test-id='select-button']")).get(0).click();
		Thread.sleep(6000);
		wdr.findElements(By.xpath("//*[contains(@data-test-id,'select-button-')]")).get(0).click();
		Thread.sleep(6000);
		wdr.findElements(By.xpath("//*[@data-test-id='select-button']")).get(0).click();
		Thread.sleep(6000);
		wdr.findElements(By.xpath("//*[@data-test-id='select-button-1']")).get(0).click();
		Thread.sleep(6000);
		
		WebElement alert = wdr.findElement(By.cssSelector("a#forcedChoiceNoThanks"));
		WebDriverWait w = new WebDriverWait(wdr, 10);
		w.until(ExpectedConditions.elementToBeClickable(alert));
		alert.click();

		Set<String> ids = wdr.getWindowHandles();
		Iterator<String> iter = ids.iterator();
		String parent = iter.next();
		String child = iter.next();
		wdr.switchTo().window(child);
		System.out.println(wdr.getTitle());

		Thread.sleep(6000);
		wdr.findElement(By.id("bookButton")).click();

		wdr.findElement(By.id("firstname[0]")).sendKeys("Rashida");
		wdr.findElement(By.id("lastname[0]")).sendKeys("Islam");

		Select se = new Select(wdr.findElement(By.xpath("//*[@aria-label='Country/Territory Code']")));
		se.selectByValue("1");

		wdr.findElement(By.id("phone-number[0]")).sendKeys("1234567890");
		wdr.findElement(By.id("confirmation-sms-provider-checkbox")).click();
		wdr.findElement(By.id("gender_female[0]")).click();

		Select month = new Select(wdr.findElement(By.id("date_of_birth_month0")));
		month.selectByIndex(1);
		Select day = new Select(wdr.findElement(By.id("date_of_birth_day[0]")));
		day.selectByIndex(2);
		Select year = new Select(wdr.findElement(By.id("date_of_birth_year[0]")));
		year.selectByValue("1970");

		wdr.findElement(By.cssSelector("input[name='creditCards[0].cardholder_name']")).sendKeys("Rashida Islam");
		wdr.findElement(By.id("creditCardInput")).sendKeys("1234567890123456");
		Select expireMonth = new Select(wdr.findElement(By.xpath("//*[@name='creditCards[0].expiration_month']")));
		expireMonth.selectByIndex(1);
		Select expireYear = new Select(wdr.findElement(By.cssSelector("[name='creditCards[0].expiration_year']")));
		expireYear.selectByValue("2024");

		wdr.findElement(By.id("new_cc_security_code")).sendKeys("012");

		Select billingCountry = (Select) wdr.findElement(By.xpath("//*[@name='creditCards[0].country']"));
		billingCountry.selectByValue("USA");
		wdr.findElement(By.xpath("//*[@name='creditCards[0].street']")).sendKeys("2547 Washington Blvd");
		wdr.findElement(By.xpath("//*[@name='creditCards[0].city']")).sendKeys("Arlington");
		Select state = new Select(wdr.findElement(By.cssSelector("[required name='creditCards[0].state']")));
		state.selectByValue("VA");
		wdr.findElement(By.xpath("//*[@name='creditCards[0].zipcode']")).sendKeys("22201");
		wdr.findElement(By.xpath("//input[@type='email']")).sendKeys("rashi@yahoo.com");
		wdr.findElement(By.id("complete-booking")).click();

	}

@AfterTest
	public void afterTest() {
		
	}

}
