package Tests.Registration;

import Enums.Country;
import Enums.Gender;
import Enums.Specialties;
import Pages.LoginPage;
import Pages.RegistrationPage;
import Tests.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

import static Enums.Country.getRandomCountry;

public class RegistrationWithExistedEmailTest extends TestBase {
    Country country = getRandomCountry();
    LoginPage login;
    RegistrationPage SignUp;
    private String email = "mohamedelroo@gmail.com";
    private String ToasterMessage = "Email or Mobile Phone already exists";

    @Test
    public void userCanRegisterSuccessfully ()   {
        login = new LoginPage(driver);
        SignUp = new RegistrationPage(driver);
        login.openRegistrationPage();
        SignUp.completeUserInfo("mohamed","elroomy", Specialties.getRandomSpecialty(),
                country,country.generatePhoneNumber(), email,
                SignUp.generatePassword(), Gender.male);
        SignUp.submit();
        System.out.println(SignUp.getToasterMSG());
        Assert.assertTrue(SignUp.getToasterMSG().contains(ToasterMessage));
    }
}
