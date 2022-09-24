package Pages;

import Enums.Country;
import Enums.Gender;
import Enums.Specialties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import static Enums.Country.Egypt;
import static Enums.Country.SaudiArabia;

public class RegistrationPage extends PageBase{

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

    @FindBy (xpath = "//input[@type = 'radio']")
    List<WebElement> genders;

    @FindBy (id = "registrationGenderMale")
    WebElement maleGender;

    @FindBy (id = "registrationGenderFemale")
    WebElement femaleGender;

    @FindBy (xpath = "//button[@type = 'submit']")
    WebElement createAccountBTN;




    public void completeUserInfo (String FirstName, String LastName,Specialties Specialty,Country country,
                                  String PhoneNumber,String Email,String Password, Gender gender)  {
        insertTextIntoElement(firstName,FirstName);
        insertTextIntoElement(lastName, LastName);
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
        //insert specialty name
        insertTextIntoElement(specialtySearch,Specialty.getName());
        new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions.visibilityOf(mainSpecialtyList));

        // re-declare mainSpecialtyList to choose the inserted specialty after the list has changed by inserting specialty name
        mainSpecialtyList = driver.findElement(By.id("registrationMainSpecialty_options"));

        //choose the inserted specialty
        List <WebElement> SpecialtiesOptions = mainSpecialtyList.findElements(By.tagName("li"));
        for (WebElement e: SpecialtiesOptions) {
            if (e.getText().equalsIgnoreCase(Specialty.getName())){
                clickOnElement(e);
            }
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
        waits(500);
        List <WebElement> CountryOptions = countryCodeList.findElements(By.tagName("li"));

                switch (country) {
                    case Egypt:
                        for (WebElement e : CountryOptions) {
                            if (e.getText().equalsIgnoreCase(Egypt.getCode())) {
                                clickOnElement(e);
                            }
                        }
                        break;
                    case SaudiArabia:
                        for (WebElement e : CountryOptions) {
                            if (e.getText().equalsIgnoreCase(SaudiArabia.getCode())) {
                                clickOnElement(e);
                            }
                        }
                        break;
                    default:
                        System.out.println("wrong Country");
                        break;

                }


    }


    public void submit (){
        clickOnElement(createAccountBTN);
    }
}
