import java.util.Optional;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v118.fetch.Fetch;

public class NetworkMocking {
	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver","C:\\Users\\vredd\\OneDrive\\Desktop\\Ravi Personal\\Rahul shetty courses\\selenium webdriver\\Selenium Documents and files and executable files\\chromedriver.exe");
		ChromeDriver driver=new ChromeDriver();
		DevTools devtool = driver.getDevTools();
		devtool.createSession();
		devtool.send(Fetch.enable(Optional.empty(), Optional.empty()));
		devtool.addListener(Fetch.requestPaused(),request->
		{
			if(request.getRequest().getUrl().contains("shetty"))
			{
				String newURl=request.getRequest().getUrl().replace("=shetty","=BadGuy");
				System.out.println(newURl);
				devtool.send(Fetch.continueRequest(request.getRequestId(),
						Optional.of(newURl), 
						Optional.of(request.getRequest().getMethod()),Optional.empty(),
						Optional.empty(),Optional.empty()));
			}
			else
			{
				devtool.send(Fetch.continueRequest(request.getRequestId(),
						Optional.of(request.getRequest().getUrl()), 
						Optional.of(request.getRequest().getMethod()),Optional.empty(),
						Optional.empty(),Optional.empty()));
			}
		}
				);
		
		driver.get("https://rahulshettyacademy.com/angularAppdemo/");
		Thread.sleep(2000);
		//to click on menu bar (three bars)
		driver.findElement(By.cssSelector(".btn.btn-primary")).click();
		//to click on library option
		Thread.sleep(2000);
		driver.findElement(By.partialLinkText("Library")).click();
		System.out.println(driver.findElement(By.cssSelector("p")).getText());
		
	}
}
