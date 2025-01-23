package org.orange.reports;

import com.aventstack.extentreports.ExtentTest;

public class ExtentManager {
    private ExtentManager(){}

    private static ThreadLocal<ExtentTest> extText = new ThreadLocal<>();

    public static ExtentTest getExtText() {
        return extText.get();
    }

    public static void setExtText(ExtentTest test) {
        extText.set(test);
    }
    public static void unload(){
        extText.remove();
    }
}

