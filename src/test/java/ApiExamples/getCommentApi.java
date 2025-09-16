package ApiExamples;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class getCommentApi {

    String baseUrl ;
    @BeforeClass
    public void setup(){
        baseUrl = "https://jsonplaceholder.typicode.com" ;
    }

    @Test
    public void getCommentsforPosts(){

        Response response = RestAssured
                .given()
                .contentType(ContentType.JSON)
                .baseUri(baseUrl)
                .when()
                .get("/posts/1/comments")
                .then()
                .log().all()
                .statusCode(200)
                .extract().response();




        Assert.assertNotNull(response.jsonPath().get());
        int firstId = response.jsonPath().getInt(("[0].postId")) ;
        Assert.assertEquals(firstId, 1 );
        Assert.assertEquals(response.jsonPath().getInt("[0].id"),1);
        Assert.assertEquals(response.jsonPath().getString("[0].name"), "id labore ex et quam laborum");



    }

}
