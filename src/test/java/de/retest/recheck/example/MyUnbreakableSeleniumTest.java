package de.retest.recheck.example;

import java.nio.file.Paths;

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
		driver = new RecheckDriver( new ChromeDriver());
	}

	@Test
	public void check_formPage() throws Exception {
		driver.startTest();
		// To see differences, simply switch to formPage-changed.html below
		String url = Paths.get( "src/test/resources/formPage.html" ).toUri().toURL().toString();
		driver.get(url);

		driver.findElement(By.id("email")).sendKeys("Emil");
		driver.findElement(By.id("age")).sendKeys("16");
		driver.findElement(By.name("login")).submit();

		driver.capTest();
	}

	@After
	public void tearDown() throws InterruptedException {
		driver.quit();
	}
}
