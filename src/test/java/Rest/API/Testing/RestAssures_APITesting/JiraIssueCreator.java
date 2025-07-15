package Rest.API.Testing.RestAssures_APITesting;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Test; // Or use org.junit.jupiter.api.Test for JUnit 5

public class JiraIssueCreator {

    // IMPORTANT: Replace with your actual Jira instance URL
    private static final String BASE_URI = "https://anasali1850510006.atlassian.net";

    // IMPORTANT: Replace with your actual Basic Authorization token
    // This token is Base64 encoded 'your_email:your_api_token'
    // Example: "YW5hc2FsaTE4NTA1MTAwMDZAZ21haWwuY29tOkFUQVRUM3hGZkdGMHJhSV84VTMzZi1td2Q4V1lLSVRuaU9XNVJXQUJDbVk0bWZ3UzZtMXNNeWloNHNZYTNSTnhNbFBxejNwZmxMOXpyemY2anhUSW01Z2x6X0d3YkFYclNwZEFtdHFiaFR3S2ZfTE9rM1J0bjljR3R5QnNKTTJyMzRZclNCX0xiSXJDUmFhUHV4YzZMaEFhWFlXa2NHajAtN1pQUkczNEEzMmg4eWlqLVlIeHYxST1CM0ZBREU3NA=="
    private static final String AUTH_TOKEN = "YW5hc2FsaTE4NTA1MTAwMDZAZ21haWwuY29tOkFUQVRUM3hGZkdGMHJhSV84VTMzZi1td2Q4V1lLSVRuaU9XNVJXQUJDbVk0bWZ3UzZtMXNNeWloNHNZYTNSTnhNbFBxejNwZmxMOXpyemY2anhUSW01Z2x6X0d3YkFYclNwZEFtdHFiaFR3S2ZfTE9rM1J0bjljR3R5QnNKTTJyMzRZclNCX0xiSXJDUmFhUHV4YzZMaEFhWFlXa2NHajAtN1pQUkczNEEzMmg4eWlqLVlIeHYxST1CM0ZBREU3NA==";

    @Test
    public void createJiraBugIssue() {
        // Set the base URI for all requests
        RestAssured.baseURI = BASE_URI;

        // Define the JSON request body as a String
        // Make sure the 'name' for 'issuetype' exactly matches what's in your Jira project.
        // Common issue types are "Bug", "Story", "Task", "Epic".
        // If "Bug" is not valid for your "SCRUM" project, you will get a 400 error.
        String requestBody = "{\n" +
                             "    \"fields\": {\n" +
                             "        \"project\": {\n" +
                             "            \"key\": \"SCRUM\"\n" +
                             "        },\n" +
                             "        \"summary\": \"Website items are not working- automation Rest Assured\",\n" +
                             "        \"issuetype\": {\n" +
                             "            \"name\": \"Bug\"\n" + // <-- Verify this name in Jira
                             "        }\n" +
                             "    }\n" +
                             "}";

        try {
            // Send the POST request to create an issue
            Response response = RestAssured.given()
                    .contentType(ContentType.JSON) // Set Content-Type header to application/json
                    .header("Authorization", "Basic " + AUTH_TOKEN) // Set Authorization header
                    .body(requestBody) // Attach the JSON request body
                    .log().all() // Log all request details to console (for debugging)
                    .when()
                    .post("/rest/api/3/issue") // Specify the endpoint for creating issues
                    .then()
                    .log().all() // Log all response details to console (for debugging)
                    .extract().response(); // Extract the response object

            // Assert the status code is 201 (Created)
            // If you get a 400, check the response body for specific error messages
            response.then().statusCode(201);

            System.out.println("Jira issue created successfully!");
            System.out.println("Issue Key: " + response.jsonPath().getString("key"));
            System.out.println("Issue ID: " + response.jsonPath().getString("id"));
            System.out.println("Issue URL: " + response.jsonPath().getString("self"));

        } catch (Exception e) {
            System.err.println("Failed to create Jira issue: " + e.getMessage());
            // If the assertion for status code fails, it will throw an AssertionError.
            // You can add more specific error handling here based on the response body.
        }
    }
}
