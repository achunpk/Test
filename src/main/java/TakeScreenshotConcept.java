
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;



public class TakeScreenshotConcept {
    public static void main(String[] args) throws IOException
    {
        WebDriver driver = new ChromeDriver();
        System.setProperty("webdriver.chrome.driver", "C:/Users/nimal/Automation-selenium/chromedriver.exe");
        driver.manage().window().maximize(); //maximisie window
        driver.manage().deleteAllCookies(); //delete all cookies
        driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);

        driver.get("https://www.facebook.com/");

        //To take screenshot of error page
        File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        //Copy the screenshot to desired location by Copy mathod
        FileUtils.copyFile(src , new File("/Users/nimal/testOne/src/main/java/facebook.png"));



    }
}
