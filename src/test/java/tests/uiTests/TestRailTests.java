package tests.uiTests;


import baseEntity.BaseTestSQL;
import org.openqa.selenium.TimeoutException;
import baseEntity.BaseTest;
import models.Projects;
import models.Users;
import pages.administration.ProjectsPage;
import steps.AdministrationStep;
import steps.LoginStep;
import steps.ProjectStep;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.sql.ResultSet;
import java.sql.SQLException;

public class TestRailTests extends BaseTestSQL {

    @Test
    public void login() {
        Users users=new Users("andreymihaevich@gmail.com", "BikDV2qk3BGXQT9J6c8S");
        LoginStep loginStep = new LoginStep(browsersService);
        loginStep.loginV(users);
    }

    @Test(dependsOnMethods = "login")
    public void createProject() {
        String projectName = "";
        String projecttype="";
        String query = "Select * from public.\"project\"" +
                " where id=1";
        ResultSet rs = jdbcService.executeQuery(query);
        try {
            while (rs.next()) {
                projectName = rs.getString("projectName");
                projecttype = rs.getString("projecttype");
            }
        } catch (SQLException throwables) {
            logger.error(throwables.getMessage());
        }
        Projects projects=new Projects(projectName, projecttype);
        ProjectStep projectStep = new ProjectStep(browsersService);
        projectStep.createNewProjectV(projects);
        Assert.assertTrue(browsersService.getDriver().getTitle().equalsIgnoreCase(projectName+" - TestRail")
                || browsersService.getDriver().getTitle().equalsIgnoreCase("Projects - TestRail"));
    }

    @Test(dependsOnMethods = "createProject")
    public void deleteProject() {
        String projectName = "";
        String query = "Select * from public.\"project\"" +
                " where id=1";
        ResultSet rs = jdbcService.executeQuery(query);
        try {
            while (rs.next()) {
                projectName = rs.getString("projectName");
            }
        } catch (SQLException throwables) {
            logger.error(throwables.getMessage());
        }
        AdministrationStep administrationStep = new AdministrationStep(browsersService);
        ProjectsPage projectsPage = administrationStep.deleteProject(projectName);
        Assert.assertEquals(projectsPage.getMessageSuccessText(), "Successfully deleted the project.");
    }

    @Test(dependsOnMethods = "login")
    public void createProjectUnsuccessful(){
        String projectName = "";
        String projecttype="";
        String query = "Select * from public.\"project\"" +
                " where id=2";
        ResultSet rs = jdbcService.executeQuery(query);
        try {
            while (rs.next()) {
                projectName = rs.getString("projectName");
                projecttype = rs.getString("projecttype");
            }
        } catch (SQLException throwables) {
            logger.error(throwables.getMessage());
        }
        Projects projects=new Projects(projectName, projecttype);
        ProjectStep projectStep = new ProjectStep(browsersService);
        projectStep.createNewProjectV(projects);
        Assert.assertEquals(projectStep.getMessageError(),"Field Name is a required field.","Ошибка создания проекта не отобразилась");
    }
}
