package steps;

import baseEntity.BaseStep;
import core.BrowsersService;
import io.qameta.allure.Step;
import models.Projects;
import pages.AddProjectPage;
import pages.DashboardPage;
import pages.administration.ProjectsPage;


public class ProjectStep extends BaseStep {

    public ProjectStep(BrowsersService browsersService) {
        super(browsersService);
    }

    @Step
    public void createNewProject(String name, String type) {
        DashboardPage dashboardPage = new DashboardPage(browsersService);
        AddProjectPage addProjectPage = dashboardPage.addProjectPageClick();
        addProjectPage.name.sendKeys(name);

        switch (type) {
            case "Use a single repository for all cases (recommended)":
                addProjectPage.suiteModeSingle.click();
                break;
            case "Use a single repository with baseline support":
                addProjectPage.suiteModeSingleBaseline.click();
                break;
            case "Use multiple test suites to manage cases":
                addProjectPage.suiteModeMulti.click();
                break;
        }
        addProjectPage.addProjectButton.submit();
    }

    @Step
    public void createNewProjectV(Projects projects) {
        DashboardPage dashboardPage = new DashboardPage(browsersService);
        AddProjectPage addProjectPage = dashboardPage.addProjectPageClick();
        addProjectPage.name.sendKeys(projects.getNameProject());

        switch (projects.getTypeProject()) {
            case "Use a single repository for all cases (recommended)":
                addProjectPage.suiteModeSingle.click();
                break;
            case "Use a single repository with baseline support":
                addProjectPage.suiteModeSingleBaseline.click();
                break;
            case "Use multiple test suites to manage cases":
                addProjectPage.suiteModeMulti.click();
                break;
        }
        addProjectPage.addProjectButton.submit();
    }

    @Step
    public String getMessageError() {
        AddProjectPage addProjectPage = new AddProjectPage(browsersService);
        return addProjectPage.messageErrorCreation.getText();
    }
}
