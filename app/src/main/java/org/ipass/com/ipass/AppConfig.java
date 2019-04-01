package org.ipass.com.ipass;

/**
 * Created by Abishek on 13-Apr-18.
 */

public class AppConfig {
    static String ipAddress = "https://ipass-gowtham.herokuapp.com/";
    public static final String urlLogin = ipAddress+"user/signin";
    public static final String urlCreateAcc = ipAddress+"user/";
    public static final String urlPublic = ipAddress+"public/display";
    public static final String urlDashboard = ipAddress+"dashboard/display";
    public static final String urlUpdateFieldName = ipAddress+"dashboard/fieldName";
    public static final String urlUpdateSwitchName = ipAddress+"dashboard/switchName";
    public static final String urlUpdateSwitchState = ipAddress+"dashboard/switchState";
    public static final String urlFieldName = ipAddress+"dashboard/fieldName";
    public static final String urlMakePublic = ipAddress+"dashboard/makePublic";
    public static final String urlUpdateMapName = ipAddress+"dashboard/mapName";

}
