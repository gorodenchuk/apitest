package scoringcontrollertest;

import org.apache.log4j.Logger;
import org.testng.annotations.Test;
import testbase.TestBase;
import testconfig.asserts.ScoringStatusAsserts;
import testconfig.dataprovider.ScoreOrganizationsData;
import testconfig.dataprovider.ScoringStatusData;
import testconfig.headers.GetHeader;
import testconfig.headers.PostHeader;
import testconfig.models.ScoreOrgDataModel;

import java.util.*;

public class ScoringStatusTestSuit extends TestBase {

    private static Logger Log = Logger.getLogger(ScoringStatusTestSuit.class.getName());
    public String jsonString;

    ScoreOrgDataModel scoreOrgDataModel = new ScoreOrgDataModel();
    PostHeader postHeader = new PostHeader();
    GetHeader getHeader = new GetHeader();
    Map<String, String> params = new HashMap<>();
//    List<String> organizationUris = new ArrayList<>();
    ScoringStatusAsserts scoringStatusAsserts = new ScoringStatusAsserts();

    @Test(dataProvider = "OrganizationWithAllValidData", dataProviderClass = ScoreOrganizationsData.class,
            description = "GET /scoring/ScoringStatus request with 1 valid OrgID " +
            "and all types of org included. Should be recieved valid token, statuscode 200, launched = true" +
            " and progress value ")
    // TS.3.1-3.11
    public void checkScoreStatusWithValidAllWeights(String[] org, String bussinessPs, String competitor,
                                                     String ownerS, String supplier) throws Exception {
        jsonString = scoreOrgDataModel.modelWithListOfOrgs(Arrays.asList(org), bussinessPs, competitor, ownerS, supplier);
        Log.info(jsonString);
        response = httpClient.callHttpPost("/scoring", "/scoreOrganizations", jsonString, postHeader.setHeaders());
        token = response.getBody().print();
        params.put("scoreToken", token);
        response = httpClient.callHttpGet("/scoring", "/scoringStatus", params, getHeader.setHeaders());
        statusCode = response.statusCode();
        responseType = response.getBody().print().getClass().getTypeName();
        jsonDataSourceString = response.getBody().asString();

        scoringStatusAsserts.assertResponse(statusCode, token, jsonDataSourceString);
    }

    @Test(dataProvider = "OrganizationWithOneWeight", dataProviderClass = ScoreOrganizationsData.class
            , description = "GET /scoring/ScoringStatus request with 1 valid OrgID " +
            "and all types of org included. Should be recieved valid token, statuscode 200, launched = true" +
            " and progress value ")
    // TS.3.12-3.15
    public void checkScoreStatusWithValidOneWeight(String[] org, String weightName, String value) throws Exception {
        jsonString = scoreOrgDataModel.modelWithUriAndOneWeight(Arrays.asList(org), weightName, value);
        Log.info(jsonString);
        response = httpClient.callHttpPost("/scoring", "/scoreOrganizations", jsonString, postHeader.setHeaders());
        token = response.getBody().print();
        params.put("scoreToken", token);
        response = httpClient.callHttpGet("/scoring", "/scoringStatus", params, getHeader.setHeaders());
        statusCode = response.statusCode();
        responseType = response.getBody().print().getClass().getTypeName();
        jsonDataSourceString = response.getBody().asString();

        scoringStatusAsserts.assertResponse(statusCode, token, jsonDataSourceString);
    }

    @Test(dataProvider = "negativeTokenValue", dataProviderClass = ScoringStatusData.class
            , description = "GET /scoring/ScoringStatus request with 1 valid OrgID " +
            "and all types of org included. Should be recieved valid token, statuscode 200, launched = true" +
            " and progress value ")
    // TS.3.17-3.18
    public void checkScoreStatusWithoutToken(String token) throws Exception {
        params.put("scoreToken", token);
        response = httpClient.callHttpGet("/scoring", "/scoringStatus", params, getHeader.setHeaders());
        statusCode = response.statusCode();
        responseType = response.getBody().print().getClass().getTypeName();
        jsonDataSourceString = response.getBody().asString();

        scoringStatusAsserts.assertResponseForBadRequest(statusCode);
    }
}
