package OAuth_API;

import io.restassured.path.json.JsonPath;
import static io.restassured.RestAssured.given;

public class OAuth_test {

	public static void main(String[] args) {
// This OAuth authentication All form parameters are the part of API contracts.
		String response =
				given()
				.formParams("client_id", "692183103107-p0m7ent2hk7suguv4vq22hjcfhcr43pj.apps.googleusercontent.com")
				.formParams("client_secret", "erZOWM9g3UtwNRj340YYaK_W")
				.formParams("grant_type", "client_credentials")
				.formParams("scope", "trust")
				.when().log().all()
				.post("https://rahulshettyacademy.com/oauthapi/oauth2/resourceOwner/token").asString();

		System.out.println(response);
		JsonPath jsonPath = new JsonPath(response);
		String accessToken = jsonPath.getString("access_token");
		System.out.println(accessToken);

		String CourseDetail = 
				given()
				.queryParams("access_token", accessToken)
				.when()
				.get("https://rahulshettyacademy.com/oauthapi/getCourseDetails")
				.asString();

		System.out.println(CourseDetail);

	}

}
