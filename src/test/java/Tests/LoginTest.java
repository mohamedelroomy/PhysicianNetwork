package Tests;

import Pages.LoginPage;
import org.testng.annotations.Test;

public class LoginTest extends TestBase {
    private String email = "mohamedelroo@gmail.com";
    private String password = "2571999m";
    LoginPage login;

    @Test
    public void userCanLogin (){
        login = new LoginPage(driver);
        login.completeLoginInput(email,password);
        login.login();
    }
}
