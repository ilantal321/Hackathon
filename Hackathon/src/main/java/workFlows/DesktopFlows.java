package workFlows;

import Utillties.CommonOps;
import Utillties.Verification;
import io.qameta.allure.Step;

import static org.testng.Assert.assertTrue;

public class DesktopFlows extends CommonOps {

    @Step("add numbers")
    public static void addNumbers(){
        grafanaUIActions.click(calculatorPage.getBtn_Nine());
        grafanaUIActions.click(calculatorPage.getBtn_Plus());
        grafanaUIActions.click(calculatorPage.getBtn_Nine());
        grafanaUIActions.click(calculatorPage.getBtn_Equals());
        Verification.verifyStrings(calculatorPage.getBtn_Results().getText().substring(11),getData("ResultAdd"));
    }
    @Step("sub numbers")
    public static void subNumbers(){
        grafanaUIActions.click(calculatorPage.getBtn_Nine());
        grafanaUIActions.click(calculatorPage.getBtn_Minus());
        grafanaUIActions.click(calculatorPage.getBtn_One());
        grafanaUIActions.click(calculatorPage.getBtn_Equals());
        Verification.verifyStrings(calculatorPage.getBtn_Results().getText().substring(11),getData("ResultSub"));
    }
    @Step("div numbers")
    public static void divNumbers(){
        grafanaUIActions.click(calculatorPage.getBtn_Nine());
        grafanaUIActions.click(calculatorPage.getBtn_DivideBy());
        grafanaUIActions.click(calculatorPage.getBtn_Two());
        grafanaUIActions.click(calculatorPage.getBtn_Equals());
        Verification.verifyStrings(calculatorPage.getBtn_Results().getText().substring(11),getData("ResultDiv"));
    }
    @Step("multi numbers")
    public static void mulNumbers(){
        grafanaUIActions.click(calculatorPage.getBtn_Nine());
        grafanaUIActions.click(calculatorPage.getBtn_MultiplyBy());
        grafanaUIActions.click(calculatorPage.getBtn_Five());
        grafanaUIActions.click(calculatorPage.getBtn_Equals());
        Verification.verifyStrings(calculatorPage.getBtn_Results().getText().substring(11),getData("ResultMul"));
    }
}
