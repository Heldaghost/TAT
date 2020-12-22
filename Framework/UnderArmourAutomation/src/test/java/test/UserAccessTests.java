package test;
import model.User;
import org.testng.Assert;
import org.testng.annotations.Test;
import util.AssertAccumulator;
import page.*;
import util.UserCreator;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class UserAccessTests extends CommonConditions {
    @Test
    public void registerExistentUserTest(){
        User testUser = UserCreator.withCredentialsFromProperty();
        String expectedErrorMessage = new UserAccessPage(driver)
                .openPage()
                .changeCountry()
                .openRegisterModalWindow()
                .registerUser(testUser)
                .getRegisterMessage();
        assertThat(expectedErrorMessage,is(equalTo("Uh-oh, we've either hit a technical error or you might already have an account set up on UA.com, UA MapMyFitness, or UA MyFitnessPal using this email address. Try")));
    }

    @Test
    public void canLogInTest() {
        User testUser = UserCreator.withCredentialsFromProperty();
        ProfilePage profilePage = new UserAccessPage(driver)
                .openPage()
                .changeCountry()
                .openLogInModalWindow()
                .logIn(testUser)
                .goToProfilePage();
        String expectedUserEmail = profilePage.getUserEmail();
        assertThat(expectedUserEmail,is(equalTo(testUser.getEmail())));
    }
}
