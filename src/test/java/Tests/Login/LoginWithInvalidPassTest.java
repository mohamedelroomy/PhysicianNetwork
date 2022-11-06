package Tests.Login;

import Pages.LoginPage;
import Tests.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginWithInvalidPassTest extends TestBase {
    private String email = "mohamedelroo@gmail.com";
    private String password = "25719_199m";
    private String ValidationMSG ="Invalid email address or password";
    LoginPage login;


    @Test
    public void userCanNotLoginWithInvalidPassword(){
        login = new LoginPage(driver);
        login.completeLoginInput(email,password);
        login.viewPassword();
        login.login();
        Assert.assertTrue(login.getValidationMSG().contains(ValidationMSG));
        driver.navigate().refresh();
    }
}
