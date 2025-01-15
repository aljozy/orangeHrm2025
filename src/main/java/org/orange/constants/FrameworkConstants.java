package org.orange.constants;

public final class FrameworkConstants {
    private FrameworkConstants(){

    }
    private static final String APP_URL ="https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";
    private static final String CONFIG_FILE_PATH =System.getProperty("user.dir")+"/src/test/resources/config/config.properties";

    public static String getAppURL(){

        return APP_URL;
    }
    public static String getConfigFilePath(){
        return CONFIG_FILE_PATH;
    }


}
