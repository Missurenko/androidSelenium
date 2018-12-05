package model;

/**
 * Created by ${bohdan.missurenko} on 11/13/2018.
 */

public class UserCaseDto {

    private String loginName;

    private String password;

    private String errorTextNotification;

    private String testCase;

    public UserCaseDto(String loginName, String password, String errorTextNotification, String testCase) {
        this.loginName = loginName;
        this.password = password;
        this.errorTextNotification = errorTextNotification;
        this.testCase = testCase;
    }

    public String getLoginName() {
        return loginName;
    }

    public String getPassword() {
        return password;
    }

    public String getErrorTextNotification() {
        return errorTextNotification;
    }

    public String getTestCase() {
        return testCase;
    }
}
