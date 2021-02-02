package de.retest.recheck.example;

import java.net.MalformedURLException;
import java.nio.file.Paths;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.chrome.ChromeOptions;

import lombok.SneakyThrows;

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
		opts.addArguments( "--window-size=1200,1200" );
		if ( runInCIdetected() ) {
			opts.addArguments( "--headless", "--no-sandbox", "--disable-dev-shm-usage" );
		}
		return opts;
	}

	private static boolean runInCIdetected() {
		return StringUtils.isNotBlank( System.getenv( "GITHUB_TOKEN" ) );
	}

}
