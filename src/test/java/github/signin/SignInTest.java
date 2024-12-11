package github.signin;

import framework.page.github.auth.SignInPage;
import github.GithubTest;
import org.assertj.core.api.SoftAssertions;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SignInTest extends GithubTest {

    @Test
    public void whenUserTriesToSignInWithCorrectCredentialsThenHomePageIsDisplayed() {
        var homePage = gitHub.openPage(SignInPage.class).logValidUserIn(testData.validUserLogin(), testData.validUserPassword());

        assertThat(homePage.isPageDisplayed()).isTrue();
    }

    @Test
    public void whenUserTriesToSignInWithIncorrectCredentialsThenErrorIsDisplayed() {
        var signInPage = gitHub.openPage(SignInPage.class).logInvalidUserIn(testData.validUserLogin(), testData.validUserPassword() + "blahblah");

        SoftAssertions.assertSoftly(softAssertions -> {
            softAssertions.assertThat(signInPage.isErrorMessageDisplayed()).isTrue();
            softAssertions.assertThat(signInPage.errorMessageContent()).contains("Incorrect username or password.");
        });
    }
}
