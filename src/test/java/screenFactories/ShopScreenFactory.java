package screenFactories;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

/**
 * Created by ${bohdan.missurenko} on 11/14/2018.
 */
public class ShopScreenFactory {

    @AndroidFindBy(id = "com.prodege.swagbucksmobile:id/app_toolbar")
    public MobileElement upperBar;

    @AndroidFindBy(id = "android.widget.TextView")
    public MobileElement upperBarText;

    @AndroidFindBy(id = "com.prodege.swagbucksmobile:id/sb2_row_offer_center_imageview")
    public MobileElement centerImage;


}
