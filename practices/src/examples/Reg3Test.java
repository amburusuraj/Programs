package examples;

import org.testng.Reporter;
import org.testng.annotations.Test;

public class Reg3Test {
	@Test(groups= {"reg","e2e"})
	  public void z() 
	  {
		Reporter.log("Regression  and End2End Test");
	  }
	@Test(groups= {"smoke","e2e"})
	  public void y() 
	  {
		Reporter.log("Smoke  and End2End Test");
	  }
	@Test(groups= {"e2e"})
	  public void x() 
	  {
		Reporter.log("End2End Test");
	  }
}
