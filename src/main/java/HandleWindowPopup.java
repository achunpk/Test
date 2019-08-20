import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class HandleWindowPopup {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        System.setProperty("webdriver.chrome.driver", "C:/Users/nimal/Automation-selenium/chromedriver.exe");

        driver.manage().window().maximize(); //maximisie window
        driver.manage().deleteAllCookies(); //delete all cookies

        driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        driver.get("http://www.popuptest.com/goodpopups.html");
        driver.findElement(By.xpath("/html/body/table[2]/tbody/tr/td/font/b/a[2]")).click();
        Thread.sleep(2000);

        //AN OBJECT IS MADE
        Set<String> handler = driver.getWindowHandles();
        //TO GET VALUE FROM SET OBJECTS WE USE ITERATOR
        Iterator<String> it = handler.iterator();

        //WILL GIVE THE FIRST VALUE
        String ParentWindowId=it.next();
        System.out.println("Parent window id:"+ParentWindowId);


        String ChildWindowId=it.next();
        System.out.println("Child window id:"+ChildWindowId);

        //SWITCHING THE WINDOW ie;FROM PARENT TO CHILD
        driver.switchTo().window(ChildWindowId);
        Thread.sleep(2000);
        //GIVE TITLE OF THAT PARTICULAR PAGE
        System.out.println("Child Window popup title:"+driver.getTitle());

        //CLOSE THE POPUP BY CLICKING ON IT
        driver.close();
        driver.switchTo().window(ParentWindowId);
        Thread.sleep(2000);
        System.out.println("Parent Window popup title:"+driver.getTitle());




    }
}

