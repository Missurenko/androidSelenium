package pageObject;

import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import model.UserCaseDto;
import org.openqa.selenium.support.PageFactory;
import screenFactories.LoginScreenFactory;

/**
 * Created by ${bohdan.missurenko} on 11/13/2018.
 */
public class LoginScreen extends BaseScreen {

    private LoginScreenFactory loginScreenFactory = new LoginScreenFactory();

    public LoginScreen() {
        PageFactory.initElements(new AppiumFieldDecorator(driver), loginScreenFactory);
        waitLoginToLoad(loginScreenFactory.logginButton);
    }

    public void inputLoginName(String name) {
        loginScreenFactory.loginNameInput.clear();
        loginScreenFactory.loginNameInput.setValue(name);
    }

    public void inputLoginPassword(String password) {
        loginScreenFactory.loginPasswordInput.clear();
        loginScreenFactory.loginPasswordInput.setValue(password);
    }

    public void clickSubmit() {
        loginScreenFactory.logginButton.click();
    }

    public void loginInSystem(UserCaseDto userCaseDto) {
        inputLoginName(userCaseDto.getLoginName());
        inputLoginPassword(userCaseDto.getPassword());
        clickSubmit();
    }

    public void skipEnableCashBack() {
        waitForElementToLoad(loginScreenFactory.noThanksToEnableCashBack);
        loginScreenFactory.noThanksToEnableCashBack.click();
        waitForElementToLoad(loginScreenFactory.clickSkipAnyway);
        loginScreenFactory.clickSkipAnyway.click();
    }

}
