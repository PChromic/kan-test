package com.sii.pageobjects;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.ui.LoadableComponent;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverConditions.urlContaining;

public class LoginPage extends LoadableComponent<LoginPage> {

    private static final String PAGE_URL = "/login";

    private final SelenideElement emailInput = $("input[name='email']");
    private final SelenideElement passwordInput = $("input[name='password']");
    private final SelenideElement passwordToggleButton = $("input[name='password'] ~ button[type='button']");
    private final SelenideElement magicLinkButton = $("button.w-full");
    private final SelenideElement signUpLink = $("a[href='/signup']");
    private BoardsOverviewPage boardsOverviewPage = new BoardsOverviewPage();

    @Override
    public void load() {
        open(PAGE_URL);
    }

    @Override
    public void isLoaded() throws Error {
        try {
            webdriver().shouldHave(urlContaining(PAGE_URL));
            emailInput.shouldBe(visible);
        } catch (IllegalStateException e) { //TODO assertion above throws Exception instead of Error.
            throw new Error(e);
        }
    }

    public LoginPage enterEmail(String email) {
        emailInput.setValue(email);
        return this;
    }

    public LoginPage enterPassword(String password) {
        passwordInput.setValue(password);
        return this;
    }

    public LoginPage togglePasswordVisibility() {
        passwordToggleButton.click();
        return this;
    }

    public BoardsOverviewPage clickMagicLink() {
        magicLinkButton.click();
        return new BoardsOverviewPage().get();
    }

    public LoginPage clickSignUp() {
        signUpLink.click();
        return this;
    }
}
