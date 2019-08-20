import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class JavaScriptExecutorConcept
{
    public static void main(String[] args) throws IOException {
        WebDriver driver = new ChromeDriver();
        System.setProperty("webdriver.chrome.driver", "C:/Users/nimal/Automation-selenium/chromedriver.exe");

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
        drawBorder(loginBtn,driver); //DRAW A BORDER

        //TAKE SCREENSHOT CODE IS CALLING HERE
        //To take screenshot of error page
        File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        //Copy the screenshot to desired location by Copy mathod
        FileUtils.copyFile(src , new File("/Users/nimal/testOne/src/main/java/element.png"));

        //GIVING ALERT MESSAGE TO THE BUG SCREENSHOT
        //generalAlert(driver,"There is an issue with ---------");

        //CLICKING ON ANY ELEMENT USIG JAVASCRIPT EXECUTOR
        clickElementByJS(loginBtn,driver);

        //REFRESH THE PAGE
        //1)By using Selenium
        driver.navigate().refresh();

        //2)By using JS
        driverRefresh(driver);

        //GET THE TITLE OF PAGE BY JS
        System.out.println(getTitleByJS(driver));

        //SCROLL PAGE DOWN
        scrollPageDown(driver);
    }
    public static void flash(WebElement element,WebDriver driver)
    {
        JavascriptExecutor js = ((JavascriptExecutor) driver);
        String bgcolor = element.getCssValue("backgroundColor");
        for(int i=0;i<10;i++)
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
 public static void drawBorder(WebElement element,WebDriver driver)
 {
     JavascriptExecutor js = ((JavascriptExecutor) driver);
     js.executeScript("arguments[0].style.border='3px solid red'",element);
 }
 public static void generalAlert(WebDriver driver,String message)
 {
     JavascriptExecutor js = ((JavascriptExecutor) driver);
     js.executeScript("alert('"+message+"')");
 }
 public static  void  clickElementByJS(WebElement element,WebDriver driver)
 {
     JavascriptExecutor js = ((JavascriptExecutor) driver);
     js.executeScript("arguments[0].click()",element);
 }
public static void driverRefresh(WebDriver driver)
{
    JavascriptExecutor js = ((JavascriptExecutor) driver);
    js.executeScript("history.go(0)");
}
public static String getTitleByJS(WebDriver driver)
{
    JavascriptExecutor js = ((JavascriptExecutor) driver);
    String title = js.executeScript("return document.title;").toString();
    return title;
}
public static void scrollPageDown(WebDriver driver)
{
    JavascriptExecutor js = ((JavascriptExecutor)driver);
    js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
}
}
