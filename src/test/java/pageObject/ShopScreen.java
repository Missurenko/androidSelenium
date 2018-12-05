package pageObject;

import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;
import screenFactories.ShopScreenFactory;

/**
 * Created by ${bohdan.missurenko} on 11/14/2018.
 */
public class ShopScreen extends BaseScreen {

    private ShopScreenFactory shopScreenFactory = new ShopScreenFactory();

    public ShopScreen() {
        PageFactory.initElements(new AppiumFieldDecorator(driver), shopScreenFactory);
        waitLoginToLoad(shopScreenFactory.centerImage);
    }
}
