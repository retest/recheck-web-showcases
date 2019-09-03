package de.retest.recheck.example;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import de.retest.recheck.Recheck;
import de.retest.recheck.RecheckImpl;

public class ExplicitChecksTest {

	RemoteWebDriver driver;
	Recheck re;

	@Before
	public void setup() {
		re = new RecheckImpl();
		driver =  new ChromeDriver();
	}

	@Test
	public void check() throws Exception {
		re.startTest();
		driver.get("https://assets.retest.org/demos/css/templated-intensify-2/index.html");
		re.check(driver, "init");
		re.capTest();
	}

	@After
	public void tearDown() throws InterruptedException {
		driver.quit();
		re.cap();
	}
}
