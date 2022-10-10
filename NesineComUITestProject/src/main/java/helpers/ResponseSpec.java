package helpers;

import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.ResponseSpecification;
import org.apache.http.HttpStatus;

public class ResponseSpec {

    private ResponseSpec(){

    }

    public static ResponseSpecification checkStatusCodeOk() {

        return new ResponseSpecBuilder()
                .expectStatusCode(HttpStatus.SC_OK)
                .build();
    }

    public static ResponseSpecification checkStatusCodeBadRequestAndContentTypeJson() {

        return checkStatusCodeBadRequest()
                .and()
                .expect()
                .contentType(ContentType.JSON);
    }

    public static ResponseSpecification checkStatusCodeBadRequest() {

        return new ResponseSpecBuilder()
                .expectStatusCode(HttpStatus.SC_BAD_REQUEST)
                .build();
    }

    public static ResponseSpecification checkStatusCodeConflictAndContentTypeJson() {

        return new ResponseSpecBuilder()
                .expectStatusCode(HttpStatus.SC_CONFLICT)
                .expectContentType(ContentType.JSON)
                .build();
    }

    public static ResponseSpecification checkStatusCodeConflict() {

        return new ResponseSpecBuilder()
                .expectStatusCode(HttpStatus.SC_CONFLICT)
                .build();
    }

    public static ResponseSpecification checkStatusCodeOkAndContentTypeJson() {

        return new ResponseSpecBuilder()
                .expectStatusCode(HttpStatus.SC_OK)
                .expectContentType(ContentType.JSON)
                .build();
    }

    public static ResponseSpecification checkStatusCodeInternalErrorAndContentTypeJson() {
        return new ResponseSpecBuilder()
                .expectStatusCode(HttpStatus.SC_INTERNAL_SERVER_ERROR)
                .expectContentType(ContentType.JSON)
                .build();
    }

    public static ResponseSpecification checkStatusCodeInternalError() {
        return new ResponseSpecBuilder()
                .expectStatusCode(HttpStatus.SC_INTERNAL_SERVER_ERROR)
                .build();
    }

    public static ResponseSpecification checkStatusCodeNotFoundAndContentTypeJson() {
        return checkStatusCodeNotFound()
                .and()
                .expect()
                .contentType(ContentType.JSON);
    }

    public static ResponseSpecification checkStatusCodeNotFound() {
        return new ResponseSpecBuilder()
                .expectStatusCode(HttpStatus.SC_NOT_FOUND)
                .build();
    }

    public static ResponseSpecification checkStatusCodeCreated() {

        return new ResponseSpecBuilder()
                .expectStatusCode(HttpStatus.SC_CREATED)
                .build();
    }

    public static ResponseSpecification checkStatusCodeCreatedAndContentTypeJson() {
        return new ResponseSpecBuilder()
                .expectStatusCode(HttpStatus.SC_CREATED)
                .expectContentType(ContentType.JSON)
                .build();
    }

    public static ResponseSpecification checkStatusCodeServerErrorAndContentTypeJson() {
        return new ResponseSpecBuilder()
                .expectStatusCode(HttpStatus.SC_INTERNAL_SERVER_ERROR)
                .expectContentType(ContentType.JSON)
                .build();
    }

    public static ResponseSpecification checkStatusCodeNoContent() {
        return new ResponseSpecBuilder()
                .expectStatusCode(HttpStatus.SC_NO_CONTENT)
                .build();
    }
}