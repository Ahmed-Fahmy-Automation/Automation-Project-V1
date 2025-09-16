package FINES.APIs;

import io.qameta.allure.Step;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GetToken {

    private static final Logger logger = LoggerFactory.getLogger(GetToken.class);

    @Test
    public String getAccessToken(){
        String requestBody = "{\n" +
                "    \"nationalId\": \"784199418389120\",\n" +
                "    \"channelCode\": \"PORTAL\",\n" +
                "    \"apiKey\": \"NY*p.p>93^P6<!s[Q7`(X5)Jc8kWD*:fJ[B)db#UXe)??Ttjx]\"\n" +
                "}" ;
        Response r = RestAssured
                .given()
                .baseUri("https://comgw.qa.rta.ae")
                .header("User-Agent","PostmanRuntime/7.28.4")
                .header("INTERNAL_CALL","true")
                .header("Connection","keep-alive")
                .contentType(ContentType.JSON)
                .relaxedHTTPSValidation()
                .body(requestBody)
                .when()
                .post("/auth/anonymous/login")
                .then()
                .log().all()
                .extract().response();

        String access_token = r.jsonPath().getString("access_token");

        //System.out.println(access_token);
        return access_token ;


    }

    @Step
    public String getMobileAccessToken(){


        String requestBody = "{\n" +
                "    \"nationalId\": \"GUEST_USER\",\n" +
                "    \"channelCode\": \"MOBILE\",\n" +
                "    \"clientId\": \"RTA_MOBILE_APP\",\n" +
                "    \"apiKey\": \"NY*p.p>93^P6<!s[Q7`(X5)Jc8kWD*:fJ[B)db#UXe)??Ttjx]\"\n" +
                "}" ;
        Response r = RestAssured
                .given()
                .baseUri("https://comgw.qa.rta.ae")
                .header("User-Agent","PostmanRuntime/7.28.4")
                .header("INTERNAL_CALL","true")
                .header("Connection","keep-alive")
                .contentType(ContentType.JSON)
                .relaxedHTTPSValidation()
                .body(requestBody)
                .when()
                .post("mobile/auth/login")
                .then()
                .extract().response();

        String access_token = r.jsonPath().getString("access_token");
        Assert.assertEquals(r.statusCode(), 200);
        logger.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>Token Generated Successfully <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
        return access_token ;


    }
}
