package de.retest.recheck.example;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import de.retest.web.selenium.RecheckDriver;

public class CheckoutTest {

	private RecheckDriver driver;

	@BeforeEach
	public void setUp() {
		final ChromeOptions opts = new ChromeOptions().addArguments( //
				"--headless", "--window-size=1200,800" );
		driver = new RecheckDriver( new ChromeDriver( opts ) );
	}

	@AfterEach
	public void tearDown() {
		driver.quit();
	}

	@Test
	public void checkout() {
		driver.get( "http://demowebshop.tricentis.com/" );
		driver.findElement( By.linkText( "Log in" ) ).click();
		driver.findElement( By.id( "Email" ) ).sendKeys( "roesslerj@web.de" );
		driver.findElement( By.id( "Password" ) ).sendKeys( "123456" );
		driver.findElement( By.cssSelector( ".login-button" ) ).click();
		driver.findElement( By.linkText( "14.1-inch Laptop" ) ).click();
		driver.findElement( By.cssSelector( ".item-box:nth-child(2) img" ) ).click();
		driver.findElement( By.id( "add-to-cart-button-36" ) ).click();
		driver.findElement( By.cssSelector( ".ico-cart > .cart-label" ) ).click();
		driver.findElement( By.id( "termsofservice" ) ).click();
		driver.findElement( By.id( "checkout" ) ).click();
		driver.findElement( By.cssSelector( ".new-address-next-step-button:nth-child(1)" ) ).click();
		driver.findElement( By.cssSelector( ".new-address-next-step-button:nth-child(2)" ) ).click();
		driver.findElement( By.cssSelector( ".shipping-method-next-step-button" ) ).click();
		driver.findElement( By.id( "paymentmethod_3" ) ).click();
		driver.findElement( By.cssSelector( ".payment-method-next-step-button" ) ).click();
		driver.findElement( By.id( "PurchaseOrderNumber" ) ).click();
		driver.findElement( By.id( "PurchaseOrderNumber" ) ).sendKeys( "123456" );
		driver.findElement( By.cssSelector( ".payment-info-next-step-button" ) ).click();
		driver.findElement( By.cssSelector( ".confirm-order-next-step-button" ) ).click();
	}
}
