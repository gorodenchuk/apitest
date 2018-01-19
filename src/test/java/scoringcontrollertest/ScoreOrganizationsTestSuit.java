package scoringcontrollertest;

import org.apache.log4j.Logger;
import org.testng.annotations.Test;
import testbase.TestBase;
import testconfig.asserts.ScoreOrganizationsAsserts;
import testconfig.dataprovider.ScoreOrganizationsData;
import testconfig.headers.PostHeader;
import testconfig.models.ScoreOrgDataModel;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ScoreOrganizationsTestSuit extends TestBase {

    private static Logger Log = Logger.getLogger(ScoreOrganizationsTestSuit.class.getName());
    public String jsonString;

    ScoreOrgDataModel scoreOrgDataModel = new ScoreOrgDataModel();
    PostHeader postHeader = new PostHeader();
    ScoreOrganizationsAsserts scoreOrganizationsAsserts = new ScoreOrganizationsAsserts();

    @Test(dataProvider = "OrganizationWithAllValidData", dataProviderClass = ScoreOrganizationsData.class,
            description = "POST /scoring/scoreOrganizations request with 10 valid organization IDs " +
                    "and all types of org included. Response should be 200 and token = string")
    // TS.2.1-2.11
    public void checkScoreOrganizationsWithAllValidData(String[] org, String bussinessPs, String competitor,
                                                                String ownerS, String supplier) throws Exception {
        jsonString = scoreOrgDataModel.modelWithListOfOrgs(Arrays.asList(org), bussinessPs, competitor, ownerS, supplier);
        Log.info(jsonString);
        response = httpClient.callHttpPost("/scoring", "/scoreOrganizations", jsonString, postHeader.setHeaders());
        token = response.getBody().print();
        statusCode = response.getStatusCode();
        scoreOrganizationsAsserts.assertResponse(statusCode, token);
    }

    @Test(dataProvider = "OrganizationWithOneValidWeight", dataProviderClass = ScoreOrganizationsData.class,
            description = "POST /scoring/scoreOrganizations request with 10 valid organization IDs " +
                    "and all types of org included. Response should be 200 and token = string")
    // TS.2.12-2.27
    public void checkScoreStatusWithValidOneWeight(String[] org, String weightName, String value) throws Exception {
        jsonString = scoreOrgDataModel.modelWithUriAndOneWeight(Arrays.asList(org), weightName, value);
        Log.info(jsonString);
        response = httpClient.callHttpPost("/scoring", "/scoreOrganizations", jsonString, postHeader.setHeaders());
        token = response.getBody().print();
        statusCode = response.getStatusCode();
        scoreOrganizationsAsserts.assertResponse(statusCode, token);
    }

    @Test(dataProvider = "OrganizationWithInvalidOrgValue", dataProviderClass = ScoreOrganizationsData.class,
            description = "POST /scoring/scoreOrganizations request with 10 valid organization IDs " +
                    "and all types of org included. Response should be 200 and token = string")
    // TS.2.28
    public void checkNegativeOrgValueValidationInScoreOrganizations(String[] org, String bussinessPs, String competitor,
                                                                        String ownerS, String supplier) throws Exception {
        jsonString = scoreOrgDataModel.modelWithListOfOrgs(Arrays.asList(org), bussinessPs, competitor, ownerS, supplier);
        Log.info(jsonString);
        response = httpClient.callHttpPost("/scoring", "/scoreOrganizations", jsonString, postHeader.setHeaders());
        token = response.getBody().print();
        statusCode = response.getStatusCode();
        scoreOrganizationsAsserts.assertResponseForBadRequest(statusCode);
    }

    @Test(dataProvider = "OrganizationWithAllInvalidWeights", dataProviderClass = ScoreOrganizationsData.class,
            description = "POST /scoring/scoreOrganizations request with 10 valid organization IDs " +
                    "and all types of org included. Response should be 200 and token = string")
    // TS.2.29-2.30
    public void checkNegativeWeightsValueValidationInScoreOrganizations(String[] org, String bussinessPs, String competitor,
                                                                        String ownerS, String supplier) throws Exception {
        jsonString = scoreOrgDataModel.modelWithListOfOrgs(Arrays.asList(org), bussinessPs, competitor, ownerS, supplier);
        Log.info(jsonString);
        response = httpClient.callHttpPost("/scoring", "/scoreOrganizations", jsonString, postHeader.setHeaders());
        token = response.getBody().print();
        statusCode = response.getStatusCode();
        scoreOrganizationsAsserts.assertResponseForBadRequest(statusCode);
    }

    @Test(dataProvider = "OrganizationWithOneInvalidWeight", dataProviderClass = ScoreOrganizationsData.class,
            description = "POST /scoring/scoreOrganizations request with 10 valid organization IDs " +
                    "and all types of org included. Response should be 200 and token = string")
    // TS.2.31-2.46
    public void checkScoreStatusWithInvalidOneWeight(String[] org, String weightName, String value) throws Exception {
        jsonString = scoreOrgDataModel.modelWithUriAndOneWeight(Arrays.asList(org), weightName, value);
        Log.info(jsonString);
        response = httpClient.callHttpPost("/scoring", "/scoreOrganizations", jsonString, postHeader.setHeaders());
        token = response.getBody().print();
        statusCode = response.getStatusCode();
        scoreOrganizationsAsserts.assertResponseForBadRequest(statusCode);
    }

        @Test(description = "POST /scoring/scoreOrganizations request jason with supplier weight only." +
            "Response should be 400")
    // TS.2.47
    public void checkScoreOrganizationsWithSupplierWeightOnly() throws Exception {
        organizationUris.clear();

        jsonString = scoreOrgDataModel.modelWithOneWeightOnly("supplier", "0.9");
        Log.info(jsonString);
        response = httpClient.callHttpPost("/scoring", "/scoreOrganizations", jsonString, postHeader.setHeaders());
        statusCode = response.getStatusCode();

        scoreOrganizationsAsserts.assertResponseForBadRequest(statusCode);
    }

    @Test(description = "POST /scoring/scoreOrganizations request with 1 OrgID without news and second with news" +
            "and all types of org included. Response should be 200 and token in string")
    // TS.2.48
    public void checkScoreOrganizationsWithOneOrgWithoutNewsAndOneWithNews() throws Exception {
        organizationUris.clear();
        organizationUris.add("5000000001");
        organizationUris.add("4297034757");

        jsonString = scoreOrgDataModel.modelWithListOfOrgs(organizationUris,"0.9", "0.9", "0.9", "0.9");
        Log.info(jsonString);
        response = httpClient.callHttpPost("/scoring", "/scoreOrganizations", jsonString, postHeader.setHeaders());
        token = response.getBody().print();
        statusCode = response.getStatusCode();
        scoreOrganizationsAsserts.assertResponse(statusCode, token);
    }
}

