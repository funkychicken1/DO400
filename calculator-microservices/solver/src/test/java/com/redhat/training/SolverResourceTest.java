package com.redhat.training;

import org.junit.jupiter.api.Test;

import io.quarkus.test.common.http.TestHTTPEndpoint;
import io.quarkus.test.junit.QuarkusTest;
import static io.restassured.RestAssured.given;
import javax.ws.rs.core.Response;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
@TestHTTPEndpoint(SolverResource.class)
public class SolverResourceTest {

    @Test
    public void simpleAdditionOfTwoNumbersTest() {
        given()
                .when().get("3+2")
                .then()
                .statusCode(Response.Status.OK.getStatusCode())
                .body(is("5.0"));
    }

    @Test
    public void simpleMultiplication() {
        given()
                .when().get("3*2")
                .then()
                .statusCode(Response.Status.OK.getStatusCode())
                .body(is("6.0"));
    }

    @Test
    public void wrongValue() {
        given()
                .when().get("3*a")
                .then()
                .statusCode(Response.Status.BAD_REQUEST.getStatusCode());
    }
}
