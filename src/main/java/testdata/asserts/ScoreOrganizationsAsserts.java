package testdata.asserts;

import org.testng.Assert;

public class ScoreOrganizationsAsserts extends Asserts{



    public static void assertResponse(int statusCode, String responseType) {
        Assert.assertEquals(statusCode, 200,
                "Actual statusCode doesn`t match with expected");
        Assert.assertTrue(responseType.equals("java.lang.String"),
                "seems that we doesn`t recieved token");
        softAssert.assertAll();
    }
}
