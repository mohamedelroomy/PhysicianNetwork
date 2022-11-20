package Pages;

import Enums.Country;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class ClinicPage extends PageBase {

    public ClinicPage(WebDriver driver) {
        super(driver);
    }
    @FindBy (xpath = "/html/body/app-root/div/app-main/clinic-information/div/app-clinic-information-list/div/empty-view/div/button")
    WebElement AddNewClinicBTN;

    @FindBy (id = "ClinicAddEditClinicNameEn")
    WebElement EnClinicName;

    @FindBy (id = "ClinicAddEditClinicNameAr")
    WebElement ArClinicName;

    @FindBy (xpath = "/html/body/ngb-modal-window/div/div/add-edit-popup/form/div[3]/button[2]")
    WebElement SaveBTN;

    @FindBy (xpath = "//*[@id=\"ClinicAddEditCountry\"]/span")
    WebElement CountryDDL;

    @FindBy (id = "ClinicAddEditCountry_options")
    WebElement CountryList;

    @FindBy (xpath = "//*[@id=\"ClinicAddEditCountry_popup\"]/span/span/input")
    WebElement CountrySearch;

    @FindBy (id = "ClinicAddEditCity")
    WebElement CityDDL;

    @FindBy (id = "ClinicAddEditCity_options")
    WebElement CityList;

    @FindBy (xpath = "//*[@id=\"ClinicAddEditCity_popup\"]/span/span/input")
    WebElement CitySearch;

    @FindBy (xpath = "//*[@id=\"ClinicAddEditCity\"]/span")
    WebElement CitySpan;

    @FindBy (id = "ClinicAddEditArea")
    WebElement AreaDDL;

    @FindBy (id = "ClinicAddEditArea_options")
    WebElement AreaList;

    @FindBy (xpath = "//*[@id=\"ClinicAddEditArea_popup\"]/span/span/input")
    WebElement AreaSearch;

    @FindBy (xpath = "//*[@id=\"ClinicAddEditArea\"]/span")
    WebElement AreaSpan;

    public void addNewClinic(String EnName, String ArName, Country country){
        clickOnElement(AddNewClinicBTN);
        new WebDriverWait(driver, Duration.ofSeconds(120)).until(ExpectedConditions.elementToBeClickable(SaveBTN));
        insertTextIntoElement(EnClinicName,EnName);
        insertTextIntoElement(ArClinicName,ArName);
        clickOnElement(CountryDDL);
        selectCountry(country);
        new WebDriverWait(driver,Duration.ofSeconds(60)).until(ExpectedConditions.attributeContains(CitySpan,"class","e-input-group e-control-wrapper e-ddl e-lib e-keyboard"));
        clickOnElement(CityDDL);
        selectCity(country);
        new WebDriverWait(driver,Duration.ofSeconds(60)).until(ExpectedConditions.attributeContains(AreaSpan,"class","e-input-group e-control-wrapper e-ddl e-lib e-keyboard"));
        clickOnElement(AreaDDL);
        selectArea(country);
    }

    public void selectCountry (Country country){
        new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions.visibilityOf(CountryList));
        waits(200);
        //insert country name
        insertTextIntoElement(CountrySearch,country.getName());
        waits(400);
        new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions.visibilityOf(CountryList));
        // re-declare country list to choose the inserted country after the list has changed by inserting country name
        CountryList = driver.findElement(By.id("ClinicAddEditCountry_options"));
        //choose the inserted country
        List<WebElement> CountryOptions = CountryList.findElements(By.tagName("li"));
        for (WebElement e: CountryOptions) {
            if (e.getText().equalsIgnoreCase(country.getName())){
                clickOnElement(e);
            }
            else clickOnEnter();
        }
    }

    public void selectCity (Country country) {
        new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions.visibilityOf(CityList));
        waits(200);
        //insert country name
        insertTextIntoElement(CitySearch,country.getCities().get(0).getName());
        waits(400);
        new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions.visibilityOf(CityList));
        // re-declare City list to choose the inserted City after the list has changed by inserting City name
        CityList = driver.findElement(By.id("ClinicAddEditCity_options"));
        //choose the inserted City
        List<WebElement> CityOptions = CityList.findElements(By.tagName("li"));
        for (WebElement e: CityOptions) {
            if (e.getText().equalsIgnoreCase(country.getCities().get(0).getName())){
                clickOnElement(e);
            }
            else clickOnEnter();
        }
    }

    public void selectArea (Country country){
        new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions.visibilityOf(AreaList));
        waits(200);
        //insert country name
        insertTextIntoElement(AreaSearch,country.getCities().get(0).getAreas().get(0).getName());
        waits(400);
        new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions.visibilityOf(AreaList));
        // re-declare Area list to choose the inserted Area after the list has changed by inserting Area name
        AreaList = driver.findElement(By.id("ClinicAddEditArea_options"));
        //choose the inserted Area
        List<WebElement> AreaOptions = AreaList.findElements(By.tagName("li"));
        for (WebElement e: AreaOptions) {
            if (e.getText().equalsIgnoreCase(country.getCities().get(0).getAreas().get(0).getName())){
                clickOnElement(e);
            }
            else clickOnEnter();
        }
    }














}