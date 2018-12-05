package utils;



/**
 * Created by ${bohdan.missurenko} on 11/13/2018.
 */
public class TestSetupProvider {

    private static TestSetupProvider ourInstance = new TestSetupProvider();
    private final TestSetup testSetup;

    private TestSetupProvider() {
        testSetup = TestSetup.getFromSystemProperty();
    }

    public static TestSetupProvider getInstance() {
        return ourInstance;
    }

    public TestSetup getTestSetup() {
        return testSetup;
    }
}
