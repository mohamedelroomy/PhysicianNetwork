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

public class RegistrationWithExistedEmailTest extends TestBase {
    Gender gender ;
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
        gender = getRandomGender();
        SignUp.completeUserInfo(
                gender.getFirstName(),
                gender.getLastName(),
                Specialties.getRandomSpecialty(),
                country,
                country.generatePhoneNumber(),
                email,
                SignUp.generatePassword(),
                gender);
        SignUp.submit();
        System.out.println("the Message is "+SignUp.getToasterMSG());
        Assert.assertTrue(SignUp.getToasterMSG().contains(ToasterMessage));
        driver.navigate().refresh();
    }
}
