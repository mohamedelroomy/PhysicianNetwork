package Tests.Login;

import Pages.LoginPage;
import Tests.Registration.RegistrationSuccessfullyTest;
import Tests.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;
import sun.security.util.Password;

public class LoginSuccessfullyTest extends TestBase {

    LoginPage login;
    private String Email;
    private String Password;
    @Test
    public void userCanLoginWithValidEmailAndPassword (){
        login = new LoginPage(driver);
        Email = RegistrationSuccessfullyTest.Email;
        Password = RegistrationSuccessfullyTest.Password;
        login.completeLoginInput(Email,Password);
        login.login();
    }
}
