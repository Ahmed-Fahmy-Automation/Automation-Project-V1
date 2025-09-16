package FINES.APIs;

import io.qameta.allure.Step;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;

public class GetPayableFines {

    private static final Logger logger = LoggerFactory.getLogger(GetPayableFines.class);

    @Step
    public int getMobilePayableFines (String accessToken , String rtaUnifiedNo){

        String requestBody = "{\n" +
                "    \"sortBy\": \"CREATION_DATE\",\n" +
                "    \"sortDirection\": \"DESC\",\n" +
                "    \"rtaUnifiedNo\": \""+rtaUnifiedNo+"\",\n" +
                "    \"pageSize\": 8,\n" +
                "    \"pageNo\": 0,\n" +
                "    \"plateCategory\": null,\n" +
                "    \"plateNo\": null,\n" +
                "    \"plateCode\": null,\n" +
                "    \"searchKey\": \"\",\n" +
                "    \"sourceCode\": null,\n" +
                "    \"source\": null,\n" +
                "    \"sourceType\": null,\n" +
                "    \"licenseSource\": null,\n" +
                "    \"driverLicenseNumber\": null,\n" +
                "    \"fineNumber\": null,\n" +
                "    \"fineYear\": null,\n" +
                "    \"fineSource\": null,\n" +
                "    \"countryId\": null\n" +
                "}";

        Response r = RestAssured
                .given()
                .contentType(ContentType.JSON)
                .baseUri("https://comgw.qa.rta.ae/")
                .body(requestBody)
                .relaxedHTTPSValidation()
                .header("Authorization","Bearer " + accessToken)
                .when()
                .post("mobile/services/cvs/api/public/payable-fines")
                .then()
                .extract().response();
        int ticketID = r.jsonPath().getInt("content[0].trafficFineId");
        Assert.assertNotNull(ticketID);
        logger.info("Fines Retrived Successfully  : = "+ticketID+" " );
        return ticketID ;
    }



}
