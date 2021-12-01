package pageObjects.toDoList;

import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ToDoListPage {
    @FindBy(xpath = "//input[@placeholder=\"Create a task\"]")
    private WebElement txt_newTask;

    @FindBy(xpath = "/html/body/div/div[1]/div[4]/div[2]/div/div[1]/div/div/div/label")
    private WebElement txt_nameTask;

    @FindBy(xpath = "/html/body/div/div[1]/div[3]/div/div")
    private WebElement chb_checkAllTasks;

    @FindBy(xpath = "/html/body/div/div[1]/div[4]/div[2]/div/div[1]/div/div/*[name()=\"svg\"]")
    private WebElement delete;
    @FindBy(xpath = "/html/body/div/div[1]/div[4]/div[2]/div/div")
    private List<WebElement> listTasks;

    @FindBy(xpath = "/html/body/div/div[1]/div[4]/div[2]/div/div/div/div/div/label")
    private List<WebElement> listNameTasks;
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

    @Step
    public List<WebElement> getListTasks(){
        return listTasks;
    }

    @Step
    public List<WebElement> getListNameTasks(){
        return listNameTasks;
    }
}
