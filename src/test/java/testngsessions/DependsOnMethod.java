package testngsessions;

import org.testng.annotations.Test;

public class DependsOnMethod {

	@Test
	public void loginPageTest() {
		System.out.println("login test");
		int i=9/0;
	}
	
	@Test(dependsOnMethods="loginPageTest")
public void homePageTest() {
		System.out.println("Home page Test");
	}	
	
}
