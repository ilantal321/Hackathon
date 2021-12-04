package workFlows;
import Utillties.CommonOps;

import Utillties.Verification;
import com.google.common.util.concurrent.Uninterruptibles;
import extensions.UIActions;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import pageObjects.toDoList.ToDoListPage;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;
public class ElectronFlows extends CommonOps{
    static List<String> listStringTasks=new ArrayList<>();

    @Step("Initialize a to-do list")
    public static void initListStringTasks(){
        listStringTasks.add("Clean the house");
        listStringTasks.add("Wash the dishes");
        listStringTasks.add("Go shopping");
    }

    @Step("add task")
    public static void addTask(){
        initListStringTasks();
        Uninterruptibles.sleepUninterruptibly(3, TimeUnit.SECONDS);
        grafanaUIActions.click(toDoListPage.getTxtNewTask());
        for(String str:listStringTasks){
            grafanaUIActions.sendKeys(toDoListPage.getTxtNewTask(),str);
            actions.sendKeys(Keys.RETURN).build().perform();
            sizeOfTasks++;
        }
        Uninterruptibles.sleepUninterruptibly(1, TimeUnit.SECONDS);
        System.out.println(UIActions.getSizeList(toDoListPage.getListTasks()));
    }

    @Step("update task")
    public static void editName(int index) {
        if (!checkSizeOfList(index))
            {
                System.out.println("wrong index task to edit");
                return;
            }
        newName=" for kids";
        oldName=toDoListPage.getTxtNameTask().get(index).getText();
        UIActions.editInput(toDoListPage.getTxtNameTask().get(index),newName);
        Uninterruptibles.sleepUninterruptibly(3, TimeUnit.SECONDS);
    }

    @Step("Click as completed all and check if all the elements displayed are marked as completed")
    public static void check(){
        grafanaUIActions.click(toDoListPage.getChbCheckAllTasks());
        for(WebElement name:toDoListPage.getListNameTasks()){
            System.out.println(name.getText());
            Verification.verifySoftAssertContain(name.getAttribute("class"), "completed");
        }
    }

    @Step("delete task by index")
    public static  void delete(int index){
        if (!checkSizeOfList(index))
        {
            System.out.println("wrong index task to delete");
            return;
        }
        UIActions.moveToElement(toDoListPage.getDelete().get(index));
        grafanaUIActions.click(toDoListPage.getDelete().get(index));
        sizeOfTasks--;
        Uninterruptibles.sleepUninterruptibly(3, TimeUnit.SECONDS);
    }
        @Step("Checks if there is a task with the same index ")
        public static  boolean checkSizeOfList(int index){
           return toDoListPage.getListTasks().size()>=index;
        }
}
