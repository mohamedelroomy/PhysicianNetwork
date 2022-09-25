package Tests.Login;

import Pages.LoginPage;
import Tests.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginSuccessfullyTest extends TestBase {
    private String email = "mohamedelroo@gmail.com";
    private String password = "2571999m";
    LoginPage login;

    @Test
    public void userCanLoginWithValidEmailAndPassword (){
        login = new LoginPage(driver);
        login.completeLoginInput(email,password);
        login.login();
    }
}
