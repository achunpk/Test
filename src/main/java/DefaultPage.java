import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class DefaultPage {

    public static void launchFirstPage( )throws InterruptedException
    {



        //Creating a driver object referencing WebDriver interface
        WebDriver driver;

        //Setting the webdriver.chrome.driver property to its executable's location
         System.setProperty("webdriver.chrome.driver", "C:/Users/nimal/testOne/chromedriver.exe");
         //System.setProperty("webdriver.gecko.driver", "C:/Users/nimal/testOne/geckodriver.exe");


        //Instantiating driver object
         driver = new ChromeDriver();
        // driver = new FirefoxDriver();

        //Using get() method to open a webpage
        driver.get("http://google.com");

        //Writing title to the page
        String title = driver.getTitle();
        System.out.println(title);

       // driver.wait(2000);

        //Closing the browser
        driver.quit();

    }

    @Test()
    public void testEmailGenerator()
    {



        //Creating a driver object referencing WebDriver interface
        WebDriver driver;

        //Setting the webdriver.chrome.driver property to its executable's location
       System.setProperty("webdriver.chrome.driver", "C:/Users/nimal/Automation-selenium/chromedriver.exe");
       // System.setProperty("webdriver.gecko.driver", "C:/Users/nimal/testOne/geckodriver.exe");

        //Instantiating driver object
        driver = new ChromeDriver();
        //driver = new FirefoxDriver();


        //Using get() method to open a webpage
        driver.get("http://google.com");


        //Closing the browser
        driver.quit();

    }


}
