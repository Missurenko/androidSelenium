package utils;

import io.appium.java_client.service.local.AppiumDriverLocalService;

import java.io.IOException;

/**
 * Created by ${bohdan.missurenko} on 11/13/2018.
 */
public class AppiumServer {

    private static AppiumDriverLocalService service = AppiumDriverLocalService.buildDefaultService();

    static void startAppiumServer() throws IOException, InterruptedException {
        service.start();
    }

    static void stopAppiumServer() throws InterruptedException, IOException {
        service.stop();
    }
}
