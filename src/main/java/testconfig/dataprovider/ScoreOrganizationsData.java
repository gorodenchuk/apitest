package testconfig.dataprovider;

import org.testng.annotations.DataProvider;

public class ScoreOrganizationsData {

    @DataProvider(name = "OrganizationWithAllValidData")
    public static Object[][] OrganizationWithAllValidData() {
        return new Object[][]{
//                {new String[]{"5034757565"}, "0.9", "0.9", "0.9", "0.9"},
//                {new String[]{"5000000001"}, "0.9", "0.9", "0.9", "0.9"},
//                {new String[] {"5000000001"}, "0.0", "0.9", "0.0", "0.0"},
//                {new String[] {"5000000001"}, "0.0", "0.0", "0.9", "0.0"},
//                {new String[] {"5000000001"}, "0.0", "0.0", "0.0", "0.9"},
//                {new String[] {"5000000001"}, "0.0", "0.0", "0.0", "0.0"},
//                {new String[]{"5000000001", "4297034757"}, "0.9", "0.9", "0.9", "0.9"},
//                {new String[]{"4297034757", "4297034757"}, "0.9", "0.9", "0.9", "0.9"},
//                {new String[]{"http://feed.thomsonreuters.com/1-4297034757"}, "0.9", "0.0", "0.0", "0.0"},
//                {new String[]{"http://feed.thomsonreuters.com/1-4297034757"}, "0.0", "0.9", "0.0", "0.0"},
//                {new String[]{"http://feed.thomsonreuters.com/1-4297034757"}, "0.0", "0.0", "0.9", "0.0"},
//                {new String[]{"http://feed.thomsonreuters.com/1-4297034757"}, "0.0", "0.0", "0.0", "0.9"},
//                {new String[]{"http://feed.thomsonreuters.com/1-4297034757"}, "0.0", "0.0", "0.0", "0.0"},
                {new String[]{"http://feed.thomsonreuters.com/1-4295903076",
                        "http://feed.thomsonreuters.com/1-4295904307",
                        "http://feed.thomsonreuters.com/1-4295903678",
                        "http://feed.thomsonreuters.com/1-4295903744",
                        "http://feed.thomsonreuters.com/1-4295905952",
                        "http://feed.thomsonreuters.com/1-4295903091",
                        "http://feed.thomsonreuters.com/1-5050895314",
                        "http://feed.thomsonreuters.com/1-4295912121",
                        "http://feed.thomsonreuters.com/1-4295903128",
                        "http://feed.thomsonreuters.com/1-4295911963"}, "0.9", "0.9", "0.9", "0.9"},
//                {new String[]{"4295903076",
//                        "4295904307",
//                        "4295903678",
//                        "4295903744",
//                        "4295905952",
//                        "4295903091",
//                        "5050895314",
//                        "4295912121",
//                        "4295903128",
//                        "4295911963"}, "0.9", "0.9", "0.9", "0.9"}
        };
    }

    @DataProvider(name = "OrganizationWithAllInvalidWeights")
    public static Object[][] OrganizationWithAllInvalidWeights() {
        return new Object[][]{
                {new String[]{"qwertyuiop"}, "0.9", "0.9", "0.9", "0.9"},
                {new String[]{"null"}, "0.9", "0.9", "0.9", "0.9"},
                {new String[]{""}, "0.9", "0.9", "0.9", "0.9"},
                {new String[]{" "}, "0.9", "0.9", "0.9", "0.9"},
                {new String[]{"1&#33;%40#$%^%26*()q"}, "0.9", "0.9", "0.9", "0.9"}
        };
    }

    @DataProvider(name = "OrganizationWithInvalidOrgValue")
    public static Object[][] OrganizationWithInvalidOrgValue() {
        return new Object[][]{
                {new String[]{"4297034757"}, "null", "null", "null", "null"},
                {new String[]{"4297034757"}, "", "", "", ""}
        };
    }

    @DataProvider(name = "OrganizationWithOneValidWeight")
    public static Object[][] OrganizationWithOneValidWeight() {
        return new Object[][]{
                {new String[]{"4295904307"}, "bussinessPs", "1.0"},
                {new String[]{"4295904307"}, "bussinessPs", "0"},
                {new String[]{"4295904307"}, "bussinessPs", "1"},
                {new String[]{"4295904307"}, "competitor", "1.0"},
                {new String[]{"4295904307"}, "competitor", "0"},
                {new String[]{"4295904307"}, "competitor", "1"},
                {new String[]{"4295904307"}, "ownerS", "1.0"},
                {new String[]{"4295904307"}, "ownerS", "0"},
                {new String[]{"4295904307"}, "ownerS", "1"},
                {new String[]{"4295904307"}, "supplier", "1.0"},
                {new String[]{"4295904307"}, "supplier", "0"},
                {new String[]{"4295904307"}, "supplier", "1"},
                {new String[]{"4295904307"}, "bussinessPs", "0.9"},
                {new String[]{"4295904307"}, "competitor", "0.9"},
                {new String[]{"4295904307"}, "ownerS", "0.9"},
                {new String[]{"4295904307"}, "supplier", "0.9"}
        };
    }

    @DataProvider(name = "OrganizationWithOneWeight")
    public static Object[][] OrganizationWithOneWeight() {
        return new Object[][]{
                {new String[] {"4297034757"}, "bussinessPs", "0.9"},
                {new String[] {"4297034757"}, "competitor", "0.9"},
                {new String[] {"4297034757"}, "ownerS", "0.9"},
                {new String[] {"4297034757"}, "supplier", "0.9"}
        };
    }

    @DataProvider(name = "OrganizationWithOneInvalidWeight")
    public static Object[][] OrganizationWithOneInvalidWeight() {
        return new Object[][]{
                {new String[]{"4295904307"}, "bussinessPs", "!@"},
                {new String[]{"4295904307"}, "bussinessPs", "1.1"},
                {new String[]{"4295904307"}, "bussinessPs", "-0.9"},
                {new String[]{"4295904307"}, "bussinessPs", "sd"},

                {new String[]{"4295904307"}, "competitor", "!@"},
                {new String[]{"4295904307"}, "competitor", "1.1"},
                {new String[]{"4295904307"}, "competitor", "-0.9"},
                {new String[]{"4295904307"}, "competitor", "sd"},

                {new String[]{"4295904307"}, "ownerS", "!@"},
                {new String[]{"4295904307"}, "ownerS", "1.1"},
                {new String[]{"4295904307"}, "ownerS", "-0.9"},
                {new String[]{"4295904307"}, "ownerS", "sd"},

                {new String[]{"4295904307"}, "supplier", "!@"},
                {new String[]{"4295904307"}, "supplier", "1.1"},
                {new String[]{"4295904307"}, "supplier", "-0.9"},
                {new String[]{"4295904307"}, "supplier", "sd"}
        };
    }

}
