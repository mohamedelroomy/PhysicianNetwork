package Pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class PageBase {

    protected static WebDriver driver;
    protected Select select;
    protected Actions actions;
    public PageBase(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }


    public void insertTextIntoElement(WebElement element, String txt){
        element.sendKeys(txt);
    }

    public void clickOnElement(WebElement element){
        element.click();
    }

    public void selectFromDDLByIndex (WebElement element,int index){

        select = new Select(element);
        select.selectByIndex(index);
    }

    public void clickOnEnter (){
        actions = new Actions(driver);
        actions.sendKeys(Keys.ENTER).build().perform();
        actions.release().perform();
    }

    public void clickOnDownArrow (){
        actions = new Actions(driver);
        actions.sendKeys(Keys.ARROW_DOWN).build().perform();
        actions.release().perform();
    }

    public void clickOnUpArrow (){
        actions = new Actions(driver);
        actions.sendKeys(Keys.ARROW_UP).build().perform();
        actions.release().perform();
    }

    public void insertText(String txt){
        actions = new Actions(driver);
        actions.sendKeys(txt).build().perform();
    }

    public void scroll(int coordinate)
    {
        String coordinates = "window.scrollBy(0,"+ Integer.toString(coordinate) +")";
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript(coordinates, "");
    }


}
