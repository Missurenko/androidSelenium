package screenFactories;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

/**
 * Created by ${bohdan.missurenko} on 11/16/2018.
 */
public class ButtonBarScreenFactory {

    @AndroidFindBy(id = "com.prodege.swagbucksmobile:id/bb_bottom_bar_item_container")
    public MobileElement bottomBar;

    @AndroidFindBy(id = "com.prodege.swagbucksmobile:id/tab_shop")
    public MobileElement tabShopOpen;
}
