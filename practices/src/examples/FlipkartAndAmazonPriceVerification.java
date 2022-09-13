package examples;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class FlipkartAndAmazonPriceVerification 
{
	@Test
	public void TestFlipkartSearch()
	{
		Reporter.log("TC to test Flipkart Search functionality started",true);
		String s_search_string="Tv";
		String url="https://www.flipkart.com";
		System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"\\Drivers\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get(url);
		Reporter.log("Chrome Invoked and navigated to UTRL : "+url+"<br>",true);
		
		String actualTitle=driver.getTitle();
		String expectedTitle="Online Shopping Site for Mobiles, Electronics, Furniture, Grocery, Lifestyle, Books & More. Best Offers!";
		Assert.assertEquals(actualTitle, expectedTitle);
		Reporter.log("Page Navigated."+"<br>",true);
		
		WebElement sign_in_crosssymbol=driver.findElement(By.xpath("//button[@class='_2KpZ6l _2doB4z']"));
		sign_in_crosssymbol.click();
		Reporter.log("Sign in Window Closed."+"<br>",true);
		
		WebElement searchbox=driver.findElement(By.name("q"));
		Assert.assertEquals(searchbox.isDisplayed(), true);
		Reporter.log("Search Box is displayed."+"<br>",true);
		
		searchbox.sendKeys(s_search_string);
		
		driver.findElement(By.xpath("//button[@class='L0Z3Pu']")).click();
		
		WebElement txtbox_search_result_text=driver.findElement(By.xpath("//span[contains(text(),'Showing 1 – 24 of 1,090 results for')]"));
		Assert.assertEquals(txtbox_search_result_text.isDisplayed(), true);
		
		String exp_search_title=s_search_string;
		String actual_search_title=driver.getTitle();
		if(actual_search_title.toLowerCase().contains(exp_search_title))
		{
			Assert.assertTrue(true);
		}
		else
		{
			Assert.assertTrue(false);
		}
		Reporter.log("Search Box set with value :"+s_search_string+" and search results displayed"+"<br>",true);
		
		List<WebElement> list_of_products=driver.findElements(By.xpath("//div[@class='_4rR01T']"));
		List<WebElement> list_of_products_price=driver.findElements(By.xpath("//div[@class='_30jeq3 _1_WHN1']"));
		
		
		String product_name;
		String product_price;
		int int_product_price;
		HashMap<Integer, String> map_final_products=new HashMap<Integer,String>();
		for(int i=0;i<list_of_products.size();i++)
		{
			product_name=list_of_products.get(i).getText();
			product_price=list_of_products_price.get(i).getText();
			product_price=product_price.replaceAll("[^0-9]", "");
			int_product_price=Integer.parseInt(product_price);
			map_final_products.put(int_product_price, product_name);
		}
		Reporter.log("Product Name and Price Fetched from UI and saved in HashMap as : "+map_final_products.toString()+"<br>",true);
		
		
		Set<Integer> allkeys=map_final_products.keySet();
		ArrayList<Integer> array_list_values_product_prices=new ArrayList<Integer>(allkeys);
		
		Collections.sort(array_list_values_product_prices);
		
		int high_price=array_list_values_product_prices.get(array_list_values_product_prices.size()-1);
		
		int low_price=array_list_values_product_prices.get(0);
		
		Reporter.log("High Product Price is : "+high_price+" Product name is : "+map_final_products.get(high_price),true);
		Reporter.log("low Product Price is : "+low_price+" Product name is : "+map_final_products.get(low_price),true);
		
		
		driver.close();
		
	}
	

}
