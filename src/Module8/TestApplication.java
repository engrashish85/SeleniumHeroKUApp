package Module8;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class TestApplication {
	
	@Before
	public void openBrowser ()
	{
		System.out.println("Opening Browser");
	}
	
	@Test
	public void testLogin ()
	{
		System.out.println("Test Login");
	}
	
	@Test
	public void testRegistration()
	{
		System.out.println("Testing Registration");
	}
	
	@After
	public void afterLogin ()
	{
		System.out.println("Closing Browser");
	}
	
	@BeforeClass
	public void intializeEnvironment()
	{
		System.out.println("Initializing Environment");
	}
}
