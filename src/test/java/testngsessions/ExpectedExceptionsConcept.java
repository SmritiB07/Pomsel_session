package testngsessions;

import org.testng.annotations.Test;

public class ExpectedExceptionsConcept {
	String name;
	
	@Test(expectedExceptions= {ArithmeticException.class,NullPointerException.class})
	public void searchTest() {
		System.out.println("macbook");
		int i=9/0;
		ExpectedExceptionsConcept obj=new ExpectedExceptionsConcept();
		obj=null;
		obj.name="Tom";
		System.out.println("bye");
	}
	
	
	
	
	
	
	
	

}
