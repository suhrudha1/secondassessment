package project1234;

import org.json.simple.JSONObject;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class file {
	@Test(enabled = true,dependsOnMethods={"putSUHRUDHA"})
	public void getSUHRUDHA()
	{
		RestAssured.baseURI="https://petstore.swagger.io/v2/";
		
		given()
		.get("user/Suhrudha77")
        .then()
		.statusCode(200).log().all();	
	}
	@SuppressWarnings("unchecked")
	@Test(enabled=true,dataProvider="postData")
	
	public void postSUHRUDHA(String data)
	{
		RestAssured.baseURI="https://petstore.swagger.io/v2/";
		
	
		given()
		.contentType(ContentType.JSON)
        .body(data)
		.when()
		.post("user")
		.then()
		.statusCode(200).log().all();
		
	}
	
	@SuppressWarnings("unchecked")
	@DataProvider(name="postData")
    public Object[][] providerPOST(){
		JSONObject j1 = new JSONObject();
        j1.put("username", "Suhrudha77");
        j1.put("firstName", "suhrudha");
        j1.put("lastName","k");
        j1.put("email", "suhrudha@gmail.com");
        j1.put("password", "Suhrudha789");
        j1.put("phone","9867543987");
        j1.put("userStatus","1");
        
        Object[][] postData = {
        		{j1.toString()}
        };
        return postData;
    }
        
	@Test(enabled=true,dataProvider="putData",dependsOnMethods={"postSUHRUDHA"})
	public void putSUHRUDHA(String data)
	{
		RestAssured.baseURI="https://petstore.swagger.io/v2/";
		
	
		given()
		.contentType(ContentType.JSON)
        .body(data)
		.when()
		.put("user/Suhrudha77")
		.then()
		.statusCode(200).log().all();
		
	}
	
	@SuppressWarnings("unchecked")
	@DataProvider(name="putData")
    public Object[][] providerPUT(){
		JSONObject j1 = new JSONObject();
        j1.put("username", "Suhrudha77");
        j1.put("firstName", "suhrudha");
        j1.put("lastName","k");
        j1.put("email", "suhrudha@gmail.com");
        j1.put("password", "SUHURDHAs987");
        j1.put("phone","7865345234");
        j1.put("userStatus","1");
        
        Object[][] putData = {
            {j1.toString()}
        };        
        return putData;
	}  
	@Test(enabled=true,dataProvider="deleteData",dependsOnMethods={"putSUHRUDHA"})
	public void deleteSUHRUDHA(String data)
	{
		RestAssured.baseURI="https://petstore.swagger.io/v2/";
		
	
		given()
		.delete("user/"+data)
		.then()
		.statusCode(200).log().all();
		
	}
	@DataProvider(name="deleteData")
    public Object[][] providerDELETE(){
        Object[][] deleteData = {{"Suhrudha77"}};
        return deleteData;
    }
	@Test(enabled=true,dataProvider="loginData",dependsOnMethods={"postSUHRUDHA"})
	public void loginSuhrudha(String username, String password)
	{
		RestAssured.baseURI="https://petstore.swagger.io/v2/";
		
	
		given()
		.queryParam("username", username)
        .queryParam("password", password)
		.get("user/login")
		.then()
		.statusCode(200).log().all();
	}
    @DataProvider(name="loginData")
    public Object[][] providerLogin(){
        Object[][] loginData = {{"Suhrudha77", "SUHURDHAs987"}};
        return loginData;
    }
}





