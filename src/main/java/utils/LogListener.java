package utils;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.filter.log.LogDetail;
import com.jayway.restassured.filter.log.RequestLoggingFilter;
import com.jayway.restassured.filter.log.ResponseLoggingFilter;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import ru.yandex.qatools.allure.annotations.Attachment;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class LogListener implements ITestListener {
    private ByteArrayOutputStream request = new ByteArrayOutputStream();
    private ByteArrayOutputStream response = new ByteArrayOutputStream();

    private PrintStream requestVar = new PrintStream(request, true);
    private PrintStream responseVar = new PrintStream(response, true);


    public void onStart(ITestContext iTestContext) {
        RestAssured.filters(new ResponseLoggingFilter(LogDetail.ALL, responseVar),
                new RequestLoggingFilter(LogDetail.ALL, requestVar));
        Log.info("***************** Testing started! *****************");
    }

    public void onTestSuccess(ITestResult iTestResult) {
        logRequest(request);
        logResponse(response);

        Log.info("----------------- Ended successfully -----------------");
    }

    public void onTestFailure(ITestResult iTestResult) {
        onTestSuccess(iTestResult);
        Log.info("================= Test: " + iTestResult.getName() + " FAILED! =================");
    }

    @Attachment(value = "request")
    public byte[] logRequest(ByteArrayOutputStream stream) {
        return attach(stream);
    }

    @Attachment(value = "response")
    public byte[] logResponse(ByteArrayOutputStream stream) {
        return attach(stream);
    }

    public byte[] attach(ByteArrayOutputStream log) {
        byte[] array = log.toByteArray();
        log.reset();
        return array;
    }

    public void onTestStart(ITestResult iTestResult) {
        Log.info("----------------- Test: " + iTestResult.getName() + " started! -----------------");
    }

    public void onTestSkipped(ITestResult iTestResult) {
        Log.info("Test: " + iTestResult.getName() + " SKIPPED!");
    }

    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {
        Log.info("Should be discovered!");

    }

    public void onFinish(ITestContext iTestContext) {
        Log.info("***************** Testing finished! *****************");
    }
}

