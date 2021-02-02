package de.retest.recheck.example;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import de.retest.recheck.Recheck;
import de.retest.recheck.RecheckImpl;
import de.retest.recheck.RecheckOptions;

class CssTemplateTest {
	WebDriver driver;
	Recheck re;

	@BeforeEach
	public void setup() {
		re = new RecheckImpl( RecheckOptions.builder()
				//.reportUploadEnabled( true )
				.build() );

		//System.setProperty( "webdriver.chrome.driver", "C:\chromedriver.exe" );
		driver = new ChromeDriver( Util.chromeDriverOpts() );
	}

	@Test
	public void excel() throws Exception {

		final String file = "pages/css/templated-intensify/index.html";
		//final String file = "pages/css/templated-intensify-2/index.html";

		driver.get( Util.toClasspathUrl( file ) );
		Util.sleep( 3 );

		re.check( driver, "open" );
		re.capTest(); // Mark test as failed on differences.
	}

	@AfterEach
	public void tearDown() {
		driver.quit();
		re.cap(); // Produce the result file.
	}
}
