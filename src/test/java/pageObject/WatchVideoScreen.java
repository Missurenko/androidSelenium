package pageObject;

import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;
import screenFactories.WatchVideoScreenFactory;

/**
 * Created by ${bohdan.missurenko} on 11/16/2018.
 */
public class WatchVideoScreen extends BaseScreen {

    private WatchVideoScreenFactory watchVideoScreenFactory = new WatchVideoScreenFactory();

    public WatchVideoScreen() {
        PageFactory.initElements(new AppiumFieldDecorator(driver), watchVideoScreenFactory);
    }

    public void clickAllFirstButton() {
        watchVideoScreenFactory.gotItNext.click();
        watchVideoScreenFactory.gotItNext.click();
        watchVideoScreenFactory.gotItNext.click();
        watchVideoScreenFactory.getFreeGiftContinueButton.click();
        watchVideoScreenFactory.getFreeGiftContinueButton.click();
    }
}
