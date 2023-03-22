package class01;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class AssertionBasic {
    public static WebDriver driver;

    // preconditions
    @BeforeMethod
    public void SetupBrowser() {
        // start with pre-conditions---> -open the browser - set implicit wait
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("http://hrm.syntaxtechs.net/humanresources/symfony/web/index.php/auth/login");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }
// post condition

    @AfterMethod   // post condition---> close the browser
    public void closeBrowser() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }
    // test case
    //enter the username:Admin and password:abracadara and click login button and verify that the message invalid credentials is displayed

    @Test
    public void invalidCredentials(){
        //locate the webelement username and senkyes
        WebElement username=driver.findElement(By.xpath("//input[@name='txtUsername']"));
        username.sendKeys("Admin");
        //locate the webelemnt password and senkeys
        WebElement password=driver.findElement(By.xpath("//input[@id='txtPassword']"));
        password.sendKeys("abracadara");
        //locate login button and click login
        WebElement loginbtn=driver.findElement(By.xpath("//*[@id='btnLogin']"));
        loginbtn.click();

        // verify that invalid credentials is displayed (error mesg)
        WebElement error=driver.findElement(By.xpath("//span[@id='spanMessage']"));
        String errorMsg=error.getText();
        //check if the error message is correct ***we do not use if else conditions we use Assertions***
        // assert the value
        String expectedError="Invalid credentials";
        Assert.assertEquals(errorMsg,expectedError);

        // verify that password text box is displayed
        // 1st finding the password element again as it is discarded when we clicked on login button becz the DOM refreshed
         password=driver.findElement(By.xpath("//input[@id='txtPassword']"));
        boolean psswrdDispayed=password.isDisplayed();
        Assert.assertTrue(psswrdDispayed);


    }
}
