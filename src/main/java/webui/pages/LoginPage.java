package webui.pages;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import webui.components.HeaderComponent;

import java.time.Duration;

public class LoginPage extends HeaderComponent {
    private final WebElement emailField;
    private final WebElement passwordField;
    private final WebElement signInButton;

    public LoginPage(AndroidDriver androidDriver) {
        super(androidDriver);
        emailField = androidDriver.findElement(AppiumBy.id("field-email"));
        passwordField = androidDriver.findElement(AppiumBy.id("field-password"));
        signInButton = androidDriver.findElement(AppiumBy.id("submit-login"));
    }

    @Step("Input an email.")
    public LoginPage setEmail(String email) {
        emailField.sendKeys(email);
        return this;
    }

    @Step("Input a password.")
    public LoginPage setPassword(String password) {
        passwordField.sendKeys(password);
        return this;
    }

    @Step("Get the sign in button.")
    public AccountPage signButtonClick() {
        androidDriver.hideKeyboard();
        signInButton.click();
        return new AccountPage(androidDriver);
    }

}