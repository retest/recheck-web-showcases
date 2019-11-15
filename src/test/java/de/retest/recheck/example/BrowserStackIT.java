package de.retest.recheck.example;

import java.net.URL;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import de.retest.recheck.Recheck;
import de.retest.recheck.RecheckImpl;
import de.retest.recheck.RecheckProperties;

class BrowserStackIT {

	public static final String USERNAME = "sebastianrler1";
	public static final String AUTOMATE_KEY = "Wqp2KsfqSHJpo3gCpkYg";
	public static final String URL = "https://" + USERNAME + ":" + AUTOMATE_KEY + "@hub-cloud.browserstack.com/wd/hub";

	private static final String testname = "retest.de";

	RemoteWebDriver driver;
	Recheck re;

	@Test
	public void checkGalaxy8() throws Exception {
		re = new RecheckImpl();
		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability("browserName", "android");
		caps.setCapability("device", "Samsung Galaxy S8");
		caps.setCapability("realMobile", "true");
		caps.setCapability("os_version", "7.0");
		caps.setCapability("name", testname);
		caps.setCapability("browserstack.debug", "true");

		driver = new RemoteWebDriver(new URL(URL), caps);
		re.startTest(testname);
		driver.get("http://www.retest.de");
		re.check(driver, "init");
		re.capTest();
	}

	@Test
	public void checkIPhone8() throws Exception {
		re = new RecheckImpl();
		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability("browserName", "iPhone");
		caps.setCapability("device", "iPhone 8 Plus");
		caps.setCapability("realMobile", "true");
		caps.setCapability("os_version", "11");
		caps.setCapability("name", testname);
		caps.setCapability("browserstack.debug", "true");

		driver = new RemoteWebDriver(new URL(URL), caps);
		re.startTest(testname);
		driver.get("http://www.retest.de");
		re.check(driver, "init");
		re.capTest();
	}

	@BeforeAll
	public static void setup() {
		System.setProperty(RecheckProperties.ROOT_ELEMENT_MATCH_THRESHOLD_PROPERTY_KEY, "0.0");
		System.setProperty(RecheckProperties.ELEMENT_MATCH_THRESHOLD_PROPERTY_KEY, "0.0");
	}

	@AfterEach
	public void tearDown() throws InterruptedException {
		driver.quit();
		re.cap();
	}
}
