package ApiExamples;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.config.EncoderConfig.encoderConfig;

public class graph {
    String baseUrl ;
    String requestBody ;

    String graphQLQuery ;

    @BeforeClass
    public void setup(){
        baseUrl = "https://eipstg.rtatestdom.local:21645" ;

        graphQLQuery = "{ GetLicenseDataAttributes(DataRequesterId: \"CM-QA-RTA\") { LicenseDataOutputAttributes } }";

        // Wrap it in JSON object (GraphQL expects it in { "query": "..."} format)
        requestBody = "{ \"query\": \"" + graphQLQuery.replace("\"", "\\\"") + "\" }";
    }

    @Test
    public void postGraph(){

        Response response = RestAssured
                .given()
                .log().all()
                .relaxedHTTPSValidation()
                .auth().preemptive().basic("eTrafficstguser", "eTrafficstguser")
                .contentType(ContentType.JSON)
                .config(RestAssured.config()
                        .encoderConfig(encoderConfig()
                                .encodeContentTypeAs("application/json", ContentType.TEXT)))
                .baseUri(baseUrl)
                .body(requestBody)
                .when()
                .post("/getLicenseData")
                .then()
                .statusCode(201)
                .log().all()
                .extract().response();

    }

}
