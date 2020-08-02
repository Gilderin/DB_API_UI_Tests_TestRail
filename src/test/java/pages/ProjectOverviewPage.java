package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import baseEntity.BasePageFactory;
import core.BrowsersService;

public class ProjectOverviewPage extends BasePageFactory {
    @FindBy(className = "header-menu-item-selected")
    WebElement identifyPage;

    public ProjectOverviewPage(BrowsersService browsersService) {
        super(browsersService, false);
    }

    @Override
    protected void openPage() {

    }

    public boolean isPageOpened() {
        return identifyPage.getText().equalsIgnoreCase("Overview");
    }
}
