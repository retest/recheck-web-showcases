package de.retest.recheck.example.demoapp;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import de.retest.recheck.example.Util;

class AClassicalSeleniumTest {

	WebDriver driver;

	@BeforeEach
	void setup() {
		driver = new ChromeDriver( Util.chromeDriverOpts() );
	}

	@Test
	public void loginCheck() throws Exception {

		final String file = "pages/app/login-form.html";
		//final String file = "pages/app/login-form_css-broken.html";
		//final String file = "pages/app/login-form_id-change.html";
		//final String file = "pages/app/login-form_btn-change.html";

		driver.get( Util.toClasspathUrl( file ) );
		Util.sleep( 6 );

		driver.findElement( By.id( "username" ) ).sendKeys( "Simon" );
		driver.findElement( By.id( "password" ) ).sendKeys( "secret" );
		Util.sleep( 6 );

		driver.findElement( By.id( "sign-in" ) ).click();

		assertEquals( driver.findElement( By.tagName( "h4" ) ).getText(), "Success!" );
		Util.sleep( 6 );
	}

	@AfterEach
	public void tearDown() throws InterruptedException {
		driver.quit();
	}
}
