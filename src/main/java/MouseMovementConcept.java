import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.concurrent.TimeUnit;

public class MouseMovementConcept
{
    public static void main(String[] args) throws InterruptedException
    {
        WebDriver driver=new ChromeDriver();
        System.setProperty("webdriver.chrome.driver", "C:/Users/nimal/Automation-selenium/chromedriver.exe");

        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();

        //dynamic wait
        driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);



        driver.get("https://www.spicejet.com/");

        Thread.sleep(3000);
        //Created a new class named Action
        Actions action = new Actions(driver);
                            //below is the specifed location of where the mouse should be moved.ie;inside of this is the  non-visible element what we want to click
        action.moveToElement(driver.findElement(By.linkText("ADD-ONS"))).build().perform();

        Thread.sleep(3000);
        driver.findElement(By.linkText("Visa Services")).click();


    }

}
