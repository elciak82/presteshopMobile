package webui;

import com.aventstack.extentreports.gherkin.model.And;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public abstract class WebEntity {
    public AndroidDriver androidDriver;

    public WebEntity(AndroidDriver androidDriver) {
        this.androidDriver = androidDriver;
    }

    protected void hoverOnElement(WebElement cssLocator) {
        Actions builder = new Actions(androidDriver);
        builder.moveToElement(cssLocator);
        builder.perform();
    }

    public String getTextFromWebElement(WebElement webElement) {
        System.out.println(webElement.getText());
        return webElement.getText();
    }
}