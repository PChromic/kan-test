package com.sii.pageobjects;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.ui.LoadableComponent;

public abstract class BasePage<T extends LoadableComponent<T>> extends LoadableComponent<T> {

    protected SelenideElement root;
    public Sidebar sidebar = new Sidebar();
}
