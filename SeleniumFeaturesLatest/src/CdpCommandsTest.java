import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;

public class CdpCommandsTest {
	public static void main(String[] args) throws InterruptedException {
		
	
	System.setProperty("webdriver.chrome.driver","C:\\Users\\vredd\\OneDrive\\Desktop\\Ravi Personal\\Rahul shetty courses\\selenium webdriver\\Selenium Documents and files and executable files\\chromedriver.exe");
	ChromeDriver driver=new ChromeDriver();
	DevTools devtool = driver.getDevTools();
	devtool.createSession();
	Map deviceMetrics=new HashMap();
	deviceMetrics.put("width",600);
	deviceMetrics.put("height", 1000);
	deviceMetrics.put("deviceScaleFactor", 50);
	deviceMetrics.put("mobile", true);
	driver.executeCdpCommand("Emulation.setDeviceMetricsOverride", deviceMetrics);
	driver.get("https://rahulshettyacademy.com/angularAppdemo/");
	//to click on menu bar (three bars)
	driver.findElement(By.cssSelector(".navbar-toggler")).click();
	//to click on library option
	Thread.sleep(2000);
	driver.findElement(By.partialLinkText("Library")).click();
}
}
