package de.retest.recheck.example;

import java.nio.file.Paths;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import de.retest.web.selenium.By;
import de.retest.web.selenium.RecheckDriver;

public class MyFirstTest {

	RecheckDriver driver;

	@Before
	public void setup() {
		final ChromeOptions opts = new ChromeOptions();
		opts.addArguments(
				// Enable headless mode to execute on Travis
				"--headless",
				// Use Chrome in container-based Travis CI enviroment (see https://docs.travis-ci.com/user/chrome#Sandboxing).
				"--no-sandbox" );
		driver = new RecheckDriver( new ChromeDriver(opts));
	}

	@Test
	public void check_formPage() throws Exception {
		driver.startTest();
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
