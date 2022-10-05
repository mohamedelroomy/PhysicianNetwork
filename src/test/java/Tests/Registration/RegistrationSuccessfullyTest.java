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
import static Enums.Gender.getRandomGender;

public class RegistrationSuccessfullyTest extends TestBase {
    Gender gender ;
    Country country = getRandomCountry();
    LoginPage login;
    RegistrationPage SignUp;
    public static String Email;
    public static String Password;
    private String ToasterMessage = "Success";


    @Test
    public void userCanRegisterSuccessfully ()   {
        login = new LoginPage(driver);
        SignUp = new RegistrationPage(driver);
        Email = SignUp.generateEmail();
        Password = SignUp.generatePassword();
        gender = getRandomGender();
//        login.openRegistrationPage();
        SignUp.completeUserInfo(
                gender.getFirstName(),
                gender.getLastName(),
                Specialties.getRandomSpecialty(),
                country,
                country.generatePhoneNumber(),
                Email,
                Password,
                gender);
        SignUp.submit();
        System.out.println("the Message is "+SignUp.getToasterMSG());
        Assert.assertTrue(SignUp.getToasterMSG().contains(ToasterMessage));
    }

}
