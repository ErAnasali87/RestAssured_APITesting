package Rest.API.Testing.RestAssures_APITesting;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
//import io.restassured.response.Response;
import files.Payloads;
import files.ReUsableMethod;

public class DynamicJson {

	@Test(dataProvider = "BooksData")
	public void addBook(String isbn, String aisle)

	{
		RestAssured.baseURI = "http://216.10.245.166";
		String resp = given().
	     		header("Content-Type", "application/json").
				body(Payloads.Addbook(isbn, aisle)).
				when().
				post("/Library/Addbook.php").
				then().assertThat().statusCode(200).
				extract().response().asString();
		JsonPath js = ReUsableMethod.rawToJson(resp);
		String id = js.get("ID");
		System.out.println(id);
		// deleteBOok
	}

	//array=collection of elements
	//multidimensional array= collection of arrays
	@DataProvider(name="BooksData")
	public Object[][]  getData(){
		return null;
		//return new Object[][] {‌{"Anas","9363"}, {"Alikk","4253"}, {"KhanK","533"}};
	}
}