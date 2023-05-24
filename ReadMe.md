# **Test cases**

### **Scenario 1**: Validate Create page UI elements.
Test steps:
1. Open https://dailytodo.org page
2. Click on "Create your Daily Todo list" button

Expected results:
1. Create page is opened.
2. Link to the home page "DailyTodo.org" is visible at the top.
3. Under the link text "Start adding your tasks - one on each line." is displayed.
4. Empty form for entering new tasks is displayed.
5. Button "Save tasks" is displayed.
6. Button "Cancel" is displayed.
___

### **Scenario 2**: Validate Edit page UI elements.
Test steps:
1. Open https://dailytodo.org page
2. Click on "Create your Daily Todo list" button
3. Click on "Save tasks" button.
4. Click on "Edit" button.

Expected results:
1. Edit page is opened.
2. Link to the home page "DailyTodo.org" is visible at the top.
3. Under the link input field is displayed with text "Tasks for today".
4. Empty form is displayed.
5. Button "Save tasks" is displayed.
6. Button "Cancel" is displayed.
___

### **Scenario 3**: Check that created tasks are saved and can be viewed.
Test steps:
1. Open https://dailytodo.org page
2. Click on "Create your Daily Todo list" button
3. Enter 3 lines in the form.
4. Click on "Save tasks" button.

Expected results:
1. View page is opened.
2. Link to the home page "DailyTodo.org" is visible at the top.
3. Under the link input field is displayed with text "Tasks for today".
4. 3 rows with entered lines are displayed as tasks.
5. Checkboxes are displayed for each line and are unchecked.
___

### **Scenario 4**: Check that checkboxes are reset when task is changed.
Test steps:
1. Open https://dailytodo.org page
2. Click on "Create your Daily Todo list" button
3. Enter 3 lines in the form.
4. Click on "Save tasks" button.
5. Click on top checkbox.
6. Click on "Edit" button.
7. Change the first line in the form.
8. Click on "Save tasks" button.

Expected results:
1. View page is opened.
2. All checkboxes are unchecked.
