package screenFactories;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

/**
 * Created by ${bohdan.missurenko} on 11/16/2018.
 */
public class WatchVideoScreenFactory {

    @AndroidFindBy(id = "com.prodege.swagbucksmobile:id/coach_marks_button")
    public MobileElement gotItNext;


    @AndroidFindBy(id = "com.prodege.swagbucksmobile:id/coach_continue_btn")
    public MobileElement getFreeGiftContinueButton;

}
