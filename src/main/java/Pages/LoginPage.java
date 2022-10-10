package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage extends PageBase {

    public LoginPage(WebDriver driver) {
        super(driver);
    }
    @FindBy (css = "a[routerlink='/Registration']")
    WebElement registerNow;

    @FindBy (id = "loginEmail")
    WebElement Email;

    @FindBy (id = "loginPassword")
    WebElement Pass;

    @FindBy (xpath = "/html/body/app-root/div/app-auth/div/div[2]/app-login/div/form/button")
    WebElement loginButton;

    @FindBy (xpath = "/html/body/app-root/div/app-auth/div/div[2]/app-login/div/form/span")
    public WebElement ValidationMessage;

    @FindBy (id = "togglePasswordInput")
    WebElement EyeIcon;

    @FindBy (xpath = "/html/body/app-root/div/app-auth/div/div[2]/app-login/div/form/div[2]/div/a")
    WebElement ForgetPasswordBTN;

    public void openRegistrationPage (){
        clickOnElement(registerNow);
    }
    public void openForgetPasswordPage (){
        clickOnElement(ForgetPasswordBTN);
    }

    public void completeLoginInput (String mail,String password){
        insertTextIntoElement(Email,mail);
        insertTextIntoElement(Pass,password);
    }
    public void login(){
      new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions.elementToBeClickable(loginButton));
      clickOnElement(loginButton);
    }

    public String getValidationMSG (){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        return ValidationMessage.getText();
    }

    public void viewPassword(){
        clickOnElement(EyeIcon);
    }

}
