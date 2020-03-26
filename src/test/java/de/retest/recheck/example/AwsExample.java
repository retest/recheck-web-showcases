package de.retest.recheck.example;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Paths;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import de.retest.recheck.Recheck;
import de.retest.recheck.RecheckImpl;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.devicefarm.DeviceFarmClient;
import software.amazon.awssdk.services.devicefarm.model.CreateTestGridUrlRequest;
import software.amazon.awssdk.services.devicefarm.model.CreateTestGridUrlResponse;

public class AwsExample {
	private final String ARN = "arn:aws:devicefarm:us-west-2:111122223333:testgrid-project:123e4567-e89b-12d3-a456-426655440000";
	
	RemoteWebDriver driver;
	Recheck re;

	@BeforeEach
	void setUp() throws MalformedURLException {
		final String myProjectARN = ARN;
		// Make sure to supply the region from the ARN below
		final DeviceFarmClient client = DeviceFarmClient.builder().region(Region.US_WEST_2).build();
		final CreateTestGridUrlRequest request = CreateTestGridUrlRequest.builder().expiresInSeconds(300)
				.projectArn(myProjectARN).build();
		final CreateTestGridUrlResponse response = client.createTestGridUrl(request);
		URL testGridUrl = new URL(response.url());
		
		re = new RecheckImpl();
		driver = new RemoteWebDriver(testGridUrl, DesiredCapabilities.chrome());
	}

	@Test
	public void check() throws Exception {
		String url = Paths.get( "src/test/resources/demo-app.html" ).toUri().toURL().toString();
		driver.get(url);
		re.check(driver, "init");
		// equivalent to
		re.check(driver.findElement(By.tagName("html")), "init");
	}

	@AfterEach
	void tearDown() {
		// make sure to close your WebDriver session and avoid being over-billed:
		driver.quit();
	}
}
