package com.sii.pageobjects.newentity;

import com.sii.pageobjects.BoardPage;


public class NewCardComponent extends NewEntityComponent<BoardPage> {

    public NewCardComponent enableCreateNewAfter() {
        switchToggle(true);
        return this;
    }

    public NewCardComponent disableCreateNewAfter() {
        switchToggle(false);
        return this;
    }

    public BoardPage submitExpectingBoardPage() {
        submitButton.click();
        return new BoardPage();
    }

    public NewCardComponent submitExpectingSameComponent() {
        submitButton.click();
        return this;
    }

}
