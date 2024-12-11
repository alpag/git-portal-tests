package framework.portal;

import framework.component.BasePage;
import framework.config.Configuration;
import framework.component.annotation.Url;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.WebDriver;

import java.lang.reflect.InvocationTargetException;

public abstract class Portal extends BasePage {
    static Configuration configuration = ConfigFactory.create(Configuration.class);

    public Portal(WebDriver driver) {
        super(driver);
    }

    public <T> T openPage(Class<T> page) {
        openPageUrl(page);
        try {
            return page.getDeclaredConstructor(new Class[]{WebDriver.class}).newInstance(driver);
        } catch (NoSuchMethodException | InvocationTargetException | InstantiationException |
                 IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    private <T> void openPageUrl(Class<T> page) {
        if (!page.isAnnotationPresent(Url.class))
            throw new IllegalArgumentException("Page is not annotated with Url. Add @Url(\"/route\") annotation to the %s class".formatted(page.getSimpleName()));

        String finalUrl = "%s%s".formatted(configuration.appUrl(), page.getAnnotation(Url.class).value());
        driver.get(finalUrl);
    }
}
