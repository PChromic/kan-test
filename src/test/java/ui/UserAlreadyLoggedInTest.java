package ui;

import com.sii.pageobjects.LoginPage;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import static com.codeborne.selenide.Selenide.closeWebDriver;

public abstract class UserAlreadyLoggedInTest extends BaseTest {

    private final LoginPage loginPage = new LoginPage();

    // _ is added to make these methods unique and also to prevent overriding by the mistake. Unfortunately, TestNG force these methods to be public.
    @BeforeMethod(alwaysRun = true)
    public final void _beforeMethod() {
        loginPage.get();
        loginPage
                .enterEmail(VALID_EMAIL)
                .enterPassword(VALID_PASSWORD)
                .submitLogin_ExpectSuccess();
    }

    @AfterMethod(alwaysRun = true)
    public final void _afterMethod() {
        closeWebDriver();
    }
}
