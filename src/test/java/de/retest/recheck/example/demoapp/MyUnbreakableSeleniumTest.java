package de.retest.recheck.example.demoapp;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.chrome.ChromeDriver;

import de.retest.recheck.example.Util;
import de.retest.web.selenium.By;
import de.retest.web.selenium.RecheckDriver;

class MyUnbreakableSeleniumTest {

	RecheckDriver driver;

	@BeforeEach
	public void setup() {
		// RecheckOptions opts = RecheckWebOptions.builder().disableScreenshots().enableReportUpload().build();
		driver = new RecheckDriver( new ChromeDriver( Util.chromeDriverOpts() ) );
	}

	@Test
	public void loginCheck() throws Exception {

		final String file = "pages/app/login-form.html";
		//final String file = "pages/app/login-form_css-broken.html";
		//final String file = "pages/app/login-form_id-change.html";
		//final String file = "pages/app/login-form_btn-change.html";

		driver.get( Util.toClasspathUrl( file ) );
		Util.sleep( 3 );

		driver.findElement( By.id( "username" ) ).skipCheck().sendKeys( "Simon" );
		driver.findElement( By.id( "password" ) ).sendKeys( "secret" );
		Util.sleep( 3 );

		driver.findElement( By.id( "sign-in" ) ).click();
	}

	@AfterEach
	public void tearDown() throws InterruptedException {
		driver.quit();
	}
}
