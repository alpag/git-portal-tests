package github.dashboard;

import framework.page.github.auth.SignInPage;
import framework.page.github.dashboard.HomePage;
import framework.page.github.dashboard.IssuesPage;
import github.GithubTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class DashboardTest extends GithubTest {
    HomePage homePage;

    @BeforeMethod
    public void logIn() {
        // todo: rewrite to API call and inject auth cookies/session into browser's cache
        homePage = gitHub.openPage(SignInPage.class).logValidUserIn(testData.validUserLogin(), testData.validUserPassword());
    }

    @Test
    public void whenUserClicksCatIconThenIsRedirectedToHomePage() {
        var homePage = gitHub.openPage(IssuesPage.class).header.clickCatIcon();

        assertThat(homePage.isPageDisplayed()).isTrue();
    }
}
