package de.retest.recheck.example;

import java.nio.file.Paths;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import de.retest.recheck.Recheck;
import de.retest.recheck.RecheckImpl;
import de.retest.recheck.RecheckOptions;

class BudgetTest {
	WebDriver driver;
	Recheck re;

	@Test
	@Disabled("Expected to show differences and thus fail...")
	public void excel() throws Exception {
		final RecheckOptions options = RecheckOptions.builder()
				//.reportUploadEnabled( true )
				.build();
		re = new RecheckImpl( options );

		final ChromeOptions opts = new ChromeOptions();
		opts.addArguments(
				// Enable headless mode for faster execution.
				"--headless",
				// Use Chrome in container-based Travis CI enviroment (see https://docs.travis-ci.com/user/chrome#Sandboxing).
				"--no-sandbox",
				// Fix window size for stable results.
				"--window-size=1200,800" );
		driver = new ChromeDriver( opts );

		//		driver.get( "https://assets.retest.org/demos/budget/OriginalBudget.htm" );
		//		driver.get( "https://assets.retest.org/demos/budget/AdaptedBudget.htm" );
		String url = Paths.get( "src/test/resources/AdaptedBudget.htm" ).toUri().toURL().toString();
		driver.get(url);

		Thread.sleep( 1000 );

		re.check( driver, "open" );
		re.capTest();
	}

	@AfterEach
	public void tearDown() {
		driver.quit();

		// Produce the result file.
		re.cap();
	}
}
