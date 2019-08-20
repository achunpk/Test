import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandleFileUploadPopUp {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:/Users/nimal/Automation-selenium/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        //driver.get("www.google.com");

        driver.get("https://html.com/input-type-file/");

        driver.findElement(By.xpath("//input[@id='fileupload']")).sendKeys("C:/Users/nimal/Desktop/Aswathi_resume_csr.docx");//give the path of the uploaded filein sendKeys


    }
}