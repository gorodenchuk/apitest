package testconfig.dataprovider;

import org.testng.annotations.DataProvider;

public class ScoringStatusData {

    @DataProvider(name = "negativeTokenValue")
    public static Object[][] negativeTokenValue() {
        return new Object[][]{
                {""},
                {"null"}
        };
    }
}
