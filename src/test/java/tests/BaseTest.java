package tests;

import helpers.Configuration;
import helpers.Driver;
import helpers.models.UserDto;
import helpers.providers.UserProvider;
import io.appium.java_client.android.AndroidDriver;
import org.testng.annotations.*;
import utils.listeners.TestAllureListener;
import org.testng.annotations.Listeners;


import java.net.MalformedURLException;
import java.sql.SQLException;
import java.sql.Statement;

@Listeners({TestAllureListener.class})
public class BaseTest {
    public static AndroidDriver androidDriver;
    public static Statement statement;
    protected UserDto user;
    protected UserDto userNoAddress;

    public static AndroidDriver getDriver() {
        return androidDriver;
    }


    @BeforeClass
    public void setUp() throws MalformedURLException {

        androidDriver = Driver.initializeAndroidDriver();
        androidDriver.get(Configuration.getConfiguration().getSiteURL());

        user = UserProvider.provideUser("ewwa@ewwa.pl");
        userNoAddress = UserProvider.provideUser("noaddress@noaddress.com");

    }

    @AfterClass
    public void tearDown() {
        androidDriver.quit();
    }
}

