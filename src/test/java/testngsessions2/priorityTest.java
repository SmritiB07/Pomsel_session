package testngsessions2;

import org.testng.annotations.Test;

public class priorityTest {

	@Test(priority=5)
public void a_test() {
System.out.println("a--test");	
}
	
	@Test(priority=2)
	public void b_test() {
	System.out.println("b--test");	
	}
	@Test(priority=2)
	public void c_test() {
	System.out.println("c--test");	
	}
	@Test
	public void d_test() {
	System.out.println("d--test");	
	}
	@Test
	public void e_test() {
	System.out.println("e--test");	
	}
	@Test
	public void f_test() {
	System.out.println("f--test");	
	}
		
	
	
	
	
	
	
	
	
}
