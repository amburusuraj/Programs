package examples;

import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class SoftsuaveTest {

	@Test
	public void Test()
	{
		Reporter.log("Test Case is Started ",true);
		System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"\\Drivers\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Reporter.log("Chrome invoked and Navigated to URL ",true);
		driver.findElement(By.xpath("(//input[@name='radioButton'])[1]")).click();
		Reporter.log("First radio button is clicked successfully ",true);
		WebElement txtBox=driver.findElement(By.id("autocomplete"));
		txtBox.sendKeys("india");
		Reporter.log("String Entered to the TextBox Successfully",true);
		WebElement drop=driver.findElement(By.id("dropdown-class-example"));
		Select sel=new Select(drop);
		sel.selectByIndex(1);
		Reporter.log("First position of Dropdown selected Successfully",true);
		driver.findElement(By.xpath("//input[@id='checkBoxOption1']")).click();
		Reporter.log("First CheckBox is selected Successfully",true);
		driver.findElement(By.xpath("//input[@id='checkBoxOption2']")).click();
		Reporter.log("Second CheckBox is selected Successfully",true);
		driver.findElement(By.xpath("//input[@id='checkBoxOption3']")).click();
		Reporter.log("Third CheckBox is selected Successfully",true);
		driver.findElement(By.xpath("//button[text()='Open Window']")).click();
		Set<String> window=driver.getWindowHandles();
		Iterator<String> it=window.iterator();
		String parent=it.next();
		String child=it.next();
		System.out.println(parent);
		System.out.println(child);
		driver.switchTo().window(child);
		Reporter.log("Navigated to child window",true);
		System.out.println(driver.getTitle());
		Reporter.log("Title of Child window Fetched Successfully",true);
		driver.close();
		Reporter.log("Child Window Closed Successfully",true);
		driver.switchTo().window(parent);
		Reporter.log("Navigated to Parent Window",true);
		driver.findElement(By.linkText("Open Tab")).click();
		Reporter.log("Clicked on Switch Tab Success",true);
		Set<String> window2=driver.getWindowHandles();
		Iterator<String> it2=window2.iterator();
		String parent2=it2.next();
		String child2=it2.next();
		driver.switchTo().window(child2);
		Reporter.log("Navigated to child2 window",true);
		System.out.println(driver.getTitle());
		Reporter.log("Title of Child2 window Fetched Successfully",true);
		driver.close();
		Reporter.log("Child2 Window Closed Successfully",true);
		driver.switchTo().window(parent2);
		Reporter.log("Navigated to Parent2 Window",true);
		driver.findElement(By.id("alertbtn")).click();
		Reporter.log("Clicked Alert Button",true);
		Alert al=driver.switchTo().alert();
		System.out.println(al.getText());
		Reporter.log("Fetched Alert Error Message",true);
		al.dismiss();
		Reporter.log("Alert Popup is closed",true);
		
		List<WebElement> ele=driver.findElements(By.xpath("//table[@name='courses']/tbody/tr/td[3]"));
		int sum=0;
		for(WebElement lis:ele)
		{
			System.out.println(lis.getText());
			String s=lis.getText().replace("(", "");
			sum=sum+Integer.parseInt(s.replace(")", ""));
		}
		System.out.println("Total sum = "+sum);
		Reporter.log("Adding of all Amounts from WebTable Success",true);
		WebElement displayTextBox=driver.findElement(By.xpath("//input[@id='displayed-text']"));
		WebElement showBtn=driver.findElement(By.xpath("//input[@id='show-textbox']"));
		boolean b=displayTextBox.isEnabled();
		if(b)
		{
			displayTextBox.sendKeys("India");
			Reporter.log("String Entered in Test Box",true);
		}
		else
		{
			showBtn.click();
			Reporter.log("String Not Entered and Click to ShowBtn",true);
		}
		System.out.println(displayTextBox.getText());
		Reporter.log("String Fetched from Entered Test Box",true);
		
		List<WebElement> names=driver.findElements(By.xpath("(//table[@id='product'])[2]/tbody/tr/td[1]"));
		int empNameCount=0;
		for(WebElement empName:names)
		{
			System.out.println(empName.getText());
			empNameCount++;
		}
		System.out.println("Total Number of Employes = "+empNameCount);
		Reporter.log("Fetched All Employe Names",true);
		List<WebElement> positions=driver.findElements(By.xpath("(//table[@id='product'])[2]/tbody/tr/td[2]"));
		int empPositionsCount=0;
		for(WebElement empPositions:positions)
		{
			System.out.println(empPositions.getText());
			empPositionsCount++;
		}
		System.out.println("Total Number of Employes Positions = "+empPositionsCount);
		Reporter.log("Fetched All Employes Positions Names",true);
		List<WebElement> cityNames=driver.findElements(By.xpath("(//table[@id='product'])[2]/tbody/tr/td[3]"));
		int empCityNameCount=0;
		for(WebElement empCityNames:cityNames)
		{
			System.out.println(empCityNames.getText());
			empCityNameCount++;
		}
		System.out.println("Total Number of Employes Cityes = "+empCityNameCount);
		Reporter.log("Fetched All Employes Cityes Names",true);
		
		List<WebElement> empAmount=driver.findElements(By.xpath("(//table[@id='product'])[2]/tbody/tr/td[4]"));
		int empAmountSum=0;
		for(WebElement empAmounts:empAmount)
		{
			System.out.println(empAmounts.getText());
			String s=empAmounts.getText().replace("(", "");
			empAmountSum=empAmountSum+Integer.parseInt(s.replace(")", ""));
		}
		System.out.println("Total Sum of Employes Amount = "+empAmountSum);
		Reporter.log("Fetched All Employes Amount Sum",true);
		
		Reporter.log("All TestCases are Executed Successfully",true);
		driver.quit();
	}

}
