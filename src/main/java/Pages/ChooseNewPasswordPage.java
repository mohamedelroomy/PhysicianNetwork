package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ChooseNewPasswordPage extends PageBase {
    public ChooseNewPasswordPage(WebDriver driver) {
        super(driver);
    }
    @FindBy (id = "changePasswordNewPassword")
    WebElement newPass;

    @FindBy (id = "changePasswordConfirmPassword")
    WebElement confirmPass;

    @FindBy (xpath = "/html/body/app-root/div/app-auth/div/div[2]/app-change-password/div/form/button")
    WebElement resetPassBTN;

    public void insertNewPassword(String pass){
        insertTextIntoElement(newPass,pass);
    }

    public void insertConfirmPassword(String pass){
        insertTextIntoElement(confirmPass,pass);
    }

    public void submit(){
        clickOnElement(resetPassBTN);
    }
}
