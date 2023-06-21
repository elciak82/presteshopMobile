
package webui.components;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import webui.WebEntity;
import webui.pages.SearchResultsPage;

import java.time.Duration;

public class SearchComponent extends WebEntity {
    //    private final WebElement searchDropdown;
    private final WebElement searchBy;

    public SearchComponent(AndroidDriver androidDriver) {
        super(androidDriver);
        WebDriverWait wait = new WebDriverWait(androidDriver, Duration.ofSeconds(2));
        wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("search_widget")));
//        searchDropdown = androidDriver.findElement(By.id("ui-id-1"));
        searchBy = androidDriver.findElement(AppiumBy.id("search_widget"));

    }

    @Step("Search a product.")
    public SearchResultsPage search(String text) throws InterruptedException {
        searchBy.click();
        new Actions(androidDriver).sendKeys(text).perform();
        androidDriver.pressKey(new KeyEvent(AndroidKey.ENTER));
        Thread.sleep(5000);
        return new SearchResultsPage(androidDriver);
    }

//
//    public void sendKeyToSearch(String text){
//        WebDriverWait wait = new WebDriverWait(androidDriver, Duration.ofSeconds(2));
//        wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("search_widget")));
//        WebElement search = androidDriver.findElement(AppiumBy.id("search_widget"));
//        search.click();
//        new Actions(androidDriver).sendKeys(text).perform();
//    }

}