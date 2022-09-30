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

public class RegistrationSuccessfullyTest extends TestBase {
    Country country = getRandomCountry();
    LoginPage login;
    RegistrationPage SignUp;
    private String ToasterMessage = "Success";


    @Test
    public void userCanRegisterSuccessfully ()   {
        login = new LoginPage(driver);
        SignUp = new RegistrationPage(driver);
//        login.openRegistrationPage();
        SignUp.completeUserInfo("mohamed","elroomy", Specialties.getRandomSpecialty(),
                country,country.generatePhoneNumber(), SignUp.generateEmail(),
                SignUp.generatePassword(), Gender.male);
        SignUp.submit();
        System.out.println("the Message is "+SignUp.getToasterMSG());
        Assert.assertTrue(SignUp.getToasterMSG().contains(ToasterMessage));
    }

}