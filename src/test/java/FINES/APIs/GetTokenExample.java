package FINES.APIs;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Test;

public class GetTokenExample {

    String baseUrl = "https://comgw.qa.rta.ae" ;
    String requestBody ="{\n" +
            "    \"nationalId\": \"GUEST_USER\",\n" +
            "    \"channelCode\": \"MOBILE\",\n" +
            "    \"clientId\": \"RTA_MOBILE_APP\",\n" +
            "    \"apiKey\": \"NY*p.p>93^P6<!s[Q7`(X5)Jc8kWD*:fJ[B)db#UXe)??Ttjx]\"\n" +
            "}";

    @Test
    public void getToken(){
        Response r  = RestAssured
                .given()
                .baseUri(baseUrl)
                .contentType(ContentType.JSON)
                .header("INTERNAL_CALL", "true")
                .relaxedHTTPSValidation()
                .body(requestBody)
                .when()
                .post("/mobile/auth/login")
                .then()
                .log().all()
                .extract().response();
        String access_token = r.jsonPath().getString("access_token");
        System.out.println(access_token);
     //   return access_token ;


    }


}
