package ApiExamples;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static org.hamcrest.Matchers.*;


public class getAPI {

        String baseURL ;
        @BeforeClass
        public void setup (){
            baseURL= "https://jsonplaceholder.typicode.com" ;
        }

        @Test
        public void testGetOnePost(){
            Response response = RestAssured
                    .given()
                    .baseUri(baseURL)
                    .when()
                    .get("/posts/1")
                    .then()
                    .log().all()
                    .assertThat()
                    .statusCode(200)
                    .body("id" ,equalTo(1))
                    .body("userId", notNullValue())
                    .body("title" ,not(emptyString()))
                    .body("body", containsString("suscipit")) // Partial match in body text
                    .extract().response();

            Assert.assertEquals(response.getStatusCode(),200);
            System.out.println("response time =" + response.getTimeIn(TimeUnit.SECONDS) );
            Assert.assertNotNull(response.jsonPath().getString("title"));
            Assert.assertNotNull(response.jsonPath().getInt("id"));
            Assert.assertEquals(response.jsonPath().getInt("id"),1);
            Assert.assertEquals(response.jsonPath().getString("title") , "sunt aut facere repellat provident occaecati excepturi optio reprehenderit");
            Assert.assertEquals(response.jsonPath().getString("body") , "quia et suscipit\nsuscipit recusandae consequuntur expedita et cum\nreprehenderit molestiae ut ut quas totam\nnostrum rerum est autem sunt rem eveniet architecto");
        }

}
