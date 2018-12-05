package pageObject;

import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;
import screenFactories.SplashScreenFactory;
import utils.BaseTest;

/**
 * Created by ${bohdan.missurenko} on 11/13/2018.
 */
public class SplashScreen extends BaseScreen {

    private SplashScreenFactory splashScreenFactory = new SplashScreenFactory();

    public SplashScreen() {
        PageFactory.initElements(new AppiumFieldDecorator(driver), splashScreenFactory);
        firstWaitLoad(splashScreenFactory.loginButton);
    }

    public LoginScreen goToLoginScreen() {
        splashScreenFactory.loginButton.click();
        return new LoginScreen();
    }
}
