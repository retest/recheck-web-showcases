package de.retest.recheck.example;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.chrome.ChromeDriver;

import de.retest.web.selenium.By;
import de.retest.web.selenium.RecheckDriver;

public class MyUnbreakableSeleniumTest {

	RecheckDriver driver;

	@Before
	public void setup() {
		// RecheckOptions opts = RecheckOptions.builder().enableReportUpload().build();
		driver = new RecheckDriver( new ChromeDriver() );
	}

	@Test
	public void login() throws Exception {
		driver.startTest();
		// To see differences, simply switch to demo-app_btn-change.html
		driver.get("https://assets.retest.org/demos/app/demo-app.html");

		driver.findElement(By.id("username")).sendKeys("Simon");
		driver.findElement(By.id("password")).sendKeys("secret");
		driver.findElement(By.id("sign-in")).click();

		driver.capTest();
	}

	@After
	public void tearDown() throws InterruptedException {
		driver.quit();
	}
}
