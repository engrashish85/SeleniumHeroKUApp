package Module9_TestNG;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import org.testng.IAnnotationTransformer;
import org.testng.annotations.ITestAnnotation;

public class Selenium_IAnnotationTransformerClass implements IAnnotationTransformer {

	@Override
	public void transform(ITestAnnotation annotation, @SuppressWarnings("rawtypes") Class testClass, @SuppressWarnings("rawtypes") Constructor testConstructor,
			Method testMethod) {
		// TODO Auto-generated method stub
		
		if (testMethod.getName().equals("testFrameNestedFrameLeft")) {
			System.out.println("Setting data provider for testFrameNestedFrameLeft method");
			annotation.setDataProviderClass(Selenium_WorkingWithDriver_TestNG.class);
			annotation.setDataProvider("returnValueFromPropertiesFile");
			System.out.println("Annotation has been successfully set");
		}
		else if (testMethod.getName().equals("testFrameNestedFrameMiddle")) {
			System.out.println("Setting data provider for testFrameNestedFrameMiddle");
			annotation.setDataProviderClass(Selenium_WorkingWithDriver_TestNG.class);
			annotation.setDataProvider("returnValueFromXMLReader");
		}
		else if (testMethod.getName().equals ("testFrameRight")) {
			System.out.println("Disabling method name - testFrameRight");
			annotation.setEnabled(false);
		}
	}

}
