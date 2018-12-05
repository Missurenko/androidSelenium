package utils;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;
import java.util.regex.Pattern;

import static java.util.regex.Pattern.CASE_INSENSITIVE;

/**
 * Created by ${bohdan.missurenko} on 11/13/2018.
 */
@Listeners({utils.Listeners.class})
public abstract class BaseTest {

    protected static AppiumDriver driver;

    static final Logger log = Logger.getLogger(BaseTest.class.getName());

    private final TestSetup setupType;

    static final Logger logSetup = Logger.getLogger(TestSetup.class.getName());


//    public static AppiumDriverLocalService service = null;

    protected static Properties prop = new Properties();

    public TestSetup getSetupType() {
        return setupType;
    }

    public static AppiumDriver getDriver() {
        return driver;
    }

    private void killUiAutomatorServer() throws IOException, InterruptedException {
        setupType.execAdbCommand("uninstall io.appium.uiautomator2.server");
        setupType.execAdbCommand("uninstall io.appium.uiautomator2.server.test");
    }

    public BaseTest() {
        setupType = TestSetupProvider.getInstance().getTestSetup();
    }

    @BeforeSuite(alwaysRun = true)
    public void setUp() throws IOException, InterruptedException {
        log.info("Start setup");
        FileInputStream fileInputStream = new FileInputStream(System.getProperty("user.dir") + "/src/test/java/user.properties");
        log.info("Load file prop");
        prop.load(fileInputStream);
        log.info("Loaded prop");
        File apkFile = findFileByMask(System.getProperty("user.dir"), ".*\\.apk");
        log.info("Completed load apk");
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Dan");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        capabilities.setCapability(MobileCapabilityType.VERSION, "7.1.2");
        capabilities.setCapability(AndroidMobileCapabilityType.NO_SIGN, "true");
        capabilities.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.prodege.swagbucksmobile");
        capabilities.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, ".sb.SplashSwagbucks");
        capabilities.setCapability("autoGrantPermissions", "true"); //grant permission to system dialogues such as location
        capabilities.setCapability("skipUnlock", "true");
        capabilities.setCapability("noReset", "false");
        capabilities.setCapability(MobileCapabilityType.APP, apkFile.getAbsolutePath());
        capabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 600); // server wait
        capabilities.setCapability(MobileCapabilityType.UDID, "49e206a87ce5");
//        log.info("before set Up");
//        setupType.setUp(capabilities);
        log.info("Set configs");
        String appiumEndpoint = setupType.getAppiumEndpoint();

        System.out.println(".......Connecting to Appium on " + appiumEndpoint);

        driver = new AndroidDriver<MobileElement>(new URL(appiumEndpoint), capabilities); //
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); // search element
        System.out.println(".......Starting Appium driver.");
    }

    private File findFileByMask(String directory, String pattern) {
        File directoryFile = new File(directory);
        Pattern filterPattern = Pattern.compile(pattern, CASE_INSENSITIVE);
        File[] files = directoryFile.listFiles(pathname -> filterPattern.matcher(pathname.getName()).matches());
        if (files == null) {
            throw new SetUpException("Failed to find files at " + directory);
        }
        if (files.length == 0) {
            throw new SetUpException("Didn't found file matching " + pattern + " at " + directory);
        }
        return files[0];
    }


}
