package pageObjects.gafana;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class DashboardPage {


    @FindBy(css = ".css-1y6y4so div:nth-child(2) a span")
    private WebElement btn_create_dashboard;

    @FindBy(css = ".css-m0fv42 div[aria-label='Add new panel']")
    private WebElement btn_addPanel;

    @FindBy(css = ".css-0 div input[id='data-source-picker']")
    private WebElement btn_chooseFromList;

    @FindBy(css = ".css-1vwi886  div:nth-child(6) button")
    private WebElement btn_save;

    @FindBy(css = ".css-1ad80n9 .css-xcstkt-input-wrapper div input")
    private WebElement txt_dashboardName;

    @FindBy(css = ".css-aja5tg-button .css-1mhnkuh")
    private WebElement btn_finallySave;

    @FindBy(css = "div[class='react-grid-layout'] div")
    private List<WebElement> dashboards_size;



    public WebElement getBtn_create_category() {
        return btn_create_dashboard;
    }

    public WebElement getBtn_addPanel() {
        return btn_addPanel;
    }

    public WebElement getBtn_chooseFromList() {
        return btn_chooseFromList;
    }

    public WebElement getBtn_save() {
        return btn_save;
    }

    public WebElement getTxt_dashboardName() {
        return txt_dashboardName;
    }

    public WebElement getBtn_finallySave() {
        return btn_finallySave;
    }

    public List<WebElement> getDashboards_size() {
        return dashboards_size;
    }
}
