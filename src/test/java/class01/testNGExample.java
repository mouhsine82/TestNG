package class01;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class testNGExample {


    // test

public static WebDriver driver; // must declare driver globally to prevent repeating in each block of code
   @BeforeMethod
    public void SetupBrowser(){
        // start with pre-conditions---> -open the browser - set implicit wait
       WebDriverManager.chromedriver().setup();
       driver =new ChromeDriver();
       driver.get("http://hrm.syntaxtechs.net/humanresources/symfony/web/index.php/auth/login");
       driver.manage().window().maximize();
       driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
   }
   @AfterMethod   // post condition---> close the browser
    public void closeBrowser() throws InterruptedException {
       Thread.sleep(3000);
       driver.quit();
   }
   // test case 1 login in

    @Test
    public void loginFunction(){

       WebElement username=driver.findElement(By.xpath("//input[@name='txtUsername']"));
       username.sendKeys("Admin");
       WebElement password=driver.findElement(By.xpath("//input[@id='txtPassword']"));
       password.sendKeys("Hum@nhrm123");
       WebElement loginbtn=driver.findElement(By.xpath("//*[@id='btnLogin']"));
       loginbtn.click();
   }

   // test case 2: verify that password textbox is displayed on the login page

    @Test
    public void passwordTextBoxVerification(){
       //find the webelement password text box
        WebElement password=driver.findElement(By.xpath("//input[@id='txtPassword']"));
        System.out.println(password.isDisplayed());
    }


}
