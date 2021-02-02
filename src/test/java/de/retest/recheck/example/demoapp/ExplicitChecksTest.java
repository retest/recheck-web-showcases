package de.retest.recheck.example.demoapp;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import de.retest.recheck.Recheck;
import de.retest.recheck.RecheckImpl;
import de.retest.recheck.example.Util;

class ExplicitChecksTest {

	WebDriver driver;
	Recheck re;

	@BeforeEach
	public void setup() {
		re = new RecheckImpl();
		driver = new ChromeDriver( Util.chromeDriverOpts() );
	}

	@Test
	public void loginCheck() throws Exception {

		final String file = "pages/app/login-form.html";
		//final String file = "pages/app/login-form_css-broken.html";
		//final String file = "pages/app/login-form_id-change.html";
		//final String file = "pages/app/login-form_btn-change.html";

		driver.get( Util.toClasspathUrl( file ) );
		Util.sleep( 3 );

		driver.findElement( By.id( "username" ) ).sendKeys( "Simon" );
		driver.findElement( By.id( "password" ) ).sendKeys( "secret" );
		Util.sleep( 3 );

		re.check( driver, "init" );
		// equivalent to
		re.check( driver.findElement( By.tagName( "html" ) ), "init" );

		driver.findElement( By.id( "sign-in" ) ).click();

		re.check( driver, "success" );
		re.capTest(); // Mark test as failed on differences.
	}

	@AfterEach
	public void tearDown() throws InterruptedException {
		driver.quit();
		re.cap(); // Produce the result file.
	}
}
