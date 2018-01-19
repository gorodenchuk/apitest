package testconfig.asserts;

import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;
import org.apache.log4j.Logger;
import org.testng.Assert;

import java.util.List;

public class ScoringResultsAsserts extends Asserts {

    private static Logger Log = Logger.getLogger(ScoringResultsAsserts.class.getName());
    private String item;

    /*    Asserts checks:
        - status code of response;
        - compare URI from returned news with URI that was used in scoringResult request;
        - presence for each returned org relevanceScore and relationType values.*/
    public void assertOrgUriInResponse(int statusCode, String jsonDataSourceString, List<String> organizationUris) {
        DocumentContext jsonContext = JsonPath.parse(jsonDataSourceString);

        String jsonpathCreatorIdPath = "$.pageContent[*].id";
        List<String> jsonpathCreatorId = jsonContext.read(jsonpathCreatorIdPath);

        for (int i = 0; i < jsonpathCreatorId.size(); i++) {
            String jsonpathCreatorOrgUrisPath = "$.pageContent[" + i + "].organizations[*].uri";
            String jsonpathCreatorRelevanceScorePath = ("$.pageContent[" + i + "].relevanceScore");
            String jsonpathCreatorRelationTypePath = "$.pageContent[" + i + "].relationType";

            List<String> jsonpathOrgUris = jsonContext.read(jsonpathCreatorOrgUrisPath);
            Double jsonpathRelevanceScore = jsonContext.read(String.valueOf(jsonpathCreatorRelevanceScorePath));
            String jsonpathRelationType = jsonContext.read(jsonpathCreatorRelationTypePath);

            System.out.println(jsonpathRelevanceScore.getClass().getSimpleName() + " ======== " + "Double");
            System.out.println(jsonpathRelationType.getClass().getSimpleName() + " ======== " + "String");

            Assert.assertTrue(jsonpathRelevanceScore.getClass().getSimpleName().equals("Double"),
                    "Relevance score value is missed");
            Assert.assertTrue(jsonpathRelationType.getClass().getSimpleName().equals("String"),
                    "Relation type value is missed");

            for (int j = 0; j < jsonpathOrgUris.size(); j++) {
                if (organizationUris.get(j).matches("http.*")) {
                    item = jsonpathOrgUris.get(j);
                    System.out.println(organizationUris +  " ========= " + item);
                    assertThatRequestedOrgSameInResponse(organizationUris, item);
                } else {
                    item = jsonpathOrgUris.get(j).replace("http://feed.thomsonreuters.com/1-", "");
                    System.out.println(organizationUris +  " ========= " + item);
                    assertThatRequestedOrgSameInResponse(organizationUris, item);
                }
            }
        }
        System.out.println(statusCode +  " ========= " + 200);
        Assert.assertEquals(statusCode, 200,
                "Actual statusCode doesn`t match with expected");
        softAssert.assertAll();
    }

    /*    Asserts checks:
      - status code of response;
      - compare URI from returned news with URI that was used in scoringResult request;
      - presence for each returned org relevanceScore and relationType values.*/
//    public void assertOrgUriInResponse1(int statusCode, String jsonDataSourceString, List<String> organizationUris) {
//        DocumentContext jsonContext = JsonPath.parse(jsonDataSourceString);
//
//        String jsonpathCreatorIdPath = "$.pageContent[*].id";
//        List<String> jsonpathCreatorId = jsonContext.read(jsonpathCreatorIdPath);
//
//        for (int i = 0; i < jsonpathCreatorId.size(); i++) {
//            String jsonpathCreatorOrgUrisPath = "$.pageContent[" + i + "].organizations[*].uri";
//            String jsonpathCreatorRelevanceScorePath = ("$.pageContent[" + i + "].relevanceScore");
//            String jsonpathCreatorRelationTypePath = "$.pageContent[" + i + "].relationType";
//
//            List<String> jsonpathOrgUris = jsonContext.read(jsonpathCreatorOrgUrisPath);
//            Double jsonpathRelevanceScore = jsonContext.read(String.valueOf(jsonpathCreatorRelevanceScorePath));
//            String jsonpathRelationType = jsonContext.read(jsonpathCreatorRelationTypePath);
//
//            System.out.println(jsonpathRelevanceScore.getClass().getSimpleName() + " ======== " + "Double");
//            System.out.println(jsonpathRelationType.getClass().getSimpleName() + " ======== " + "String");
//
//            Assert.assertTrue(jsonpathRelevanceScore.getClass().getSimpleName().equals("Double"),
//                    "Relevance score value is missed");
//            Assert.assertTrue(jsonpathRelationType.getClass().getSimpleName().equals("String"),
//                    "Relation type value is missed");
//
//            for (int j = 0; j < jsonpathOrgUris.size(); j++) {
//                if (organizationUris.get(j).matches("http.*")) {
//                    item = jsonpathOrgUris.get(j);
//                    System.out.println(organizationUris +  " ========= " + item);
//                    assertThatRequestedOrgSameInResponse(organizationUris, item);
//                } else {
//                    item = jsonpathOrgUris.get(j).replace("http://feed.thomsonreuters.com/1-", "");
//                    System.out.println(organizationUris +  " ========= " + item);
//                    assertThatRequestedOrgSameInResponse(organizationUris, item);
//                }
//            }
//        }
//        System.out.println(statusCode +  " ========= " + 200);
//        Assert.assertEquals(statusCode, 200,
//                "Actual statusCode doesn`t match with expected");
//        softAssert.assertAll();
//    }


    private static void assertThatRequestedOrgSameInResponse(List<String> organizationUris, String item) {
        if (organizationUris.contains(item)) {
            Assert.assertTrue(true,
                    "Links comparing does not detected equal in response with request");
        } else {
            Assert.assertFalse(true,
                    "Links comparing does not detected equal in response with request");
        }
    }


}
