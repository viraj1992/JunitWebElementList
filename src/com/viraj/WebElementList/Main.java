package com.viraj.WebElementList;

import static org.junit.Assert.*;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Main {
	WebDriver driver;
	String baseURL = "https://letskodeit.teachable.com/p/practice";

	@Before
	public void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver", 
				"C:\\Users\\Viraj\\Desktop\\Selenium Drivers\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();

	}
	
	@Test
	public void test() throws InterruptedException {
		driver.get(baseURL);
		List<WebElement> element1 = driver.findElements
				(By.xpath("//input[contains(@type, 'radio') and contains(@name, 'cars')]"));
		for(int i = 0; i < element1.size(); i++) {
			if(!(element1.get(i).isSelected())){
				element1.get(i).click();
				Thread.sleep(2000);
			}
		}
	}

	@After
	public void tearDown() throws Exception {
		driver.quit();
	}

	
}
