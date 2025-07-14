package files;

public class Payloads {

	public static String AddPlaceJson() {

		return "{\r\n" + "  \"location\": {\r\n" + "    \"lat\": -38.383494,\r\n" + "    \"lng\": 33.427362\r\n"
				+ "  },\r\n" + "  \"accuracy\": 50,\r\n" + "  \"name\": \"Anas Ali khan house\",\r\n"
				+ "  \"phone_number\": \"(+91) 9389416686\",\r\n" + "  \"address\": \"87, Kanpur Nagar, Up 78\",\r\n"
				+ "  \"types\": [\r\n" + "    \"Leather park\",\r\n" + "    \"shop\"\r\n" + "  ],\r\n"
				+ "  \"website\": \"http://rahulshettyacademy.com\",\r\n" + "  \"language\": \"Hindi-IN\"\r\n" + "}";
	}

	public static String CoursePrice() {

		return "{\r\n" + "  \"dashboard\": {\r\n" + "    \"purchaseAmount\": 1162,\r\n"
				+ "    \"website\": \"rahulshettyacademy.com\"\r\n" + "  },\r\n" + "  \"courses\": [\r\n" + "    {\r\n"
				+ "      \"title\": \"Selenium Python\",\r\n" + "      \"price\": 50,\r\n" + "      \"copies\": 6\r\n"
				+ "    },\r\n" + "    {\r\n" + "      \"title\": \"Cypress\",\r\n" + "      \"price\": 40,\r\n"
				+ "      \"copies\": 4\r\n" + "    },\r\n" + "    {\r\n" + "      \"title\": \"RPA\",\r\n"
				+ "      \"price\": 45,\r\n" + "      \"copies\": 10\r\n" + "    },\r\n" + "     {\r\n"
				+ "      \"title\": \"Appium\",\r\n" + "      \"price\": 36,\r\n" + "      \"copies\": 7\r\n"
				+ "    }\r\n" + "    \r\n" + "    \r\n" + "    \r\n" + "  ]\r\n" + "}\r\n" + "";

	}

	public static String Addbook(String isbn, String aisle) {
		
		String payload ="{\r\n"
				+ "\r\n"
				+ "\"name\":\"Learn Appium Automation with Java\",\r\n"
				+ "\"isbn\":\""+isbn+"\",\r\n"
				+ "\"aisle\":\""+aisle+"\",\r\n"
				+ "\"author\":\"John foe\"\r\n"
				+ "}\r\n"
				+ "";

		return payload;
		
	}
}
