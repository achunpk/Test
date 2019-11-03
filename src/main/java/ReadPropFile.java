
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ReadPropFile
{
    public static void main(String[] args) throws IOException
    {
        Properties prop = new Properties();

        FileInputStream ip = new FileInputStream("./Config.properties");

        prop.load(ip);

        System.out.println(prop.getProperty("name"));
        String url = prop.getProperty("URL");
        System.out.println("url");

        String browsername= prop.getProperty("browser");

        System.out.println("browsername");

        if(browsername.equals("chrome"))
        {

            System.setProperty("webdriver.chrome.driver", "./chromedriver_78.exe");
            WebDriver driver = new ChromeDriver();
            driver.get(url);
            driver.findElement(By.xpath(prop.getProperty("email_Xpath"))).sendKeys(prop.getProperty("email"));
            driver.findElement(By.xpath(prop.getProperty("pass_Xpath"))).sendKeys(prop.getProperty("pass"));

        }


    }
}
