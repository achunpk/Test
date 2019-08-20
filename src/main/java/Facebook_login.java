import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class Facebook_login
{
    public static void Locator()
    {
        System.setProperty("webdriver.chrome.driver","C:/Users/nimal/Automation-selenium/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.facebook.com");
        //1.Xpath

        driver.findElement(By.xpath("//input[@aria-label='First name']")).sendKeys("tom");
        driver.findElement(By.xpath("//input[@aria-label='Last name']")).sendKeys("kt");

        /*2.name
        driver.findElement(By.name("firstname")).sendKeys("tom");*/

        driver.findElement(By.xpath("//input[@ aria-label ='Mobile number or email']")).sendKeys("tomkt@gmail.com");
        driver.findElement(By.xpath("//input[@ aria-label ='Re-enter email']")).sendKeys("tomkt@gmail.com");
        driver.findElement(By.xpath("//input[@ aria-label ='New password']")).sendKeys("abc123");


        //Drop down box using Select
        Select selectMonth=new Select(driver.findElement(By.id("month")));//Object of select class we have to pass the element
        selectMonth.selectByVisibleText("Jan");//Method with the Object name
        Select selectDay=new Select(driver.findElement(By.id("day")));
        selectDay.selectByVisibleText("10");
        Select selectYear=new Select(driver.findElement(By.id("year")));
        selectYear.selectByVisibleText("1991");


       /* driver.findElement(By.xpath("//*[@id='month']")).sendKeys("Jan");
        driver.findElement(By.xpath("//*[@id='day']")).sendKeys("15");
        driver.findElement(By.xpath("//*[@id='year']")).sendKeys("1992");*/

        driver.findElement(By.id("birthday-help")).sendKeys("Why do i need to provide my birthday?");

        driver.findElement(By.xpath("//input[@value='2']")).click();

       // driver.findElement(By.xpath("//button[@name='websubmit']")).click();

        //driver.findElement(By.xpath("//input[@id='email']")).sendKeys("nimalwyd@gmail.com");
        driver.findElement(By.id("email")).sendKeys("nimalwyd@gmail.com");
        driver.findElement(By.id("pass")).sendKeys("nimal#krishna6");
        driver.findElement(By.xpath("//input[@value='Log In']")).click();
        driver.quit();

    }

    @Test()
    public void testEmailGenerator()
    {

        System.setProperty("webdriver.chrome.driver","C:/Users/nimal/Automation-selenium/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.facebook.com");

        driver.findElement(By.xpath("//input[@aria-label='First name']")).sendKeys("tom");
        driver.findElement(By.xpath("//input[@aria-label='Last name']")).sendKeys("kt");

        driver.findElement(By.xpath("//input[@ aria-label ='Mobile number or email']")).sendKeys("tomkt@gmail.com");
        driver.findElement(By.xpath("//input[@ aria-label ='Re-enter email']")).sendKeys("tomkt@gmail.com");
        driver.findElement(By.xpath("//input[@ aria-label ='New password']")).sendKeys("abc123");


        Select selectMonth=new Select(driver.findElement(By.id("month")));//Object of select class we have to pass the element
        selectMonth.selectByVisibleText("Jan");//Method with the Object name
        Select selectDay=new Select(driver.findElement(By.id("day")));
        selectDay.selectByVisibleText("10");
        Select selectYear=new Select(driver.findElement(By.id("year")));
        selectYear.selectByVisibleText("1991");


        driver.findElement(By.id("birthday-help")).sendKeys("Why do i need to provide my birthday?");

        driver.findElement(By.xpath("//input[@value='2']")).click();

        driver.findElement(By.id("email")).sendKeys("nimalwyd@gmail.com");
        driver.findElement(By.id("pass")).sendKeys("nimal#krishna6");
        driver.findElement(By.xpath("//input[@value='Log In']")).click();
        driver.quit();

    }

}
