package ApiExamples;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class getCommentForSpecificPost {

    String baseUrl ;
    @BeforeClass
    public void setup(){

        baseUrl= "https://jsonplaceholder.typicode.com";

    }
    @Test
    public void getCommentForSpecificQueryParam(){

        for (int postId = 1 ; postId <6 ; postId++){
            Response response = RestAssured
                    .given()
                    .contentType(ContentType.JSON)
                    .baseUri(baseUrl)
                    .queryParam("postId" , postId)
                    .when()
                    .get("/comments")
                    .then()
                    .log().all()
                    .statusCode(200)
                    .extract().response();

            Assert.assertNotNull(response);
            Assert.assertNotNull(response.jsonPath().getString("[0].name"));
        }

    }


}
