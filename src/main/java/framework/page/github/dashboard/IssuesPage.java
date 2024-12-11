package framework.page.github.dashboard;

import framework.component.BasePage;
import framework.component.HeaderComponent;
import framework.component.PageElement;
import framework.component.annotation.Url;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

@Url("/issues")
public class IssuesPage extends BasePage {
    public HeaderComponent header;

    public IssuesPage(WebDriver driver) {
        super(driver);
        header = new HeaderComponent(driver);
    }
}
