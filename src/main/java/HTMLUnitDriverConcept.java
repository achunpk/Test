import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

import java.util.concurrent.TimeUnit;

public class HTMLUnitDriverConcept {
    public static void main(String[] args) throws InterruptedException {
       //WebDriver driver = new ChromeDriver();
        WebDriver driver = new HtmlUnitDriver();
        System.setProperty("webdriver.chrome.driver", "C:/Users/nimal/Automation-selenium/chromedriver.exe");

        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();

        //dynamic wait
        driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        driver.get("https://classic.crmpro.com/");
        System.out.println("Before login title is:"+driver.getTitle());

        driver.findElement(By.name("username")).sendKeys("aswathi");
        driver.findElement(By.name("password")).sendKeys("achukannan");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@type='submit']")).click();
       // Thread.sleep(2000);
        System.out.println("After login title is:"+driver.getTitle());
    }
}
