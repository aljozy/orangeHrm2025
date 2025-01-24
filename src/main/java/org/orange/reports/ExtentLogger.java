package org.orange.reports;

public final class ExtentLogger {

    private ExtentLogger(){}
    public static void pass(String message){
        ExtentManager.getExtText().pass(message);
    }

    public static void fail(String message){
        ExtentManager.getExtText().fail(message);
    }

    public static void skip(String message){
        ExtentManager.getExtText().skip(message);
    }
    public static void info(String message){
        ExtentManager.getExtText().info(message);
    }


}
