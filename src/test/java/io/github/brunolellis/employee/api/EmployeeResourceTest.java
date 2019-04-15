package io.github.brunolellis.employee.api;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

//@QuarkusTest
public class EmployeeResourceTest {

    //@Test
    public void testInvalidEndpoint() {
        given()
          .when().get("/invalid-endpoint")
          .then()
             .statusCode(404);
    }

}