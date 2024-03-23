import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;

public class NetworkFailedRequest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver","C:\\Users\\vredd\\OneDrive\\Desktop\\Ravi Personal\\Rahul shetty courses\\selenium webdriver\\Selenium Documents and files and executable files\\chromedriver.exe");
		ChromeDriver driver=new ChromeDriver();
		DevTools devtool = driver.getDevTools();
		devtool.createSession();
		
	}

}
