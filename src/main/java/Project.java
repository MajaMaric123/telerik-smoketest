import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Project {
    private WebDriver driver;
    @BeforeClass
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Petar\\Downloads\\chromedriver_win32(1)\\chromedriver.exe");
        driver = new ChromeDriver();
    }
    @BeforeMethod
    public void beforeMethod(){
        driver.navigate().to("https://www.telerik.com/support/demos");
        driver.manage().window().maximize();
    }
    @Test
    public void desktopNavigation() {
        WebElement desktopButton = driver.findElement(By.xpath("//*[@id=\"ContentPlaceholder1_T53129E6C012_Col00\"]/nav/div/div[2]/a[2]"));
        desktopButton.click();

        WebElement desktopTitle = driver.findElement(By.id("desktop"));
        String expectedTitle = "Desktop";
        String actualTitle = desktopTitle.getText();
        Assert.assertEquals(actualTitle, expectedTitle);
    }
    @Test
    public void mobileNavigation() {
        WebElement mobileButton = driver.findElement(By.xpath("//*[@id=\"ContentPlaceholder1_T53129E6C012_Col00\"]/nav/div/div[2]/a[3]"));
        mobileButton.click();

        WebElement mobileTitle = driver.findElement(By.id("mobile"));
        String expectedTitle = "Mobile";
        String actualTitle = mobileTitle.getText();
        Assert.assertEquals(actualTitle, expectedTitle);
    }
    @AfterClass
    public void afterClass(){
        driver.close();
    }
}

