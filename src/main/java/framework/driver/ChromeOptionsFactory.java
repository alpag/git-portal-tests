package framework.driver;

import org.openqa.selenium.chrome.ChromeOptions;

public class ChromeOptionsFactory {
    public static ChromeOptions getOptions() {

        var options = new ChromeOptions();
        options.addArguments("start-maximized");

        return options;
    }
}
