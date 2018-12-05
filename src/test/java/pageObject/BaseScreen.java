package pageObject;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.BaseTest;

import java.util.logging.Logger;

/**
 * Created by ${bohdan.missurenko} on 11/16/2018.
 */
public abstract class BaseScreen {

    protected static AppiumDriver driver = BaseTest.getDriver();

    static final Logger log = Logger.getLogger(BaseScreen.class.getName());

    protected void waitForElementToLoad(MobileElement id) {
        waitLoad("", 10, id);
    }

    protected void waitLoginToLoad(MobileElement id) {
        waitLoad("Login in app.", 20, id);
    }

    protected void firstWaitLoad(MobileElement id) {
        waitLoad("App load.", 20, id);
    }

    private void waitLoad(String logMessage, int time, MobileElement id) {
        log.info("Start waiting element. " + logMessage);
        WebDriverWait wait = new WebDriverWait(driver, time);
        wait.until(ExpectedConditions.visibilityOf(id));
    }
}
