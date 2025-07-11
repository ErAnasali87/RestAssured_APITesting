package Rest.API.Testing.RestAssures_APITesting;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import org.testng.Assert;
import static io.restassured.RestAssured.*;
import static org.hamcrest.CoreMatchers.equalTo;

public class addPlace_API {
	/* Rest Assure in Java works on three basic keywords
	 1- Given -> Containing all the input details
	 2- When -> Submitting the API(resources and http method)
	 3- Then -> Validating the response
	*/
	public static void main(String[] args) {
		
		RestAssured.baseURI = "https://rahulshettyacademy.com";
		
		// adding place 
		
		String response = given().log().all().queryParam("key", "qaclick123").header("content-Type", "application/json")
		.body(Payloads.AddPlaceJson()).when().post("maps/api/place/add/json")
		.then().assertThat().statusCode(200).body("scope", equalTo("APP"))
		.extract().response().asString();
		
		JsonPath js = new JsonPath(response);//Parsing the json and extracting the Place ID
		String placeID = js.getString("place_id");
		
		System.out.println(placeID);
		
		//update the place 
		String newAddress = "16 Heera man Purwa";
		given().log().all().queryParam("key", "qaclick123").header("content-Type", "application/json")
		.body("{\r\n"
				+ "\"place_id\":\""+placeID+"\",\r\n"
				+ "\"address\":\""+newAddress+"\",\r\n"
				+ "\"key\":\"qaclick123\"\r\n"
				+ "}").
		when().put("maps/api/place/update/jason").
		then().assertThat().statusCode(200).body("msg", equalTo("Address successfully updated"));
		
		// get place
		
		String getPlaceResponse = given().log().all().queryParam("key", "qaclick123").queryParam("place_id", placeID)
		.when().get("maps/api/place/get/jason")
		.then().assertThat().statusCode(200).extract().asString();
		
		JsonPath js1 = new JsonPath(getPlaceResponse);
		String ActualAddress = js1.getString("address");
		Assert.assertEquals(ActualAddress, newAddress);
	}

}
