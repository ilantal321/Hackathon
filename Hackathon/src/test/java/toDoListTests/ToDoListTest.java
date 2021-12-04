package toDoListTests;

import Utillties.CommonOps;
import Utillties.Verification;
import extensions.UIActions;
import io.qameta.allure.Description;
import org.testng.annotations.Test;
import workFlows.ElectronFlows;

public class ToDoListTest extends CommonOps {

    @Test(priority = 1)
    @Description("add a new task")
    public void test01_addTask(){
        ElectronFlows.addTask();
        Verification.verifyInt(sizeOfTasks, UIActions.getSizeList(toDoListPage.getListTasks()));
    }

    @Test(priority = 2)
    @Description("update a task according index")
    public void test02_editName(){
        ElectronFlows.editName(index=2);
        Verification.verifyStrings(toDoListPage.getTxtNameTask().get(index).getText(), oldName+newName);
    }

    @Test(priority = 3)
    @Description("delete a task according index")
    public void test03_deleteTask(){
        ElectronFlows.delete(index=1);
        Verification.verifyInt(sizeOfTasks,UIActions.getSizeList(toDoListPage.getListTasks()));
    }

    @Test(priority = 4)
    @Description("check if all the tasks Are marked completed ")
    public void test04_checkAll(){
        ElectronFlows.check();
        Verification.verifyAssertAll();
    }
}
