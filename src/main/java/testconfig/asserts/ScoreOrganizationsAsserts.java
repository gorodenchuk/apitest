package testconfig.asserts;

import org.testng.Assert;

public class ScoreOrganizationsAsserts extends Asserts{



    public void assertResponse(int statusCode, String responseType) {
        Assert.assertEquals(statusCode, 200,
                "Actual statusCode doesn`t match with expected");
        Assert.assertTrue(responseType.getClass().getSimpleName().equals("String"),
                "seems that we doesn`t recieved token");
        softAssert.assertAll();
    }

    public void assertResponseForBadRequest(int statusCode) {
        Assert.assertEquals(statusCode, 400,
                "Actual statusCode doesn`t match with expected");
        softAssert.assertAll();
    }
}
