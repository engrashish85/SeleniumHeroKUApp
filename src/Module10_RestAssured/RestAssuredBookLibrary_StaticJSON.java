package Module10_RestAssured;

import static io.restassured.RestAssured.given;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.testng.annotations.Test;

import Module9.Selenium_WorkingWithDriver;

public class RestAssuredBookLibrary_StaticJSON extends Selenium_WorkingWithDriver {
	
	public String sPropertiesFileLocation = 
			".\\src\\Module9\\Config\\restAssuredEnvironment.Properties";
	public static String[] arrBookLibraryValues;
	
	@Test
	public void AddBook () throws IOException {
		
		//Creating object of RestAssuredGlobalVariables class
		//RestAssuredGlobalVariables obRestAssuredGlobalVariables = new RestAssuredGlobalVariables ();
		
		//Retrieving baseURI from properties file and printing the same in console
		RestAssured.baseURI = returnValueFromPropertiesFile(sPropertiesFileLocation, "sWSDLHost");
		System.out.println(RestAssured.baseURI);
		
		//Initializing resources
		String sAddBookLibrary_Json = returnValueFromPropertiesFile (sPropertiesFileLocation, 
				"sAddBookLibrary_Json");
		//String sGetBookLibrary_Json = returnValueFromPropertiesFile (sPropertiesFileLocation, 
		//		"sGetBookLibrary_Json");
		
		//Returning array values needed to be appended in the request
		//arrBookLibraryValues = obRestAssuredGlobalVariables.returnBodyStringsAddBook(sBookName, sIsbn, 
		//		sAisle, sAuthorName);
		//System.out.println(arrBookLibraryValues.length);
		//for (int i = 0; i < arrBookLibraryValues.length; i ++) {
		//	System.out.println("iCounter = " + i+ "	" + arrBookLibraryValues[i]);
		//}
		
		//Retrieving text from text file and printing the same to console
		String sJsonRequest = retrieveTextFromTextFile(".\\src\\Module10_RestAssured\\Files\\Json\\AddBook.json");
		System.out.println("Request is - "+sJsonRequest);
		
		//Extracting response by using given, when, then and extract keywords
		Response resResponse = given().header("content-Type", "application/json").
		body(sJsonRequest).when().post(sAddBookLibrary_Json).then().//assertThat().statusCode(200)
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

	}
	
	public String retrieveTextFromTextFile (String sFilePath) throws IOException {
		return new String (Files.readAllBytes(Paths.get(sFilePath)));
	}

}
	
