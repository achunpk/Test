import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;

public class PopAlert {

    public static void main(String[] args) throws InterruptedException
    {
      System.setProperty("webdriver.chrome.driver","C:/Users/nimal/testOne/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://mail.rediff.com/cgi-bin/login.cgi");

        driver.findElement(By.xpath("//input[@name='proceed']")).click();//click on GO button

        Thread.sleep(5000); // To see the pop up

        Alert alert=driver.switchTo().alert(); // To get the text of the pop up
        System.out.println(alert.getText());
        String text=alert.getText();

        //Test case condition that is testing the input
        if(text.equals("Please enter a valid user name"))
        {
            System.out.println("correct alert message");
        }
        else
        {
            System.out.println("incorrect message");
        }

        alert.accept(); //click on OK button
    }


}

