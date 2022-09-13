package examples;

import org.testng.Reporter;
import org.testng.annotations.Test;

public class Reg02Test {
	@Test(groups= {"smoke"})
	  public void a() 
	  {
		Reporter.log("Smoke Test");
	  }
	@Test(groups= {"reg","e2e"})
	  public void b() 
	  {
		Reporter.log("Regression  and End2End Test");
	  }
	@Test(groups= {"reg"})
	  public void c() 
	  {
		Reporter.log("Regression  Test");
	  }
	@Test(groups= {"smoke","e2e"})
	  public void d() 
	  {
		Reporter.log("Smoke  and End2End Test");
	  }
}
