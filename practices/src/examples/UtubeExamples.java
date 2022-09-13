package examples;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class UtubeExamples 
{
	@Test
	public void formRegister() throws Exception
	{
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\Drivers\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.opencart.com/index.php?route=account/register");
		WebElement country_drop=driver.findElement(By.id("input-country"));
		Select sel=new Select(country_drop);
		sel.selectByIndex(1);
		Thread.sleep(1000);
		sel.selectByValue("2");
		Thread.sleep(1000);
		sel.selectByVisibleText("India");
		
		
		
		
	}

}
