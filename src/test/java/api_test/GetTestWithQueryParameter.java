package api_test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class GetTestWithQueryParameter extends BaseClassAPITests {
//    private static final Logger LOGGER = LogManager.getLogger(SimpleGetTest.class);

    @Test
    public void getUsersWithQueryParameter() {
        LOGGER.info(testCaseName);

        // Specify the base URL or endpoint of the REST API
        RestAssured.baseURI = "https://reqres.in/api/users";

        // Get the requestSpecification of the request that you want to send to the server.
        // The server is specified by thr BaseURI that we have specified in the above step.
        RequestSpecification httpRequest = RestAssured.given();

        // Make a request to the server by specifying the method Type and the method URL.
        // This will return the Response from the server. Store the response in a variable.
        Response response =  httpRequest.queryParam("page", "2").request(Method.GET);
        LOGGER.debug(response.prettyPrint());

        Assert.assertEquals(response.getStatusCode(), 200);

        JsonPath jsonPath = response.jsonPath();
        List<String> listEmails = jsonPath.get("data.email");

        String expectedEmailId = "michael.lawson@reqres.in";
        boolean emailExist = listEmails.contains(expectedEmailId);

        Assert.assertTrue(emailExist, expectedEmailId + " does not exist");

        LOGGER.info(endTestCase);
    }
}
