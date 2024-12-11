package framework.page.github.dashboard;

import framework.component.BasePage;
import framework.component.HeaderComponent;
import framework.component.PageElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {
    PageElement feed;
    public HeaderComponent header;

    public HomePage(WebDriver driver) {
        super(driver);
        feed = new PageElement(driver, By.tagName("feed-container"));
        header = new HeaderComponent(driver);
    }

    @Override
    public boolean isPageDisplayed() {
        return feed.isDisplayed();
    }
}
