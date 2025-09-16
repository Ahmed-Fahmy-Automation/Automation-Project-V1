package ApiExamples;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class postPhotos {
    String baseUrl ;
    List<Map<String, Object>> requestBody ;

    @BeforeClass
    public void setup(){
        baseUrl ="https://jsonplaceholder.typicode.com";
        requestBody = new ArrayList<>();
        Map<String , Object> photo1 = new HashMap<>();
        Map<String , Object> photo2 = new HashMap<>();

        photo1.put("albumId", "1");
        photo1.put("id", "1");
        photo1.put("title", "accusamus beatae ad facilis cum similique qui sunt");
        photo1.put("url", "https://via.placeholder.com/600/92c952");
        photo1.put("thumbnailUrl", "https://via.placeholder.com/150/92c952");

        //>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>ADD Photo 2 <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
        photo2.put("albumId", "1");
        photo2.put("id", "2");
        photo2.put("title", "reprehenderit est deserunt velit ipsam");
        photo2.put("url", "https://via.placeholder.com/600/771796");
        photo2.put("thumbnailUrl", "https://via.placeholder.com/150/771796");

        requestBody.add(photo1);
        requestBody.add(photo2);

    }

    @Test
    public void postPhotos(){
        Response response = RestAssured
                .given()
                .contentType(ContentType.JSON)
                .baseUri(baseUrl)
                .body(requestBody)
                .when()
                .post("/photos")
                .then()
                .log().all()
                .statusCode(201)
                .extract().response();
    }
}
