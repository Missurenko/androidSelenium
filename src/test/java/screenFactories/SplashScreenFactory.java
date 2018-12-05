package screenFactories;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

/**
 * Created by ${bohdan.missurenko} on 11/13/2018.
 */
public class SplashScreenFactory {

    @AndroidFindBy(id = "com.prodege.swagbucksmobile:id/welcome_footer_textViewBottomLeft")
    public MobileElement loginButton;
}
