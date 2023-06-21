package tests.login;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.TmsLink;

import org.testng.Assert;
import org.testng.annotations.*;

import webui.components.HeaderComponent;
import webui.pages.AccountPage;
import webui.pages.LoginPage;
import tests.BaseTest;

import java.lang.reflect.Method;

public class LogInTests extends BaseTest {
    HeaderComponent header;

    @BeforeMethod
    public void signIn() {
        header = new HeaderComponent(androidDriver);
        header.getPageTitle();
    }

    @BeforeMethod()
    public void name(Method method) {
        System.out.println("Test name is: " + method.getName());
        System.out.println("Test description is: " + method.getAnnotation(Test.class).testName());
    }

    @Test(testName = "Correct log in to the account.", description = "Behavior = Positive")
    @Description("Test verifying correct log in to the account - the user has an account.")
    @Severity(SeverityLevel.CRITICAL)
    @TmsLink("PRESTASHOP-11")
    @Parameters("browser: chrome")
    public void correctLogInToAccountTest() throws InterruptedException {
        String email = user.getUsername();
        String password = user.getPassword();
        header.clickOnSignIn();

        AccountPage accountPage = new LoginPage(androidDriver)
                .setEmail(email)
                .setPassword(password)
                .signButtonClick();
        Thread.sleep(5000);

        Assert.assertTrue(accountPage.informationIsVisible());

//        header.getSignOutButton().click();

    }
}
