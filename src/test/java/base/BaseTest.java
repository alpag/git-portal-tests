package base;

import framework.config.TestData;
import framework.driver.DriverFactory;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public abstract class BaseTest {
    protected static TestData testData = ConfigFactory.create(TestData.class);

    protected WebDriver driver;

    @BeforeMethod
    public void setUpBeforeEach() {
        this.driver = new DriverFactory().getWebDriver();
    }

    @AfterMethod
    public void tearDownAfterEach() {
        this.driver.quit();
    }
}
