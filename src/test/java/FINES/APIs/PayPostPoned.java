package FINES.APIs;

import io.qameta.allure.Step;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PayPostPoned {
    private static final Logger logger = LoggerFactory.getLogger(PayPostPoned.class);
    @Step
    public void payPostPone(String access_token ,String applicationRefNo){
        JSONObject obj = new JSONObject();
        obj.put("applicationReferenceNo", applicationRefNo );
        obj.put("systemType" , "CVS");
        obj.put("freePayment" ,  "false");
        obj.put("multipleReceipts" , "false");
        obj.put("sdgTransactionReferenceNo", "SVJ14604E0000000199400658");
        obj.put("sdgSPCode",  "RTA5");
        obj.put("sdgServiceCode", "SPV");
        obj.put("spTrn", "12345615");
        obj.put("spTrnTimestamp", "2025-04-30T12:27:39.0598229");
        String requestBody = obj.toString();

        Response r = RestAssured
                .given()
                .contentType(ContentType.JSON)
                .baseUri("https://comgw.qa.rta.ae/mobile/services/invoice")
                .header("Authorization","Bearer"+access_token)
                .body(requestBody)
                .relaxedHTTPSValidation()
                .log().all()
                .when()
                .post("/api/dt-payment/v2/postpone/pay")
                .then()
                .log().all()
                .statusCode(200)
                .extract().response();

        logger.info("");


    }

}
