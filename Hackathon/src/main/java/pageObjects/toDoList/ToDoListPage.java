package pageObjects.toDoList;

import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ToDoListPage {
    @FindBy(xpath = "//input[@placeholder=\"Create a task\"]")
    private WebElement txt_newTask;
    @FindBy(xpath = "//*[@class='label_5i8SP']")
    private List<WebElement> txt_nameTask;

    @FindBy(xpath = "//*[@class='allCompletedIconWrapper_2rCqr']")
    private WebElement chb_checkAllTasks;

    @FindBy(xpath = "//*[@class='destroy_19w1q']")
    private List<WebElement> delete;
    @FindBy(xpath = "//*[@class='taskWrapper_2u8dN']")
    private List<WebElement> listTasks;

    @FindBy(xpath = "//*[@class='textWrapper_X9gil']/label")
    private List<WebElement> listNameTasks;
    @Step
    public WebElement getTxtNewTask(){
        return txt_newTask;
    }

    @Step
    public List<WebElement> getTxtNameTask(){
        return txt_nameTask;
    }

    @Step
    public WebElement getChbCheckAllTasks(){
        return chb_checkAllTasks;
    }

    @Step
    public List<WebElement> getDelete(){
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
