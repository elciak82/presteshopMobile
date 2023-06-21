package webui.pages;

import io.appium.java_client.android.AndroidDriver;
import io.qameta.allure.Step;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.FluentWait;
import webui.WebEntity;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public abstract class BasePage extends WebEntity {

    public BasePage(AndroidDriver androidDriver) {
        super(androidDriver);
    }

    public void fluentWaitForElementDisplayed(WebElement elementToBeDisplayed) {
        new FluentWait<>(elementToBeDisplayed)
                .withTimeout(Duration.ofSeconds(10))
                .pollingEvery(Duration.ofMillis(1000))
                .ignoring(NoSuchElementException.class)
                .until(WebElement::isDisplayed);
    }

    @Step("Get page title.")
    public String getPageTitle() {
        String title = androidDriver.getTitle();
        System.out.println("The page title is " + title + ".");
        return title;
    }

    public List<String> getAllResults(List<WebElement> webElements) {
        List<WebElement> links = new ArrayList<>(webElements);
        List<String> filterLinks = links
                .stream()
                .map(WebElement::getText)
                .filter(text -> !text.equals(""))
                .collect(Collectors.toList());
        System.out.println(filterLinks);
        return filterLinks;
    }


}