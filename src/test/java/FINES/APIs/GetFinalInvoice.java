package FINES.APIs;

import io.qameta.allure.Step;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;


public class GetFinalInvoice {

    private static final Logger logger = LoggerFactory.getLogger(GetFinalInvoice.class);

    @Step
    public  void getFinalInv(String applicationRefNo , String access_token ){

        String requestBody =     "{\n" +
                "  \"applicationReferenceNo\": \""+applicationRefNo+"\",\n" +  // ✅ fixed quote
                "  \"callBackURL\": \"https://ums.qa.rta.ae/violations/public-fines/violations-confirmation\",\n" +
                "  \"systemType\": \"CVS\",\n" +
                "  \"failedCallbackUrl\": \"https://ums.qa.rta.ae/violations/error\",\n" +
                "  \"language\": \"en\",\n" +
                "  \"freePayment\": true\n" +
                "}";


        Response r = RestAssured
                .given()
                .contentType(ContentType.JSON)
                .header("Authorization","Bearer"+ access_token)
                .relaxedHTTPSValidation()
                .baseUri("https://comgw.qa.rta.ae/mobile/services/paycustomerviolationjourney")
           //     .log().all()
                .body(requestBody)
                .when()
                .post("/api/public/pay-customer-violation/invoice/get-final-invoice")
                .then()
                .statusCode(200)
              //  .log().all()
                .extract().response();

        String businessAction = r.jsonPath().getString("businessAction") ;
        Assert.assertEquals(businessAction , "READY_FOR_PAYMENT");
        logger.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>Invoice Created Successfully and the Business Action "+businessAction+" <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");



    }
}
