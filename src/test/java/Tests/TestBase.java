package Tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.util.Random;


public class TestBase {
    public static WebDriver driver;
    private String Url = "http://18.197.85.177:5104/Login";



    @BeforeSuite
    public void start (){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(Url);
    }


    @AfterMethod
    public void screenshotOnFailure(ITestResult result)
    {
        if (result.getStatus() == ITestResult.FAILURE)
        {
            System.out.println("Failed!");
            System.out.println("Taking Screenshot....");
            Utilities.Helper.captureScreenshot(driver, result.getName());
        }
    }



//
//    @AfterSuite
//    public void exit (){
//        driver.quit();
//    }


}
