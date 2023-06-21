package tests.search;

import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import tests.BaseTest;
import webui.components.HeaderComponent;
import webui.components.SearchComponent;
import webui.pages.SearchResultsPage;

public class SearchTests extends BaseTest {
    HeaderComponent header;
    SearchComponent search;

    @BeforeMethod
    public void setupData() {
        header = new HeaderComponent(androidDriver);
        search = new SearchComponent(androidDriver);
    }

    @Test(testName = "Verifying the Search option - selecting element from the list.", description = "Behavior = Positive")
    @Severity(SeverityLevel.CRITICAL)
    @Parameters("browser: chrome")
    public void searchProductTest() throws InterruptedException {
        String searchingValue = "Customizable mug";
        SearchResultsPage searchResultsPage = new SearchComponent(androidDriver)
                .search(searchingValue);
        Assert.assertTrue(searchResultsPage.productIsVisible());
    }

}
