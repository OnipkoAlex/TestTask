package org.example.ui_tests;

import com.codeborne.selenide.CollectionCondition;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;

public class DailyTodoTest extends CoreTest {

    @Test
    @DisplayName("Scenario 1: Validate Create page UI elements.")
    void checkCreatePageUI() {
        $("#start").click();

        $("h1 a").shouldBe(visible)
                .shouldHave(text("DailyTodo.org"))
                .shouldHave(href("/"));

        $("form").shouldBe(visible)
                        .shouldHave(text("Start adding your tasks - one on each line."));

        $("textarea").shouldBe(visible)
                .shouldBe(empty);

        $("p input").shouldBe(visible)
                .shouldHave(value("Save tasks"));

        $("p a").shouldBe(visible)
                .shouldHave(text("Cancel"));
    }

    @Test
    @DisplayName("Scenario 2: Validate Edit page UI elements.")
    void checkEditPageUI() {
        $("#start").click();
        $("p input").click();
        $("td a").click();

        $("h1 a").shouldBe(visible)
                .shouldHave(text("DailyTodo.org"))
                .shouldHave(href("/"));

        $(".input-title").shouldBe(visible)
                .shouldHave(value("Tasks for today"));

        $("textarea").shouldBe(visible)
                .shouldBe(empty);

        $("p input").shouldBe(visible)
                .shouldHave(value("Save tasks"));

        $("p a").shouldBe(visible)
                .shouldHave(text("Cancel"));
    }

    @Test
    @DisplayName("Scenario 3: Check that created tasks are saved and can be viewed.")
    void checkCreateTaskWorks() {
        $("#start").click();

        $("textarea").val("1").pressEnter()
                .append("2").pressEnter()
                .append("3");

        $("p input").click();

        $("tbody").findAll("tr").shouldHave(CollectionCondition.size(3));

        $("[class*='t1']").shouldHave(text("1"));
        $("[class*='t2']").shouldHave(text("2"));
        $("[class*='t3']").shouldHave(text("3"));

        $("tbody").findAll("[class*='current']").shouldHave(CollectionCondition.size(3))
                .stream()
                .map(element -> element.shouldHave(attribute("title", "Check if you've finished this task for today")))
                .forEach(element -> element.shouldBe(visible));
    }
}
