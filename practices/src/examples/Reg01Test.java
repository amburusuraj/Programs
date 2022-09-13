package examples;

import org.testng.Reporter;
import org.testng.annotations.Test;

public class Reg01Test {
  @Test(groups= {"reg"})
  public void a() 
  {
	  Reporter.log("Regression Test");
  }
  @Test(groups= {"reg","e2e"})
  public void b() 
  {
	  Reporter.log("Regression  and End2End Test");
  }
  @Test(groups= {"reg","smoke"})
  public void c() 
  {
	  Reporter.log("Regression  and smoke Test");
  }
  @Test(groups= {"reg","e2e"})
  public void d() 
  {
	  Reporter.log("Regression  and End2End Test");
  }
  @Test(groups= {"e2e"})
  public void e() 
  {
	  Reporter.log("End2End Test");
  }
}
