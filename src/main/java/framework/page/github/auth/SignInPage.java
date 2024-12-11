package framework.page.github.auth;

import framework.component.BasePage;
import framework.component.PageElement;
import framework.component.annotation.Url;
import framework.page.github.dashboard.HomePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

@Url("/login")
public class SignInPage extends BasePage {

    PageElement loginInput;
    PageElement passwordInput;
    PageElement signInButton;
    PageElement errorMessage;

    public SignInPage(WebDriver driver) {
        super(driver);
        loginInput = new PageElement(driver, By.id("login_field"));
        passwordInput = new PageElement(driver, By.id("password"));
        signInButton = new PageElement(driver, By.name("commit"));
        errorMessage = new PageElement(driver, By.xpath("//div[@role='alert']"));
    }

    public HomePage logValidUserIn(String login, String password) {
        loginInput.sendKeys(login);
        passwordInput.sendKeys(password);
        signInButton.click();

        return new HomePage(driver);
    }

    public SignInPage logInvalidUserIn(String login, String password) {
        loginInput.sendKeys(login);
        passwordInput.sendKeys(password);
        signInButton.click();

        return this;
    }

    public boolean isErrorMessageDisplayed() {
        return errorMessage.isDisplayed();
    }

    public String errorMessageContent() {
        return errorMessage.getText();
    }
}
