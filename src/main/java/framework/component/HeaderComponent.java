package framework.component;

import framework.page.github.dashboard.HomePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

// TODO: Define as element, rewrite PageElement for keeping SearchContext (either driver or another element)
// in order to locate elements in contexts
public class HeaderComponent extends BasePage {
    PageElement area; //not utilized yet due to reason above, future search context
    PageElement headerIcon;

    public HeaderComponent(WebDriver driver) {
        super(driver);
        area = new PageElement(driver, By.xpath("//header[@role='banner']"));
        headerIcon = new PageElement(driver, By.xpath("//a[contains(@aria-label,'Homepage')]"));
    }

    public HomePage clickCatIcon(){
        headerIcon.click();
        return new HomePage(driver);
    }
}
