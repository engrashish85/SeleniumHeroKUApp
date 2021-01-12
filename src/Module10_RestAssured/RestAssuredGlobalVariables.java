
package Module10_RestAssured;

public class RestAssuredGlobalVariables {
	
	//Initializing addPlace request in JSON format
	String sJSONAddPlaceRequest = "{" +

    "\"location\":{" +

        "\"lat\" : -38.383494," +

        "\"lng\" : 33.427362" +

    "}," +

    "\"accuracy\":50," +

    "\"name\":\"Frontline house\"," +

    "\"phone_number\":\"(+91) 983 893 3937\"," +

    "\"address\" : \"29, side layout, cohen 09\"," +

    "\"types\": [\"shoe park\",\"shop\"],"+

    "\"website\" : \"http://google.com\"," +

    "\"language\" : \"French-IN\"" +

	"}";
	
	//Initializing addPlace request in XML format
	String sXMLAddPlaceRequest = "<?xml version=\"1.0\" encoding=\"UTF-8\" ?>" +
	
	"<root>" +
	
    	"<location>" +
    	
        	"<lat>-38.383494</lat>" +
        	
        	"<lng>33.427362</lng>" +
        	
        "</location>" +
        
	    "<accuracy>50</accuracy>" +
	    
	    "<name>The Mens store</name>" +
	    
	    "<phone_number>(+91) 983 893 3937</phone_number>" +
	    
	    "<address>Anna Salai, Chennai</address>" +
	    
	    "<types>shoe park</types>" +
	    
	    "<types>kadai</types>" +
	    
	    "<website>http://google.com</website>" +
	    
	    "<language>tamil-IN</language>" +
	    
	"</root>";
	
	//String sBodyFormatterJsonEscapeAddBookRequest = "{\r\n\"name\":\"Learn Appium Automation with Java\",\r\n\"isbn\":\"bcd\",\r\n\"aisle\":\"227\",\r\n\"author\":\"John foe\"\r\n}";
	
	public static String sBodyFormatterJsonEscapeAddBookRequest = "{\r\n\"name\":\"Learn Appium Automation with Java2\",\r\n\"isbn\":\"bcdasd\",\r\n\"aisle\":\"228\",\r\n\"author\":\"John foe\"\r\n}\r\n";

	public String returnDeletePlaceRequestString (String sOutputResponseType, String sPlaceID)  {
		
		//Initializing sDeletePlaceRequest
		String sDeletePlaceRequest = null;
		
		switch (sOutputResponseType) {
			case "JSON" :
				
				//Defining sDeletePlaceRequest in JSON response
				sDeletePlaceRequest = "{" +
					    "\"place_id\":\"" + sPlaceID + "\"" +
				"}";
				
				break;
				
			case "XML" :
				
				//Defining sDeletePlaceRequest in XML format
				sDeletePlaceRequest = "<?xml version=\"1.0\" encoding=\"UTF-8\" ?>" +
				"<root>" +
				    "<place_id>" + sPlaceID + "</place_id>" +
				"</root>";
				
				break;
			
			default:
				break;
				
		}
			
		//Returning String through the method
		return sDeletePlaceRequest;
	
	}
	
	public String[] returnBodyStringsAddBook (String sName, String sIsbn, String sAisle, String sAuthor) {
		
		//Initializing an array
		String[] arrName = new String[4];
		
		//Iterating through the loop to put values in the array
		for (int iCounter = 0; iCounter < arrName.length; iCounter ++) {
			switch (iCounter) {
				case (0) :
					if (!(sName == "")) {
						arrName[0] = sName;
					}
					break;
				case (1) :
					if (!(sIsbn == "")) {
						arrName[1] = sIsbn;
					}
					break;
				case (2) :
					if (!(sAisle == "")) {
						arrName[2] = sAisle;
					}
					break;
				case (3) :
					if (!(sAuthor == "")) {
						arrName[3] = sAuthor;
					}
					break;
				default :
					break;
				
			}
				 
		}
		
		sBodyFormatterJsonEscapeAddBookRequest = "{\r\n\"name\":\"" + sName + "\",\r\n\"isbn\":\"" + sIsbn + "\",\r\n\"aisle\":\"" + sAisle + "\",\r\n\"author\":\"" + sAuthor + "\"\r\n}\r\n";
		
		//Returning array through the function
		return arrName;
	}

}
