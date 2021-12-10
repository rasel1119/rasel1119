package api_test;

import com.github.javafaker.Faker;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SimplePatchTest extends BaseClassAPITests {
//    private static final Logger LOGGER = LogManager.getLogger(SimplePutTest.class);

    @Test
    public void updateUserSingleField() {
        LOGGER.info(testCaseName);

        RestAssured.baseURI = "https://reqres.in/api/users";

        RequestSpecification httpRequest = RestAssured.given();

        Faker faker = new Faker();
        String userRole = faker.name().fullName();
        LOGGER.debug("User Job: " + userRole);

        JSONObject reqBody = new JSONObject();
        reqBody.put("job", userRole);

        httpRequest.header("Content-Type", "application/json");
        httpRequest.body(reqBody.toString());

        String id = "2";
        Response response = httpRequest.request(Method.PATCH, id);
        LOGGER.debug(response.getBody().asString());

        Assert.assertEquals(response.getStatusCode(), 200);

        JsonPath jsonPath = response.jsonPath();

        String actualName = jsonPath.getString("job");
        Assert.assertEquals(actualName, userRole);

        LOGGER.info(endTestCase);
    }
}
