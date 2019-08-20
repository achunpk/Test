import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class CalendarHandlingwithJS {
    public static void main(String args[]) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        System.setProperty("webdriver.chrome.driver", "C:/Users/nimal/Automation-selenium/chromedriver.exe");
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();

        //dynamic wait
        driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get("https://www.spicejet.com/");

        Thread.sleep(3000);

        WebElement date = driver.findElement(By.id("ctl00_mainContent_view_date1"));
        String dateVal = "28/08";

        SelectDatebyJS(driver, date, dateVal);
        Thread.sleep(3000);

    }

    public static void SelectDatebyJS(WebDriver driver, WebElement element, String dateVal)
    {

        JavascriptExecutor js = ((JavascriptExecutor) driver); // CASTING THE EXECUTOR
        js.executeScript("arguments[0].setAttribute('value','" + dateVal + "');", element);
    }

}
