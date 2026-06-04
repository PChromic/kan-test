package com.sii.pageobjects.newentity;

import com.sii.pageobjects.BoardPage;

import static com.codeborne.selenide.Selenide.$;

public class NewBoardComponent extends NewEntityComponent {

    public NewBoardComponent selectTemplate(String templateId) {
        $("[data-open] label[data-template-id='" + templateId + "']").click();
        return this;
    }

    public NewBoardComponent enableUseTemplate() {
        switchToggle(true);
        return this;
    }

    public NewBoardComponent disableUseTemplate() {
        switchToggle(false);
        return this;
    }

    public NewBoardComponent enterName(String name) {
        nameInput.setValue(name);
        return this;
    }

    public BoardPage submit() {
        submitButton.click();
        return new BoardPage();
    }


}
