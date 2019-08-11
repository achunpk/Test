import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class CalendarSelectTest
{
    public static void main(String args[]) throws InterruptedException
    {
        WebDriver driver = new ChromeDriver();
        System.setProperty("webdriver.chrome.driver2", "C:/Users/nimal/testOne/chromedriver.exe");
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();

        //dynamic wait
        driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        driver.get("https://classic.crmpro.com/");
        driver.findElement(By.name("username")).sendKeys("aswathi");
        driver.findElement(By.name("password")).sendKeys("achukannan");
        Thread.sleep(3000);
        driver.findElement(By.xpath("//input[@type='submit']")).click();

        driver.switchTo().frame("mainpanel");
        Thread.sleep(3000);


       Thread.sleep(3000);
        String date = "31-September-2019";
        String dateArr[] = date.split("-"); //contains 18,september,2017
        String day = dateArr[0];
        String month = dateArr[1];
        String year = dateArr[2];
        System.out.println(month);
        Thread.sleep(3000);
       Select select = new Select(driver.findElement(By.xpath("//select[@name='slctMonth']")));
       select.selectByVisibleText(month);

        Select select1 = new Select(driver.findElement(By.xpath("//*[@name='slctYear']")));
        select1.selectByVisibleText(year);

        //This gives the input value of the day ie: the user giving value
//        driver.findElement(By.xpath("//td[contains(text(),'"+day+"')]")).click();

        //*[@id="crmcalendar"]/table/tbody/tr[2]/td/table/tbody/tr[2]/td[1]
        //*[@id="crmcalendar"]/table/tbody/tr[2]/td/table/tbody/tr[2]/td[2]
        //*[@id="crmcalendar"]/table/tbody/tr[2]/td/table/tbody/tr[2]/td[6]
// OR CAN USE THE BELOW CODE
        String BeforeXpath = "//*[@id='crmcalendar']/table/tbody/tr[2]/td/table/tbody/tr[";
        String AfterXpath = "]/td[";

        boolean flag=false;
        final int totalWeekDays=7;
        String dayVal=null;
        for(int rowNum=2;rowNum<=7;rowNum++ )
        {
            for(int colNum=1;colNum<=7;colNum++)
            {
                try
                {
                    dayVal = driver.findElement(By.xpath(BeforeXpath+rowNum+AfterXpath+colNum+"]")).getText();
                }catch(NoSuchElementException e)
                {
                    System.out.println("Please enter a correct date value");
                    flag=false;
                    break;
                }
                System.out.println(dayVal);
             if(dayVal.equals(day))
             {
                 driver.findElement(By.xpath(BeforeXpath+rowNum+AfterXpath+colNum+"]")).click();
                 flag=true;
                 break;
             }

            }
            if (flag)
            {
                break;
            }

        }
    }
}


