package helpers;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;

public class GeneralServiceHelper {
    private final RequestSpecification reqSpec;

    public GeneralServiceHelper(String baseUrl) {
        this.reqSpec = new RequestSpecBuilder()
                .setBaseUri(baseUrl)
                .setContentType("application/json; charset=utf-8")
                .addHeader("X-UserEmail", "Nesine-com-api-acceptance-tests")
                .build();
    }

    public RequestSpecification getReqSpec() {
        return reqSpec;
    }


}
