import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;
import static org.hamcrest.Matchers.empty;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;

import io.restassured.RestAssured;
import io.restassured.authentication.PreemptiveBasicAuthScheme;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class LocationTest {

    @BeforeAll
    public static void setUpAuth() {
        PreemptiveBasicAuthScheme authScheme = new PreemptiveBasicAuthScheme();
        authScheme.setUserName("admin");
        authScheme.setPassword("admin");
        RestAssured.authentication = authScheme;
    }

    @BeforeAll
    public static void setUpErrorLogging() {
        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
    }

    // create
    @Test
    public void shouldCreateCountryWhenUnique() {
        given()
            .contentType("application/json")
            .body("{\n" +
                "  \"countryName\": \"00\"\n" +
                "}")
            .when()
            .post("/api/countries")
            .then()
            .statusCode(201)
            .body("id", not(empty()));
    }

    // read
    @Test
    public void shouldGetLocationsWhenPopulatedDb() {
        when()
            .get("/api/locations")
            .then()
            .statusCode(200)
            .body(
                "size()", is(10),
                "[0].city", is("West Hopefort")
            );
    }


    // update
    @Test
    public void shouldUpdateEmployeeWhenGiven() {
        Response response = given()
            .contentType("application/json")
            .body("{\n" +
                "  \"id\": 2 ,\n" +
                "  \"lastName\": \"Grizzly\"\n" +
                "}")
            .when()
            .patch("/api/employees/2")
            .then()
            //.statusCode(200)
            .body("lastName", equalTo("Grizzly"));

        Assertions.assertEquals(200, response.statusCode());

    }

    // delete
    @Test
    public void shouldDeleteUserRecordwhenGiven() {

    }
}
