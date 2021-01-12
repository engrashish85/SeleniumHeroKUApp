//package Module10_RestAssured;
//
//import io.restassured.RestAssured;
//import io.restassured.http.ContentType;
//import io.restassured.path.json.JsonPath;
//import io.restassured.response.Response;
//import org.testng.annotations.Test;
//
//import static io.restassured.RestAssured.given;
//import static org.hamcrest.Matchers.equalTo;
//
//public class RestAssuredBasics {
//
//	@Test
//	public void Test () {
//		// TODO Auto-generated method stub
//
//		//Providing Base URL
//		RestAssured.baseURI = "https://maps.googleapis.com";
//
//		//given() - pass request headers, parameters and request cookies
//		Response res = given().
//		param("location", "-33.8670522,151.1957362").
//		param("radius", "500").
//		param("key", "AIzaSyAQeHkUUh5KJJvUwWkAwONULplIszoIwZI").
//
//		//When() - pass get(resource), put (resource) and post (resource),
//		when().
//		get ("maps/api/place/nearbysearch/json").
//
//		then().assertThat().statusCode(200).and().contentType(ContentType.JSON).and().
//		//body("results[0].geometry.location.lat",equalTo("-33.8650921"));
//		//body("results[0].photos[0].height", equalTo("3120")).and().
//		body("results[0].name",  equalTo("Sydney")).and().
//		header ("server", "scaffolding on HTTPServer2").extract().response();
//
//		//Extracting results
//		String resGetPlace = res.asString();
//
//		//Converting to JSON path
//		JsonPath oJsonPath = new JsonPath (resGetPlace);
//
//		//Retrieving size of results
//		int counter = oJsonPath.get("results.size()");
//		System.out.println(counter);
//
//		//Looping through the for loop to get name of each and every place
//		for (int i = 0; i < counter; i ++) {
//			String sPlaceName = oJsonPath.get("results[" + i + "].name");
//			System.out.println(sPlaceName);
//		}
//
//
//	}
//
//}
