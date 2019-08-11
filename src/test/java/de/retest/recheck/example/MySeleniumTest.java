package de.retest.recheck.example;

import java.nio.file.Paths;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import de.retest.web.selenium.By;

public class MySeleniumTest {

	RemoteWebDriver driver;

	@Before
	public void setup() {
		driver =  new ChromeDriver();
	}

	@Test
	public void check_formPage() throws Exception {
		// To see differences, simply switch to formPage-changed.html below
		String url = Paths.get( "src/test/resources/formPage.html" ).toUri().toURL().toString();
		driver.get(url);

		driver.findElement(By.id("email")).sendKeys("Emil");
		driver.findElement(By.id("age")).sendKeys("16");
		driver.findElement(By.name("login")).submit();

		Assert.assertEquals(driver.findElement(By.id("email")).getText(), "");
	}

	@After
	public void tearDown() throws InterruptedException {
		driver.quit();
	}
}
