import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Navigation {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        System.setProperty("webdriver.chrome.driver", "C:/Users/nimal/Automation-selenium/chromedriver.exe");
        driver.manage().window().maximize(); //maximisie window
        driver.manage().deleteAllCookies(); //delete all cookies
        driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);

        driver.get("https://www.facebook.com/");//launch the url

        driver.navigate().to("https://www.amazon.com/");//Moving to another webpage or external url

        //back and forward simulation of the browser
        driver.navigate().back();
        Thread.sleep(2000);

        driver.navigate().forward();//moving forward of the page
        Thread.sleep(2000);

        driver.navigate().back();

        driver.navigate().refresh();//refresh the page
    }
}
