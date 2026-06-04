package com.sii.pageobjects.newentity;

import com.codeborne.selenide.SelenideElement;
import com.sii.pageobjects.BasePage;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public abstract class NewEntityComponent<T extends BasePage<T>> {


    protected final SelenideElement nameInput = $(rootSelector + " input[name='name']");
    protected final SelenideElement submitButton = $(rootSelector + " button[type='submit']");
    protected final SelenideElement closeButton = $x("//*[@data-open]//h2[text()='Nowy board']/following-sibling::button[@type='button']");
    protected final SelenideElement toggler = $("[data-open] button[role='switch']");
    private static final String rootSelector = "[data-open] form";
    private T destination;

    public NewEntityComponent<T> enterName(String name) {
        nameInput.setValue(name);
        return this;
    }

    protected void switchToggle(boolean isEnabled) {
        if (isToggleEnabled() != isEnabled) {
            toggler.click();
        }
    }

    protected boolean isToggleEnabled() {
        return "true".equals(toggler.getAttribute("aria-checked"));
    }

    public T close() {
        closeButton.click();
        return destination.get();
    }
}
