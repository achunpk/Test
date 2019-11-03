import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class ElementVisibilityTEst {

    public static void main(String[] args) throws IOException {
        System.setProperty("webdriver.chrome.driver", "./chromedriver_78.exe");
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();

        //dynamic wait
        driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get("https://www.facebook.com/");

        //1.isDisplayed() METHOD APPLICABLE FOR ALL ELEMENTS
        boolean b1 = driver.findElement(By.name("websubmit")).isDisplayed(); //for signup button
        System.out.println(b1); //return true,it is there

        //2.isEnable() METHOD
        boolean b2 = driver.findElement(By.name("websubmit")).isEnabled();
        System.out.println(b2);

        //isSelected() METHOD
        boolean b3 = driver.findElement(By.name("sex")).isSelected();
        System.out.println(b3);

    }
}
