package Module10_RestAssured;

import java.io.IOException;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;
import static  org.hamcrest.Matchers.equalTo;

import org.testng.annotations.Test;

import Module9.Selenium_WorkingWithDriver;

public class RestAssuredPlaceAddandDelete_JSON extends Selenium_WorkingWithDriver {
	
	public String sPropertiesFileLocation = 
			".\\src\\Module9\\Config\\restAssuredEnvironment.Properties";
	
	@Test
	public void AddPlace () throws IOException {
		
		//Creating object of RestAssuredGlobalVariables class
		RestAssuredGlobalVariables obRestAssuredGlobalVariables = new RestAssuredGlobalVariables ();
		
		//Retrieving baseURI from properties file and printing the same in console
		RestAssured.baseURI = returnValueFromPropertiesFile(sPropertiesFileLocation, "sWSDLHost");
		System.out.println(RestAssured.baseURI);
		
		//Initializing resources
		String sAddPlaceResources_Json = returnValueFromPropertiesFile (sPropertiesFileLocation, 
				"sAddPlaceResources_Json");
		String sDeletePlaceResources_Json = returnValueFromPropertiesFile (sPropertiesFileLocation, 
				"sDeletePlaceResources_Json");
		String sGoogleSecureKey = returnValueFromPropertiesFile(sPropertiesFileLocation, 
				"sGoogleSecureKey");
		
		//Extracting response by using given, when, then and extract keywords
		Response resJSONResponse = given().queryParam("key", sGoogleSecureKey).
		body(obRestAssuredGlobalVariables.sJSONAddPlaceRequest).when().post(sAddPlaceResources_Json).then().assertThat().statusCode(200).and().
		body("status", equalTo ("OK")).extract().response();
		
		//Typecasting response to String
		String sJSONResponse = resJSONResponse.asString();
		
		//Printing response in console
		System.out.println(sJSONResponse);
		
		//Converting string to JSON format and extracting place_id
		JsonPath oJsonPath = new JsonPath (sJSONResponse);
		String sPlaceID = oJsonPath.get("place_id");
		
		//Printing place id to console
		System.out.println(sPlaceID);
		
		//Initializing Delete Request by concatenating the place id retrieved from add place response
		String sDeletePlaceRequest = obRestAssuredGlobalVariables.returnDeletePlaceRequestString("JSON", sPlaceID);
		
		//Posting and extracting response of delete request
		resJSONResponse = given().queryParam("key", sGoogleSecureKey).
				body(sDeletePlaceRequest).when().post(sDeletePlaceResources_Json).then().assertThat().
				statusCode(200).extract().response();
		
		//Type casting response to string and printing the same to console
		sJSONResponse = resJSONResponse.asString();
		System.out.println(sJSONResponse);
		
		//extracting status value from JSON Response and printing the same to console
		oJsonPath = new JsonPath (sJSONResponse);
		String sStatus = oJsonPath.get("status");
		System.out.println("status value is - "+sStatus);
		
	}
}
