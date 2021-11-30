package pageObjects.toDoList;

import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ToDoListPage {
    @FindBy(xpath = "//input[@placeholder=\"Create a task\"]")
    private WebElement txt_newTask;

    @FindBy(xpath = "/html/body/div/div[1]/div[4]/div[2]/div/div[1]/div/div/div/label")
    private WebElement txt_nameTask;

    @FindBy(xpath = "/html/body/div/div[1]/div[3]/div/div")
    private WebElement chb_checkAllTasks;

    @FindBy(xpath = "/html/body/div/div[1]/div[4]/div[2]/div/div[1]/div/div/*[name()=\"svg\"]")
    private WebElement delete;

    @Step
    public WebElement getTxtNewTask(){
        return txt_newTask;
    }

    @Step
    public WebElement getTxtNameTask(){
        return txt_nameTask;
    }

    @Step
    public WebElement getChbCheckAllTasks(){
        return chb_checkAllTasks;
    }

    @Step
    public WebElement getDelete(){
        return delete;
    }
}
