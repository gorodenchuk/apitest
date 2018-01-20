package scoringcontrollertest;

import bo.ScoringStatusLogic;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import testbase.TestBase;
import testconfig.asserts.ScoringResultsAsserts;
import testconfig.dataprovider.ScoreOrganizationsData;
import testconfig.headers.PostHeader;
import testconfig.headers.GetHeader;
import testconfig.models.ScoreOrgDataModel;

import java.util.*;

public class ScoringResultsTestSuit extends TestBase {

    private static Logger Log = Logger.getLogger(ScoringResultsTestSuit.class.getName());
    public String jsonString;

    ScoreOrgDataModel scoreOrgDataModel = new ScoreOrgDataModel();
    PostHeader postHeader = new PostHeader();
    GetHeader getHeader = new GetHeader();
    ScoringResultsAsserts scoringResultsAsserts = new ScoringResultsAsserts();
    Map<String, Object> params = new HashMap<>();
    Double jsonpathCreatorProgressToken;

    @Test(dataProvider = "OrganizationWithAllValidData", dataProviderClass = ScoreOrganizationsData.class,
            description = "GET /scoring/ScoringResults request with 1 valid organization " +
                    "and all types of org included. Response should be 200, with valid token, launched = true and with progress status")
    // TS.4.1
    public void checkScoringResultWithValidAllWeights(String[] org, String bussinessPs, String competitor,
                                                      String ownerS, String supplier) throws Exception {

        jsonString = scoreOrgDataModel.modelWithListOfOrgs(Arrays.asList(org), bussinessPs, competitor, ownerS, supplier);
        Log.info(jsonString);
        response = httpClient.callHttpPost("/scoring", "/scoreOrganizations", jsonString, postHeader.setHeaders());
        token = response.getBody().print();
        params.put("scoreToken", token);

        long start_time = System.currentTimeMillis();

        while (!jsonpathCreatorProgressToken.equals(1.0) && (System.currentTimeMillis() - start_time) < 1000) {
            response = httpClient.callHttpGet("/scoring", "/scoringStatus", params, getHeader.setHeaders());
            jsonDataSourceString = response.getBody().asString();
            jsonpathCreatorProgressToken = ScoringStatusLogic.checkProgressStatus(jsonDataSourceString);
        }

        if (!jsonpathCreatorProgressToken.equals(1.0)) {
            Assert.assertTrue(false);
        }

        responseType = response.getBody().print().getClass().getTypeName();
        params.put("pageNumber", 1);
        response = httpClient.callHttpGet("/scoring", "/scoringResults", params, getHeader.setHeaders());
        jsonDataSourceString = response.getBody().asString();
        statusCode = response.statusCode();

        scoringResultsAsserts.assertOrgUriInResponse(statusCode, jsonDataSourceString, Arrays.asList(org));
    }

//
//    @Test(description = "GET /scoring/ScoringResults request with 1 valid organization " +
//            "and for BusinessPartnership weights. Response should be 200, with valid token, launched = true and with progress status")
//    // TS.4.2
//    public void checkScoringResultWithValidOrgForBussinessPs() throws Exception {
//        organizationUris.clear();
////        organizationUris.add("4297034757");
//        organizationUris.add("5034757565");
//
//
//        jsonString = scoreOrgDataModel.modelWithListOfOrgs(organizationUris, "0.9", "0.0", "0.0", "0.0");
//        Log.info(jsonString);
//        response = httpClient.callHttpPost("/scoring", "/scoreOrganizations", jsonString, postHeader.setHeaders());
//        token = response.getBody().print();
//        params.put("scoreToken", token);
//
//        do {
//            response = httpClient.callHttpGet("/scoring", "/scoringStatus", params, getHeader.setHeaders());
//            jsonDataSourceString = response.getBody().asString();
//            jsonpathCreatorProgressToken = ScoringStatusLogic.checkProgressStatus(jsonDataSourceString);
//        } while (!jsonpathCreatorProgressToken.equals(1.0));
//
//        responseType = response.getBody().print().getClass().getTypeName();
//
//        params.put("pageNumber", 1);
//        response = httpClient.callHttpGet("/scoring", "/scoringResults", params, getHeader.setHeaders());
//        jsonDataSourceString = response.getBody().asString();
//        statusCode = response.statusCode();
//
//        scoringResultsAsserts.assertOrgUriInResponse(statusCode, jsonDataSourceString, organizationUris);
//    }
//
//
//    @Test(description = "GET /scoring/ScoringResults request with 1 valid organization " +
//            "and for Competitor weights. Response should be 200, with valid token, launched = true and with progress status")
//    // TS.4.3
//    public void checkScoringResultWithValidOrgForCompetitor() throws Exception {
//        organizationUris.clear();
//        organizationUris.add("4297034757");
//
//        jsonString = scoreOrgDataModel.modelWithListOfOrgs(organizationUris, "0.0", "0.9", "0.0", "0.0");
//        Log.info(jsonString);
//        response = httpClient.callHttpPost("/scoring", "/scoreOrganizations", jsonString, postHeader.setHeaders());
//        token = response.getBody().print();
//        params.put("scoreToken", token);
//
//        do {
//            response = httpClient.callHttpGet("/scoring", "/scoringStatus", params, getHeader.setHeaders());
//            jsonDataSourceString = response.getBody().asString();
//            jsonpathCreatorProgressToken = ScoringStatusLogic.checkProgressStatus(jsonDataSourceString);
//        } while (!jsonpathCreatorProgressToken.equals(1.0));
//
//        responseType = response.getBody().print().getClass().getTypeName();
//
//        params.put("pageNumber", 1);
//        response = httpClient.callHttpGet("/scoring", "/scoringResults", params, getHeader.setHeaders());
//        jsonDataSourceString = response.getBody().asString();
//        statusCode = response.statusCode();
//
//        scoringResultsAsserts.assertOrgUriInResponse(statusCode, jsonDataSourceString, organizationUris);
//    }
//
//
//    @Test(description = "GET /scoring/ScoringResults request with 1 valid organization " +
//            "and for OwnerShip weights. Response should be 200, with valid token, launched = true and with progress status")
//    // TS.4.4
//    public void checkScoringResultWithValidOrgForOwnerShip() throws Exception {
//        organizationUris.clear();
//        organizationUris.add("4297034757");
//
//        jsonString = scoreOrgDataModel.modelWithListOfOrgs(organizationUris, "0.0", "0.0", "0.9", "0.0");
//        Log.info(jsonString);
//        response = httpClient.callHttpPost("/scoring", "/scoreOrganizations", jsonString, postHeader.setHeaders());
//        token = response.getBody().print();
//        params.put("scoreToken", token);
//
//        do {
//            response = httpClient.callHttpGet("/scoring", "/scoringStatus", params, getHeader.setHeaders());
//            jsonDataSourceString = response.getBody().asString();
//            jsonpathCreatorProgressToken = ScoringStatusLogic.checkProgressStatus(jsonDataSourceString);
//        } while (!jsonpathCreatorProgressToken.equals(1.0));
//
//        responseType = response.getBody().print().getClass().getTypeName();
//
//        params.put("pageNumber", 1);
//        response = httpClient.callHttpGet("/scoring", "/scoringResults", params, getHeader.setHeaders());
//        jsonDataSourceString = response.getBody().asString();
//        statusCode = response.statusCode();
//
//        scoringResultsAsserts.assertOrgUriInResponse(statusCode, jsonDataSourceString, organizationUris);
//    }
//
//
//    @Test(description = "GET /scoring/ScoringResults request with 1 valid organization " +
//            "and for Supplier weights. Response should be 200, with valid token, launched = true and with progress status")
//    // TS.4.5
//    public void checkScoringResultWithValidOrgForSupplier() throws Exception {
//        organizationUris.clear();
//        organizationUris.add("4297034757");
//
//        jsonString = scoreOrgDataModel.modelWithListOfOrgs(organizationUris, "0.0", "0.0", "0.0", "0.9");
//        Log.info(jsonString);
//        response = httpClient.callHttpPost("/scoring", "/scoreOrganizations", jsonString, postHeader.setHeaders());
//        token = response.getBody().print();
//        params.put("scoreToken", token);
//
//        do {
//            response = httpClient.callHttpGet("/scoring", "/scoringStatus", params, getHeader.setHeaders());
//            jsonDataSourceString = response.getBody().asString();
//            jsonpathCreatorProgressToken = ScoringStatusLogic.checkProgressStatus(jsonDataSourceString);
//        } while (!jsonpathCreatorProgressToken.equals(1.0));
//
//        responseType = response.getBody().print().getClass().getTypeName();
//
//        params.put("pageNumber", 1);
//        response = httpClient.callHttpGet("/scoring", "/scoringResults", params, getHeader.setHeaders());
//        jsonDataSourceString = response.getBody().asString();
//        statusCode = response.statusCode();
//
//        scoringResultsAsserts.assertOrgUriInResponse(statusCode, jsonDataSourceString, organizationUris);
//    }
//
//
//    @Test(description = "GET /scoring/ScoringResults request with 1 valid organization " +
//            "and but without weights. Response should be 200, with valid token, launched = true and with progress status")
//    // TS.4.6
//    public void checkScoringResultWithValiOrgAndNoWeights() throws Exception {
//        organizationUris.clear();
//        organizationUris.add("4297034757");
//
//        jsonString = scoreOrgDataModel.modelWithListOfOrgs(organizationUris, "0.0", "0.0", "0.0", "0.0");
//        Log.info(jsonString);
//        response = httpClient.callHttpPost("/scoring", "/scoreOrganizations", jsonString, postHeader.setHeaders());
//        token = response.getBody().print();
//        params.put("scoreToken", token);
//
//        do {
//            response = httpClient.callHttpGet("/scoring", "/scoringStatus", params, getHeader.setHeaders());
//            jsonDataSourceString = response.getBody().asString();
//            jsonpathCreatorProgressToken = ScoringStatusLogic.checkProgressStatus(jsonDataSourceString);
//        } while (!jsonpathCreatorProgressToken.equals(1.0));
//
//        responseType = response.getBody().print().getClass().getTypeName();
//
//        params.put("pageNumber", 1);
//        response = httpClient.callHttpGet("/scoring", "/scoringResults", params, getHeader.setHeaders());
//        jsonDataSourceString = response.getBody().asString();
//        statusCode = response.statusCode();
//
//        scoringResultsAsserts.assertOrgUriInResponse(statusCode, jsonDataSourceString, organizationUris);
//    }
//
//
//    @Test(description = "GET /scoring/ScoringResults request with 10 valid organization URIs " +
//            "and all types of org included. Response should be 200, with valid token, launched = true and with progress status")
//      //TS.4.7
//    public void checkScoringResultWithListOfOrgsUrisWithValidAllWeight() throws Exception {
//        organizationUris.clear();
//        organizationUris.add("http://feed.thomsonreuters.com/1-4297034757");
//        organizationUris.add("http://feed.thomsonreuters.com/1-5000072036");
//        organizationUris.add("http://feed.thomsonreuters.com/1-4295903329");
//        organizationUris.add("http://feed.thomsonreuters.com/1-4295905573");
//        organizationUris.add("http://feed.thomsonreuters.com/1-4295903076");
//        organizationUris.add("http://feed.thomsonreuters.com/1-4295903678");
//        organizationUris.add("http://feed.thomsonreuters.com/1-4295903744");
//        organizationUris.add("http://feed.thomsonreuters.com/1-4295904620");
//        organizationUris.add("http://feed.thomsonreuters.com/1-4295915611");
//        organizationUris.add("http://feed.thomsonreuters.com/1-4296808518");
//
//        jsonString = scoreOrgDataModel.modelWithListOfOrgs(organizationUris, "0.9", "0.9", "0.9", "0.9");
//        Log.info(jsonString);
//        response = httpClient.callHttpPost("/scoring", "/scoreOrganizations", jsonString, postHeader.setHeaders());
//        token = response.getBody().print();
//        params.put("scoreToken", token);
//
//        do {
//            response = httpClient.callHttpGet("/scoring", "/scoringStatus", params, getHeader.setHeaders());
//            jsonDataSourceString = response.getBody().asString();
//            jsonpathCreatorProgressToken = ScoringStatusLogic.checkProgressStatus(jsonDataSourceString);
//        } while (!jsonpathCreatorProgressToken.equals(1.0));
//
//        responseType = response.getBody().print().getClass().getTypeName();
//
//        params.put("pageNumber", 1);
//        response = httpClient.callHttpGet("/scoring", "/scoringResults", params, getHeader.setHeaders());
//        jsonDataSourceString = response.getBody().asString();
//        statusCode = response.statusCode();
//
//        scoringResultsAsserts.assertOrgUriInResponse(statusCode, jsonDataSourceString, organizationUris);
//    }
//
//    @Test(description = "GET /scoring/ScoringResults request with 10 valid organization IDs " +
//            "and all types of org included. Response should be 200, with valid token, launched = true and with progress status")
//    // TS.1.1
//    public void checkScoringResultWithListOfOrgsIdsWithValidAllWeight() throws Exception {
//        organizationUris.clear();
//        organizationUris.add("4297034757");
//        organizationUris.add("5000072036");
//        organizationUris.add("4295903329");
//        organizationUris.add("4295905573");
//        organizationUris.add("4295903076");
//        organizationUris.add("4295903678");
//        organizationUris.add("4295903744");
//        organizationUris.add("4295904620");
//        organizationUris.add("4295915611");
//        organizationUris.add("4296808518");
//
//        jsonString = scoreOrgDataModel.modelWithListOfOrgs(organizationUris, "0.9", "0.9", "0.9", "0.9");
//        Log.info(jsonString);
//        response = httpClient.callHttpPost("/scoring", "/scoreOrganizations", jsonString, postHeader.setHeaders());
//        token = response.getBody().print();
//        params.put("scoreToken", token);
//
//        do {
//            response = httpClient.callHttpGet("/scoring", "/scoringStatus", params, getHeader.setHeaders());
//            jsonDataSourceString = response.getBody().asString();
//            jsonpathCreatorProgressToken = ScoringStatusLogic.checkProgressStatus(jsonDataSourceString);
//            Thread.sleep(3000);
//        } while (!jsonpathCreatorProgressToken.equals(1.0));
//
//        responseType = response.getBody().print().getClass().getTypeName();
//
//        params.put("pageNumber", 1);
//        response = httpClient.callHttpGet("/scoring", "/scoringResults", params, getHeader.setHeaders());
//        jsonDataSourceString = response.getBody().asString();
//        statusCode = response.statusCode();
//
//        scoringResultsAsserts.assertOrgUriInResponse(200, jsonDataSourceString, organizationUris);
//    }

}
