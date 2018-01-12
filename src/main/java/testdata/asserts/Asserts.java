package testdata.asserts;

import org.testng.asserts.SoftAssert;

public abstract class Asserts {

    protected static SoftAssert softAssert;

    static{
        softAssert = new SoftAssert();
    }
}
