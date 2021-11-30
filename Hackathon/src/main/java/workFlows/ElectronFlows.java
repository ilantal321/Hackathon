package workFlows;
import Utillties.CommonOps;

import com.google.common.util.concurrent.Uninterruptibles;
import extensions.UIActions;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;
public class ElectronFlows extends CommonOps{
    static List<String> listStringTasks=new ArrayList<>();

    @Step
    public static void initListStringTasks(){
        listStringTasks.add("Clean the house");
        listStringTasks.add("Wash the dishes");
        listStringTasks.add("Go shopping");
    }

    @Step
    public static void addTask(){
        initListStringTasks();
        grafanaUIActions.click(toDoListPage.getTxtNewTask());
        for(String str:listStringTasks){
            grafanaUIActions.sendKeys(toDoListPage.getTxtNewTask(),str);
            actions.sendKeys(Keys.RETURN).build().perform();
        }
        Uninterruptibles.sleepUninterruptibly(1, TimeUnit.SECONDS);
    }

    @Step
    public static void editName(){
        String newName=" for kids";
        UIActions.editInput(toDoListPage.getTxtNameTask(),newName);
        Uninterruptibles.sleepUninterruptibly(3, TimeUnit.SECONDS);
    }

    @Step
    public static void check(){
        grafanaUIActions.click(toDoListPage.getChbCheckAllTasks());
    }

    @Step
    public static  void delete(){
        UIActions.moveToElement(toDoListPage.getTxtNameTask());
        UIActions.moveToElement(toDoListPage.getDelete());
        grafanaUIActions.click(toDoListPage.getDelete());
        Uninterruptibles.sleepUninterruptibly(5, TimeUnit.SECONDS);
    }
}
