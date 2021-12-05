package api_test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;


public class GetTestWithPathVariable {
    private static final Logger LOGGER = LogManager.getLogger(SimpleGetTest.class);

    @Test
    public void getSingleUser() {
        LOGGER.info("----------API Test: Get Single User with the Path Variable----------");

        // Specify the base URL or endpoint of the REST API
        RestAssured.baseURI = "https://reqres.in/api/users";

        // Get the requestSpecification of the request that you want to send to the server.
        // The server is specified by thr BaseURI that we have specified in the above step.
        RequestSpecification httpRequest = RestAssured.given();

        // Make a request to the server by specifying the method Type and the method URL.
        // This will return the Response from the server. Store the response in a variable.
        String id = "2";
        Response response =  httpRequest.request(Method.GET, id);
        LOGGER.debug(response.prettyPrint());

        Assert.assertEquals(response.getStatusCode(), 200);

        JsonPath jsonPath = response.jsonPath();
        String actualEmailed = jsonPath.getString("data.email");

        String expectedEmailId = "janet.weaver@reqres.in";
        Assert.assertEquals(actualEmailed, expectedEmailId);

        LOGGER.info("------------API Test: Get Single User with the Path Variable------------");
    }

    @Test
    public void attemptToGetUserWithInvalidId() {
        LOGGER.info("----------API Test: Attempt to retrieve user with Invalid Id----------");

        // Specify the base URL or endpoint of the REST API
        RestAssured.baseURI = "https://reqres.in/api/users";

        // Get the requestSpecification of the request that you want to send to the server.
        // The server is specified by thr BaseURI that we have specified in the above step.
        RequestSpecification httpRequest = RestAssured.given();

        // Make a request to the server by specifying the method Type and the method URL.
        // This will return the Response from the server. Store the response in a variable.
        String id = "23";
        Response response =  httpRequest.request(Method.GET, id);
        LOGGER.debug(response.prettyPrint());

        Assert.assertEquals(response.getStatusCode(), 404);

        JsonPath jsonPath = response.jsonPath();

        Assert.assertEquals(jsonPath.get().toString(), "{}");

        LOGGER.info("------------API Test: Attempt to retrieve user with Invalid Id------------");
    }
}
