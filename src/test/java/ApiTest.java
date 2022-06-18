import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;
import static org.hamcrest.Matchers.empty;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.not;
import static org.junit.jupiter.api.Assertions.assertEquals;

import io.restassured.RestAssured;
import io.restassured.authentication.PreemptiveBasicAuthScheme;
import io.restassured.response.Response;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ApiTest {

    private Connection connection;

    @BeforeEach
    public void connect() throws SQLException {
        connection = DriverManager.getConnection(
            "jdbc:postgresql://localhost:5432/app-db",
            "app-db-admin",
            "P@ssw0rd"
        );
    }

    @BeforeEach
    public void setUpAuth() {
        PreemptiveBasicAuthScheme authScheme = new PreemptiveBasicAuthScheme();
        authScheme.setUserName("admin");
        authScheme.setPassword("admin");
        RestAssured.authentication = authScheme;
    }

    @BeforeAll
    public static void setUpErrorLogging() {
        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
    }

    @AfterEach
    public void disconnect() throws SQLException {
        connection.close();
    }

    //create
    @Test
    public void shouldCreateCountryWhenUniqueGiven() {
        given()
            .contentType("application/json")
            .body("{\n" +
                "  \"countryName\": \"we\"\n" +
                "}")
            .when()
            .post("/api/countries")
            .then()
            .statusCode(201)
            .body("id", not(empty()));

//        PreparedStatement sqlDelete = connection.prepareStatement(
//            "DELETE FROM countryName WHERE id = we"
//        );
//        sqlDelete.executeUpdate();
    }

    @Test
    public void shouldReturnErrorWhenCreateNotUniqueCountry() throws SQLException {

        PreparedStatement sql = connection.prepareStatement(
            "INSERT INTO country(id, country_name) VALUES(?,?)"
        );
        sql.setInt(1, 333);
        sql.setString(2, "lk");
        sql.executeUpdate();

        given()
            .contentType("application/json")
            .body("{\n" +
                "  \"countryName\": \"lk\"\n" +
                "}")
            .when()
            .post("/api/countries")
            .then()
            .statusCode(500)
            .body("message", not(empty()));

        PreparedStatement sqlDelete = connection.prepareStatement(
            "DELETE FROM country WHERE id = 333"
        );
        sqlDelete.executeUpdate();
    }

    @Test
    public void shouldReturnErrorWhenCreateWithOneSymbolName() {
        given()
            .contentType("application/json")
            .body("{\n" +
                "  \"countryName\": \"w\"\n" +
                "}")
            .when()
            .post("/api/countries")
            .then()
            .statusCode(400)
            .body("message", not(empty()));
    }

    @Test
    public void shouldReturnErrorWhenCreateWithThreeSymbolName() {
        given()
            .contentType("application/json")
            .body("{\n" +
                "  \"countryName\": \"wew\"\n" +
                "}")
            .when()
            .post("/api/countries")
            .then()
            .statusCode(400)
            .body("message", not(empty()));
    }


    //read
    @Test
    public void shouldGetCountriesWhenPopulatedDb() throws SQLException {

        PreparedStatement sql = connection.prepareStatement(
            "INSERT INTO country(id, country_name) VALUES(?,?)"
        );
        sql.setInt(1, 104);
        sql.setString(2, "er");
        sql.executeUpdate();

        when()
            .get("/api/countries/104")
            .then()
            .statusCode(200);

        PreparedStatement sqlDelete = connection.prepareStatement(
            "DELETE FROM country WHERE id = 104"
        );
        sqlDelete.executeUpdate();
    }

    //update
    @Test
    public void shouldChangeCountryDataWhenUpdate() throws SQLException {
        PreparedStatement sql = connection.prepareStatement(
            "INSERT INTO country(id, country_name) VALUES(?,?)"
        );
        sql.setInt(1, 555);
        sql.setString(2, "le");
        sql.executeUpdate();

        given()
            .contentType("application/json")
            .body("{\n"
                + "\"id\": 555,\n"
                + "  \"countryName\": \"mt\"\n"
                + "}")
            .when()
            .patch("/api/countries/555")
            .then()
            .statusCode(200)
            .body("countryName", equalTo("mt"));

        PreparedStatement sqlDelete = connection.prepareStatement(
            "DELETE FROM country WHERE id = 555"
        );
        sqlDelete.executeUpdate();

    }

    //delete
    @Test
    public void shouldDeleteCountryDataWhenGiven() throws SQLException {
        PreparedStatement sql = connection.prepareStatement(
            "INSERT INTO country(id, country_name) VALUES(?,?)"
        );
        sql.setInt(1, 444);
        sql.setString(2, "kd");
        sql.executeUpdate();

        Response response = given()
            .contentType("application/json")
            .when()
            .delete("api/countries/444")
            .then()
            .extract()
            .response();

        assertEquals(204, response.statusCode());


    }
}
