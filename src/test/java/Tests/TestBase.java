package Tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;




public class TestBase {
    protected static WebDriver driver;


    @BeforeSuite
    public void start (){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        String url = "http://18.197.85.177:5104/Login";
        driver.get(url);
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


//    @AfterSuite
//    public void exit (){driver.quit();}


}
