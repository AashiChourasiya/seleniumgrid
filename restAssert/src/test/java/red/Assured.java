package red;

import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import org.json.simple.JSONObject;
import static io.restassured.matcher.RestAssuredMatchers.*;
public class Assured {
	
		@Test(enabled = false)
		public void setup() {
			Response rest = RestAssured.get("https://reqres.in/api/users");
			int status = rest.statusCode();
			Assert.assertEquals(status, 200);
		}
		@Test(enabled = false)
		public void listuser() {
			given().get("https://reqres.in//api/users?page=2").then().statusCode(200).log().all();
		}
		@Test(enabled = false)
		public void ListUsers() {
			given().get("https://reqres.in/api/users?page=2").then().statusCode(200).log().all();
		}
		@Test(enabled = false)
		public void SingleUser() {
			given().get("https://reqres.in/api/users/2").then().statusCode(200).body("data.first_name", equalTo("Janet"));
		}
		@Test(enabled = false)
		public void singleUserNotFound() {
			given().get("https://reqres.in/api/users/23").then().statusCode(404).log().all();
		}
		@Test(enabled = false)
		public void listResourse() {
			given().get("https://reqres.in/api/unknown").then().statusCode(200).log().all();
		}
		@Test(enabled = false)
		public void singleUser() {
			given().get("https://reqres.in/api/unknown/2").then().statusCode(200).body("data.id", equalTo(2)).log().all();
		}
		
		@Test(enabled = false)
		public void singleRessourse() {
			given().get("https://reqres.in/api/unknown/23").then().statusCode(404).log();
		}
		@Test(enabled = false)
		public void create() {
			JSONObject obj = new JSONObject();
			obj.put("name", "Aashi");
			obj.put("job", "tester");
			given().body(obj.toJSONString()).when().post("https://reqres.in/api/users").then().statusCode(201).log().all();
		}
		
		 @Test(enabled = false)
		 public void Delete() {
			 given().delete("https://reqres.in/api/users/2").then().statusCode(204).log().all();
		 }
		 @Test(enabled = true)
		 public void delete() {
			 given().delete("https://reqres.in/api/users/2").then().statusCode(204).log().all();
		 }
		 @Test(enabled = false)
			public void Register() {
				JSONObject obj = new JSONObject();
				obj.put("email", "aashichourasiya7631@gmail.com");
				obj.put("password", "8305359788");
				given().body(obj.toJSONString()).when().post("https://reqres.in/api/register").then().statusCode(200).log().all();
			}
		 @Test(enabled = true)
			public void UnSuccessFullRegister() {
				JSONObject obj = new JSONObject();
				obj.put("email", "aashichourasiya7631@gmail.com");
				
			given().body(obj.toJSONString()).when().post("https://reqres.in/api/register").then().statusCode(400).log().all();
			}
		 @Test(enabled = false)
			public void loginSuccessFul() {
				JSONObject obj = new JSONObject();
				obj.put("email", "aashichourasiya7631@gmail.com");
				obj.put("password", "8305359788");
			given().body(obj.toJSONString()).when().post("https://reqres.in/api/login").then().statusCode(200).log().all();
			}
		 @Test(enabled = false)
			public void UnsuccessfulLogin() {
				JSONObject obj = new JSONObject();
				obj.put("email", "aashichourasiya7631@gmail.com");
				obj.put("password", "8305359788");
			given().body(obj.toJSONString()).when().post("https://reqres.in/api/login").then().statusCode(400).log().all();
			}
	}

