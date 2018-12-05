package pageObject;

import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;
import screenFactories.NotificationScreenFactory;

/**
 * Created by ${bohdan.missurenko} on 11/13/2018.
 */
public class NotificationScreen extends BaseScreen {

    private NotificationScreenFactory notificationScreenFactory = new NotificationScreenFactory();

    public NotificationScreen() {
        PageFactory.initElements(new AppiumFieldDecorator(driver), notificationScreenFactory);
        waitLoginToLoad(notificationScreenFactory.closeNotificationButton);
    }

    public String getNotificationText() {
        return notificationScreenFactory.notification.getText();
    }

    public void closeNotification() {
        notificationScreenFactory.closeNotificationButton.click();
    }
}
