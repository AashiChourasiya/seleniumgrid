package seleniumgrid;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class Gridtest {
	public static void main(String[] args) throws MalformedURLException {
	
	DesiredCapabilities des = new DesiredCapabilities();
	des.setPlatform(Platform.WINDOWS);
	des.setBrowserName("chrome");
	
	ChromeOptions option = new ChromeOptions();
    option.merge(des);
    
    String hub = "http://192.168.29.170:5555/wd/hub";
    
    WebDriver driver = new RemoteWebDriver(new URL(hub),option);
    
    driver.get("https://rahulshettyacademy.com/AutomationPractice/");
    System.out.println(driver.getTitle());
  }
}
