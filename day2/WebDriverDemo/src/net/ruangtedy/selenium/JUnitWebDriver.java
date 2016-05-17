package net.ruangtedy.selenium;

import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class JUnitWebDriver {

	WebDriver driver;

	@Before
	public void setUp() {
		driver = new FirefoxDriver();

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@After
	public void tearDown() {
		driver.quit();
	}

	@Test
	public void test() {
		driver.navigate().to("http://calculator.net/");
		driver.manage().window().maximize();
		driver.findElement(By.xpath(".//*[@id='menu']/div[3]/a")).click();

		// Click on Percent Calculators
		driver.findElement(By.xpath(".//*[@id='menu']/div[4]/div[3]/a"))
				.click();

		// Enter value 10 in the first number of the percent Calculator
		driver.findElement(By.id("cpar1")).sendKeys("10");

		// Enter value 50 in the second number of the percent Calculator
		driver.findElement(By.id("cpar2")).sendKeys("50");

		// Click Calculate Button
		driver.findElement(
				By.xpath(".//*[@id='content']/table/tbody/tr[2]/td/input[2]"))
				.click();

		// Get the Result Text based on its xpath
		String result = driver.findElement(
				By.xpath(".//*[@id='content']/p[2]/font/b")).getText();

		// Print a Log In message to the screen
		System.out.println(" The Result is " + result);

	}

}
