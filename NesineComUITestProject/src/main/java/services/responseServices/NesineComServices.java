package services.responseServices;

import helpers.GeneralServiceHelper;
import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.response.Response;
import io.restassured.specification.ResponseSpecification;

import static io.restassured.RestAssured.given;

public class NesineComServices extends GeneralServiceHelper {
    public NesineComServices(String baseUrl) {
        super(baseUrl);
    }
    public Response getPopularBets(String body, ResponseSpecification spec){
        return given()
                .filter(new AllureRestAssured())
                .spec(getReqSpec())
                .body(body)
                .when()
                .get()
                .then()
                .spec(spec)
                .extract()
                .response();
    }
}
