package ui;

import com.sii.pageobjects.LoginPage;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.closeWebDriver;

public class LoginTests extends BaseTest {

    private final LoginPage loginPage = new LoginPage();

    @BeforeMethod
    public final void _beforeMethod() {
        loginPage.get();
    }

    @AfterMethod(alwaysRun = true)
    public final void _afterMethod() {
        closeWebDriver();
    }

    @Test
    public void shouldLoginSuccessfully_WithValidCredentials() {
        loginPage.enterEmail(VALID_EMAIL)
                .enterPassword(VALID_PASSWORD)
                .submitLogin_ExpectSuccess();
    }

    @Test
    public void shouldNotLogin_WithInvalidPassword() {
        loginPage.enterEmail(VALID_EMAIL)
                .enterPassword("wrongpassword123")
                .submitLogin()
                .validateInvalidPasswordAlertIsVisible();
    }

    @Test
    public void shouldNotLogin_WithNonExistentEmail() {
        loginPage.enterEmail("nonexistent@example.com")
                .enterPassword(VALID_PASSWORD)
                .submitLogin()
                .validateInvalidPasswordAlertIsVisible();
    }

    @Test
    public void shouldNotLogin_WithEmptyEmail() {
        loginPage.enterPassword(VALID_PASSWORD)
                .submitLogin()
                .validateInvalidEmailAlertIsVisible();
    }
}