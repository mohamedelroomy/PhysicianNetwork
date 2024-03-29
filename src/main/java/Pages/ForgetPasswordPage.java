package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static Utilities.DataBase.getForgetPasswordToken;

public class ForgetPasswordPage extends PageBase {
    private String insertedEmail;

    public ForgetPasswordPage(WebDriver driver) {super(driver);}

    @FindBy (id = "forgotPassEmail")
    WebElement Email;
    @FindBy (xpath = "/html/body/app-root/div/app-auth/div/div[2]/app-forgot-password/div/form/button")
    WebElement SendLink;

    public void insertEmail(String email){
        insertTextIntoElement(Email,email);
        insertedEmail = email;
    }
    public void sendLink(){
        clickOnElement(SendLink);
    }
    public String getLink(){
        String token = getForgetPasswordToken(insertedEmail);
        return "http://18.197.85.177:5104/ChangePassword?token="+token;
    }
}
