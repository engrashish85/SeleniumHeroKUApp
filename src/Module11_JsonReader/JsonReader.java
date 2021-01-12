//package Module11_JsonReader;
//
//import java.io.FileNotFoundException;
//import java.io.FileReader;
//import java.util.Iterator;
//import java.util.Map;
//
//import com.fasterxml.jackson.core.JsonParser;
//import com.google.gson.JsonObject;
//import org.json.simple.JSONArray;
//import org.json.simple.JSONObject;
//import org.json.simple.parser.*;
//import org.testng.annotations.Test;
//
//public class JsonReader {
//    private String jsonFileLocation = ".\\src\\Module10_RestAssured\\Files.Json\\SampleJson.json";
//
//    @Test
//    public void readJsonFromJsonFile() throws FileNotFoundException {
//        Object obj = new JsonParser().parse(new FileReader(jsonFileLocation));
//        JsonObject jsonObject = (JsonObject) obj;
//        //String firstName = (String) jsonObject.get("firstName");
//
//    }
//}
