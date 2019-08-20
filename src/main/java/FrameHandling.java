import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.concurrent.TimeUnit;

public class FrameHandling
{
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver=new ChromeDriver();
        System.setProperty("webdriver.chrome.driver", "C:/Users/nimal/Automation-selenium/chromedriver.exe");

        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();

        //dynamic wait
        driver.manage().timeouts().pageLoadTimeout(40,TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        driver.get("https://classic.crmpro.com/");
        driver.findElement(By.name("username")).sendKeys("aswathi");
        driver.findElement(By.name("password")).sendKeys("achukannan");
        // WebDriverWait wait2 = new WebDriverWait(driver,30);
        // wait2.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@type='submit']")));
        // driver.findElement(By.xpath("//input[@value='Login']")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//input[@type='submit']")).click();

        //After the above click, it will switch to the selected frame
        driver.switchTo().frame("mainpanel");
        Thread.sleep(3000);

        Thread.sleep(3000);
        driver.findElement(By.xpath("//a[@title='Contacts']")).click(); //Clicking on the Contacts link

      /* driver.switchTo().frame("leftpanel");
        Thread.sleep(3000);

        Thread.sleep(3000);
        driver.findElement(By.xpath("//a[@title='Messages']")).click();*/







    }
}
