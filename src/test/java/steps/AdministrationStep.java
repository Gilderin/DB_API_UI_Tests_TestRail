package steps;

import io.qameta.allure.Step;
import baseEntity.BaseStep;
import core.BrowsersService;
import pages.administration.AdministrationPage;
import pages.administration.ProjectsPage;

public class AdministrationStep extends BaseStep {

    public AdministrationStep(BrowsersService browsersService) {
        super(browsersService);
    }

    @Step
    public ProjectsPage deleteProject(String projectName) {
        AdministrationPage administrationPage = new AdministrationPage(browsersService, true);
        ProjectsPage projectsPage = administrationPage.projectLinkClick();
        projectsPage.deleteIconClick(projectName);
        projectsPage.confirmationYesCheckbox.click();
        projectsPage.confirmationOkButton.click();
        return new ProjectsPage(browsersService,false);
    }
}
