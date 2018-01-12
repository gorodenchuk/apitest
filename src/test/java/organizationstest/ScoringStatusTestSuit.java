package organizationstest;

import jsonfactory.models.request.scoreOrganization.ScoreOrganization;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import testbase.TestBase;
import testdata.asserts.ScoringStatusAsserts;
import testdata.headers.ScoreOrganizationsHeader;
import testdata.headers.ScoringStatusHeader;
import testdata.models.ScoreOrgDataModel;

import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.jayway.restassured.RestAssured.given;

public class ScoringStatusTestSuit extends TestBase {

    private static Logger Log = Logger.getLogger(ScoringStatusTestSuit.class.getName());
    public String jsonString;

    ScoreOrgDataModel scoreOrgDataModel = new ScoreOrgDataModel();
    ScoreOrganizationsHeader scoreOrganizationsHeader = new ScoreOrganizationsHeader();
    ScoringStatusHeader scoringStatusHeader = new ScoringStatusHeader();
    Map<String, String> params = new HashMap<>();

    @Test(description = "GET /scoring/asdasd.ScoringStatus request with 1 valid organization " +
            "and all types of org included. Response should be 200 and token in string")
    public void checkScoringWithPostRequestWithValidAllData() throws Exception {
        jsonString = scoreOrgDataModel.modelWithOneOrgUri(0.9, 0.9, 0.9, 0.9);
        Log.info(jsonString);
        response = httpClient.callHttpPost("/scoring", "/scoreOrganizations", jsonString, scoreOrganizationsHeader.setHeaders());
        token = response.getBody().print();

        params.put("scoreToken", token);
        response2 = httpClient.callHttpGet("/scoring", "/scoringStatus", params, scoringStatusHeader.setHeaders());
        statusCode = response2.statusCode();
        responseType = response2.getBody().print().getClass().getTypeName();

        ScoringStatusAsserts.assertResponse(statusCode, token);
//        ScoringStatusAsserts.assertResponse(statusCode, responseType);
    }


//    @Test(description = "GET /scoring/asdasd.ScoringStatus request with 1 valid organization " +
//            "and for BusinessPartnership weights. Response should be 200 and token = string")
//    public void checkScoringWithPostRequestWithValiOrgAndBussinessPs() throws Exception {
//        jsonString = scoreOrgDataModel.modelWithOneOrgUri(0.9, 0.0, 0.0, 0.0);
//        Log.info(jsonString);
//        response = httpClient.callHttpPost("/scoring", "/scoreOrganizations", jsonString);
//        Log.info("Token: " + response.getBody().print());
//
//        Assert.assertEquals(response.statusCode(), 200,
//                "Actual statusCode doesn`t match with expected");
//        Assert.assertTrue(response.getBody().print().getClass().getTypeName().equals("java.lang.String"),
//                "seems that we doesn`t recieved token");
//    }
//
//
//    @Test(description = "GET /scoring/asdasd.ScoringStatus request with 1 valid organization " +
//            "and for Competitor weights. Response should be 200 and token = string")
//    public void checkScoringWithPostRequestWithValiOrgAndCompetitor() throws Exception {
//        jsonString = scoreOrgDataModel.modelWithOneOrgUri(0.0, 0.9, 0.0, 0.0);
//        Log.info(jsonString);
//        response = httpClient.callHttpPost("/scoring", "/scoreOrganizations", jsonString);
//        Log.info("Token: " + response.getBody().print());
//
//        Assert.assertEquals(response.statusCode(), 200,
//                "Actual statusCode doesn`t match with expected");
//        Assert.assertTrue(response.getBody().print().getClass().getTypeName().equals("java.lang.String"),
//                "seems that we doesn`t recieved token");
//    }
//
//
//    @Test(description = "GET /scoring/asdasd.ScoringStatus request with 1 valid organization " +
//            "and for OwnerShip weights. Response should be 200 and token = string")
//    public void checkScoringWithPostRequestWithValiOrgAndOwnerShip() throws Exception {
//        jsonString = scoreOrgDataModel.modelWithOneOrgUri(0.0, 0.0, 0.9, 0.0);
//        Log.info(jsonString);
//        response = httpClient.callHttpPost("/scoring", "/scoreOrganizations", jsonString);
//        Log.info("Token: " + response.getBody().print());
//
//        Assert.assertEquals(response.statusCode(), 200,
//                "Actual statusCode doesn`t match with expected");
//        Assert.assertTrue(response.getBody().print().getClass().getTypeName().equals("java.lang.String"),
//                "seems that we doesn`t recieved token");
//    }
//
//
//    @Test(description = "GET /scoring/asdasd.ScoringStatus request with 1 valid organization " +
//            "and for Supplier weights. Response should be 200 and token = string")
//    public void checkScoringWithPostRequestWithValiOrgAndSupplier() throws Exception {
//        jsonString = scoreOrgDataModel.modelWithOneOrgUri(0.0, 0.0, 0.0, 0.9);
//        Log.info(jsonString);
//        response = httpClient.callHttpPost("/scoring", "/scoreOrganizations", jsonString);
//        Log.info("Token: " + response.getBody().print());
//
//        Assert.assertEquals(response.statusCode(), 200,
//                "Actual statusCode doesn`t match with expected");
//        Assert.assertTrue(response.getBody().print().getClass().getTypeName().equals("java.lang.String"),
//                "seems that we doesn`t recieved token");
//    }
//
//
//    @Test(description = "GET /scoring/asdasd.ScoringStatus request with 1 valid organization " +
//            "and but without weights. Response should be200 and token = string")
//    public void checkScoringWithPostRequestWithValiOrgAndNoWeights() throws Exception {
//        jsonString = scoreOrgDataModel.modelWithOneOrgUri(0.0, 0.0, 0.0, 0.0);
//        Log.info(jsonString);
//        response = httpClient.callHttpPost("/scoring", "/scoreOrganizations", jsonString);
//        Log.info("Token: " + response.getBody().print());
//
//        Assert.assertEquals(response.statusCode(), 200,
//                "Actual statusCode doesn`t match with expected");
//        Assert.assertTrue(response.getBody().print().getClass().getTypeName().equals("java.lang.String"),
//                "seems that we doesn`t recieved token");
//    }
//
//
//    @Test(description = "GET /scoring/asdasd.ScoringStatus request with 10 valid organization URIs " +
//            "and all types of org included. Response should be 200 and token = string")
//    public void checkScoringWithPostRequestForListOfOrgsUrisWithValidAllData() throws Exception {
//        organizationUris.add("http://feed.thomsonreuters.com/1-4295903076");
//        organizationUris.add("http://feed.thomsonreuters.com/1-4295904307");
//        organizationUris.add("http://feed.thomsonreuters.com/1-4295903678");
//        organizationUris.add("http://feed.thomsonreuters.com/1-4295903744");
//        organizationUris.add("http://feed.thomsonreuters.com/1-4295905952");
//        organizationUris.add("http://feed.thomsonreuters.com/1-4295903091");
//        organizationUris.add("http://feed.thomsonreuters.com/1-5050895314");
//        organizationUris.add("http://feed.thomsonreuters.com/1-4295912121");
//        organizationUris.add("http://feed.thomsonreuters.com/1-4295903128");
//        organizationUris.add("http://feed.thomsonreuters.com/1-4295911963");
//
//        jsonString = scoreOrgDataModel.modelWithListOfOrgs(organizationUris, 0.9, 0.9, 0.9, 0.9);
//        Log.info(jsonString);
//        response = httpClient.callHttpPost("/scoring", "/scoreOrganizations", jsonString);
//        Log.info("Token: " + response.getBody().print());
//
//        Assert.assertEquals(response.statusCode(), 200,
//                "Actual statusCode doesn`t match with expected");
//        Assert.assertTrue(response.getBody().print().getClass().getTypeName().equals("java.lang.String"),
//                "seems that we doesn`t recieved token");
//    }
//
//    @Test(description = "GET /scoring/asdasd.ScoringStatus request with 10 valid organization IDs " +
//            "and all types of org included. Response should be 200 and token = string")
//    public void checkScoringWithPostRequestForListOfOrgsIdsWithValidAllData() throws Exception {
//        organizationUris.add("4295903076");
//        organizationUris.add("4295904307");
//        organizationUris.add("4295903678");
//        organizationUris.add("4295903744");
//        organizationUris.add("4295905952");
//        organizationUris.add("4295903091");
//        organizationUris.add("5050895314");
//        organizationUris.add("4295912121");
//        organizationUris.add("4295903128");
//        organizationUris.add("4295911963");
//
//        jsonString = scoreOrgDataModel.modelWithListOfOrgs(organizationUris, 0.9, 0.9, 0.9, 0.9);
//        Log.info(jsonString);
//        response = httpClient.callHttpPost("/scoring", "/scoreOrganizations", jsonString);
//        Log.info("Token: " + response.getBody().print());
//
//        Assert.assertEquals(response.statusCode(), 200,
//                "Actual statusCode doesn`t match with expected");
//        Assert.assertTrue(response.getBody().print().getClass().getTypeName().equals("java.lang.String"),
//                "seems that we doesn`t recieved token");
//    }

}
