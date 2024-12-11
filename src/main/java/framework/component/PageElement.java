package framework.component;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class PageElement implements WebElement {
    private WebElement element;
    private final WebDriver driver;
    private final By locator;

    public PageElement(WebDriver driver, By locator) {
        this.driver = driver;
        this.locator = locator;
    }

    private void initElement() {
        initElement(Duration.ofSeconds(30));
    }

    private void initElement(Duration duration) {
        WebDriverWait wait = new WebDriverWait(driver, duration);
        element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    @Override
    public void click() {
        initElement();
        element.click();
    }

    @Override
    public void submit() {

    }

    @Override
    public void sendKeys(CharSequence... keysToSend) {
        initElement();
        element.sendKeys(keysToSend);
    }

    @Override
    public void clear() {

    }

    @Override
    public String getTagName() {
        return "";
    }

    @Override
    public String getAttribute(String name) {
        initElement();
        return element.getAttribute(name);
    }

    @Override
    public boolean isSelected() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
            element = wait.until(ExpectedConditions.elementToBeClickable(locator));
            return true;
        } catch (TimeoutException e) {
            return false;
        }
    }

    @Override
    public String getText() {
        initElement();
        return element.getText();
    }

    @Override
    public List<WebElement> findElements(By by) {
        return List.of();
    }

    @Override
    public WebElement findElement(By by) {
        initElement();
        return element.findElement(by);
    }

    @Override
    public boolean isDisplayed() {
        try {
            initElement(Duration.ofSeconds(2));
            return true;
        } catch (TimeoutException | StaleElementReferenceException e) {
            return false;
        }
    }

    @Override
    public Point getLocation() {
        return null;
    }

    @Override
    public Dimension getSize() {
        return null;
    }

    @Override
    public Rectangle getRect() {
        return null;
    }

    @Override
    public String getCssValue(String propertyName) {
        return "";
    }

    @Override
    public <X> X getScreenshotAs(OutputType<X> target) throws WebDriverException {
        return null;
    }
}
