package de.retest.recheck.example;

import java.nio.file.Paths;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import de.retest.recheck.RecheckOptions;
import de.retest.recheck.persistence.ClassAndMethodBasedShortNamingStrategy;
import de.retest.recheck.persistence.GradleProjectLayout;
import de.retest.web.selenium.RecheckDriver;


class MySeleniumTest {

	RecheckDriver driver;

	@BeforeEach
	void setup() {
		RecheckOptions opts = RecheckOptions.builder(). //
				projectLayout(new GradleProjectLayout()). //
				namingStrategy(new ClassAndMethodBasedShortNamingStrategy() ). //
				enableReportUpload().
				build();
		driver = new RecheckDriver( new ChromeDriver(), opts );
	}

	@Test
	void login() throws Exception {
		String url = Paths.get( "src/test/resources/demo-app.html" ).toUri().toURL().toString();
		driver.get(url);

		driver.findElement(By.id("username")).sendKeys("Simon");
		driver.findElement(By.id("password")).sendKeys("secret");
		driver.findElement(By.id("sign-in")).click();

		driver.capTest();
	}

	@AfterEach
	void tearDown() throws InterruptedException {
		driver.quit();
	}
}
