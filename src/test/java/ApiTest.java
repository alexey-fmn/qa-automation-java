import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;
import static org.hamcrest.Matchers.empty;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;
import static org.junit.jupiter.api.Assertions.assertEquals;

import io.restassured.RestAssured;
import io.restassured.authentication.PreemptiveBasicAuthScheme;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class ApiTest {

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
                "  \"countryName\": \"03\"\n" +
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
        given()
            .contentType("application/json")
            .body("{\n" +
                "  \"id\": 2 ,\n" +
                "  \"lastName\": \"Grizzly\"\n" +
                "}")
            .when()
            .patch("/api/employees/2")
            .then()
            .statusCode(200)
            .body("lastName", equalTo("Grizzly"));

    }

    @Test
    public void shouldCreateUserWhenGivenUnique() {
        String requestBody = "{\n"
            + "  \"login\": \"madmax335\",\n"
            + "\"email\": \"asd2@qwe.com\"\n"
            + "}";

        given()
            .contentType("application/json")
            .body(requestBody)
            .when()
            .post("/api/admin/users")
            .then()
            .statusCode(201)
            .body("id", not(empty()));

    }


    // delete
    @Test
    public void shouldDeleteUserRecordWhenGiven() {
        Response response = given()
            .contentType("application/json")
            .when()
            .delete("/api/admin/users/madmax335")
            .then()
            .extract()
            .response();

        assertEquals(204, response.statusCode());
    }

    @Test
    public void shouldReturnErrorWhenGetDeletedUser() {
        Response response = when()
            .get("/api/admin/users/madmax335")
            .then()
            .extract().response();

        Assertions.assertEquals(404, response.statusCode());
    }
}
