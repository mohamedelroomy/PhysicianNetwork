package Tests;

import Enums.Country;
import Enums.Gender;
import Enums.Specialties;
import Pages.LoginPage;
import Pages.RegistrationPage;
import org.testng.annotations.Test;

import static Enums.Country.Egypt;

public class RegistrationTest extends TestBase {
    LoginPage login;
    RegistrationPage SignUp;

    @Test
    public void userCanRegisterSuccessfully ()   {
        login = new LoginPage(driver);
        SignUp = new RegistrationPage(driver);
        login.openRegistrationPage();
        SignUp.completeUserInfo("mohamed","elroomy", Specialties.getRandomSpecialty(),
                Egypt,Egypt.generatePhoneNumber(), generateEmail(),
                generatePassword(), Gender.male);
        SignUp.submit();
    }

}
