package screenFactories;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

/**
 * Created by ${bohdan.missurenko} on 11/13/2018.
 */
public class NotificationScreenFactory {

    @AndroidFindBy(id = "android:id/message")
    public MobileElement notification;

    @AndroidFindBy(id = "android:id/button1")
    public MobileElement closeNotificationButton;

}
