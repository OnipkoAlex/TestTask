package org.example.ui_tests;

import com.codeborne.selenide.CollectionCondition;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.*;
import static org.example.pages.CreatePage.homePageLink;
import static org.example.pages.CreatePage.*;
import static org.example.pages.EditPage.nameInput;
import static org.example.pages.ViewPage.*;

public class DailyTodoTest extends CoreTest {

    @Test
    @DisplayName("Scenario 1: Validate Create page UI elements.")
    void checkCreatePageUI() {
        startButton.click();

        homePageLink.shouldBe(visible)
                .shouldHave(text("DailyTodo.org"))
                .shouldHave(href("/"));

        formLabel.shouldBe(visible)
                        .shouldHave(text("Start adding your tasks - one on each line."));

        tasksInputField.shouldBe(visible)
                .shouldBe(empty);

        saveButton.shouldBe(visible)
                .shouldHave(value("Save tasks"));

        cancelButton.shouldBe(visible)
                .shouldHave(text("Cancel"));
    }

    @Test
    @DisplayName("Scenario 2: Validate Edit page UI elements.")
    void checkEditPageUI() {
        startButton.click();
        saveButton.click();
        editButton.click();

        homePageLink.shouldBe(visible)
                .shouldHave(text("DailyTodo.org"))
                .shouldHave(href("/"));

        nameInput.shouldBe(visible)
                .shouldHave(value("Tasks for today"));

        tasksInputField.shouldBe(visible)
                .shouldBe(empty);

        saveButton.shouldBe(visible)
                .shouldHave(value("Save tasks"));

        cancelButton.shouldBe(visible)
                .shouldHave(text("Cancel"));
    }

    @Test
    @DisplayName("Scenario 3: Check that created tasks are saved and can be viewed.")
    void checkCreateTaskWorks() {
        startButton.click();

        tasksInputField.val("1").pressEnter()
                .append("2").pressEnter()
                .append("3");

        saveButton.click();

        tasksList.shouldHave(CollectionCondition.size(3));

        firstTask.shouldHave(text("1"));
        secondTask.shouldHave(text("2"));
        thirdTask.shouldHave(text("3"));

        checkboxList.shouldHave(CollectionCondition.size(3))
                .stream()
                .map(element -> element.shouldHave(attribute("title", "Check if you've finished this task for today")))
                .forEach(element -> element.shouldBe(visible));
    }
}
