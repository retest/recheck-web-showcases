package de.retest.recheck.example;

import java.nio.file.Paths;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import de.retest.recheck.Recheck;
import de.retest.recheck.RecheckImpl;
import de.retest.recheck.RecheckOptions;

class BudgetTest {
	WebDriver driver;
	Recheck re;

	@Test
	public void excel() throws Exception {
		final RecheckOptions options = RecheckOptions.builder()
				//.reportUploadEnabled( true )
				.build();
		re = new RecheckImpl( options );

		System.setProperty( "webdriver.chrome.driver", "chromedriver" );
		driver = new ChromeDriver();

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
