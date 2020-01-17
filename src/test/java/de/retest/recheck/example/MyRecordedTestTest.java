package de.retest.recheck.example;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import de.retest.recheck.RecheckOptions;
import de.retest.web.RecheckWebOptions;
import de.retest.web.selenium.RecheckDriver;

public class MyRecordedTestTest {
	private RecheckDriver driver;

	@BeforeEach
	public void setUp() {
		RecheckOptions opts = RecheckWebOptions.builder().enableReportUpload().build();
		driver = new RecheckDriver(new ChromeDriver(), opts);
	}

	@AfterEach
	public void tearDown() {
		driver.quit();
	}

	@Test
	public void myRecordedTest() {
		driver.get("https://assets.retest.org/demos/app/demo-app_btn-change.html");
		driver.findElement(By.id("username")).click();
		driver.findElement(By.id("username")).sendKeys("Simon");
		driver.findElement(By.id("password")).sendKeys("secret");
		driver.findElement(By.id("sign-in")).click();
	}
}
