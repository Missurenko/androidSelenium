package acceptanceTests;

import model.UserCaseDto;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pageObject.LoginScreen;
import pageObject.NotificationScreen;
import pageObject.SplashScreen;
import pageObject.WatchVideoScreen;
import utils.BaseTest;

import java.util.logging.Logger;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

/**
 * Created by ${bohdan.missurenko} on 11/13/2018.
 */

public class LoginTest extends BaseTest {

    static final Logger log = Logger.getLogger(LoginTest.class.getName());


    @DataProvider(name = "errorLogin")
    public Object[][] errorLogin() {
        return new Object[][]{
                {new UserCaseDto("", "", "Please enter an email address or swagname.", "Login without login and pass")},
                {new UserCaseDto("example@login.name", "", "Please enter a password.", "Login without pass")},
                {new UserCaseDto("deactivated@sbxmail.com", "deactivateduser", "This account has been deactivated, please contact support.", "Login deactivate user.")},
                {new UserCaseDto("mypointsuser@sbxmail.com", "mypointspass", "Invalid Credentials", "Login myPoints user")},
                {new UserCaseDto("mypointsuser", "mypointspass", "Invalid Credentials", "Login without at sign")},

        };
    }

    @DataProvider(name = "correctWork")
    public Object[][] createUserCasesForLogin() {
        return new Object[][]{
                {new UserCaseDto("testpleaseignore@gmail.com", "turingtest42", "", "Login as real user")},
        };
    }


    @Test(dataProvider = "errorLogin")
    public void loginError(UserCaseDto userCaseDto) {
        log.info("Start case " + userCaseDto.getTestCase());
        SplashScreen splashScreen = new SplashScreen();
        LoginScreen loginScreen = splashScreen.goToLoginScreen();
        loginScreen.loginInSystem(userCaseDto);
        log.info("Click Login button");
        NotificationScreen notification = new NotificationScreen();
        String notificationMessage = notification.getNotificationText();
        log.info("Notification " + notificationMessage);
        String errorTextNotification = userCaseDto.getErrorTextNotification();
        String testCase = userCaseDto.getTestCase();
        String userName = userCaseDto.getLoginName();
        assertEquals(notificationMessage, errorTextNotification, testCase + "UserName [" + userName + "]");
    }

    @Test(dataProvider = "correctWork")
    public void loginCorrect(UserCaseDto userCaseDto) {
        log.info("Start case " + userCaseDto.getTestCase());
        SplashScreen splashScreen = new SplashScreen();
        LoginScreen loginScreen = splashScreen.goToLoginScreen();
        loginScreen.loginInSystem(userCaseDto);
        log.info("Click Login button");
        loginScreen.skipEnableCashBack();
        WatchVideoScreen watchVideoScreen = new WatchVideoScreen();
        watchVideoScreen.clickAllFirstButton();
        log.info("Logged in.");
        assertTrue(true);
    }

    @AfterMethod
    public static void cleanUp() {
        System.out.println("Resetting App");
        driver.resetApp();
    }
}
