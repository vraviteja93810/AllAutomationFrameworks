import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;

public class SetGeoLocation {
public static void main(String[] args) throws InterruptedException {
	System.setProperty("webdriver.chrome.driver","C:\\Users\\vredd\\OneDrive\\Desktop\\Ravi Personal\\Rahul shetty courses\\selenium webdriver\\Selenium Documents and files and executable files\\chromedriver.exe");
	ChromeDriver driver=new ChromeDriver();
	DevTools devtool = driver.getDevTools();
	devtool.createSession();
	Map<String,Object> coordinates = new HashMap<String,Object>();
	coordinates.put("latitude", 40);
	coordinates.put("langitude", 3);
	coordinates.put("accuracy", 1);
	driver.executeCdpCommand("Emulation.setGeolocationOverride",coordinates);
	driver.get("https://www.google.com/");
	driver.findElement(By.name("q")).sendKeys("netFlix",Keys.ENTER);
	Thread.sleep(3000);
	driver.findElements(By.cssSelector(".LC20lb")).get(0).click();
	System.out.println(driver.findElement(By.cssSelector(".default-ltr-cache-1dvfrvc h1")).getText());
}
}
