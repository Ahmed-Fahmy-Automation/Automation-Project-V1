package ApiExamples;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class getPhotos {
    String baseUrl ;
    @BeforeClass
    public void setup (){
        baseUrl = "https://jsonplaceholder.typicode.com" ;
    }

    @Test
    public void getPhotos(){
        Response response = RestAssured
                .given()
                .baseUri(baseUrl)
                .contentType(ContentType.ANY)
                .when()
                .get("/photos")
                .then()
                //.log().all()
                .statusCode(200)
                .extract().response();

        String actualFirsAlbumId = response.jsonPath().getString("[0].albumId");
        System.out.println(actualFirsAlbumId);
        Assert.assertNotNull(response.getBody());
        Assert.assertEquals(response.statusCode() , 200);
        Assert.assertEquals(actualFirsAlbumId, "1" , "Content not equal ");
    }
}
