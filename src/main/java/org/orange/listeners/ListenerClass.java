package org.orange.listeners;

import org.orange.reports.ExtentLogger;
import org.orange.reports.ExtentReport;
import org.testng.*;

import java.io.IOException;

public class ListenerClass implements ITestListener, ISuiteListener {

    @Override
    public void onStart(ISuite suite) {
        ExtentReport.initReports();
    }

    @Override
    public void onFinish(ISuite suite) {
        try {
            ExtentReport.flushReports();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void onTestStart(ITestResult result) {
        ExtentReport.createTest(result.getMethod().getMethodName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        ExtentLogger.pass(result.getMethod().getMethodName() +" is passed ");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        ExtentLogger.fail(result.getMethod().getMethodName()+" is failed");
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        ExtentLogger.skip(result.getMethod().getMethodName()+" is skipped");
    }






}
