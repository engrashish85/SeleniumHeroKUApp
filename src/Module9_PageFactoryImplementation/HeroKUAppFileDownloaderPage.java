package Module9_PageFactoryImplementation;

import Module9.Selenium_WorkingWithDriver;
import org.openqa.selenium.By;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

public class HeroKUAppFileDownloaderPage extends Selenium_WorkingWithDriver {
	
	//Instantiating objects
	By oFileDownload = By.linkText("File Download");
	By oImageLink = By.linkText("some-file.txt");

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		//Creating an object of class
		Selenium_WorkingWithDriver obDriver = new Selenium_WorkingWithDriver ();

		//Invoking URL in chrome browser
		obDriver.InvokeChrome(obDriver.sURL);
		driver = obDriver.getChromeDriver();
		
		//Creating an object of class
		HeroKUAppFileDownloaderPage obHeroKUAppFileDownloaderPage = new HeroKUAppFileDownloaderPage();

		//Clicking on File Download object
		driver.findElement(obHeroKUAppFileDownloaderPage.oFileDownload).click();
		
		//Clicking on capture.png link
//		driver.findElement(obHeroKUAppFileDownloaderPage.oImageLink).click();

		//Downloading a file using httpURLConnectionObject
		String link = driver.findElement(obHeroKUAppFileDownloaderPage.oImageLink).getAttribute("href");
		URL url = new URL(link);
		HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
		int responseCode = httpURLConnection.getResponseCode();
		System.out.println("responseCode is - "+responseCode);
		if (responseCode == 200) {
			String fileName = "";
			String disposition = httpURLConnection.getHeaderField("Content-Disposition");
			String contentType = httpURLConnection.getContentType();
			int contentLength = httpURLConnection.getContentLength();
			if (disposition!=null) {
				int index = disposition.indexOf("filename=");
				if (index > 0) {
					fileName = disposition.substring(index + 10, disposition.length() - 1);
				}
			} else {
				// extracts file name from URL
				fileName = link.substring(link.lastIndexOf("/") + 1);
			}
			System.out.println("content-type = "+ contentType);
			System.out.println("Content-Disposition = " + disposition);
			System.out.println("Content-Length = " + contentLength);
			System.out.println("fileName = " + fileName);
			InputStream inputStream = httpURLConnection.getInputStream();
			String saveFilePath = "c:\\Ashish\\Downloads" + File.separator + fileName;
			Files.copy(inputStream, new File(saveFilePath).toPath(), StandardCopyOption.REPLACE_EXISTING);
			httpURLConnection.disconnect();
			inputStream.close();
		}

	}

}
