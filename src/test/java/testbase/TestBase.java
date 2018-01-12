package testbase;

import assure.RestAssuredHttpClient;
import com.jayway.restassured.response.Response;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import testdata.headers.IHeaders;
import testdata.headers.ScoreOrganizationsHeader;
import utils.LogListener;

import java.util.HashMap;
import java.util.Map;

@Listeners(LogListener.class)
public class TestBase {

    protected RestAssuredHttpClient httpClient;
    protected Response response;
    protected Response response2;
    protected String token;
    protected int statusCode;
    protected String responseType;

    @BeforeClass(description = "Configure Base Url before test")
    public void setupHttpClient() throws Exception {
        httpClient = new RestAssuredHttpClient("http://linkq-alb-1990426547.eu-west-1.elb.amazonaws.com", 9080);
    }

    @AfterClass(description = "Reset Client Props after test")
    public void tearDownHttpClientTests() {
        httpClient.resetClientProps();
    }
}
