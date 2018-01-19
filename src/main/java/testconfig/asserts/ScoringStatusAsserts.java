package testconfig.asserts;

import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;
import org.testng.Assert;

public class ScoringStatusAsserts extends Asserts{

    public void assertResponse(int statusCode, String token, String jsonDataSourceString) {
        String jsonpathCreatorScoreTokenPath = "$.scoreToken";
        String jsonpathCreatorLaunchedPath = "$.launched";
        String jsonpathCreatorProgressPath = "$.progress";

        DocumentContext jsonContext = JsonPath.parse(jsonDataSourceString);

        String jsonpathCreatorScoreToken = jsonContext.read(jsonpathCreatorScoreTokenPath);
        Boolean jsonpathCreatorLaunched = jsonContext.read(jsonpathCreatorLaunchedPath);
        Double jsonpathCreatorProgressToken = jsonContext.read(jsonpathCreatorProgressPath);

        Assert.assertEquals(statusCode, 200,
                "Actual statusCode doesn`t match with expected");
        Assert.assertTrue(jsonpathCreatorScoreToken.equals(token),
                "seems that we doesn`t recieved token, or it is not correct");
        Assert.assertTrue(jsonpathCreatorLaunched == true,
                "launched equal False");
        Assert.assertTrue(jsonpathCreatorProgressToken.getClass().getSimpleName().equals("Double"),
                "seems that we doesn`t recieved progress status");
        softAssert.assertAll();
    }

    public void assertResponseForBadRequest(int statusCode) {
        Assert.assertEquals(statusCode, 400,
                "Actual statusCode doesn`t match with expected");
        softAssert.assertAll();
    }
}
