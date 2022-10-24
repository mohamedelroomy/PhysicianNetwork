package Tests;

import Enums.Country;
import Enums.Gender;
import Enums.Specialties;
import Pages.ChooseNewPasswordPage;
import Pages.ForgetPasswordPage;
import Pages.LoginPage;
import Pages.RegistrationPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

import static Enums.Country.getRandomCountry;
import static Enums.Gender.getRandomGender;

public class ResetPasswordTest extends TestBase{
    Gender gender ;
    Country country = getRandomCountry();
    RegistrationPage SignUp;
    LoginPage login;
    ForgetPasswordPage forget;
    ChooseNewPasswordPage chooseNewPassword;
    public static String Email;
    public static String Password;
    private String ToasterMessage = "Success";


    @Test (priority = 0)
    public void userCanRegisterSuccessfully ()   {
        login = new LoginPage(driver);
        SignUp = new RegistrationPage(driver);
        Email = SignUp.generateEmail();
        Password = SignUp.generatePassword();
        System.out.println("Old Password is : " + Password);
        gender = getRandomGender();
        login.openRegistrationPage();
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
    @Test (priority = 1)
    public void userInsertRegisteredEmail()  {
       driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(70));
       login.openForgetPasswordPage();
       forget = new ForgetPasswordPage(driver);
       forget.insertEmail(Email);
       forget.sendLink();
       String link=forget.getLink();
       driver.navigate().to(link);
    }
    @Test (priority = 2)
    public void userCanResetPassword()   {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(70));
        chooseNewPassword =new ChooseNewPasswordPage(driver);
        Password = SignUp.generatePassword();
        System.out.println("New Password is : "+Password);
        chooseNewPassword.insertNewPassword(Password);
        chooseNewPassword.insertConfirmPassword(Password);
        chooseNewPassword.submit();
    }
    @Test (priority = 3)
    public void userCanLoginWithValidEmailAndPassword  () {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(70));
        login.completeLoginInput(Email, Password);
        login.login();
    }
}
