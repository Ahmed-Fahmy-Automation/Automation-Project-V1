package ApiExamples;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

public class postApiForOnePost {

    String baseUrl ;
    Map<String,Object> requestBody = new HashMap<>();

    @BeforeClass
    public void setup(){
        baseUrl = "https://jsonplaceholder.typicode.com";
        requestBody.put("userId" ,"1");
        requestBody.put("id" ,"1");
        requestBody.put("title" ,"sunt aut facere repellat provident occaecati excepturi optio reprehenderit");
        requestBody.put("body" ,"quia et suscipit\\nsuscipit recusandae consequuntur expedita et cum\\nreprehenderit molestiae ut ut quas totam\\nnostrum rerum est autem sunt rem eveniet architecto");

    }
    @Test
    public void postApinePost(){
        Response response = RestAssured
                .given()
                .baseUri(baseUrl)
                .contentType(ContentType.JSON)
                .body(requestBody)
                .when()
                .post("/posts")
                .then()
                .statusCode(201)
                .log().all()
                .extract().response();

        Assert.assertNotNull(response);
    }

}
