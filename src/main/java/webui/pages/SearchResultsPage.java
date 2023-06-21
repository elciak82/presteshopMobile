package webui.pages;


import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import webui.components.HeaderComponent;

import java.time.Duration;

public class SearchResultsPage extends HeaderComponent {
    private final WebElement product;

    public SearchResultsPage(AndroidDriver androidDriver) {
        super(androidDriver);
        WebDriverWait wait = new WebDriverWait(androidDriver, Duration.ofSeconds(2));
        wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("js-product-list")));

        product = androidDriver.findElement(AppiumBy.id("js-product-list"));
    }

    public boolean productIsVisible() {
        return product.isDisplayed();
    }

}
