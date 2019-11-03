import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class FindElementConcept {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "./chromedriver_78.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("https://www.facebook.com/");

        //1.Get the total count of links on the page
        List <WebElement> linklist = driver.findElements(By.tagName("a"));

        //size of linked list
        System.out.println(linklist.size());

        //2.Get the text of the list
        for(int i=0;i<linklist.size();i++)
        {
            String linkText = linklist.get(i).getText();
            System.out.println(linkText);
        }


    }
}