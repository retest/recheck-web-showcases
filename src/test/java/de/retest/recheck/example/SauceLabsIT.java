package de.retest.recheck.example;

import java.net.URL;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import de.retest.recheck.Recheck;
import de.retest.recheck.RecheckImpl;
import de.retest.recheck.RecheckProperties;

class SauceLabsIT {

	private static final String sauceUserName = "roessler1";
	private static final String sauceAccessKey = "49342fea-55f6-4c60-9402-aac73de16828";

	private static final String remoteUrl = "http://ondemand.eu-central-1.saucelabs.com/wd/hub";
	//	private static final String targetUrl = "https://assets.retest.org/demos/app/demo-app.html";
	private static final String targetUrl = "https://retest.de";
	private static final String testName = "retest.de";
	private static final String checkName = "initial";

	private WebDriver driver;
	private Recheck re;

	@Test
	public void checkChrome74_Win10() throws Exception {
		re = new RecheckImpl();
		re.startTest(testName);
		DesiredCapabilities capabilities = createCapabilities("Chrome", "74.0", "Windows 10");
		driver = new RemoteWebDriver(new URL("http://ondemand.eu-central-1.saucelabs.com/wd/hub"), capabilities);

		driver.get(targetUrl);
		Thread.sleep(1000);
		re.check(driver, checkName);

		re.capTest();
	}

	@Test
	public void checkFirefox_Windows10() throws Exception {
		re = new RecheckImpl();
		re.startTest(testName);
		DesiredCapabilities capabilities = createCapabilities("Firefox", "67.0", "Windows 10");
		driver = new RemoteWebDriver(new URL(remoteUrl), capabilities);

		driver.get(targetUrl);
		Thread.sleep(1000);
		re.check(driver, checkName);

		re.capTest();
	}

	@Test
	public void checkSafari11_MacOs10() throws Exception {
		re = new RecheckImpl();
		re.startTest(testName);
		DesiredCapabilities capabilities = createCapabilities("Safari", "11.1", "macOS 10.13");
		driver = new RemoteWebDriver(new URL(remoteUrl), capabilities);

		driver.get(targetUrl);
		Thread.sleep(1000);
		re.check(driver, checkName);

		re.capTest();
	}

	@Test
	public void checkIE11_Windows10() throws Exception {
		re = new RecheckImpl();
		re.startTest(testName);
		DesiredCapabilities capabilities = createCapabilities("internet explorer", "11.285", "Windows 10");
		driver = new RemoteWebDriver(new URL(remoteUrl), capabilities);

		driver.get(targetUrl);
		Thread.sleep(1000);
		re.check(driver, checkName);

		re.capTest();
	}

	@AfterEach
	public void afterTest() {
		driver.quit();
		re.cap();
	}

	@BeforeAll
	public static void setup() {
		System.setProperty(RecheckProperties.ROOT_ELEMENT_MATCH_THRESHOLD_PROPERTY_KEY, "0.0");
		System.setProperty(RecheckProperties.ELEMENT_MATCH_THRESHOLD_PROPERTY_KEY, "0.0");
	}

	private static DesiredCapabilities createCapabilities(String browser, String browserVersion, String os) {
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("username", sauceUserName);
		capabilities.setCapability("accessKey", sauceAccessKey);
		capabilities.setCapability("browserName", browser);
		capabilities.setCapability("version", browserVersion);
		capabilities.setCapability("screenResolution", "1600x1200");
		capabilities.setCapability("platform", os);
		capabilities.setCapability("name", testName);
		return capabilities;
	}
}
