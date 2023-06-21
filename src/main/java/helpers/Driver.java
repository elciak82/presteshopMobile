package helpers;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class Driver {

    public static AndroidDriver initializeAndroidDriver() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "G6");
        capabilities.setCapability(MobileCapabilityType.UDID, "LGH8706fc11981");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "9");
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
        capabilities.setCapability(MobileCapabilityType.BROWSER_NAME, "Chrome");
        capabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 60);
        capabilities.setCapability("appium:chromeOptions", ImmutableMap.of("w3c", false));

        URL url = new URL("http://127.0.0.1:4723");

        AndroidDriver androidDriver = new AndroidDriver(url, capabilities);
        return new AndroidDriver(url, capabilities);
    }

}
