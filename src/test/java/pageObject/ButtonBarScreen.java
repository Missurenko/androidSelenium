package pageObject;

import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;
import screenFactories.ButtonBarScreenFactory;

/**
 * Created by ${bohdan.missurenko} on 11/16/2018.
 */
public class ButtonBarScreen extends BaseScreen {

    ButtonBarScreenFactory buttonBarScreenFactory = new ButtonBarScreenFactory();

    public ButtonBarScreen() {
        PageFactory.initElements(new AppiumFieldDecorator(driver), buttonBarScreenFactory);
        waitForElementToLoad(buttonBarScreenFactory.bottomBar);
    }

    public ShopScreen goToShopScreen() {
        buttonBarScreenFactory.tabShopOpen.click();
        return new ShopScreen();
    }

}
