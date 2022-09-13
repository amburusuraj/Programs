package javaprograms;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Demo {

	public static void selectChoicevalues(WebDriver driver,String... value)
	{
		List<WebElement> choiceList=driver.findElements(By.xpath("//div[@class='message']"));
		if(!value[0].equalsIgnoreCase("all"))
		{
			for(WebElement item:choiceList)
			{
				String text=item.getText();
				for(String val:value)
				{
					if(text.equals(val))
					{
						item.click();
						break;
					}
				}
			}
		}
		else
		{
			try
			{
				for(WebElement item:choiceList)
				{
					item.click();
				}
			}
			catch(Exception e)
			{
				
			}
		}
	}
		
	}
	
