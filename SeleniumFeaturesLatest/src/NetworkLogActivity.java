import java.util.Optional;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v118.network.Network;
import org.openqa.selenium.devtools.v118.network.model.Request;
import org.openqa.selenium.devtools.v118.network.model.Response;

public class NetworkLogActivity {
public static void main(String[] args) throws InterruptedException {
	
	System.setProperty("webdriver.chrome.driver","C:\\Users\\vredd\\OneDrive\\Desktop\\Ravi Personal\\Rahul shetty courses\\selenium webdriver\\Selenium Documents and files and executable files\\chromedriver.exe");
	ChromeDriver driver=new ChromeDriver();
	DevTools devtool = driver.getDevTools();
	devtool.createSession();
	devtool.send(Network.enable(Optional.empty(), Optional.empty(),Optional.empty()));
	devtool.addListener(Network.requestWillBeSent(), request->
	{
		Request Req = request.getRequest();
		//System.out.println(Req.getUrl());
	}
			);
	
	devtool.addListener(Network.responseReceived(),response ->
	{
		 Response Response = response.getResponse();
		// System.out.println(Response.getUrl());
		 if(Response.getStatus().toString().startsWith("4"))
		 {
		 System.out.println(Response.getUrl()+" is failing with status code"+Response.getStatus());
		 }		 
	}
			);
	driver.get("https://rahulshettyacademy.com/angularAppdemo/");
	//to click on menu bar (three bars)
	//driver.findElement(By.cssSelector(".navbar-toggler")).click();
	driver.findElement(By.cssSelector(".btn.btn-primary")).click();
	//to click on library option
	Thread.sleep(2000);
	driver.findElement(By.partialLinkText("Library")).click();
}
}
