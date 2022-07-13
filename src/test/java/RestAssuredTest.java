import io.restassured.http.ContentType;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class RestAssuredTest {

    @Test
    public void getTheApiCat() {
        given()
                .header("x-api-key", "DEMO-API-KEY")
                .when()
                .get("https://api.thecatapi.com/v1/votes?sub_id")
                .then()
                .log().all()
                .statusCode(200).extract().path("id").toString();
    }

    @Test
    public void postTheApiCat() {

        given()
                .header("x-api-key", "DEMO-API-KEY")
                .contentType(ContentType.JSON)
                .body("{\n" +
                        "\t\"image_id\":\"teste\",\n" +
                        "\t\"sub_id\": \"my-user-1234\",\n" +
                        "\t\"value\":1\n" +
                        "}")
                .when()
                .post("https://api.thecatapi.com/v1/votes")
                .then()
                .statusCode(200);
    }

    @Test
    public void DeleteTheApiCat() {
        given()
                .header("x-api-key", "DEMO-API-KEY")
                .when()
                .delete("https://api.thecatapi.com/v1/votes/31100")
                .then()
                .statusCode(200);
    }

    @Test
    public void putApiUsers() {

        given()
                .contentType(ContentType.JSON)
                .body("{\n" +
                        "\t\"name\":\"Leonardo\",\n" +
                        "\t\"job\": \"QA\"\n" +
                        "}")
                .when()
                .put("https://reqres.in/api/users/2")
                .then()
                .statusCode(200);
    }

}
