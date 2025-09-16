package ApiExamples;

import io.qameta.allure.*;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;




public class getPostsApi {
    String url ;
    @BeforeClass
    public void setup(){
        url= "https://jsonplaceholder.typicode.com" ;
    }

    @Epic("Posts API")
    @Feature("Get Single Post")
    @Story("GET /posts/1")
    @Severity(SeverityLevel.NORMAL)
    @Test(description = "Verify GET /posts/1")

    public void getMoreOneResponseApi(){
        Response response = RestAssured
                .given()
                .baseUri(url)
                .contentType(ContentType.JSON)
                .when()
                .get("/posts")
                .then()
                .statusCode(200)
                .extract().response();

        Assert.assertEquals(response.statusCode(), 200 , "Status Code = 200 ");
        Assert.assertNotNull(response, "Response it not null ");
        Assert.assertEquals(response.jsonPath().getInt("[2].id") , 3 , "The Third id = 3 ");
        Assert.assertEquals(response.jsonPath().getString("[2].title") , "ea molestias quasi exercitationem repellat qui ipsa sit aut"
                , "The thired title meet the expected ");



    }
}
