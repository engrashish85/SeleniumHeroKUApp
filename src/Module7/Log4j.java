package Module7;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.log4testng.Logger;

public class Log4j {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Logger APPLICATION_LOGS = Logger.getLogger(ExpectedConditions.class);
		APPLICATION_LOGS.debug("starting");
		APPLICATION_LOGS.debug("executing");
		APPLICATION_LOGS.debug("ending");
		
	}

}
