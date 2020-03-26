package de.retest.recheck.example;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.devicefarm.DeviceFarmClient;

public class AwsExample {
	// ... When you set up your test suite
	private static RemoteWebDriver driver;

	@BeforeEach
	void setUp() {
		final String myProjectARN =
				"arn:aws:devicefarm:us-west-2:111122223333:testgrid-project:123e4567-e89b-12d3-a456-426655440000";
		final DeviceFarmClient client = DeviceFarmClient.builder().region( Region.EU_CENTRAL_1 ).build();
		final CreateTestGridUrlRequest request =
				CreateTestGridUrlRequest.builder().expiresInSeconds( 300 ).projectArn( myProjectARN ).build();
		final CreateTestGridUrlResponse response = client.createTest.GridUrl( request );
		testGridUrl = new URL( response.url() );
		// You can now pass this URL into RemoteWebDriver.
		final WebDriver driver = new RemoteWebDriver( testGridUrl, DesiredCapabilities.firefox() );
	}

	@AfterEach
	void tearDown() {
		// make sure to close your WebDriver session and avoid being over-billed:
		driver.quit();
	}
}
