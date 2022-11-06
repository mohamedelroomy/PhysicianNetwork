package Tests;

import Enums.Country;
import Enums.Gender;
import Enums.Specialties;
import Pages.ClinicPage;
import Pages.LoginPage;
import Pages.RegistrationPage;
import Tests.Registration.RegistrationSuccessfullyTest;
import org.testng.Assert;
import org.testng.annotations.Test;

import static Enums.Country.Egypt;
import static Enums.Country.getRandomCountry;
import static Enums.Gender.getRandomGender;

public class AddNewClinicTest extends TestBase {

   Country country = Egypt;
   ClinicPage clinic;
   LoginPage login;
   Gender gender ;
   RegistrationPage SignUp;
   public static String Email;
   public static String Password;
   private String ToasterMessage = "Success";


    @Test(priority = 0)
    public void userCanRegisterSuccessfully ()   {
        login = new LoginPage(driver);
        SignUp = new RegistrationPage(driver);
        Email = SignUp.generateEmail();
        Password = SignUp.generatePassword();
        gender = getRandomGender();
        login.openRegistrationPage();
        SignUp.completeUserInfo(
                gender.getFirstName(),
                gender.getLastName(),
                Specialties.getRandomSpecialty(),
                Egypt,
                Egypt.generatePhoneNumber(),
                Email,
                Password,
                gender);
        SignUp.waits(8000);
        SignUp.submit();
        System.out.println("the Message is "+SignUp.getToasterMSG());
        Assert.assertTrue(SignUp.getToasterMSG().contains(ToasterMessage));
    }
    @Test(priority = 1)
    public void userCanLoginWithValidEmailAndPassword  ()  {
        login = new LoginPage(driver);
        if (Email == null || Password == null ){
            login.completeLoginInput("mohamedelroo@gmail.com","2571999m");
        }
        else login.completeLoginInput(Email,Password);
        login.login();
        login.waits(3000);
    }

   @Test(priority = 2)
    public void userCanAddClinic(){
       driver.navigate().to("http://18.197.85.177:5104/ClinicInformation");
       clinic = new ClinicPage(driver);
       clinic.addNewClinic("romy clinic","عيادة رومي",Egypt);
   }
}
