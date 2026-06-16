package com.sii.pageobjects;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class Sidebar {

    private final SelenideElement boardsLink = $("a[href='/boards']");
    private BoardPage boardPage;

    public BoardPage clickBoards() {
        boardsLink.click();
        return boardPage();
    }

    private BoardPage boardPage() {
        if (boardPage == null) {
            boardPage = new BoardPage();
        }
        return boardPage;
    }
}
