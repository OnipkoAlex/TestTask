package org.example.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class ViewPage extends CorePage {

    public static SelenideElement editButton = $("td a");
    public static ElementsCollection tasksList = $("tbody ").findAll("tr");
    public static SelenideElement firstTask = $("[class*='t1']");
    public static SelenideElement secondTask = $("[class*='t2']");
    public static SelenideElement thirdTask = $("[class*='t3']");
    public static ElementsCollection checkboxList = $("tbody ").findAll("[class*='current'] input");
}
