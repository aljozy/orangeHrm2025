package org.orange.reports;

import com.aventstack.extentreports.ExtentTest;

public class ExtentManager {
    private ExtentManager(){}

    private static ThreadLocal<ExtentTest> extText = new ThreadLocal<>();

      static ExtentTest getExtText() {
        return extText.get();
    }

    //making it default access modifier so it can be exposed to other packages
     static void setExtText(ExtentTest test) {
        extText.set(test);
    }
     static void unload(){
        extText.remove();
    }
}

