package framework.portal;

import framework.page.github.LandingPage;
import org.openqa.selenium.WebDriver;

public final class GitHubPortal extends Portal {

    public GitHubPortal(WebDriver driver) {
        super(driver);
    }

    public LandingPage open() {
        System.out.println("Opening GitHub Portal " + configuration.appUrl());
        driver.get(configuration.appUrl());
        return new LandingPage(driver);
    }
}
