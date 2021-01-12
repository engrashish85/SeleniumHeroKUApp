package Module6;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ReflectionAPI {

	public static void main(String[] args) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		// TODO Auto-generated method stub
		String x = "SampleTest";
		Method method = ReflectionAPI.class.getMethod (x, String.class);
		method.invoke(method, "TestKeyword driven Framework");
		System.out.println("End");
	}
	
	public static void SampleTest (String x) {
		System.out.println("This is a test " + x);
	}
}
