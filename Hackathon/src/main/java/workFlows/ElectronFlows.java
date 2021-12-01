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

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;
public class ElectronFlows extends CommonOps{
    static List<String> listStringTasks=new ArrayList<>();
    static int size=0;

    @Step
    public static void initListStringTasks(){
        listStringTasks.add("Clean the house");
        listStringTasks.add("Wash the dishes");
        listStringTasks.add("Go shopping");
    }

    @Step
    public static void addTask(){
        initListStringTasks();
        Uninterruptibles.sleepUninterruptibly(6, TimeUnit.SECONDS);
        grafanaUIActions.click(toDoListPage.getTxtNewTask());
        for(String str:listStringTasks){
            grafanaUIActions.sendKeys(toDoListPage.getTxtNewTask(),str);
            actions.sendKeys(Keys.RETURN).build().perform();
            size++;
        }
        Uninterruptibles.sleepUninterruptibly(1, TimeUnit.SECONDS);
        System.out.println(UIActions.getSizeList(toDoListPage.getListTasks()));
        Verification.verifyInt(size,UIActions.getSizeList(toDoListPage.getListTasks()));
    }

    @Step
    public static void editName(){
        String newName=" for kids";
        String oldName=toDoListPage.getTxtNameTask().getText();
        UIActions.editInput(toDoListPage.getTxtNameTask(),newName);
        Uninterruptibles.sleepUninterruptibly(3, TimeUnit.SECONDS);
        Verification.verifyStrings(toDoListPage.getTxtNameTask().getText(), oldName+newName);
    }

    @Step
    public static void check(){
        grafanaUIActions.click(toDoListPage.getChbCheckAllTasks());
        for(WebElement name:toDoListPage.getListNameTasks()){
            System.out.println(name.getText());
            Verification.verifyContain(name.getAttribute("class"), "completed");
        }
    }

    @Step
    public static  void delete(){
        UIActions.moveToElement(toDoListPage.getTxtNameTask());
        UIActions.moveToElement(toDoListPage.getDelete());
        grafanaUIActions.click(toDoListPage.getDelete());
        size--;
        Uninterruptibles.sleepUninterruptibly(3, TimeUnit.SECONDS);
        Verification.verifyInt(size,UIActions.getSizeList(toDoListPage.getListTasks()));
    }
}
