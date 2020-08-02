package pages.administration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import baseEntity.BasePageFactory;
import core.BrowsersService;

public class AdministrationPage extends BasePageFactory {
    @FindBy(xpath = "//div[@class = 'info-box-title']/a[. = 'Projects']")
    public WebElement projectLink;
    @FindBy(xpath = "//h1[. = 'Administration']")
    public WebElement identifyPage;

    public AdministrationPage(BrowsersService browsersService, boolean openPageByUrl) {
        super(browsersService, openPageByUrl);
    }

    @Override
    protected void openPage() {
        browsersService.getDriver().get(browsersService.getBaseUrl() + "index.php?/admin/overview");
    }

    public boolean isPageOpened() {
        return identifyPage.isDisplayed();
    }

    public ProjectsPage projectLinkClick(){
        projectLink.click();
        return new ProjectsPage(browsersService, true);
    }

}
