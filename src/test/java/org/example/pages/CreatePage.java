package org.example.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class CreatePage extends CorePage {

    public static SelenideElement startButton = $("#start");
    public static SelenideElement formLabel = $("form");
    public static SelenideElement tasksInputField = $("textarea");
    public static SelenideElement saveButton = $("p input");
    public static SelenideElement cancelButton = $("p a");
}
