package Tests.Login;

import Pages.LoginPage;
import Tests.Registration.RegistrationSuccessfullyTest;
import Tests.TestBase;
import org.openqa.selenium.net.UrlChecker;
import org.testng.Assert;
import org.testng.annotations.Test;


public class LoginSuccessfullyTest extends TestBase {

    LoginPage login;
    private String Email;
    private String Password;
    @Test
    public void userCanLoginWithValidEmailAndPassword  ()  {
        login = new LoginPage(driver);
        Email = RegistrationSuccessfullyTest.Email;
        Password = RegistrationSuccessfullyTest.Password;
        if (Email == null || Password == null ){
            login.completeLoginInput("mohamedelroo@gmail.com","2571999m");
        }
        else login.completeLoginInput(Email,Password);
        login.login();
    }
}
