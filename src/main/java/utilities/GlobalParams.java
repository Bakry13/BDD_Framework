package utilities;

public class GlobalParams {

    //---------------------------------------App Language---------------------------------------
    public static Language currentLanguage = Language.ENGLISH;
    //------------------------------------------------------------------------------------------

    private static final ThreadLocal<Platform> platformName = new ThreadLocal<>();
    private static final ThreadLocal<String> udid = new ThreadLocal<>();
    private static final ThreadLocal<String> deviceName = new ThreadLocal<>();
    private static final ThreadLocal<String> systemPort = new ThreadLocal<>();
    private static final ThreadLocal<String> chromeDriverPort = new ThreadLocal<>();
    private static final ThreadLocal<String> wdaLocalPort = new ThreadLocal<>();
    private static final ThreadLocal<String> webkitDebugProxyPort = new ThreadLocal<>();

    public void setPlatformName(Platform platformName1) {
        platformName.set(platformName1);
    }

    public Platform getPlatformName() {
        if (platformName.get() == null)
            initializeGlobalParams(Language.ENGLISH.name(), Platform.ANDROID.name());

        return platformName.get();
    }

    public String getUDID() {
        return udid.get();
    }

    public void setUDID(String udid2) {
        udid.set(udid2);
    }

    public String getDeviceName() {
        return deviceName.get();
    }

    public void setDeviceName(String deviceName2) {
        deviceName.set(deviceName2);
    }

    public String getSystemPort() {
        return systemPort.get();
    }

    public void setSystemPort(String systemPort2) {
        systemPort.set(systemPort2);
    }

    public String getChromeDriverPort() {
        return chromeDriverPort.get();
    }

    public void setChromeDriverPort(String chromeDriverPort2) {
        chromeDriverPort.set(chromeDriverPort2);
    }

    public String getWdaLocalPort() {
        return wdaLocalPort.get();
    }

    public void setWdaLocalPort(String wdaLocalPort2) {
        wdaLocalPort.set(wdaLocalPort2);
    }

    public String getWebkitDebugProxyPort() {
        return webkitDebugProxyPort.get();
    }

    public void setWebkitDebugProxyPort(String webkitDebugProxyPort2) {
        webkitDebugProxyPort.set(webkitDebugProxyPort2);
    }

    public void initializeGlobalParams(String appLanguage, String runningPlatform) {
        GlobalParams params = new GlobalParams();
        setCurrentTestLanguage(appLanguage);
        params.setPlatformName(
                runningPlatform.equals(GlobalParams.Platform.ANDROID.name()) ?
                        GlobalParams.Platform.ANDROID : GlobalParams.Platform.IOS);

        // Will be revisited in the future
//        setCurrentMachineSupportedPlatform(params);

        switch (params.getPlatformName()) {
            case ANDROID:
                params.setSystemPort(System.getProperty("systemPort", "10000"));
                params.setChromeDriverPort(System.getProperty("chromeDriverPort", "11000"));
                params.setDeviceName(System.getProperty("deviceName", "Google Emulator"));
                break;
            case IOS:
                params.setUDID(System.getProperty("udid", "0CF89381-7377-4D2B-B2F7-D5A004E53148"));
                params.setDeviceName(System.getProperty("deviceName", "iPhone 11"));
                params.setWdaLocalPort(System.getProperty("wdaLocalPort", "10001"));
                params.setWebkitDebugProxyPort(System.getProperty("webkitDebugProxyPort", "11001"));
                break;
            default:
                throw new IllegalStateException("Invalid Platform Name!");
        }
    }

    private void setCurrentMachineSupportedPlatform(GlobalParams params) {
        String osName = System.getProperty("os.name", "windows");
        Platform mobileSupportedPlatform;
        if (osName.toLowerCase().contains("mac"))
            mobileSupportedPlatform = Platform.IOS;
        else
            mobileSupportedPlatform = Platform.ANDROID;

        params.setPlatformName(mobileSupportedPlatform);
    }

    private static void setCurrentTestLanguage(String appLanguage) {
        if (appLanguage.equals(GlobalParams.Language.ARABIC.toString())) {
            currentLanguage = GlobalParams.Language.ARABIC;
        } else
            currentLanguage = GlobalParams.Language.ENGLISH;
    }

    //=================================================================
    public GlobalParams() {

    }

    public enum Platform {
        ANDROID,
        IOS
    }

    public enum Language {
        ENGLISH,
        ARABIC
    }

    public static int getCurrentLanguagePosition() {
        int position = 0;
        Language[] availableLanguages = Language.values();
        for (int i = 0; i < availableLanguages.length; i++) {
            if (availableLanguages[i] == currentLanguage) {
                position = i;
                break;
            }
        }
        return position;
    }
}
