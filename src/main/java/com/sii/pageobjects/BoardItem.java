package com.sii.pageobjects;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class BoardItem {

    public SelenideElement root;
    public By addToFavouritesBtn = By.cssSelector("button[aria-label='Add to favourites']");
    public By removeFromFavouritesBtn = By.cssSelector("button[aria-label='Remove from favourites']");
    private BoardPage boardPage;

    public BoardItem withRoot(SelenideElement root) {
        this.root = root;
        return this;
    }

    public BoardPage click() {
        root.click();
        return boardPage().get();
    }

    private BoardPage boardPage() {
        if (boardPage == null) {
            boardPage = new BoardPage();
        }
        return boardPage;
    }

    public BoardItem addToFavourites() {
        $(addToFavouritesBtn).click();
        return this;
    }

    public BoardItem removeFromFavourites() {
        $(removeFromFavouritesBtn).click();
        return this;
    }

    public String getName() {
        return $(root).find("p").getText();
    }
}
