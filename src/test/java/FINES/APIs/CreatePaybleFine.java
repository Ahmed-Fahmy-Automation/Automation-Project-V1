package FINES.APIs;

import io.qameta.allure.Step;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;

public class CreatePaybleFine {

    private static final Logger logger = LoggerFactory.getLogger(CreatePaybleFine.class);

    @Step
    public String createMobileFineJourney(String accessToken , int ticketID ){
        String requestBody = "{\n" +
                "    \"payFineDTO\": {\n" +
                "        \"emirateFinesIds\": ["+ticketID+"],\n" +
                "        \"otherFinesIds\": [],\n" +
                "        \"vehicleConfisicationIds\": [],\n" +
                "        \"trafficCodeNo\": null\n" +
                "    }\n" +
                "}";

        Response r = RestAssured
                .given()
                .header("Authorization","Bearer"+ accessToken)
                .contentType(ContentType.JSON)
                .relaxedHTTPSValidation()
                .baseUri("https://comgw.qa.rta.ae/mobile/services/paycustomerviolationjourney")
                .body(requestBody)
                .when()
                .post("/api/public/pay-customer-violation/create")
                .then()
                .statusCode(200)
                .extract().response();

        String applicationRefNo = r.jsonPath().getString("applicationRefNo") ;
        Assert.assertNotNull(applicationRefNo);
        logger.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>Application Created Successfully  "+applicationRefNo+" <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
        return applicationRefNo;

    }

}
