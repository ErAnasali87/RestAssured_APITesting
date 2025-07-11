package Rest.API.Testing.RestAssures_APITesting;

public class Payloads{ 
 
	public static String AddPlaceJson() {
		
		return "{\r\n"
				+ "  \"location\": {\r\n"
				+ "    \"lat\": -38.383494,\r\n"
				+ "    \"lng\": 33.427362\r\n"
				+ "  },\r\n"
				+ "  \"accuracy\": 50,\r\n"
				+ "  \"name\": \"Anas Ali khan house\",\r\n"
				+ "  \"phone_number\": \"(+91) 9389416686\",\r\n"
				+ "  \"address\": \"87, Kanpur Nagar, Up 78\",\r\n"
				+ "  \"types\": [\r\n"
				+ "    \"Leather park\",\r\n"
				+ "    \"shop\"\r\n"
				+ "  ],\r\n"
				+ "  \"website\": \"http://rahulshettyacademy.com\",\r\n"
				+ "  \"language\": \"Hindi-IN\"\r\n"
				+ "}";
	}
}
