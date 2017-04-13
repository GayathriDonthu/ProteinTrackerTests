package com.proteinTracker.tests;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SeleniumTests {
	
	@Test
	public void canOpenGoogle() {
		WebDriver driver;
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\gayathri.guttikonda\\Desktop\\Gayathri\\Libraries\\Selenium\\geckodriver.exe");
		driver =new FirefoxDriver();
		driver.navigate().to("http://www.google.com");
		WebElement searchBox = driver.findElement(By.name("q"));
		searchBox.sendKeys("Avinash Babu Donthu");
		searchBox.submit();
	}
}
