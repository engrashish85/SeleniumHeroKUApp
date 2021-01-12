package Module10_RestAssured;

import java.io.IOException;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;
import static  org.hamcrest.Matchers.equalTo;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Module9.Selenium_WorkingWithDriver;

public class RestAssuredBookLibraryAddGetBook_JSON_DataProvider extends Selenium_WorkingWithDriver {
	
	public String sPropertiesFileLocation = 
			".\\src\\Module9\\Config\\restAssuredEnvironment.Properties";
	public static String[] arrBookLibraryValues;
	
	@Test (dataProvider = "BooksData")
	public void AddBook (String sBookName, String sIsbn, String sAisle, String sAuthorName) throws IOException {
		
		//Creating object of RestAssuredGlobalVariables class
		RestAssuredGlobalVariables obRestAssuredGlobalVariables = new RestAssuredGlobalVariables ();
		
		//Retrieving baseURI from properties file and printing the same in console
		RestAssured.baseURI = returnValueFromPropertiesFile(sPropertiesFileLocation, "sWSDLHost");
		System.out.println(RestAssured.baseURI);
		
		//Initializing resources
		String sAddBookLibrary_Json = returnValueFromPropertiesFile (sPropertiesFileLocation, 
				"sAddBookLibrary_Json");
		String sGetBookLibrary_Json = returnValueFromPropertiesFile (sPropertiesFileLocation, 
				"sGetBookLibrary_Json");
		
		//Returning array values needed to be appended in the request
		arrBookLibraryValues = obRestAssuredGlobalVariables.returnBodyStringsAddBook(sBookName, sIsbn, 
				sAisle, sAuthorName);
		System.out.println(arrBookLibraryValues.length);
		for (int i = 0; i < arrBookLibraryValues.length; i ++) {
			System.out.println("iCounter = " + i+ "	" + arrBookLibraryValues[i]);
		}
		
		//Extracting response by using given, when, then and extract keywords
		Response resResponse = given().header("content-Type", "application/json").
		body(RestAssuredGlobalVariables.sBodyFormatterJsonEscapeAddBookRequest).when().
		post(sAddBookLibrary_Json).then().//assertThat().statusCode(200)
		extract().response();
		
		//Type casting response to String
		String sJsonResponse = resResponse.asString();
		
		//Printing response and ID to console
		System.out.println(sJsonResponse);
		
		//Converting to JSON Response
		JsonPath oJsonPath = new JsonPath (sJsonResponse);
		String sID = oJsonPath.get("msg");
		
		//Printing ID to console
		System.out.println(sID);
		
		System.out.println("sGetBookLibrary_Json - "+sGetBookLibrary_Json);
		
		//Printing author name whose book needs to be retrieved to console
		System.out.println("Author name whose book value needs to be retrieved is - " +arrBookLibraryValues[3]);
		
		//Retrieving book added through getBook API
		Response resGetBook = given().header ("content-Type", "application/json").param("AuthorName", 
				arrBookLibraryValues[3]).when().get(sGetBookLibrary_Json).then().extract().response();
		
		//Converting response into string and printing the same to console
		String sGetBookJsonResponse = resGetBook.asString();
		System.out.println("GetBook response is - "+ sGetBookJsonResponse);
		
	}
	
	@DataProvider (name="BooksData")
	public Object[][] returnDataThroughDataProvider () {
		return new Object[][] {{"Appium Rest APIs", "bcd1244", "123", "Ravi"}, {"Appium", "abc123", "abc123", "Ashish"}, 
				{"Rest Assured", "APIs123", "1234", "Ashsh"}, {"RestAssured APIs", "Rest123", "Rest1234", "Ashish"}};
	}

}
