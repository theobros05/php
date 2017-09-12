package samples;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
public class Dependency {
	@Test(dependsOnMethods={"method2"})
	public void method1()
	{
		System.out.println("20");
	}
	@Test (dependsOnMethods={"method3"})
	public void method2()
	{
		System.out.println("30");
	}
	@Test 
	public void method3()
	{
		System.out.println("40");
	}
	
}