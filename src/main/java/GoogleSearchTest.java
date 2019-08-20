import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class GoogleSearchTest
{
    public static void main(String args [])
    {
        System.setProperty("webdriver.chrome.driver", "C:/Users/nimal/Automation-selenium/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.google.com");

        driver.findElement(By.xpath("//input[@role='combobox']")).sendKeys("java");
        List<WebElement> list = driver.findElements(By.xpath("//ul[@role='listbox']//li/descendant:://span[contains(text(),'java')]"));
        System.out.println("Total no.of suggestion in search box:::========>"+list.size());

       /* for(int i=0;i<list.size();i++)
        {
            System.out.println(list.get(i));
        }*/

    }

}
