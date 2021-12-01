package toDoListTests;

import Utillties.CommonOps;
import org.testng.annotations.Test;
import workFlows.ElectronFlows;

public class ToDoListTest extends CommonOps {

    @Test
    public void test01_addTask(){
        ElectronFlows.addTask();
    }

    @Test(dependsOnMethods = "test01_addTask")
    public void test02_editName(){
        ElectronFlows.editName();
    }

    @Test(dependsOnMethods = "test01_addTask")
    public void test03_deleteTask(){
        ElectronFlows.delete();
    }

    @Test(dependsOnMethods = "test01_addTask")
    public void test04_checkAll(){
        ElectronFlows.check();
    }
}
