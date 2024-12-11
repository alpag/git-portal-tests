package framework.page.github;

import framework.component.BasePage;
import framework.component.PageElement;
import framework.page.github.auth.SignUpPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LandingPage extends BasePage {

    PageElement signUpInput;
    PageElement signInButton;

    public LandingPage(WebDriver driver) {
        super(driver);
        signUpInput = new PageElement(driver, By.id("hero_user_email"));
        signInButton = new PageElement(driver, By.xpath("//span[contains(text(),'Sign up')]//ancestor::button"));
    }

    public SignUpPage signUp(String email) {
        signUpInput.sendKeys(email);
        signInButton.click();
        return new SignUpPage(driver);
    }
}
