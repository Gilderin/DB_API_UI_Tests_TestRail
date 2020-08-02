package pages.administration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import baseEntity.BasePageFactory;
import core.BrowsersService;

public class ProjectsPage extends BasePageFactory {
    @FindBy(css = "#dialog-ident-deleteDialog input")
    public WebElement confirmationYesCheckbox;
    @FindBy(css = "#dialog-ident-deleteDialog .button-ok")
    public WebElement confirmationOkButton;
    @FindBy(className = "message-success")
    public WebElement messageSuccess;


    public ProjectsPage(BrowsersService browsersService, boolean openPageByUrl) {
        super(browsersService, openPageByUrl);
    }

    @Override
    protected void openPage() {
        browsersService.getDriver().get(browsersService.getBaseUrl() + "index.php?/admin/projects/overview");
    }

    public boolean isPageOpened() {
        return browsersService.getDriver().getTitle().equalsIgnoreCase("Projects - TestRail");
    }

    public WebElement getProjectItemLink(String projectName) {
        WebElement itemLink=browsersService.getDriver().findElement(By.linkText(projectName));
        return itemLink;
    }

    public void confirmationYesCheckboxClick() {
        confirmationYesCheckbox.click();
    }

    public void deleteIconClick(String projectName) {
        String deleteIcon="//*[text()='replace']/../..//*[@class='icon-small-delete']";
        String tmpIconSelector=deleteIcon.replace("replace",projectName);
        WebElement element = browsersService.getDriver().findElement(By.xpath(tmpIconSelector));
        element.click();
    }

    public void confirmationOkButtonClik() {
        confirmationOkButton.click();
    }

    public String getMessageSuccessText() {
        return messageSuccess.getText();
    }

}
