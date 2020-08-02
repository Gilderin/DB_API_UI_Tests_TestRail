package steps;

import io.qameta.allure.Step;
import baseEntity.BaseStep;
import core.BrowsersService;
import models.Users;
import pages.LoginPage;

public class LoginStep extends BaseStep {

    public LoginStep(BrowsersService browsersService) {
        super(browsersService);
    }

    @Step
    public void login(String username, String password) {
        LoginPage loginPage = new LoginPage(browsersService);
        loginPage.email.sendKeys(username);
        loginPage.password.sendKeys(password);
        loginPage.loginButton.click();
    }

    @Step
    public void loginV(Users user) {
        LoginPage loginPage = new LoginPage(browsersService);
        loginPage.email.sendKeys(user.getEmail());
        loginPage.password.sendKeys(user.getPassword());
        loginPage.loginButton.click();
    }

}
