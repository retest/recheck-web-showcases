package de.retest.recheck.example;

import static org.junit.Assert.assertEquals;

import java.nio.file.Paths;

import org.junit.After;
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
	public void login() throws Exception {
		String url = Paths.get( "src/test/resources/demo-app.html" ).toUri().toURL().toString();
		driver.get(url);

		driver.findElement(By.id("username")).sendKeys("Simon");
		driver.findElement(By.id("password")).sendKeys("secret");
		driver.findElement(By.id("sign-in")).click();

		assertEquals(driver.findElement(By.tagName("h4")).getText(), "Success!");
	}

	@After
	public void tearDown() throws InterruptedException {
		driver.quit();
	}
}
