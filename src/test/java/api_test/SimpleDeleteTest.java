package api_test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SimpleDeleteTest extends BaseClassAPITests {

    @Test
    public void deleteSingleUser() {
        LOGGER.info(testCaseName);

        RestAssured.baseURI = "https://reqres.in/api/users";
        RequestSpecification httpRequest = RestAssured.given();

        String id = "2";
        Response response = httpRequest.request(Method.DELETE, id);
        LOGGER.debug(response.getBody().asString());

        Assert.assertEquals(response.getStatusCode(), 204);

        LOGGER.info(endTestCase);
    }
}
