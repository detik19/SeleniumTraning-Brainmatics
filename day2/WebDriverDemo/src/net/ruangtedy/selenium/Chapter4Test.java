package net.ruangtedy.selenium;

import java.io.File;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Chapter4Test {
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
		driver.navigate().to("http://book.theautomatedtester.co.uk/chapter4");
		driver.manage().window().maximize();

		driver.findElement(By.id("dateInput")).sendKeys(Long.toString(countDown()));
		
	}
	
	@Test
	public void test2(){
		driver.navigate().to("http://book.theautomatedtester.co.uk/chapter4");
		driver.manage().window().maximize();
		String lala=driver.findElement(By.id("bid")).getText();
		Integer nextBid=Integer.parseInt(lala)+10;
		driver.findElement(By.id("nextBid")).sendKeys(nextBid.toString());
		screenShot("lala.png");
	}
	
	public void screenShot(String output){
		File srcFile=((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(srcFile, new File(output));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	private long countDown(){
	    int SECONDS_IN_A_DAY = 24 * 60 * 60;

		Calendar thatDay = Calendar.getInstance();
        thatDay.setTime(new Date(0)); /* reset */
        thatDay.set(Calendar.DAY_OF_MONTH,6);
        thatDay.set(Calendar.MONTH,5); // 0-11 so 1 less
        thatDay.set(Calendar.YEAR, 2016);

        Calendar today = Calendar.getInstance();
        long diff =  thatDay.getTimeInMillis() - today.getTimeInMillis(); 
        long diffSec = diff / 1000;

        long days = diffSec / SECONDS_IN_A_DAY;
     //   long secondsDay = diffSec % SECONDS_IN_A_DAY;
      //  long seconds = secondsDay % 60;
      //  long minutes = (secondsDay / 60) % 60;
       // long hours = (secondsDay / 3600); // % 24 not needed
        System.out.println(days);
        return days;

	}
	

}
