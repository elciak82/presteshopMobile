package webui.pages;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import webui.components.HeaderComponent;

import java.time.Duration;

public class AccountPage extends HeaderComponent {
    private final WebElement identityLink;

    public AccountPage(AndroidDriver androidDriver) {
        super(androidDriver);
        WebDriverWait wait = new WebDriverWait(androidDriver, Duration.ofSeconds(2));
        wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("identity-link")));
        identityLink = androidDriver.findElement(AppiumBy.id("identity-link"));
    }

    @Step("Click on the Addresses link.")
    public Boolean informationIsVisible() {
        return identityLink.isDisplayed();
    }
}

