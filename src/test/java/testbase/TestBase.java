package testbase;

import assure.RestAssuredHttpClient;
import com.jayway.restassured.response.Response;
import org.testng.annotations.*;
import utils.LogListener;

import java.util.ArrayList;
import java.util.List;

@Listeners(LogListener.class)
public class TestBase {

    protected RestAssuredHttpClient httpClient;
    protected Response response;
    protected String token;
    protected int statusCode;
    protected String responseType;
    protected String jsonDataSourceString;

    protected List<String> organizationUris = new ArrayList<>();

    @BeforeMethod(alwaysRun = true, description = "Configure Base Url before test")
    public void setupHttpClient() throws Exception {
        httpClient = new RestAssuredHttpClient("http://linkq-alb-1990426547.eu-west-1.elb.amazonaws.com", 9080);
    }

    @AfterMethod(alwaysRun = true, description = "Reset Client Props after test")
    public void tearDownHttpClientTests() {
        httpClient.resetClientProps();
    }
}
