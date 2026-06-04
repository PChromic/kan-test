package com.sii.pageobjects;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.SelenideElement;
import com.sii.pageobjects.newentity.NewBoardComponent;
import org.openqa.selenium.By;

import java.util.NoSuchElementException;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverConditions.urlContaining;

public class BoardsOverviewPage extends BasePage<BoardsOverviewPage> {

    private static final String PAGE_URL = "/boards";

    private final SelenideElement heading = $("h1");
    private final SelenideElement importButton = $x("//button[.//span[text()='Importuj']]");
    private final SelenideElement newBoardButton = $x("//button[.//span[text()='Nowy']]");
    private final SelenideElement activeTab = $x("//button[@type='button' and text()='Active']");
    private final SelenideElement archivedTab = $x("//button[@type='button' and text()='Archived']");
    private final By boardCards = By.cssSelector("a[href^='/boards/']");
    private BoardItem boardItem = new BoardItem();
    private NewBoardComponent newBoardComponent = new NewBoardComponent();

    @Override
    public void load() {
        open(PAGE_URL);
    }

    @Override
    public void isLoaded() throws Error {
        try {
            webdriver().shouldHave(urlContaining(PAGE_URL));
            heading.shouldBe(visible);
            $$(boardCards).should(CollectionCondition.allMatch("asda,asd", element -> element.isDisplayed()));
        } catch (IllegalStateException e) {
            throw new Error(e);
        }
    }

    public void clickImport() {
        importButton.click();
    }

    public NewBoardComponent clickNewBoard() {
        newBoardButton.click();
        return newBoardComponent;
    }

    public void clickActiveTab() {
        activeTab.click();
    }

    public BoardsOverviewPage clickArchivedTab() {
        archivedTab.click();
        return this;
    }

    public BoardItem getBoardCardByName(String name) {
        var board = $$(boardCards)
                .stream()
                .map(x -> x.find(By.cssSelector("p")))
                .filter(element -> element.getText().equals(name))
                .map(element -> element.ancestor("div"))
                .findFirst()
                .orElseThrow(NoSuchElementException::new);
        return boardItem.withRoot(board);
    }

    public BoardsOverviewPage validateBoardWithNameIsActive(String name) {
        validateBoardWithNameIsVisible(name);
        return this;
    }
    public BoardsOverviewPage validateBoardWithNameIsNotActive(String name) {
        validateBoardWithNameIsNotVisible(name);
        return this;
    }

    public BoardsOverviewPage validateBoardWithNameIsArchived(String name) {
        validateBoardWithNameIsVisible(name);
        return this;
    }
    public BoardsOverviewPage validateBoardWithNameIsNotArchived(String name) {
        validateBoardWithNameIsNotVisible(name);
        return this;
    }

    private void validateBoardWithNameIsVisible(String name) {
        $$(boardCards).should(CollectionCondition.anyMatch("text", element -> element.getText().equals(name))
                .because("Board with name " + name + " should be visible in active boards list"));
    }
    private void validateBoardWithNameIsNotVisible(String name) {
        $$(boardCards).should(CollectionCondition.noneMatch("text", element -> element.getText().equals(name))
                .because("Board with name " + name + " should be visible in active boards list"));
    }
}
