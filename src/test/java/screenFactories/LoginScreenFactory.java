package screenFactories;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

/**
 * Created by ${bohdan.missurenko} on 11/13/2018.
 */
public class LoginScreenFactory {

    @AndroidFindBy(id = "com.prodege.swagbucksmobile:id/activity_login_signup_editTextUserName")
    public MobileElement loginNameInput;

    @AndroidFindBy(id = "com.prodege.swagbucksmobile:id/activity_login_signup_editTextPassword")
    public MobileElement loginPasswordInput;

    @AndroidFindBy(id = "com.prodege.swagbucksmobile:id/login_Submit")
    public MobileElement logginButton;

    @AndroidFindBy(id = "com.prodege.swagbucksmobile:id/no_thanks")
    public MobileElement noThanksToEnableCashBack;

    @AndroidFindBy(id = "com.prodege.swagbucksmobile:id/skip_anyway")
    public MobileElement clickSkipAnyway;
}
