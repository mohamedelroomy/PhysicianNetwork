package Pages;

import Enums.Country;
import Enums.Gender;
import Enums.Specialties;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Duration;
import java.util.List;
import java.util.Random;

import static Utilities.DataBase.getForgetPasswordToken;
import static Utilities.DataBase.getUserID;


public class RegistrationPage extends PageBase{
    Path dest = Paths.get("./Photos", "3.PNG");
    public RegistrationPage(WebDriver driver) {
        super(driver);
    }

    @FindBy (id = "registrationFirstName")
    WebElement firstName;

    @FindBy (id = "registrationLastName")
    WebElement lastName;

    @FindBy (id = "registrationMainSpecialty")
    WebElement mainSpecialtyDDL;

    @FindBy (id = "registrationMainSpecialty_options")
    WebElement mainSpecialtyList;

    @FindBy (xpath = "//*[@id=\"registrationMainSpecialty_popup\"]/span/span/input")
    WebElement specialtySearch;

    @FindBy (id = "registrationCountryCode_options")
    WebElement countryCodeList;

    @FindBy (id = "registrationCountryCode")
    WebElement countryCodeDDL;

    @FindBy (id = "registrationMobileNumber")
    WebElement mobileNumberInput;

    @FindBy (id = "registrationEmailAddress")
    WebElement emailInput;

    @FindBy (id = "registrationPassword")
    WebElement passwordInput;

    @FindBy (id = "registrationGenderMale")
    WebElement maleGender;

    @FindBy (id = "registrationGenderFemale")
    WebElement femaleGender;

    @FindBy (xpath = "//button[@type = 'submit']")
    WebElement createAccountBTN;

    @FindBy (id = "registrationMedicalLicense")
    WebElement license;

    @FindBy (xpath = "/html/body/app-root/div/app-toaster/ngb-toast/div")
    WebElement toasterMessage;




    public void completeUserInfo (String FirstName, String LastName,Specialties Specialty,Country country,
                                  String PhoneNumber,String Email,String Password, Gender gender)  {
        insertTextIntoElement(firstName,FirstName);
        insertTextIntoElement(lastName, LastName);
        insertTextIntoElement(license,dest.toAbsolutePath().toString());
        clickOnElement(mainSpecialtyDDL);
        selectMainSpecialty(Specialty);
        clickOnElement(countryCodeDDL);
        selectCountry(country);
        insertTextIntoElement(mobileNumberInput,PhoneNumber);
        selectGender(gender);
        insertTextIntoElement(emailInput,Email);
        insertTextIntoElement(passwordInput,Password);
    }


    public void selectMainSpecialty(Specialties Specialty)  {
        new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions.visibilityOf(mainSpecialtyList));
        waits(200);
        //insert specialty name
        insertTextIntoElement(specialtySearch,Specialty.getName());
        waits(400);
        new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions.visibilityOf(mainSpecialtyList));
        // re-declare mainSpecialtyList to choose the inserted specialty after the list has changed by inserting specialty name
        mainSpecialtyList = driver.findElement(By.id("registrationMainSpecialty_options"));
        //choose the inserted specialty
        List <WebElement> SpecialtiesOptions = mainSpecialtyList.findElements(By.tagName("li"));
        for (WebElement e: SpecialtiesOptions) {
            if (e.getText().equalsIgnoreCase(Specialty.getName())){
                clickOnElement(e);
            }
            else clickOnEnter();
        }
    }


    public void selectGender(Gender gender){
        switch (gender) {
            case male:
                clickOnElement(maleGender);
                break;
            case female:
                clickOnElement(femaleGender);
                break;
            default:
                System.out.println("wrong Gender");
                break;
        }
    }



    public void selectCountry (Country country) {
        List<WebElement> CountryOptions = countryCodeList.findElements(By.tagName("li"));
        new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions.visibilityOfAllElements(CountryOptions));
        waits(300);
        for (WebElement e : CountryOptions) {
            if (e.getText().equalsIgnoreCase(country.getCode())) {
                clickOnElement(e);
            }
        }
    }

    public void submit (){
        clickOnElement(createAccountBTN);
    }

    public String getToasterMSG (){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60000));
        waits(500);
        return toasterMessage.getText();
    }

    public String generatePassword() {
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz!@#$%&()";
        String pwd = RandomStringUtils.random( 9, characters );
        // It will generate 9 digit random Number.
        // from 0 to 99999999
        Random rnd = new Random();
        int number = rnd.nextInt(99999999);
        return String.format("%06d", number) + pwd;
    }

    public String generateEmail(){
        String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        StringBuilder salt = new StringBuilder();
        Random rnd = new Random();
        while (salt.length() < 10) { // length of the random string.
            int index = (int) (rnd.nextFloat() * chars.length());
            salt.append(chars.charAt(index));
        }
        String saltStr = salt.toString();
        return saltStr + "@gmail.com";
    }
    public String UserID(String email){
        String ID = getUserID(email);
        return ID;
    }
}
