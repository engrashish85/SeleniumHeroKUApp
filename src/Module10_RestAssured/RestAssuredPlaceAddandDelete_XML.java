package Module10_RestAssured;

import java.io.IOException;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;
import static  org.hamcrest.Matchers.equalTo;

import org.testng.annotations.Test;

import Module9.Selenium_WorkingWithDriver;

public class RestAssuredPlaceAddandDelete_XML extends Selenium_WorkingWithDriver {
	
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
		String sAddPlaceResources_XML = returnValueFromPropertiesFile (sPropertiesFileLocation, 
				"sAddPlaceResources_XML");
		String sDeletePlaceResources_XML = returnValueFromPropertiesFile (sPropertiesFileLocation, 
				"sDeletePlaceResources_XML");
		String sGoogleSecureKey = returnValueFromPropertiesFile(sPropertiesFileLocation, 
				"sGoogleSecureKey");
		
		
		//Extracting response by using given, when, then and extract keywords
		Response resResponse = given().queryParam("key", sGoogleSecureKey).
		body(obRestAssuredGlobalVariables.sXMLAddPlaceRequest).when().post(sAddPlaceResources_XML).then().
		assertThat().statusCode(200).and().body("response.status", equalTo ("OK")).extract().response();
		
		//Type casting response to String
		String sXMLResponse = resResponse.asString();
		
		//Printing response in console
		System.out.println(sXMLResponse);
		
		//Converting string to JSON format and extracting place_id
		XmlPath oXmlPath = new XmlPath (sXMLResponse);
		String sPlaceID = oXmlPath.get("response.place_id");
		
		//Printing place id to console
		System.out.println(sPlaceID);
		
		//Initializing Delete Request by concatenating the place id retrieved from add place response
		String sDeletePlaceRequest = obRestAssuredGlobalVariables.returnDeletePlaceRequestString("XML", sPlaceID);
		
		//Posting and extracting response of delete request
		Response resXMLResponse = given().queryParam("key", sGoogleSecureKey).
				body(sDeletePlaceRequest).when().post(sDeletePlaceResources_XML).then().assertThat().
				statusCode(200).extract().response();
		
		//Type casting response to string and printing the same to console
		sXMLResponse = resXMLResponse.asString();
		System.out.println(sXMLResponse);
		
		//extracting status value from JSON Response and printing the same to console
		oXmlPath = new XmlPath (sXMLResponse);
		String sStatus = oXmlPath.get("response.status");
		System.out.println("status value is - "+sStatus);
		
	}
}
