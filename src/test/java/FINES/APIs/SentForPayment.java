package FINES.APIs;

import com.fasterxml.jackson.databind.util.JSONPObject;
import io.qameta.allure.Step;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;

public class SentForPayment {

    private static final Logger logger = LoggerFactory.getLogger(SentForPayment.class);
    @Step
    public void sentPayment(String access_token , String applicationRefNo ){


        JSONObject obj = new JSONObject();

        obj.put("applicationReferenceNo", applicationRefNo);
        String requestBody = obj.toString();

        Response r = RestAssured
                .given()
                .contentType(ContentType.JSON)
                .baseUri("https://comgw.qa.rta.ae/mobile/services/paycustomerviolationjourney")
                .relaxedHTTPSValidation()
                .header("Authorization","Bearer"+access_token)
                .body(requestBody)
                .when()
                .post("/api/public/pay-customer-violation/invoice/sendForPayment")
                .then()
                .statusCode(200)
                .extract().response();

        Assert.assertEquals(r.statusCode() , 200);
        logger.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>Application sent for payment successfully  <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
    }

}
