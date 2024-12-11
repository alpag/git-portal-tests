package framework.driver;

import framework.config.Configuration;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.config.DriverManagerType;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverFactory {

    public WebDriver getWebDriver() {

        Configuration configuration = ConfigFactory.create(Configuration.class);
        DriverManagerType driverType;
        WebDriver driver;
        try {
            driverType = DriverManagerType.valueOf(configuration.browserName().toUpperCase());
        } catch (IllegalArgumentException e) {
            throw new IllegalStateException("Wrong browserName, supported browser is CHROME only yet");
        }

        driver = switch (driverType) {
            default -> {
                WebDriverManager.chromedriver().setup();
                yield new ChromeDriver(ChromeOptionsFactory.getOptions());
            }
        };
        return driver;
    }
}
