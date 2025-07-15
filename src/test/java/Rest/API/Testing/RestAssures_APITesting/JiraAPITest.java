package Rest.API.Testing.RestAssures_APITesting;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import static io.restassured.RestAssured.*;
import java.io.File;

// Creating Jira ticket for bug and adding attachment directly from RESTAPI call.
// Authenticating through base authentication.

public class JiraAPITest {

	public static void main(String[] args) {
		
		RestAssured.baseURI = "https://anasali1850510006.atlassian.net/";
		String createIssueResponse = 
				given()
				.header("Content-Type", "application/json")
				.header("Authorization", "Basic YW5hc2FsaTE4NTA1MTAwMDZAZ21haWwuY29tOkFUQVRUM3hGZkdGMHJhSV84VTMzZi1td2Q4V1lLSVRuaU9XNVJXQUJDbVk0bWZ3UzZtMXNNeWloNHNZYTNSTnhNbFBxejNwZmxMOXpyemY2anhUSW01Z2x6X0d3YkFYclNwZEFtdHFiaFR3S2ZfTE9rM1J0bjljR3R5QnNKTTJyMzRZclNCX0xiSXJDUmFhUHV4YzZMaEFhWFlXa2NHajAtN1pQUkczNEEzMmg4eWlqLVlIeHYxST1CM0ZBREU3NA==")
				.body("{\n" + "    \"fields\": {\n"
						+ "       \"project\":\n" 
						+ "       {\n"
						+ "          \"key\": \"SCRUM\"\n" 
						+ "       },\n"
						+ "       \"summary\": \"Creating Jira Bug from automation Rest Assured\",\n"
						+ "       \"issuetype\": {\n"
						+ "          \"name\": \"Bug\"\n" 
						+ "       }\n" 
						+ "   }\n" 
						+ "}")
				.log().all()
				.post("rest/api/3/issue")
				.then().log().all().assertThat().statusCode(201)
				.contentType("application/json").extract().response().asString();
		
		JsonPath js = new JsonPath(createIssueResponse);
		String issueId = js.getString("id");
		System.out.println(issueId);
		
		given().pathParam("key", issueId)
		.header("X-Atlassian-Token", "no-check")
		.header("Authorization", "Basic YW5hc2FsaTE4NTA1MTAwMDZAZ21haWwuY29tOkFUQVRUM3hGZkdGMHJhSV84VTMzZi1td2Q4V1lLSVRuaU9XNVJXQUJDbVk0bWZ3UzZtMXNNeWloNHNZYTNSTnhNbFBxejNwZmxMOXpyemY2anhUSW01Z2x6X0d3YkFYclNwZEFtdHFiaFR3S2ZfTE9rM1J0bjljR3R5QnNKTTJyMzRZclNCX0xiSXJDUmFhUHV4YzZMaEFhWFlXa2NHajAtN1pQUkczNEEzMmg4eWlqLVlIeHYxST1CM0ZBREU3NA==")
		.multiPart("file", new File("C:\\Users\\Hp\\Downloads\\AI-Wallpaper.pictures")).log().all()
		.post("rest/api/3/issue/{key}/attachments").then().log().all().assertThat().statusCode(200);

	}

}
