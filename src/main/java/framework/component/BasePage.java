package framework.component;

import org.openqa.selenium.WebDriver;

public abstract class BasePage {
    protected WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isPageDisplayed() {
        throw new IllegalStateException("isPageDisplayed() method not implemented. Add a new override method into the target class");
    }
}
