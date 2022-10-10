package Tests;

import Pages.ChooseNewPasswordPage;
import Pages.ForgetPasswordPage;
import Pages.LoginPage;
import org.testng.annotations.Test;

import java.time.Duration;

public class ResetPasswordTest extends TestBase{
    LoginPage login;
    ForgetPasswordPage forget;
    ChooseNewPasswordPage chooseNewPassword;

    @Test (priority = 1)
    public void userInsertRegisteredEmail()  {
       login =new LoginPage(driver);
       login.openForgetPasswordPage();
       forget = new ForgetPasswordPage(driver);
       forget.insertEmail("mohamedelroo@gmail.com");
       forget.sendLink();
       String link=forget.getLink();
       driver.navigate().to(link);
    }
    @Test (priority = 2)
    public void userCanResetPassword()   {
        chooseNewPassword =new ChooseNewPasswordPage(driver);
        chooseNewPassword.insertNewPassword("2571999m");
        chooseNewPassword.insertConfirmPassword("2571999m");
        chooseNewPassword.submit();
    }
    @Test (priority = 3)
    public void userCanLoginWithValidEmailAndPassword  () {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(70));
        login.completeLoginInput("mohamedelroo@gmail.com", "2571999m");
        login.login();
    }
}
