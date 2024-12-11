package framework.page.github.auth;

import framework.component.BasePage;
import framework.component.PageElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SignUpPage extends BasePage {

    PageElement errorMessage;
    PageElement continueButton;

    public SignUpPage(WebDriver driver) {
        super(driver);
        errorMessage = new PageElement(driver, By.id("email-err"));
        continueButton = new PageElement(driver, By.xpath("//button[@data-continue-to='password-container']"));
    }

    public String errorMessageContent() {
        return errorMessage.getText();
    }

    public boolean isErrorMessageDisplayed() {
        return errorMessage.isDisplayed();
    }

    public boolean canContinue() {
        // race condition - need to implement custom ExpectedCondition
        return continueButton.isEnabled();
    }
}
