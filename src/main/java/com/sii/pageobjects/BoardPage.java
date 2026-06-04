package com.sii.pageobjects;

import com.codeborne.selenide.SelenideElement;
import com.sii.pageobjects.newentity.NewCardComponent;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverConditions.urlContaining;

public class BoardPage extends BasePage<BoardPage> {

    private static final String PAGE_URL = "/boards/";

    private final SelenideElement boardNameInput = $("input#name[name='name']");
    private final SelenideElement copyLinkButton = $("button[aria-label='Kopiuj link do tablicy']");
    private final SelenideElement visibilityButton = $x("//button[.//span[text()='Widoczność']]");
    private final SelenideElement filterButton = $x("//button[.//span[text()='Filtruj']]");
    private final SelenideElement newListButton = $x("//button[.//span[text()='Nowa lista']]");
    private final SelenideElement optionsMenu = $("button[class='flex h-7 w-7 items-center justify-center rounded-[5px] hover:bg-light-200 focus:outline-none dark:hover:bg-dark-200']");
    private final NewCardComponent newCardComponent = new NewCardComponent();
    private final BoardsOverviewPage boardsOverviewPage = new BoardsOverviewPage();

    // Options menu items (visible after clickOptionsMenu())
    private final SelenideElement editBoardUrlMenuItem = $x("//button[@role='menuitem' and contains(text(),'Edytuj URL tablicy')]");
    private final SelenideElement archiveBoardMenuItem = $x("//button[@role='menuitem' and contains(text(),'Zarchiwizuj tablicę')]");
    private final SelenideElement removeFromFavouritesMenuItem = $x("//button[@role='menuitem' and contains(text(),'Usuń z ulubionych')]");
    private final SelenideElement deleteBoardMenuItem = $x("//button[@role='menuitem' and contains(text(),'Usuń tablicę')]");

    @Override
    public void load() {
        open(PAGE_URL);
    }

    @Override
    public void isLoaded() throws Error {
        try {
            webdriver().shouldHave(urlContaining(PAGE_URL));
            boardNameInput.shouldBe(visible);
        } catch (IllegalStateException e) {
            throw new Error(e);
        }
    }


    public BoardPage setBoardName(String name) {
        boardNameInput.clear();
        boardNameInput.setValue(name);
        boardNameInput.pressEnter();
        return this;
    }

    public BoardPage clickCopyLink() {
        copyLinkButton.click();
        return this;
    }

    public BoardPage clickVisibility() {
        visibilityButton.click();
        return this;
    }

    public BoardPage clickFilter() {
        filterButton.click();
        return this;
    }

    public NewCardComponent clickNewCard() {
        newListButton.click();
        return newCardComponent;
    }

    public BoardPage clickOptionsMenu() {
        optionsMenu.click();
        return this;
    }

    public BoardPage clickEditBoardUrl() {
        editBoardUrlMenuItem.click();
        return this;
    }

    public BoardsOverviewPage clickArchiveBoard() {
        archiveBoardMenuItem.click();
        return boardsOverviewPage.get();
    }

    public BoardPage clickRemoveFromFavourites() {
        removeFromFavouritesMenuItem.click();
        return this;
    }

    public BoardsOverviewPage clickDeleteBoard() {
        deleteBoardMenuItem.click();
        return boardsOverviewPage.get();
    }
}
