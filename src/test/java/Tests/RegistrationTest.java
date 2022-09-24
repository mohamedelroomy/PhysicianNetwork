package Tests;

import Enums.Country;
import Enums.Gender;
import Enums.Specialties;
import Pages.LoginPage;
import Pages.RegistrationPage;
import org.testng.annotations.Test;

import static Enums.Country.Egypt;
import static Enums.Country.getRandomCountry;

public class RegistrationTest extends TestBase {
    Country country = getRandomCountry();
    LoginPage login;
    RegistrationPage SignUp;

    @Test
    public void userCanRegisterSuccessfully ()   {
        login = new LoginPage(driver);
        SignUp = new RegistrationPage(driver);
        login.openRegistrationPage();
        SignUp.completeUserInfo("mohamed","elroomy", Specialties.getRandomSpecialty(),
                country,country.generatePhoneNumber(), generateEmail(),
                generatePassword(), Gender.male);
        SignUp.submit();
    }

}
