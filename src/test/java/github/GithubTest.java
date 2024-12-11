package github;

import base.BaseTest;
import framework.portal.GitHubPortal;
import org.testng.annotations.BeforeMethod;

public class GithubTest extends BaseTest {
    protected GitHubPortal gitHub;

    @BeforeMethod()
    public void initPortal() {
        gitHub = new GitHubPortal(driver);
    }
}
