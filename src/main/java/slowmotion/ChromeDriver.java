package slowmotion;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ChromeDriver extends org.openqa.selenium.chrome.ChromeDriver {

	@Override
	public WebElement findElement(By by) {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
		}
		return super.findElement(by);
	}

}
