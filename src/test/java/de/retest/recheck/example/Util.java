package de.retest.recheck.example;

import java.net.MalformedURLException;
import java.nio.file.Paths;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WrapsDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Util {

	public static String toClasspathUrl( final String ressourcePath ) throws MalformedURLException {
		return Paths.get( "src/test/resources/" + ressourcePath ).toUri().toURL().toString();
	}

	@SneakyThrows
	public static void sleep( final float seconds ) {
		Thread.sleep( (int) (1000 * seconds) );
	}

	public static ChromeOptions chromeDriverOpts() {
		final ChromeOptions opts = new ChromeOptions();
		if ( runInCIdetected() ) {
			opts.addArguments( "--headless", "--no-sandbox", "--disable-dev-shm-usage" );
		}
		return opts;
	}

	private static boolean runInCIdetected() {
		return StringUtils.isNotBlank( System.getenv( "GITHUB_TOKEN" ) );
	}

	public static void forceContentSize( WebDriver driver ) {
		if ( driver instanceof WrapsDriver ) {
			driver = ((WrapsDriver) driver).getWrappedDriver();
		}

		final int width = 1200;
		final int height = 1200;

		driver.get( "about:blank" );
		driver.manage().window().setSize( new Dimension( width, height ) );

		final String currentInnerSize = getInnerSize( driver );
		final int borderWidth = width - Integer.parseInt( currentInnerSize.split( "," )[0] );
		final int borderHeight = height - Integer.parseInt( currentInnerSize.split( "," )[1] );
		log.info( "Current inner size {}, add {},{} resulting in {},{} to match {},{}.", currentInnerSize, borderWidth,
				borderHeight, width + borderWidth, height + borderHeight, width, height );

		driver.manage().window().setSize( new Dimension( width + borderWidth, height + borderHeight ) );
		log.info( "New inner size {}.", getInnerSize( driver ) );
	}

	static String getInnerSize( final WebDriver driver ) {
		return ((JavascriptExecutor) driver).executeScript( "return window.innerWidth + ',' + window.innerHeight; " )
				.toString();
	}

}
