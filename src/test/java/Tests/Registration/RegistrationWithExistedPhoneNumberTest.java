package Tests.Registration;

import Enums.Country;
import Enums.Gender;
import Enums.Specialties;
import Pages.LoginPage;
import Pages.RegistrationPage;
import Tests.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;
import static Enums.Country.Egypt;
import static Enums.Gender.getRandomGender;

public class RegistrationWithExistedPhoneNumberTest extends TestBase {
    Gender gender ;
    Country country = Egypt;
    LoginPage login;
    RegistrationPage SignUp;
    private String phoneNumber = "1010133512";
    private String ToasterMessage = "Email or Mobile Phone already exists";

    @Test
    public void userCanRegisterSuccessfully ()   {
        login = new LoginPage(driver);
        SignUp = new RegistrationPage(driver);
        gender = getRandomGender();
//        login.openRegistrationPage();
        SignUp.completeUserInfo(
                gender.getFirstName(),
                gender.getLastName(),
                Specialties.getRandomSpecialty(),
                country,
                phoneNumber,
                SignUp.generateEmail(),
                SignUp.generatePassword(),
                gender);
        SignUp.submit();
        System.out.println("the Message is "+SignUp.getToasterMSG());
        Assert.assertTrue(SignUp.getToasterMSG().contains(ToasterMessage));
        driver.navigate().refresh();
    }
}
