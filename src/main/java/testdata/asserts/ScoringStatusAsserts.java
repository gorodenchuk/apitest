package testdata.asserts;

import org.testng.Assert;

public class ScoringStatusAsserts extends Asserts{

    public static void assertResponse(int statusCode, String token) {
        String jsonpathScoreToken = "$.scoreToken";
        String jsonpathLaunched = "$.launched";
        String jsonpathProgress = "$.progress";

        Assert.assertEquals(statusCode, 200,
                "Actual statusCode doesn`t match with expected");
        Assert.assertEquals(jsonpathScoreToken.equals(token),
                "seems that we doesn`t recieved token, or it is not correct");
        Assert.assertEquals(jsonpathLaunched, true,
                "launched equal False");
        System.out.println(jsonpathProgress.getClass().getSimpleName() + "SDFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFF");
        Assert.assertEquals(jsonpathProgress.isEmpty(), true,
                "seems that we doesn`t recieved progress status");
        softAssert.assertAll();
    }
}
