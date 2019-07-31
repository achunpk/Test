
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class JavaScriptExecutorClass {
    public static void main(String[] args)
    {
        WebDriver driver = new ChromeDriver();
        System.setProperty("webdriver.chrome.driver", "C:/Users/nimal/testOne/chromedriver.exe");

        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();

        //dynamic wait
        driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        driver.get("https://classic.crmpro.com/");  //ENTER URL
        driver.findElement(By.name("username")).sendKeys("aswathi");
        driver.findElement(By.name("password")).sendKeys("achukannan");
       // Thread.sleep(2000);
        //driver.findElement(By.xpath("//input[@type='submit']")).click();

        WebElement loginBtn = driver.findElement(By.xpath("//input[@type='submit']")); //Login button
        flash(loginBtn,driver); //CALLING FLASH METHOD

    }
    public static void flash(WebElement element,WebDriver driver)
    {
        JavascriptExecutor js = ((JavascriptExecutor) driver);
        String bgcolor = element.getCssValue("backgroundColor");
        for(int i=0;i<100;i++)
        {
            changeColor("rgb(0,200,0)",element,driver);
            changeColor(bgcolor,element,driver);
        }
    }
    public static void changeColor(String color,WebElement element,WebDriver driver)
    {
        JavascriptExecutor js = ((JavascriptExecutor) driver);
        js.executeScript("arguments[0].style.backgroundColor = '"+color+"'",element);
        try
        {
            Thread.sleep(20);
        }
        catch(InterruptedException e) {
        }

    }

}
