import java.util.Optional;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v116.emulation.Emulation;

public class ChromeTest {
public static void main(String[] args) throws InterruptedException {
	
	System.setProperty("webdriver.chrome.driver","C:\\Users\\vredd\\OneDrive\\Desktop\\Ravi Personal\\Rahul shetty courses\\selenium webdriver\\Selenium Documents and files and executable files\\chromedriver.exe");
	ChromeDriver driver=new ChromeDriver();
	DevTools devtool = driver.getDevTools();
	devtool.createSession();
	//now we can send commands to CDP>CDP method will invoke and get access chromedev tools.
	devtool.send(Emulation.setDeviceMetricsOverride(500, 1000,50, true, Optional.empty(), Optional.empty(),Optional.empty(), Optional.empty(), Optional.empty(),Optional.empty(),Optional.empty(), Optional.empty(), Optional.empty()));
	driver.get("https://rahulshettyacademy.com/angularAppdemo/");
	//to click on menu bar (three bars)
	driver.findElement(By.cssSelector(".navbar-toggler")).click();
	//to click on library option
	Thread.sleep(2000);
	driver.findElement(By.partialLinkText("Library")).click();
}
}
