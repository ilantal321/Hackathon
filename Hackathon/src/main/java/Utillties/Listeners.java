package Utillties;

import org.testng.ITestListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.File;

public class Listeners implements ITestListener {
    @Override
    public void onStart(ITestContext arg0) {
        System.out.println("------------------starting Execution-------------------------");
    }

    @Override
    public void onTestStart(ITestResult arg0) {
        System.out.println("------------------Starting Test: " + arg0.getName() + "-------------------------");
        if (Base.platformNameForSC.equals("web")) {
            try {
                MonteScreenRecorder.startRecord(arg0.getName());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    @Override
    public void onTestSuccess(ITestResult arg0) {
        System.out.println("------------------Success Test: " + arg0.getName() + "-------------------------");
        if (Base.platformNameForSC.equals("web")) {
            try {
                MonteScreenRecorder.stopRecord();
            } catch (Exception e) {
                e.printStackTrace();
            }
            File file = new File("./test-recordings/" + arg0.getName() + ".avi");
            if (file.delete()) System.out.println("File Deleted Successfully");
            else System.out.println("Failed to delete the file");
        }
    }
    @Override
    public void onTestFailure(ITestResult arg0) {
        System.out.println("------------------Failure Test: " + arg0.getName() + "-------------------------");
        if (Base.platformNameForSC.equals("web")) {
                CommonOps.saveScreenshot();
            try {
                MonteScreenRecorder.stopRecord();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void onTestSkipped(ITestResult arg0) {
        System.out.println("------------------Skipped Test: " + arg0.getName() + "-------------------------");
    }
    @Override
    public void onFinish(ITestContext arg0) {
        System.out.println("------------------ended Execution-------------------------");
    }
}
