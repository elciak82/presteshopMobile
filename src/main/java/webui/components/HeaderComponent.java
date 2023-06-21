package webui.components;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import webui.pages.*;

import java.time.Duration;

public class HeaderComponent extends BasePage {
    private final WebElement logo;

    public HeaderComponent(AndroidDriver androidDriver) {
        super(androidDriver);
        PageFactory.initElements(androidDriver, this);
        WebDriverWait wait = new WebDriverWait(androidDriver, Duration.ofSeconds(2));
        wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.cssSelector("[id = '_mobile_logo']")));

        logo = androidDriver.findElement(AppiumBy.cssSelector("[id = '_mobile_logo']"));

    }

    @Step("Go to the Home Page.")
    public HomePage goToHomePage() {
        logo.click();
        return new HomePage(androidDriver);
    }

    @Step("Sign In link click.")
    public LoginPage clickOnSignIn() {
        WebDriverWait wait = new WebDriverWait(androidDriver, Duration.ofSeconds(2));
        wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("_mobile_user_info")));

        WebElement signInButton = androidDriver.findElement(AppiumBy.id("_mobile_user_info"));
        new Actions(androidDriver).moveToElement(signInButton,25, 12).click().build().perform();

        return new LoginPage(androidDriver);
    }

}