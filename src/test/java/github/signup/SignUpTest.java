package github.signup;

import com.github.javafaker.Faker;
import github.GithubTest;
import org.assertj.core.api.SoftAssertions;
import org.testng.annotations.Test;

public class SignUpTest extends GithubTest {

    @Test
    public void whenAnExistingUserTriesToSignUpThenErrorMessageIsShown() {
        var signUpPage = gitHub.open().signUp(testData.validUserLogin());

        SoftAssertions.assertSoftly(softAssertions -> {
            softAssertions.assertThat(signUpPage.canContinue()).isFalse();
            softAssertions.assertThat(signUpPage.isErrorMessageDisplayed()).isTrue();
            softAssertions.assertThat(signUpPage.errorMessageContent()).isEqualTo("The email you have provided is already associated with an account.\nSign in or reset your password.");
        });
    }

    @Test
    public void whenANewUserTriesToSignUpThenUserCanContinueAndNoErrorMessageIsNotDisplayed() {
        var newUserName = new Faker().internet().emailAddress();

        var signUpPage = gitHub.open().signUp(newUserName);

        SoftAssertions.assertSoftly(softAssertions -> {
            softAssertions.assertThat(signUpPage.canContinue()).as("check if Continue button is disabled").isTrue();
            softAssertions.assertThat(signUpPage.isErrorMessageDisplayed()).as("check if error message is displayed").isFalse();
        });
    }
}
