package Pages;

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

    public void openRegistrationPage (){
        clickOnElement(registerNow);
    }

    public void completeLoginInput (String mail,String password){
        insertTextIntoElement(Email,mail);
        insertTextIntoElement(Pass,password);
    }
    public void login(){
      new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions.elementToBeClickable(loginButton));
      clickOnElement(loginButton);
    }


}
