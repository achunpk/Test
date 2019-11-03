import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class HeadlessChrome {
    public static void main(String args[]) throws InterruptedException
    {
        //MANDATORY THINGS
        //Two things are required to work this properly
        //1)Chrome version is greater than 59 on MAC & greater than 60 on WINDOWS
        //2)Window size should be 1400,800
       ChromeOptions options=new ChromeOptions();
        options.addArguments("window-size=1400,800");
        options.addArguments("headless");

        System.setProperty("webdriver.chrome.driver", "./chromedriver_78.exe");
        WebDriver driver = new ChromeDriver(options);

        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();

        //dynamic wait
        driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        driver.get("https://classic.crmpro.com/");
        System.out.println("login page title=="+driver.getTitle());
        driver.findElement(By.name("username")).sendKeys("aswathi");
        driver.findElement(By.name("password")).sendKeys("achukannan");
        Thread.sleep(3000);
        driver.findElement(By.xpath("//input[@type='submit']")).click();
        System.out.println("Home page title=="+driver.getTitle());

    }
}

