package Tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import java.util.Random;


public class TestBase {
    protected WebDriver driver;
    private String Url = "http://18.197.85.177:5104/Login";



    @BeforeTest
    public void start (){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(Url);
    }


    public static String generatePassword() {

        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz!@#$%&()";
        String pwd = RandomStringUtils.random( 9, characters );
        // It will generate 6 digit random Number.
        // from 0 to 99999999
        Random rnd = new Random();
        int number = rnd.nextInt(99999999);
        String pass = String.format("%06d", number) + pwd;
        return pass;
    }

    public static String generateEmail(){
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




//    @AfterTest
//    public void exit (){
//        driver.quit();
//    }


}
