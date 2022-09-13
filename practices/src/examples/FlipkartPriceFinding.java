package examples;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FlipkartPriceFinding 
{
	static
	{
		System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"\\Drivers\\chromedriver.exe");
	}
public static void main(String[] args) 
{
	WebDriver driver=new ChromeDriver();
	driver.get("https://www.flipkart.com/");
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	driver.findElement(By.xpath("//button[@class='_2KpZ6l _2doB4z']")).click();
	WebElement searchBtn1=driver.findElement(By.name("q"));
	searchBtn1.sendKeys("REDMI Note 10 Pro (Dark Night, 128 GB)");
	driver.findElement(By.xpath("//button[@class='L0Z3Pu']")).click();
	driver.findElement(By.xpath("(//div[text()='REDMI Note 10 Pro (Dark Night, 128 GB)'])[1]")).click();
	Set<String> windows1=driver.getWindowHandles();
	Iterator<String> it1=windows1.iterator();
	String parent1=it1.next();
	String child1=it1.next();
	System.out.println(parent1);
	System.out.println(child1);
	driver.switchTo().window(child1);
	String flipkartValue= driver.findElement(By.xpath("//span[text()='REDMI Note 10 Pro (Dark Night, 128 GB)']/../../../div[4]/div/div[1]/div[1]")).getText();
	//String val1=driver.findElement(By.xpath("//*[@id=\"container\"]/div/div[3]/div[1]/div[2]/div[2]/div/div[4]/div[1]/div/div[1]")).getText();
	flipkartValue=flipkartValue.replace("₹", "");
	System.out.println(flipkartValue);
	
	driver.get("https://www.amazon.in/");
	WebElement searchBtn2=driver.findElement(By.id("twotabsearchtextbox"));
	searchBtn2.sendKeys("REDMI Note 10 Pro (Dark Night, 128 GB)");
	driver.findElement(By.xpath("//input[@type='submit']")).submit();
	driver.findElement(By.xpath("//span[contains(text(),'Redmi Note 10 Pro (Dark Night, 6GB RAM, 128GB Storage)')]")).click();
	Set<String> windows2=driver.getWindowHandles();
	Iterator<String> it2=windows2.iterator();
	String parent2=it2.next();
	String child2=it2.next();
	String child3=it2.next();
	System.out.println(parent2);
	System.out.println(child2);
	System.out.println(child3);
	driver.switchTo().window(child3);
	//String val2=driver.findElement(By.xpath("(//span[contains(text(),'Redmi Note 10 Pro (Dark Night, 6GB RAM, 128GB Storage)')])[1]/../../../../div[10]/div/div/table/tbody/tr[2]/td[2]/span[1]")).getText();
	String amazonValue=driver.findElement(By.xpath("//span[@class='a-price a-text-price a-size-medium apexPriceToPay']")).getText();
	amazonValue=amazonValue.replace("₹", "");
	System.out.println(amazonValue);
	
	if(flipkartValue.equals(amazonValue))
	{
		System.out.println("Both Prices are Same");
	}
	else
	{
		System.out.println("Both Prices are Not Same");
	}
	driver.quit();
}

}
